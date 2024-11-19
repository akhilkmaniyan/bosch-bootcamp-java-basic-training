package com.labs.java.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class ProductImportSerializer {
    public static void main(String[] args) throws FileNotFoundException {
        String productDetail = readProductDetailFromFile();
        Product product = createProduct(productDetail);
        serializeProductToFile(product);
    }


//    public static String readProductDetailFromFile() throws FileNotFoundException {
//        String productDetail = "";
//        try (Scanner scanner = new Scanner(new FileReader("./input/product.txt"))) {
//            while (scanner.hasNextLine()) {
//                productDetail = scanner.nextLine();
//            }
//            System.out.println(productDetail);
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//        return productDetail;
//    }

    public static String readProductDetailFromFile() throws FileNotFoundException {
        String productDetail = "";
        Path path = Paths.get("./input/product.txt");
        try (ByteChannel byteChannel = FileChannel.open(path, StandardOpenOption.READ)) {
            long fileSize = Files.size(path);
            ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);
            while (byteChannel.read(buffer) > 0) {
            }
            buffer.flip();
            productDetail = new String(buffer.array(), 0, buffer.limit(), "UTF-8");
            System.out.println(productDetail);

            return productDetail;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Product createProduct(String productDetail) {
        String[] productDetails = productDetail.split(",");
        int id = Integer.parseInt(productDetails[0]);
        Product.ProductCategory category = Product.ProductCategory.valueOf(productDetails[1]);
        String description = productDetails[2];
        double price = Double.parseDouble(productDetails[3]);
        boolean active = Boolean.parseBoolean(productDetails[4]);
        return new Product(id, category, description, price, active);
    }

    public static void serializeProductToFile(Product product) {
        try (FileOutputStream fileOut = new FileOutputStream("./output/product.ser"); ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(product);
            System.out.println("Product objects serialized successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


}