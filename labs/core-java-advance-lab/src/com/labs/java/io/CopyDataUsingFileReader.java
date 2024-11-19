package com.labs.java.io;

import java.io.*;

public class CopyDataUsingFileReader {
    public static void main(String[] args) {
        try (FileReader in = new FileReader("./input/input.txt");
             FileWriter out = new FileWriter("./output/output.txt");) {
             in.transferTo(out);//option 1
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}