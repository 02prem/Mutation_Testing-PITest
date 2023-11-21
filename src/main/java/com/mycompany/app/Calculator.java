package com.mycompany.app;

public class Calculator {
    // add
    public static double add(double a, double b) {
        double c = a + b;
        return c;
    }

    // subtract
    public static double subtract(double a, double b) {
        double c = a - b;
        return c;
    }

    // multiply
    public static double multiply(double num1, double num2) {
        double result = num1 * num2;
        return result;
    }

    // divide
    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            // double result = num1 / num2;
            throw new ArithmeticException("Cannot divide by zero");
        }
        
        double res = num1 / num2;
        return res;
    }

    // mod
    public static double mod(double a, double b) {
        double res = a % b;
        return res;
    }

    // absolute value
    public static double absoluteValue(double num) {
        return Math.abs(num);
    }

    // power
    public static double power(double base, int exponent) {
        // Using Math.pow() to calculate power
        double res = Math.pow(base, exponent);
        return res;
    }

    // square (call power)
    public static double square(double base){
        double res = power(base, 2);
        return res;
    }

    // exponential
    public static double exponential(int exponent){
        double res = Math.exp(exponent);
        return res;
    }

    // log base 10
    public static double logBase10(double num) {
        double res = Math.log10(num);
        return res;
    }

    // log base x   (call divide and logBase10)
    public static double logBaseX(double num, double base) {
        double res = divide(logBase10(num), logBase10(base));
        return res;
    }

    // sqaure root
    public static double squareRoot(double number) {
        return Math.sqrt(number);
    }
    // inverse (x ^ -1)
    // factorial
    // sin
    // cos
    // tan (sin / cos)
    
}
