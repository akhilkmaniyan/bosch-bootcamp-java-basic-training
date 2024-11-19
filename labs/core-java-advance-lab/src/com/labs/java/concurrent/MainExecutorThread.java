package com.labs.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutorThread {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("cores available : "+cores);
        ExecutorService es = Executors.newFixedThreadPool(cores);
        System.out.println("executor service : "+es);
    }
}
