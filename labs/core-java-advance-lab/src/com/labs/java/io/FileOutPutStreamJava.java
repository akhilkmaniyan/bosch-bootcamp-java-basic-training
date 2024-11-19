package com.labs.java.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileOutPutStreamJava {
    public static void main(String[] args) {
        String message = "Welcome to java training";
        try (FileOutputStream out = new FileOutputStream("./output/output.txt")) {
            //option 1
//            out.write(message.getBytes());
//            System.out.println("Data has been written to the file.");

            //option 2
            out.write(message.getBytes(StandardCharsets.UTF_8));
            System.out.println("Data has been written to the file.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
