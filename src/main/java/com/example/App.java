package com.example;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, Jenkins with Maven!");

        // Keep the application alive
        try {
            while (true) {
                Thread.sleep(60000); // Sleep for 60 seconds in each iteration
            }
        } catch (InterruptedException e) {
            System.err.println("Application interrupted: " + e.getMessage());
        }
    }
}
