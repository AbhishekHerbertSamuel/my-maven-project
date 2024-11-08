package com.example;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws IOException {
        // Create an HTTP server that listens on port 8082
        HttpServer server = HttpServer.create(new InetSocketAddress(8082), 0);
        
        // Define a context to handle requests to the root URL ("/")
        server.createContext("/", (exchange -> {
            String response = "Hello, Jenkins with Maven! This is a simple Java server!";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }));

        // Set the default executor and start the server
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8082");

        // Keeps the server running indefinitely
    }
}
