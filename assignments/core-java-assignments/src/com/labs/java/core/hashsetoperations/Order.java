package com.labs.java.core.hashsetoperations;

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

    // Overriding equals() and hashCode() to use 'id' for comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Order ID: " + id + ", Description: " + description + ", Category: " + category +
                ", Quantity: " + quantity + ", Price: " + price;
    }
}
