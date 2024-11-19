package com.labs.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamJava {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("./input/input.txt")) {
            int byteData;
            while ((byteData = in.read()) != -1) {
                System.out.print((char) byteData);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
