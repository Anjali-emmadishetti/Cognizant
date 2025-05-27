import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;
import java.net.http.*;
import java.net.URI;
import java.lang.reflect.*;
import java.sql.*;
public class CoreJavaExercises{
     // 21. Custom Exception
    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

    public static void checkAge() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        try {
            if (age < 18) throw new InvalidAgeException("Underage: " + age);
            System.out.println("Valid age.");
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 22. File Writing
    public static void writeFile() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter content to write to file: ");
            String data = sc.nextLine();
            FileWriter writer = new FileWriter("output.txt");
            writer.write(data);
            writer.close();
            System.out.println("Data written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 23. File Reading
    public static void readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 24. ArrayList Example
    public static void arrayListExample() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        System.out.println("Enter names (type 'end' to stop):");
        while (true) {
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("end")) break;
            names.add(name);
        }
        System.out.println("Student Names: " + names);
    }

    // 25. HashMap Example
    public static void hashMapExample() {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> students = new HashMap<>();
        System.out.print("Enter ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        students.put(id, name);
        System.out.print("Enter ID to retrieve: ");
        int searchId = sc.nextInt();
        System.out.println("Name: " + students.getOrDefault(searchId, "Not found"));
    }

    // 26. Thread Creation
    static class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < 3; i++) System.out.println("Thread: " + i);
        }
    }

    // 27. Lambda Expressions
    public static void lambdaExample() {
        List<String> items = Arrays.asList("Banana", "Apple", "Mango", "Cherry");
        items.sort((a, b) -> a.compareTo(b));
        System.out.println("Sorted List: " + items);
    }

    // 28. Stream API
    public static void streamAPI() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evens = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("Even Numbers: " + evens);
    }

    // 29. Records (Java 16+)
    public record Person(String name, int age) {}

    public static void useRecords() {
        List<Person> people = List.of(new Person("Alice", 22), new Person("Bob", 17));
        people.stream().filter(p -> p.age() > 18).forEach(System.out::println);
    }

    // 30. Pattern Matching for switch (Java 21)
    public static void patternSwitch(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("Integer: " + i);
            case String s -> System.out.println("String: " + s);
            case Double d -> System.out.println("Double: " + d);
            default -> System.out.println("Unknown type");
        }
    }

    // 31. Basic JDBC Connection
    public static void jdbcConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) System.out.println(rs.getInt(1) + " " + rs.getString(2));
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 32. Insert and Update Operations in JDBC
    public static void insertUpdateJDBC() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            PreparedStatement ps = con.prepareStatement("INSERT INTO students (id, name) VALUES (?, ?)");
            ps.setInt(1, 1); ps.setString(2, "Alice");
            ps.executeUpdate();
            con.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    // 33. Transaction Handling in JDBC
    public static void jdbcTransaction() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            con.setAutoCommit(false);
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE accounts SET balance = balance - 100 WHERE id = 1");
            st.executeUpdate("UPDATE accounts SET balance = balance + 100 WHERE id = 2");
            con.commit();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	// 36. HTTP Client API
    public static void httpClientAPI() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.github.com"))
                .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status: " + response.statusCode());
            System.out.println("Body: " + response.body());
        } catch (Exception e) { e.printStackTrace(); }
    }	
     // 39. Reflection in Java
    public static void reflectionExample() throws Exception {
        Class<?> clazz = Class.forName("java.util.ArrayList");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) System.out.println(m.getName());
    }

    // 40. Virtual Threads (Java 21)
    public static void virtualThreads() {
        for (int i = 0; i < 1000; i++) {
            Thread.startVirtualThread(() -> System.out.println("Virtual thread running"));
        }
    }

    // 41. Executor Service and Callable
    public static void executorServiceExample() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Callable<String> task = () -> "Task Result";
        Future<String> future = service.submit(task);
        System.out.println(future.get());
        service.shutdown();
    }
    	public static void main(String[] args) throws Exception {
	checkAge();
        writeFile();
        readFile();
        arrayListExample();
        hashMapExample();
        new MyThread().start();
        lambdaExample();
        streamAPI();
        useRecords();
        patternSwitch("Test");
        // Uncomment if JDBC is setup
        // jdbcConnection();
        // insertUpdateJDBC();
        // jdbcTransaction();
        httpClientAPI();
        reflectionExample();
        virtualThreads();
        executorServiceExample();
    }
}