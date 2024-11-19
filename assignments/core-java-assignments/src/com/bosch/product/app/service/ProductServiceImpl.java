package com.bosch.product.app.service;

import com.bosch.product.app.exception.ProductValidationException;
import com.bosch.product.app.model.Product;
import com.labs.java.core.arraylistoperations.Order;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class ProductServiceImpl implements ProductService {

    public static HashMap<Integer,Product> products = new HashMap<>();

    @Override
    public void addProduct(Product product) throws ProductValidationException {
        if (product.getId() <= 0) {
            throw new ProductValidationException("Product Id cannot be zero or negative");
        }
        products.put(product.getId(),product);
    }

    @Override
    public void updateProduct(int id, Product product) throws ProductValidationException {
      if (id <= 0){
          throw new ProductValidationException("Product Id cannot be zero or negative");
      }
        products.put(id,product);
        System.out.println("Product Updated successfully");
    }

    @Override
    public void deleteProduct(int id) throws ProductValidationException {
        if (id <= 0){
            throw new ProductValidationException("Product Id cannot be zero or negative");
        }
        products.remove(id);
        System.out.println("Product deleted successfully");
    }


    @Override
    public void viewProduct(Product product) throws ProductValidationException {
        if (product.getId() <= 0) {
            throw new ProductValidationException("Product Id cannot be zero or negative");
        }
        System.out.println(product);
    }

    @Override
    public void viewAlProducts() {
        for (Product value : products.values()) {
            System.out.println(value);
        }
    }
    @Override
    public void printStatistics() {
        long countExpensiveProducts = products.values().stream()
                .filter(p -> p.getPrice() > 10000)
                .count();
        System.out.println("countExpensiveProducts:" + countExpensiveProducts);
        //Show no of products by product category with sorting
        Map<Product.ProductCategory, Long> productsByCategory = products.values().stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        productsByCategory.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        //Show avg price by product category
        Map<Product.ProductCategory, Double> avgPriceByCategory = products.values().stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)
                ));
        System.out.println("avgPriceByCategory:" + avgPriceByCategory);
        //List product ids whose product name contains given name
        avgPriceByCategory.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));


        int totalProducts = products.size();
        long totalAvailable = products.values().stream().filter(Product::isActive).count();
        double averagePrice = products.values().stream().mapToDouble(Product::getPrice).average().orElse(0.0);

        System.out.println("countExpensiveProducts:" + countExpensiveProducts);
        System.out.println("Total products: " + totalProducts);
        System.out.println("Total available products: " + totalAvailable);
        System.out.println("Average price: " + averagePrice);

        //List product ids whose product name contains given name
        Scanner in = new Scanner(System.in);
        System.out.print("Enter name to search for product IDs: ");
        String searchName = in.nextLine();
        List<Integer> matchingProductIds = products.values().stream()
                .filter(product -> product.getDescription().toLowerCase().contains(searchName.toLowerCase()))
                .map(Product::getId)
                .collect(Collectors.toList());
        if (matchingProductIds.isEmpty()) {
            System.out.println("No products found with name containing: " + searchName);
        } else {

            System.out.println("Product IDs containing name '" + searchName + "': " + matchingProductIds);
        }
    }

    @Override
    public boolean importProducts() {
        String filePath = "./input/product-input.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                Product.ProductCategory category = Product.ProductCategory.valueOf(values[1].toUpperCase());
                String name = values[2];
                double price = Double.parseDouble(values[3]);
                boolean active = Boolean.parseBoolean(values[4]);
                Product product = new Product(id, category, name, price, active);
                products.put(id, product);
            }
            System.out.println(Thread.currentThread().getName() + " - Importing products...");
            return true;
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error importing products: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean exportProducts() {
        String filePath = "./output/product-output.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("id,category,name,price,active\n");
            for (Product product : products.values()) {
                bw.write(product.getId() + "," + product.getCategory() + "," + product.getDescription() + "," + product.getPrice() + "," + product.isActive() + "\n");
            }
            System.out.println(Thread.currentThread().getName() + " - Exporting products...");
            return true;
        } catch (IOException e) {

            System.err.println("Error exporting products: " + e.getMessage());
            return false;
        }
    }

}
