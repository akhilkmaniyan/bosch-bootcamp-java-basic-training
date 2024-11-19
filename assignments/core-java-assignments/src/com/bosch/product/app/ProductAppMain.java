package com.bosch.product.app;

import com.bosch.product.app.exception.ProductValidationException;
import com.bosch.product.app.model.Product;
import com.bosch.product.app.service.ProductService;
import com.bosch.product.app.service.ProductServiceImpl;
import com.labs.java.core.arraylistoperations.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductAppMain {
    private static Scanner scanner = new Scanner(System.in);

    private static ProductService productService = new ProductServiceImpl();

    public static void main(String[] args) {

        System.out.println("Welcome to Product App");
        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. view Product");
            System.out.println("5. View All Products");
            System.out.println("6. Print Statics");
            System.out.println("7. Import");
            System.out.println("8. Export");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            int id;
            switch (choice) {
                case 1:
                    System.out.println("Enter Product Order ID:");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the product category:");
                    String category = scanner.nextLine();
                    System.out.println("Enter Description :");
                    String description = scanner.nextLine();
                    System.out.println("Enter the price");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Product active or not");
                    boolean active = scanner.nextBoolean();
                    Product product = new Product(id, Product.ProductCategory.valueOf(category), description, price, active);
                    try {
                        productService.addProduct(product);
                    } catch (ProductValidationException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println(" Enter the product Id to update");
                    id = scanner.nextInt();
                    Product productIdToUpdate = updateProducts(ProductServiceImpl.products.get(id));
                    try {
                        productService.updateProduct(productIdToUpdate.getId(),productIdToUpdate);
                    } catch (ProductValidationException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("3. Delete Product");
                    break;
                case 4:
                    productService.viewProduct(new Product());
                    break;
                case 5:
                    productService.viewAlProducts();

                    break;
                case 6:
                    System.out.println("6. Print Statics");
                    break;
                case 7:
                    System.out.println("7. Import");

                    //To import product details from a file
                    break;
                case 8:
                    //To export product details from a file
                    System.out.println("8. Export");
                    break;
                case 9:
                    System.out.println("9. Exit");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
                    break;
            }
        }
    }

    private static Product updateProducts(Product product)  {
        System.out.println(" Enter the new Category");
        String categoryToUpdate = scanner.next();
        scanner.nextLine();
        product.setCategory(Product.ProductCategory.valueOf(categoryToUpdate));
        System.out.println("Enter Description :");
        String descriptionToUpdate = scanner.nextLine();
        product.setDescription(descriptionToUpdate);
        System.out.println("Enter the price");
        double priceToUpdate = scanner.nextDouble();
        product.setPrice(priceToUpdate);
        return product;
    }

}
