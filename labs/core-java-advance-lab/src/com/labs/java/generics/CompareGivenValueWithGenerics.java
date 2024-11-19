package com.labs.java.generics;

public class CompareGivenValueWithGenerics {

    public static <E extends Comparable<E>> void compareValues(E a, E b) {
      if(a.compareTo(b) > 0) {
          System.out.println( a + "is larger ");
      }
        else if(a.compareTo(b) < 0) {
            System.out.println( b + "is larger");
        }
        else {
          System.out.println("Both are equal");
      }
    }

    public static void main(String[] args) {
        compareValues(5,6);
        compareValues("Akhil","Maniyan");
    }
}
