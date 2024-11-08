package com.labs.java.core;

import java.util.Scanner;

public class TemperatureConverter {

    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu options
            System.out.println("\nTemperature Converter");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Exit");
            System.out.print("Please choose an option (1, 2, or 3): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Convert Celsius to Fahrenheit
                    System.out.print("Enter temperature in Celsius: ");
                    double celsius = scanner.nextDouble();
                    double fahrenheit = celsiusToFahrenheit(celsius);
                    System.out.printf("%.2f degrees Celsius is equal to %.2f degrees Fahrenheit.\n", celsius, fahrenheit);
                    break;

                case 2:
                    // Convert Fahrenheit to Celsius
                    System.out.print("Enter temperature in Fahrenheit: ");
                    double fahrenheitTemp = scanner.nextDouble();
                    double celsiusTemp = fahrenheitToCelsius(fahrenheitTemp);
                    System.out.printf("%.2f degrees Fahrenheit is equal to %.2f degrees Celsius.\n", fahrenheitTemp, celsiusTemp);
                    break;

                case 3:
                    // Exit the program
                    System.out.println("Exiting the program");
                    scanner.close();
                    return;  // Break out of the method (and thus the program)

                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}
