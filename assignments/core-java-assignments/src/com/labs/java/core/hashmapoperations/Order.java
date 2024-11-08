package com.labs.java.core.hashmapoperations;

public class Order {
    int id;
    String description;
    String category;
    int quantity;
    double price;

    // Constructor
    public Order(int id, String description, String category, int quantity, double price) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    // Override toString() to display the order details
    @Override
    public String toString() {
        return "Order ID: " + id + ", Description: " + description + ", Category: " + category +
                ", Quantity: " + quantity + ", Price: " + price;
    }
}