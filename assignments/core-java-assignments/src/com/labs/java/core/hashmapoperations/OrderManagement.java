package com.labs.java.core.hashmapoperations;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OrderManagement {

    // HashMap to store orders by ID
    private static Map<Integer, Order> orders = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n----- Order Management System -----");
            System.out.println("1. Add Order");
            System.out.println("2. View Order");
            System.out.println("3. Update Order");
            System.out.println("4. Delete Order");
            System.out.println("5. Show Category Wise Count");
            System.out.println("6. Show Category Wise Total Amount");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addOrder();
                    break;
                case 2:
                    viewOrder();
                    break;
                case 3:
                    updateOrder();
                    break;
                case 4:
                    deleteOrder();
                    break;
                case 5:
                    showCategoryWiseCount();
                    break;
                case 6:
                    showCategoryWiseTotalAmount();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    // Add Order
    public static void addOrder() {
        System.out.print("Enter Order ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        Order order = new Order(id, description, category, quantity, price);
        orders.put(id, order);
        System.out.println("Order added successfully!");
    }

    // View Order
    public static void viewOrder() {
        System.out.print("Enter Order ID to view: ");
        int id = scanner.nextInt();
        Order order = orders.get(id);

        if (order != null) {
            System.out.println(order);
        } else {
            System.out.println("Order not found.");
        }
    }

    // Update Order
    public static void updateOrder() {
        System.out.print("Enter Order ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        Order orderToUpdate = orders.get(id);

        if (orderToUpdate != null) {
            System.out.println("Order found: " + orderToUpdate);

            System.out.print("Enter new Description (leave blank to keep current): ");
            String description = scanner.nextLine();
            if (!description.isEmpty()) {
                orderToUpdate.description = description;
            }

            System.out.print("Enter new Category (leave blank to keep current): ");
            String category = scanner.nextLine();
            if (!category.isEmpty()) {
                orderToUpdate.category = category;
            }

            System.out.print("Enter new Quantity (enter 0 to keep current): ");
            int quantity = scanner.nextInt();
            if (quantity != 0) {
                orderToUpdate.quantity = quantity;
            }

            System.out.print("Enter new Price (enter 0 to keep current): ");
            double price = scanner.nextDouble();
            if (price != 0) {
                orderToUpdate.price = price;
            }

            System.out.println("Order updated successfully!");
        } else {
            System.out.println("Order not found.");
        }
    }

    // Delete Order
    public static void deleteOrder() {
        System.out.print("Enter Order ID to delete: ");
        int id = scanner.nextInt();

        if (orders.containsKey(id)) {
            orders.remove(id);
            System.out.println("Order deleted successfully!");
        } else {
            System.out.println("Order not found.");
        }
    }

    // Show Category-wise Count
        public static void showCategoryWiseCount() {
        Map<String, Integer> categoryCount = new HashMap<>();

        for (Order order : orders.values()) {
            categoryCount.put(order.category, categoryCount.getOrDefault(order.category, 0) + 1);
        }

        System.out.println("Category-wise Order Count:");
        for (Map.Entry<String, Integer> entry : categoryCount.entrySet()) {
            System.out.println("Category: " + entry.getKey() + ", Orders: " + entry.getValue());
        }
    }

    // Show Category-wise Total Amount
    public static void showCategoryWiseTotalAmount() {
        Map<String, Double> categoryTotalAmount = new HashMap<>();

        for (Order order : orders.values()) {
            double totalAmount = order.quantity * order.price;
            categoryTotalAmount.put(order.category, categoryTotalAmount.getOrDefault(order.category, 0.0) + totalAmount);
        }

        System.out.println("Category-wise Total Amount:");
        for (Map.Entry<String, Double> entry : categoryTotalAmount.entrySet()) {
            System.out.println("Category: " + entry.getKey() + ", Total Amount: " + entry.getValue());
        }
    }
}
