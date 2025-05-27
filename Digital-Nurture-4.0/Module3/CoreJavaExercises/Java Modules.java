// 34. Java Modules (modular classes)
// com/utils/Utils.java
package com.utils;

public class Utils {
    public static String getGreeting() {
        return "Hello from Utils!";
    }
}

// com/utils/module-info.java
module com.utils {
    exports com.utils;
}

// com/greetings/Main.java
package com.greetings;

import com.utils.Utils;

public class Main {
    public static void main(String[] args) {
        System.out.println(Utils.getGreeting());
    }
}

// com/greetings/module-info.java
module com.greetings {
    requires com.utils;
}

// 35. TCP Client-Server Chat
// Server.java
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started. Waiting for client...");
        Socket socket = server.accept();
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        output.println("Welcome client!");
        String msg;
        while (!(msg = input.readLine()).equalsIgnoreCase("bye")) {
            System.out.println("Client: " + msg);
        }
        socket.close();
        server.close();
    }
}

// Client.java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Server says: " + serverInput.readLine());
        String msg;
        while (!(msg = input.readLine()).equalsIgnoreCase("bye")) {
            output.println(msg);
        }
        socket.close();
    }
}

// 37. javap - Just an example class
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

// 38. Decompiled class simulation (assume Hello.class is decompiled)
// Decompiled by JD-GUI or CFR from Hello.class
public class Hello {
    public Hello() {
        super();
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
