package com.bosch.product.app.service;

import com.bosch.product.app.exception.ProductValidationException;
import com.bosch.product.app.model.Product;
import com.labs.java.core.arraylistoperations.Order;

import java.util.ArrayList;
import java.util.HashMap;


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

}
