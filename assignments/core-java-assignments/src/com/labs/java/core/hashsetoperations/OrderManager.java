package com.labs.java.core.hashsetoperations;
import java.util.HashSet;
import java.util.Scanner;

public class OrderManager {
     static HashSet<Order> orders = new HashSet<>();
     static Scanner scanner = new Scanner(System.in);

    // CREATE: Add a new order
    public static void addOrder() {
        System.out.println("Enter Order ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Description:");
        String description = scanner.nextLine();
        System.out.println("Enter Category:");
        String category = scanner.nextLine();
        System.out.println("Enter Quantity:");
        int quantity = scanner.nextInt();
        System.out.println("Enter Price:");
        double price = scanner.nextDouble();

        Order newOrder = new Order(id, description, category, quantity, price);
        if (orders.add(newOrder)) {
            System.out.println("Order added successfully!");
        } else {
            System.out.println("Order with this ID already exists.");
        }
    }

    // READ: View all orders
    public static void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders to display.");
        } else {
            System.out.println("All Orders:");
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    // UPDATE: Update an existing order
    public static void updateOrder() {
        System.out.println("Enter the Order ID to update:");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Find the order by id
        Order orderToUpdate = null;
        for (Order order : orders) {
            if (order.id == id) {
                orderToUpdate = order;
                break;
            }
        }

        if (orderToUpdate != null) {
            System.out.println("Order found: " + orderToUpdate);

            System.out.println("Enter new Description (leave blank to keep current):");
            String description = scanner.nextLine();
            if (!description.isEmpty()) {
                orderToUpdate.description = description;
            }

            System.out.println("Enter new Category (leave blank to keep current):");
            String category = scanner.nextLine();
            if (!category.isEmpty()) {
                orderToUpdate.category = category;
            }

            System.out.println("Enter new Quantity (enter 0 to keep current):");
            int quantity = scanner.nextInt();
            if (quantity != 0) {
                orderToUpdate.quantity = quantity;
            }

            System.out.println("Enter new Price (enter 0 to keep current):");
            double price = scanner.nextDouble();
            if (price != 0) {
                orderToUpdate.price = price;
            }

            System.out.println("Order updated successfully!");
        } else {
            System.out.println("Order not found.");
        }
    }

    // DELETE: Delete an order
    public static void deleteOrder() {
        System.out.println("Enter the Order ID to delete:");
        int id = scanner.nextInt();

        Order orderToDelete = null;
        for (Order order : orders) {
            if (order.id == id) {
                orderToDelete = order;
                break;
            }
        }

        if (orderToDelete != null) {
            orders.remove(orderToDelete);
            System.out.println("Order deleted successfully!");
        } else {
            System.out.println("Order not found.");
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nOrder Management System");
            System.out.println("1. Add Order");
            System.out.println("2. View Orders");
            System.out.println("3. Update Order");
            System.out.println("4. Delete Order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addOrder();
                    break;
                case 2:
                    viewOrders();
                    break;
                case 3:
                    updateOrder();
                    break;
                case 4:
                    deleteOrder();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
