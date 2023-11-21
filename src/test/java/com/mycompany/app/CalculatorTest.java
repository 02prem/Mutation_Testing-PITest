package com.mycompany.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
    
    @Test
    public void testAdd() {
        assertEquals(5.0, Calculator.add(2.0, 3.0), 0.0001);
        assertEquals(-1.5, Calculator.add(-2.5, 1.0), 0.0001);
        assertEquals(0.0, Calculator.add(0.0, 0.0), 0.0001);
    }

    @Test
    public void testSubtract() {
        assertEquals(2.0, Calculator.subtract(5.0, 3.0), 0.0001);
        assertEquals(-3.5, Calculator.subtract(-2.5, 1.0), 0.0001);
        assertEquals(0.0, Calculator.subtract(0.0, 0.0), 0.0001);
    }

    @Test
    public void testMultiply() {
        assertEquals(6.0, Calculator.multiply(2.0, 3.0), 0.0001);
        assertEquals(-2.5, Calculator.multiply(-2.5, 1.0), 0.0001);
        assertEquals(0.0, Calculator.multiply(0.0, 0.0), 0.0001);
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, Calculator.divide(6.0, 3.0), 0.0001);
        assertEquals(-2.5, Calculator.divide(-5.0, 2.0), 0.0001);
        assertEquals(0.0, Calculator.divide(5.0, 0.0), 0.0001);
    }

    @Test
    public void testMod(){
        assertEquals(2.0, Calculator.mod(7.0, 5.0), 0.001);
        assertEquals(0.0, Calculator.mod(10.0, 2.0), 0.001);
    }

    @Test
    public void testAbsoluteValue(){
        assertEquals(10.0, Calculator.absoluteValue(10.0), 0.001);
        assertEquals(2.0, Calculator.absoluteValue(-2.0), 0.001);
        assertEquals(0.0001, Calculator.absoluteValue(-0.0001), 0.001);
    }

    @Test
    public void testPower(){
        assertEquals(8.0, Calculator.power(2.0, 3), 0.001);
        assertEquals(1.0, Calculator.power(5.0, 0), 0.001);
        assertEquals(0.25, Calculator.power(2.0, -2), 0.001);
    }

    @Test
    public void testSquare() {
        assertEquals(25.0, Calculator.square(5.0), 0.001);
        assertEquals(0.0, Calculator.square(0.0), 0.001);
        assertEquals(9.0, Calculator.square(-3.0), 0.001);
    }

    @Test
    public void testExponential() {
        assertEquals(Math.exp(3), Calculator.exponential(3), 0.001);
        assertEquals(1.0, Calculator.exponential(0), 0.001);
        assertEquals(Math.exp(-2), Calculator.exponential(-2), 0.001);
    }

    private static final double TOLERANCE = 1e-3;
    @Test
    public void testLogbase10() {
        assertEquals(1.0, Calculator.logBase10(10), TOLERANCE);
        assertEquals(2.0, Calculator.logBase10(100), TOLERANCE);
        assertEquals(0, Calculator.logBase10(-10), TOLERANCE);
    }

    @Test
    public void testLogbaseX() {
        assertEquals(3.0, Calculator.logBaseX(8, 2), TOLERANCE);
        assertEquals(1.0, Calculator.logBaseX(10, 10), TOLERANCE);        
        assertEquals(0.0, Calculator.logBaseX(8, 0), TOLERANCE);
        assertEquals(0.0, Calculator.logBaseX(0, 7), TOLERANCE);
        assertEquals(0.0, Calculator.logBaseX(8, -2), TOLERANCE);
    } 

    @Test
    public void testSquareRoot() {
        assertEquals(2.0, Calculator.squareRoot(4), TOLERANCE);
        assertEquals(0.0, Calculator.squareRoot(0), TOLERANCE);
        assertEquals(-1.0, Calculator.squareRoot(-9), TOLERANCE);
    }

    @Test
    public void testInverse() {
        assertEquals(0.5, Calculator.inverse(2), TOLERANCE);
        assertEquals(-0.25, Calculator.inverse(-4), TOLERANCE);
        assertEquals(0, Calculator.inverse(0), TOLERANCE);
    }

    @Test
    public void testFactorial() {
        assertEquals(1, Calculator.factorial(0), TOLERANCE);
        assertEquals(1, Calculator.factorial(1), TOLERANCE);
        assertEquals(24, Calculator.factorial(4), TOLERANCE);
        assertEquals(0, Calculator.factorial(-2), TOLERANCE);
    }

    @Test
    public void testSine() {
        assertEquals(0.5, Calculator.sine(30), TOLERANCE);
        assertEquals(-0.707, Calculator.sine(-45), TOLERANCE);
        assertEquals(0.0, Calculator.sine(0), TOLERANCE);
        assertEquals(1.0, Calculator.sine(90), TOLERANCE);
    }

    @Test
    public void testInverseSine() {
        assertEquals(30, Calculator.inverseSine(0.5), TOLERANCE);
        assertEquals(90, Calculator.inverseSine(1), TOLERANCE);
        assertEquals(-90, Calculator.inverseSine(-1), TOLERANCE);
    }

    @Test
    public void testCosine() {
        assertEquals(0.866, Calculator.cosine(30), TOLERANCE);
        assertEquals(0.707, Calculator.cosine(-45), TOLERANCE);
        assertEquals(1.0, Calculator.cosine(0), TOLERANCE);
        assertEquals(0.0, Calculator.cosine(90), TOLERANCE);
    }

    @Test
    public void testInverseCosine() {
        assertEquals(30.0, Calculator.inverseCosine(0.866), 0.01);
        assertEquals(0.0, Calculator.inverseCosine(1), TOLERANCE);
        assertEquals(180.0, Calculator.inverseCosine(-1), TOLERANCE);
    }

    @Test
    public void testTangent() {
        assertEquals(Math.tan(Math.toRadians(30)), Calculator.tangent(30), TOLERANCE);
        // assertEquals(0, Calculator.tangent(90), TOLERANCE);
        assertEquals(0, Calculator.tangent(180), TOLERANCE);
    }

    @Test
    public void testInverseTangent() {
        assertEquals(30, Calculator.inverseTan(Math.tan(Math.toRadians(30))), TOLERANCE);
        assertEquals(0, Calculator.inverseTan(0), TOLERANCE);
    }
}
