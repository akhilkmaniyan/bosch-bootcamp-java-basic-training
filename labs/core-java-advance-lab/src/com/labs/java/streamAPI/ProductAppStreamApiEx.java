package com.labs.java.streamAPI;

import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductAppStreamApiEx {
    public static void main(String[] args) {
        Map<Integer,Product> products = new HashMap<>();
        products.put(100, new Product(100,Product.ProductCategory.LAPTOP, "HP Pavilion", 45000, true));
        products.put(101, new Product(101,Product.ProductCategory.MOBILES, "iPhone 16", 15000, true));
        products.put(102, new Product(102,Product.ProductCategory.FURNITURE, "Table", 5000, true));
        products.put(103, new Product(103,Product.ProductCategory.STATIONARY, "Pen", 50, true));
        products.put(104, new Product(104,Product.ProductCategory.MOBILES, "Samsung Galaxy S24", 25000, true));
        products.put(105, new Product(105,Product.ProductCategory.LAPTOP, "Dell Inspiron", 35000, true));
        products.put(106, new Product(106,Product.ProductCategory.FURNITURE, "Chair", 2500, true));
        products.put(107, new Product(107,Product.ProductCategory.STATIONARY, "Pencil", 5, true));
        products.put(108, new Product(108,Product.ProductCategory.MOBILES, "OnePlus 9", 45000, true));
        products.put(109, new Product(109,Product.ProductCategory.LAPTOP, "Lenovo ThinkPad", 55000, true));

        double count = products.values().stream()
                .filter(product -> product.getPrice() > 10000)
                .count();
        System.out.println("Products with price greater than 10,000: " + count);


        Map<Product.ProductCategory, Long> productsByCategory = products.values().stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));

        productsByCategory.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));


        Map<Product.ProductCategory, Double> avgPriceByCategory = products.values().stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)
                ));

        avgPriceByCategory.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));


        List<Product> laptops = products.values().stream()
                .filter(product -> product.getCategory() == Product.ProductCategory.LAPTOP)
                .collect(Collectors.toList());

        laptops.forEach(laptop -> System.out.println( laptop.getDescription() + ":" + laptop.getId()));
    }
}
