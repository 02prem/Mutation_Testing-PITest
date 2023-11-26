package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.*;

public class NumberTheoryTest {
    @Test
    public void t1(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(9, 5, 6));
        List<Integer> res = NumberTheory.add(l1, l2, 10);
        assertEquals(Arrays.asList(1, 0, 7, 9), res);
    }

    @Test
    public void t2(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(4, 5));
        List<Integer> res = NumberTheory.add(l1, l2, 10);
        assertEquals(Arrays.asList(1, 6, 8), res);
    }

    @Test
    public void t3(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> l2 = new ArrayList<>();
        List<Integer> res = NumberTheory.add(l1, l2, 10);
        assertEquals(Arrays.asList(1, 2, 3), res);
    }

    @Test
    public void t4(){
        List<Integer> l2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> l1 = new ArrayList<>();
        List<Integer> res = NumberTheory.add(l1, l2, 10);
        assertEquals(Arrays.asList(1, 2, 3), res);
    }

    @Test
    public void t5(){
        List<Integer> l2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> l1 = new ArrayList<>(Arrays.asList(4, 5));
        List<Integer> res = NumberTheory.add(l1, l2, 10);
        assertEquals(Arrays.asList(1, 6, 8), res);
    }

    @Test
    public void t6(){
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> res = NumberTheory.add(l1, l2, 10);
        assertEquals(Arrays.asList(), res);
    }

    @Test
    public void t7(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(4, 5, 6));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> res = NumberTheory.subtract(l1, l2, 10);
        assertEquals(Arrays.asList(3, 3, 3), res);
    }

    @Test
    public void t8(){
        List<Integer> l2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> res = NumberTheory.subtract(l1, l2, 10);
        assertEquals(Arrays.asList(-3, 3, 3), res);
    }

    @Test
    public void t9(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(5, 0, 0));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 5));
        List<Integer> res = NumberTheory.subtract(l1, l2, 10);
        assertEquals(Arrays.asList(4, 7, 5), res);
    }

    @Test
    public void tx(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(5, 0, 0, 0, 0, 0, 0, 0));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2));
        List<Integer> res = NumberTheory.subtract(l1, l2, 10);
        assertEquals(Arrays.asList(4, 9, 9, 9, 9, 9, 9, 8), res);
    }

    @Test
    public void t10(){
        List<Integer> l2 = new ArrayList<>(Arrays.asList(1, 0, 0));
        List<Integer> l1 = new ArrayList<>(Arrays.asList(2, 5));
        List<Integer> res = NumberTheory.subtract(l1, l2, 10);
        assertEquals(Arrays.asList(-7, 5), res);
    }

    @Test
    public void t11(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> res = NumberTheory.subtract(l1, l2, 10);
        assertEquals(Arrays.asList(0), res);
    }

    @Test
    public void t12(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(4, 5, 6));
        List<Integer> l2 = new ArrayList<>();
        List<Integer> res = NumberTheory.subtract(l1, l2, 10);
        assertEquals(Arrays.asList(4, 5, 6), res);
    }

    @Test
    public void t14(){
        List<Integer> l2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        List<Integer> l1 = new ArrayList<>();
        List<Integer> res = NumberTheory.subtract(l1, l2, 10);
        assertEquals(Arrays.asList(-4, 5, 6), res);
    }

    @Test
    public void t13(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 0, 0));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(9, 9, 9));
        List<Integer> res = NumberTheory.subtract(l1, l2, 10);
        assertEquals(Arrays.asList(-8, 9, 9), res);
    }

    @Test
    public void t15(){
        int res = NumberTheory.max(1, 0);
        assertEquals(1, res);
    }

    @Test
    public void t16(){
        int res = NumberTheory.max(2, 5);
        assertEquals(5, res);
    }

    @Test
    public void t17(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 0));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(9));
        List<Integer> res = NumberTheory.multiply(l1, l2, 10);
        assertEquals(Arrays.asList(0, 9, 0), res);
    }

    @Test
    public void t18(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(0));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(9, 9));
        List<Integer> res = NumberTheory.multiply(l1, l2, 10);
        assertEquals(Arrays.asList(0, 0, 0), res);
    }

    @Test
    public void t19(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 0));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(9, 0));
        List<Integer> res = NumberTheory.multiply(l1, l2, 10);
        assertEquals(Arrays.asList(0, 9, 0, 0), res);
    }

    @Test
    public void t20(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(6, 5));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(9));
        List<Integer> res = NumberTheory.multiply(l1, l2, 8);
        assertEquals(Arrays.asList(7, 3, 5), res);
    }

    @Test
    public void t21(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(5));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2));
        AbstractMap.SimpleEntry<List<Integer>, List<Integer>> res = NumberTheory.divide(l1, l2, 10);
        assertEquals(Arrays.asList(2), res.getKey());
        assertEquals(Arrays.asList(0, 1), res.getValue());
    }

    @Test
    public void t22(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(2, 5));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 9));
        AbstractMap.SimpleEntry<List<Integer>, List<Integer>> res = NumberTheory.divide(l1, l2, 10);
        assertEquals(Arrays.asList(0), res.getKey());
        assertEquals(Arrays.asList(2, 5), res.getValue());
    }

    @Test
    public void t23(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(5, 2, 5));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(0));
        AbstractMap.SimpleEntry<List<Integer>, List<Integer>> res = NumberTheory.divide(l1, l2, 10);
        assertEquals(Arrays.asList(0, 0, 0), res.getKey());
        assertEquals(Arrays.asList(0, 5, 2, 5), res.getValue());
    }

    @Test
    public void t24() {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(5, 2, 5));
        NumberTheory.normalizeMul(l1,2);
        assertEquals(Arrays.asList(5, 2, 5, 0, 0), l1);
    }

    @Test
    public void t25() {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(0, 0, 5, 2, 5));
        NumberTheory.truncate(l1);
        assertEquals(Arrays.asList(5, 2, 5), l1);
    }

    @Test
    public void t26(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(2, 3));
        NumberTheory.normalize(l1, 2);
        assertEquals(Arrays.asList(2, 3, 0, 0), l1);
    }

    @Test
    public void t27(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(2, 5));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 9));
        int e1 = 2, e2 = 2;
        NumberTheory.normalize(l1, l2, e1, e2);
        assertEquals(Arrays.asList(2, 5), l1);
        assertEquals(Arrays.asList(2, 9), l2);
    }

    @Test
    public void t28(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(2, 5));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 9));
        int e1 = 1, e2 = 2;
        NumberTheory.normalize(l1, l2, e1, e2);
        assertEquals(Arrays.asList(2, 5), l1);
        assertEquals(Arrays.asList(2, 9, 0), l2);
    }

    @Test
    public void t29(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(2, 5));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 9));
        int e1 = 2, e2 = 1;
        NumberTheory.normalize(l1, l2, e1, e2);
        assertEquals(Arrays.asList(2, 5, 0), l1);
        assertEquals(Arrays.asList(2, 9), l2);
    }

    @Test
    public void t30() {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        AbstractMap.SimpleEntry<List<Integer>, Integer> n = new AbstractMap.SimpleEntry<>(l1, 5);
        AbstractMap.SimpleEntry<List<Integer>, Integer> res = NumberTheory.precise(n, 2);
        assertEquals(Arrays.asList(1, 2, 3, 0, 0), res.getKey());
    }

    @Test
    public void t31(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        AbstractMap.SimpleEntry<List<Integer>, Integer> n = new AbstractMap.SimpleEntry<>(l1, -4);
        NumberTheory.removeBack(n, 3);
        assertEquals(Arrays.asList(1, 2, 3), n.getKey());
        assertEquals(-3, n.getValue().intValue());
    }

    @Test
    public void t32(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        AbstractMap.SimpleEntry<List<Integer>, Integer> num1 = new AbstractMap.SimpleEntry<>(l1, -3);
        AbstractMap.SimpleEntry<List<Integer>, Integer> num2 = new AbstractMap.SimpleEntry<>(l2, -2);
        AbstractMap.SimpleEntry<List<Integer>, Integer> res = NumberTheory.addReal(num1, num2, 10);
        assertEquals(Arrays.asList(4, 6, 8, 3), res.getKey());
        assertEquals(-3, res.getValue().intValue());
    }

    @Test
    public void t33(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        AbstractMap.SimpleEntry<List<Integer>, Integer> num1 = new AbstractMap.SimpleEntry<>(l1, -3);
        AbstractMap.SimpleEntry<List<Integer>, Integer> num2 = new AbstractMap.SimpleEntry<>(l2, -2);
        AbstractMap.SimpleEntry<List<Integer>, Integer> res = NumberTheory.subtractReal(num1, num2, 10);
        assertEquals(Arrays.asList(-4, 4, 3, 7), res.getKey());
        assertEquals(-3, res.getValue().intValue());
    }

    @Test
    public void t34(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        AbstractMap.SimpleEntry<List<Integer>, Integer> num1 = new AbstractMap.SimpleEntry<>(l1, -3);
        AbstractMap.SimpleEntry<List<Integer>, Integer> num2 = new AbstractMap.SimpleEntry<>(l2, -2);
        AbstractMap.SimpleEntry<List<Integer>, Integer> res = NumberTheory.multiplyReal(num1, num2, 10);
        assertEquals(Arrays.asList(0, 5, 6, 0, 8, 8), res.getKey());
        assertEquals(-5, res.getValue().intValue());
    }

    @Test
    public void t35(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        AbstractMap.SimpleEntry<List<Integer>, Integer> num1 = new AbstractMap.SimpleEntry<>(l1, -3);
        AbstractMap.SimpleEntry<List<Integer>, Integer> num2 = new AbstractMap.SimpleEntry<>(l2, -2);
        AbstractMap.SimpleEntry<List<Integer>, Integer> res = NumberTheory.divideReal(num1, num2, 3, 10);
        assertEquals(Arrays.asList(2, 6), res.getKey());
        assertEquals(-3, res.getValue().intValue());
    }
}
