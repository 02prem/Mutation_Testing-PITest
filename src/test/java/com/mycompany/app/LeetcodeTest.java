package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LeetcodeTest {

    @Test
    public void t1() {
        assertEquals(9, Leetcode.largestPalindrome(1));
    }

    @Test
    public void t2() {
        assertEquals(987, Leetcode.largestPalindrome(2));
    }

    @Test
    public void t3() {
        assertEquals(123, Leetcode.largestPalindrome(3));
    }

    @Test
    public void t4() {
        assertEquals(597, Leetcode.largestPalindrome(4));
    }

    @Test
    public void t5() {
        assertEquals(0, Leetcode.largestPalindrome(-1));
    }

    @Test
    public void t6() {
        assertEquals(2, Leetcode.nthMagicalNumber(1, 2, 3));
        assertEquals(3, Leetcode.nthMagicalNumber(2, 2, 3));
        assertEquals(4, Leetcode.nthMagicalNumber(3, 2, 3));
    }

    @Test
    public void t7() {
        assertEquals(2, Leetcode.nthMagicalNumber(1, 2, 2));
        assertEquals(4, Leetcode.nthMagicalNumber(2, 2, 2));
        assertEquals(6, Leetcode.nthMagicalNumber(3, 2, 2));
    }

    @Test
    public void t8() {
        assertEquals(8,  Leetcode.nthMagicalNumber(5, 2, 3));
        assertEquals(20, Leetcode.nthMagicalNumber(6, 5, 7));
    }

    @Test
    public void t9() {
        assertEquals(0, Leetcode.nthMagicalNumber(0, 2, 3));
    }

    @Test
    public void t10() {
        assertEquals(0, Leetcode.nthMagicalNumber(-1, 2, 3));
    }

    @Test
    public void t11() {
        String[] digitSet = {"1"};
        assertEquals(1, Leetcode.atmostNGivenDigitSet(digitSet, 5));
        assertEquals(1, Leetcode.atmostNGivenDigitSet(digitSet, 10));
    }

    @Test
    public void t12() {
        String[] digitSet = {"1", "3", "5"};
        assertEquals(3,  Leetcode.atmostNGivenDigitSet(digitSet, 5));
        assertEquals(9, Leetcode.atmostNGivenDigitSet(digitSet, 50));
    }

    @Test
    public void t13() {
        String[] digitSet = {"1", "3", "5"};
        assertEquals(0, Leetcode.atmostNGivenDigitSet(digitSet, 0));
    }

    @Test
    public void t14() {
        String[] digitSet = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        assertEquals(66429, Leetcode.atmostNGivenDigitSet(digitSet, 100000));
    }

    @Test
    public void t15() {
        String[] invalidDigitSet = {};
        assertEquals(0, Leetcode.atmostNGivenDigitSet(invalidDigitSet, 5));
    }

    @Test
    public void t16() {
        assertEquals(0, Leetcode.numDupDigitsAtMostN(9));
        assertEquals(0, Leetcode.numDupDigitsAtMostN(1));
    }

    @Test
    public void t17() {
        assertEquals(1, Leetcode.numDupDigitsAtMostN(11));
        assertEquals(10, Leetcode.numDupDigitsAtMostN(100));
    }

    @Test
    public void t18() {
        assertEquals(262, Leetcode.numDupDigitsAtMostN(1000));
    }

    @Test
    public void t19() {
        assertEquals(0, Leetcode.numDupDigitsAtMostN(0));
    }

    @Test
    public void t20() {
        assertEquals(0, Leetcode.numDupDigitsAtMostN(-1));
    }

    @Test
    public void t21() {
        List<List<String>> result = Leetcode.solveNQueens(1);
        assertEquals("Q", result.get(0).get(0));
    }

    @Test
    public void t22() {
        List<List<String>> result = Leetcode.solveNQueens(4);
        String[][] exp = {{".Q..", "...Q", "Q...", "..Q."}, {"..Q.", "Q...", "...Q", ".Q.."}};
        List<List<String>> listOfLists = new ArrayList<>();
        for (String[] row : exp) {
            listOfLists.add(Arrays.asList(row));
        }
        assertEquals(listOfLists, result);
    }

    @Test
    public void t23() {
        List<List<String>> result = Leetcode.solveNQueens(-1);
        assertEquals(null, result);
    }

    @Test
    public void t24() {
        List<List<String>> result = Leetcode.solveNQueensII(2);
        String[][] exp = {};
        List<List<String>> listOfLists = new ArrayList<>();
        for (String[] row : exp) {
            listOfLists.add(Arrays.asList(row));
        }
        assertEquals(listOfLists, result);
    }

    @Test
    public void t25() {
        List<List<String>> result = Leetcode.solveNQueensII(1);
        String[][] exp = {{"Q"}};
        List<List<String>> listOfLists = new ArrayList<>();
        for (String[] row : exp) {
            listOfLists.add(Arrays.asList(row));
        }
        assertEquals(listOfLists, result);
    }

    @Test
    public void t26() {
        List<List<String>> result = Leetcode.solveNQueens(4);
        String[][] exp = {{".Q..", "...Q", "Q...", "..Q."}, {"..Q.", "Q...", "...Q", ".Q.."}};
        List<List<String>> listOfLists = new ArrayList<>();
        for (String[] row : exp) {
            listOfLists.add(Arrays.asList(row));
        }
        assertEquals(listOfLists, result);
    }
}
