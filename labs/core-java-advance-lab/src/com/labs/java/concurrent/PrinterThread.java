package com.labs.java.concurrent;

public class PrinterThread extends Thread{
    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            System.out.println("PrinterThread name : "+Thread.currentThread().getName()+"   " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}