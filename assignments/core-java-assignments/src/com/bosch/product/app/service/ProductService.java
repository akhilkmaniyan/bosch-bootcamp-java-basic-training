package com.bosch.product.app.service;

import com.bosch.product.app.exception.ProductValidationException;
import com.bosch.product.app.model.Product;

public interface ProductService {
    void addProduct(Product product) throws ProductValidationException;

    void updateProduct(int id, Product product) throws ProductValidationException;

    void deleteProduct(int id) throws ProductValidationException;

    void viewAlProducts();

    void viewProduct(Product product) throws ProductValidationException;

    void printStatistics();

    boolean importProducts();

    boolean exportProducts();
}
