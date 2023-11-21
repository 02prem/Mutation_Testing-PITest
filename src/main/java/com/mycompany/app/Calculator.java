package com.mycompany.app;

import java.util.*;
import java.io.*;

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
            return 0;
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
        if(num <= 0){
            return 0;
        }

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
        if(number < 0){
            return -1;
        }
        return Math.sqrt(number);
    }

    // inverse (x ^ -1) (call divide)
    public static double inverse(double num){
        double res = divide(1, num);
        return res;
    }

    // factorial
    public static double factorial(double n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        else {
            return n * factorial(n - 1);
        }
    }

    // sine
    public static double sine(double degree){
        double radians = Math.toRadians(degree);
        double res = Math.sin(radians);

        return res;
    }

    // inverse sine
    public static double inverseSine(double num){
        double res = Math.asin(num);
        return Math.toDegrees(res);
    }

    // cosine
    public static double cosine(double degree){
        double radians = Math.toRadians(degree);
        double res = Math.cos(radians);

        return res;
    }

    // inverse cosine
    public static double inverseCosine(double num){
        double res = Math.acos(num);
        return Math.toDegrees(res);
    }

    // tan (sin / cos)  (call sine, cosine and divide)
    public static double tangent(double degree){
        double res = divide(sine(degree), cosine(degree));

        return res;
    }

    // inverse tangent
    public static double inverseTan(double num){
        double res = Math.atan(num);
        return Math.toDegrees(res);
    }
}
