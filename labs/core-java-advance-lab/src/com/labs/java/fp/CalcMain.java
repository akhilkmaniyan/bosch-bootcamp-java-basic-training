package com.labs.java.fp;

public class CalcMain {

    public static void main(String[] args) {
//        CalcaulatorOOP calcaulatorOOP = new CalcaulatorOOP(5, 5);
//        System.out.println("Addition is" + calcaulatorOOP.add());
//        System.out.println("multiply is" + calcaulatorOOP.mult());
//        System.out.println("substraction is" + calcaulatorOOP.sub());
//        System.out.println("division is  is" + calcaulatorOOP.div());

//        CalculatorFP calculatorFP = new CalculatorFP();
//        System.out.println("Addition is" + calculatorFP.add(5, 6));
//        System.out.println("multiply is" + calculatorFP.mult(7, 8));
//        System.out.println("substraction is" + calculatorFP.sub(8, 9));
//        System.out.println("division is  is" + calculatorFP.div(10, 11));

        Operation operation = new Operation() {
            @Override
            public int compute(int a, int b) {
                return a + b;
            }
        };
        Operation operation1 = (a, b) -> {
            return a - b;
        };
        CalculatorFP calculatorFP = new CalculatorFP();
        System.out.println("Addition is" + calculatorFP.compute(5, 6, operation));
        System.out.println("Substraction is" + calculatorFP.compute(11, 6, operation));
    }

}
