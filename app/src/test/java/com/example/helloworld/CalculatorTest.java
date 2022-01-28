package com.example.helloworld;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    public void testAdd() {
        int expected = 30;
        int actual = Calculator.add(10,20);

        assertEquals(expected,actual);
    }

    public void testMultiply() {
        int expected = 40;
        int actual = Calculator.multiply(10,20);

        assertEquals(expected,actual);
    }
}
