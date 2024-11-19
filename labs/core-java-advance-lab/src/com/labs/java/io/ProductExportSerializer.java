package com.labs.java.io;

import java.io.*;

public class ProductExportSerializer {
    public static void main(String[] args) throws FileNotFoundException {
        Product Obj =  deserializeProduct();
        writetoFile(Obj);
    }

    public static Product deserializeProduct() {
        Product product = null;
        try (FileInputStream fileIn = new FileInputStream("./output/product.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            product = (Product) in.readObject();
            System.out.println("Product deserialized successfully.");
            System.out.println(product);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return product;
    }

    public static void writetoFile(Product product) throws FileNotFoundException {
        try (FileWriter fileWriter = new FileWriter("./output/product_details.txt");
             PrintWriter writer = new PrintWriter(fileWriter)) {
            writer.println("Product Details:");
            writer.println("Id: " + product.getId());
            writer.println("Name: " + product.getDescription());
            writer.println("Price: " + product.getId());
            System.out.println("Product details written to product_details.txt.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
