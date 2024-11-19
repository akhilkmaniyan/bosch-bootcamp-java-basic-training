package com.bosch.tests;

import org.junit.Test;
//import org.junit.jupiter;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void add() {
        Calculator calculator = new Calculator();
        assertEquals(11, calculator.add(5, 6));
    }

}
