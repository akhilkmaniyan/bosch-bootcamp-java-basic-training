package com.labs.java.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Account {

    private final int id;
    private final double balance;
    private final String name;

    public Account(final int id, final double balance, final String name) {
        this.id = id;
        this.balance = balance;
        this.name = name;
    }

    public Double checkBalance() {
        return balance;
    }

    @ApplyInterest(roi = 7.5)
    public double calculateBalance() {
        double interestRate = 0;
        try {
            Method method = this.getClass().getMethod("calculateBalance");
            double roi = method.isAnnotationPresent(ApplyInterest.class) ? method.getAnnotation(ApplyInterest.class).roi()
                    : 0.0;
            interestRate = checkBalance() * roi;

        } catch (NoSuchMethodException e) {
            System.out.println("Method not found: " + e.getMessage());
        }

        return interestRate;
    }

    public static void main(String[] args) {

        Account account = new Account(1, 500.00, "Akhil");
        account.checkBalance();
        System.out.println("Balance  is" + account.calculateBalance());
    }
}
