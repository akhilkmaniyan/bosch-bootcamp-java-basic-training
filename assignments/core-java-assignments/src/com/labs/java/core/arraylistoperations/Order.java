package com.labs.java.core.arraylistoperations;

public class Order {
    int id;
    String description;
    String category;
    int quantity;
    double price;

    public Order(int id, String description, String category, int quantity, double price) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return "Order ID: " + id + ", Description: " + description + ", Category: " + category +
                ", Quantity: " + quantity + ", Price: " + price;
    }
}