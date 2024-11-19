package com.labs.java.fp;

import java.util.function.BiFunction;

public class LambdaExp {

    public static void main(String[] args) {
//        BiFunction<Integer, Integer, String> checkEvenOrOdd = (a, b) -> {
//            int sum = a + b;
//            return (sum % 2 == 0) ? "Even" : "Odd";
//        };
//        int num1 = 4, num2 = 5;
//        System.out.println("The sum of " + num1 + " and " + num2 + " is " + checkEvenOrOdd.apply(num1, num2));


//        Predicate<Integer> isPrime = (number) -> {
//            if (number <= 1) {
//                return false;
//            }
//            for (int i = 2; i < number/2; i++) {
//                if (number % i == 0) {
//                    return false;
//                }
//            }
//            return true;
//        };
//
//        int numberToCheck = 30;
//        if (isPrime.test(numberToCheck)) {
//            System.out.println(numberToCheck + " is a prime number.");
//        } else {
//            System.out.println(numberToCheck + " is not a prime number.");
//        }
//


//        Function<int[], Integer> sumFunction = (int[] arr) -> {
//            int sum = 0;
//            for (int num : arr) {
//                if (num % 2 == 0) {
//                    sum += num*num;
//                }
//            }
//            return sum;
//        };
//        int[] numbers = {1, 2, 3, 4};
//        System.out.println("Sum is + " + sumFunction.apply(numbers));


        BiFunction<String, String,Integer> stringComparison =(s1, s2)-> s1.compareTo(s2);
        System.out.println("Value is" + stringComparison.apply("Hello","Bosch"));

    }
}
