import java.util.*;
public class CoreJavaExercise{

    // 1. Hello World Program
    public static void helloWorld() {
        System.out.println("Hello, World!");
    }

    // 2. Simple Calculator
    public static void calculator() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        System.out.print("Choose operation (+, -, *, /): ");
        char op = sc.next().charAt(0);
        switch (op) {
            case '+': System.out.println("Result: " + (a + b)); break;
            case '-': System.out.println("Result: " + (a - b)); break;
            case '*': System.out.println("Result: " + (a * b)); break;
            case '/': System.out.println("Result: " + (a / b)); break;
            default: System.out.println("Invalid operator");
        }
    }

    // 3. Even or Odd Checker
    public static void evenOddChecker() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        System.out.println(n % 2 == 0 ? "Even" : "Odd");
    }

    // 4. Leap Year Checker
    public static void leapYear() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
            System.out.println("Leap year");
        else
            System.out.println("Not a leap year");
    }

    // 5. Multiplication Table
    public static void multiplicationTable() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        for (int i = 1; i <= 10; i++)
            System.out.println(num + " x " + i + " = " + (num * i));
    }

    // 6. Data Type Demonstration
    public static void dataTypes() {
        int i = 42;
        float f = 3.14f;
        double d = 3.14159;
        char c = 'A';
        boolean b = true;
        System.out.println("int: " + i + ", float: " + f + ", double: " + d + ", char: " + c + ", boolean: " + b);
    }

    // 7. Type Casting Example
    public static void typeCasting() {
        double d = 9.7;
        int i = (int) d;
        int j = 5;
        double dj = j;
        System.out.println("Double to int: " + i);
        System.out.println("Int to double: " + dj);
    }

    // 8. Operator Precedence
    public static void operatorPrecedence() {
        int result = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + result);
    }

    // 9. Grade Calculator
    public static void gradeCalculator() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks out of 100: ");
        int marks = sc.nextInt();
        char grade = (marks >= 90) ? 'A' : (marks >= 80) ? 'B' : (marks >= 70) ? 'C' : (marks >= 60) ? 'D' : 'F';
        System.out.println("Grade: " + grade);
    }

    // 10. Number Guessing Game
    public static void guessingGame() {
        Scanner sc = new Scanner(System.in);
        int number = (int) (Math.random() * 100 + 1);
        int guess;
        do {
            System.out.print("Guess a number (1-100): ");
            guess = sc.nextInt();
            if (guess < number) System.out.println("Too low!");
            else if (guess > number) System.out.println("Too high!");
        } while (guess != number);
        System.out.println("Correct!");
    }

    // 11. Factorial Calculator
    public static void factorial() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        long fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        System.out.println("Factorial: " + fact);
    }

    // 12. Method Overloading
    public static int add(int a, int b) { return a + b; }
    public static double add(double a, double b) { return a + b; }
    public static int add(int a, int b, int c) { return a + b + c; }

    // 13. Recursive Fibonacci
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 14. Array Sum and Average
    public static void arraySumAvg() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        System.out.println("Sum: " + sum + ", Average: " + (sum / (double) n));
    }

    // 15. String Reversal
    public static void reverseString() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        StringBuilder reversed = new StringBuilder(input).reverse();
        System.out.println("Reversed: " + reversed);
    }

    // 16. Palindrome Checker
    public static void palindromeChecker() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(s.equals(new StringBuilder(s).reverse().toString()) ? "Palindrome" : "Not a palindrome");
    }

    // 17. Class and Object Creation
    static class Car {
        String make, model;
        int year;
        void displayDetails() {
            System.out.println("Car: " + make + " " + model + " " + year);
        }
    }

    // 18. Inheritance Example
    static class Animal {
        void makeSound() { System.out.println("Some sound"); }
    }
    static class Dog extends Animal {
        void makeSound() { System.out.println("Bark"); }
    }

    // 19. Interface Implementation
    interface Playable { void play(); }
    static class Guitar implements Playable { public void play() { System.out.println("Strumming guitar..."); } }
    static class Piano implements Playable { public void play() { System.out.println("Playing piano..."); } }

    // 20. Try-Catch Example
    public static void tryCatchExample() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter two integers: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }
    }
public static void main(String[] args) {
        helloWorld();
        calculator();
        evenOddChecker();
        leapYear();
        multiplicationTable();
        dataTypes();
        typeCasting();
        operatorPrecedence();
        gradeCalculator();
        guessingGame();
        factorial();
        System.out.println("Add(int,int): " + add(2, 3));
        System.out.println("Add(double,double): " + add(2.5, 3.5));
        System.out.println("Add(int,int,int): " + add(1, 2, 3));
        System.out.println("Fibonacci(5): " + fibonacci(5));
        arraySumAvg();
        reverseString();
        palindromeChecker();
        Car car = new Car(); car.make = "Toyota"; car.model = "Corolla"; car.year = 2020; car.displayDetails();
        Animal a = new Animal(); Dog d = new Dog(); a.makeSound(); d.makeSound();
        Playable g = new Guitar(); Playable p = new Piano(); g.play(); p.play();
        tryCatchExample();
}
}
