package com.labs.java.concurrent;

public class MainThread {
    public static void main(String[] args) {
        System.out.println("Java Thread Demo");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println("Current Thread name : " + Thread.currentThread().getName());
        System.out.println("Current Thread id : " + Thread.currentThread().getId());
        System.out.println("Current Thread priority : " + Thread.currentThread().getPriority());
        System.out.println("Current Thread state : " + Thread.currentThread().getState());

        PrinterThread t1 = new PrinterThread();
        t1.setDaemon(true);
        t1.setName("newthread");
        System.out.println("Thread state : "+ t1.getState());
        t1.start();

        for(int i=1;i<=10;i++) {
            System.out.println("MainThread name : " + Thread.currentThread().getName() + "   " + i);
        }
    }
}
