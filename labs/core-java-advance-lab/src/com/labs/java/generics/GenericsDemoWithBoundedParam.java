package com.labs.java.generics;

public class GenericsDemoWithBoundedParam {

    public  static <E extends Number> void printArray(E[] inputArray ) {//Bounded param
      for(E element :inputArray){
          System.out.println(element);
      }
    }
    public static void main(String[] args) {
        //Gener
        Integer [] integers ={1,2,3,4,5};
         printArray(integers);
//        String [] strings ={"Hello","world"};
//        printArray(strings);
    }
}
