package com.labs.java.core;

import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Enter a temperature in Celsius
        System.out.print("Input a degree in Celsius: ");
        double celsius = scanner.nextDouble();

        // Convert the Celsius temperature to Fahrenheit
        double fahrenheit = (celsius * 9/5) + 32;

        // Display the result
        System.out.println(celsius + " degree Celsius is equal to " + (int)fahrenheit + " in Fahrenheit");

        // Close the scanner
        scanner.close();
    }
}
