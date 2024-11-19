package com.labs.java.io;

public class Product implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    enum ProductCategory {
        MOBILES, LAPTOP, FURNITURE
    }

    private int id;
    private ProductCategory category;
    private String description;
    private double price;
    private boolean active;

    public Product() {

    }

    public Product(int id, ProductCategory category, String description, double price, boolean active) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.price = price;
        this.active = active;

    }

    public int getId() {
        return id;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void main(String[] args) {

    }
}
