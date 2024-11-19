package com.labs.java.fp;

public class CalculatorFP {
    private int a;
    private int b;

//    public CalculatorFP() {
//    }
//
//    public int add(int a, int b) {
//        return a + b;
//    }
//
//    public int sub(int a, int b) {
//        return a - b;
//    }
//
//    public int mult(int a, int b) {
//        return a * b;
//    }
//
//    public int div(int a, int b) {
//        return a / b;
//    }
    public int compute(int a, int b, Operation operation) {
       return operation.compute(a,b);
    }
}
