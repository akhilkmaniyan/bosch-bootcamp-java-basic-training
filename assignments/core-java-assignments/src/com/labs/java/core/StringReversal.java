package com.labs.java.core;

import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Reverse the string using a loop
        String reversedString = reverseString(inputString);

        // Output the reversed string
        System.out.println("Reversed string: " + reversedString);

        // Close the scanner
        scanner.close();
    }

    // Method to reverse the string using a loop
    public static String reverseString(String str) {
        // Initialize an empty string to store the reversed result
        String reversed = "";

        // Loop through the string from the end to the beginning
        for (int i = str.length() - 1; i >= 0; i--) {
            // Append each character to the reversed string
            reversed += str.charAt(i);
        }

        // Return the reversed string
        return reversed;
    }
}

