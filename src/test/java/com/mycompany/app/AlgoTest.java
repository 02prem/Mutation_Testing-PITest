package com.mycompany.app;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;

public class AlgoTest {
    @Test
    public void t1() {
        char arr[] = {};
        char expected[] = {};
        assertArrayEquals(expected, Algorithms.countsort(arr));
    }

    @Test
    public void t2() {
        char arr[] = {'a'};
        char expected[] = {'a'};
        assertArrayEquals(expected, Algorithms.countsort(arr));
    }

    @Test
    public void t3() {
        char arr[] = {'a', 'b', 'c'};
        char expected[] = {'a', 'b', 'c'};
        assertArrayEquals(expected, Algorithms.countsort(arr));
    }

    @Test
    public void t4() {
        char arr[] = {'c', 'b', 'a'};
        char expected[] = {'a', 'b', 'c'};
        assertArrayEquals(expected, Algorithms.countsort(arr));
    }

    @Test
    public void t5() {
        char arr[] = {'c', 'a', 'b', 'a', 'c'};
        char expected[] = {'a', 'a', 'b', 'c', 'c'};
        assertArrayEquals(expected, Algorithms.countsort(arr));
    }

    @Test
    public void t6() {
        char arr[] = {'b', 'a', 'b', 'a', 'b', 'a'};
        char expected[] = {'a', 'a', 'a', 'b', 'b', 'b'};
        assertArrayEquals(expected, Algorithms.countsort(arr));
    }

    @Test
    public void t7() {
        int arr[] = {};
        int expected[] = {};
        Algorithms.heapSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void t8() {
        int arr[] = {5};
        int expected[] = {5};
        Algorithms.heapSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void t9() {
        int arr[] = {5, 4, 3, 2, 1};
        int expected[] = {1, 2, 3, 4, 5};
        Algorithms.heapSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void t10() {
        int arr[] = {4, 1, 7, 3, 9, 2};
        int expected[] = {1, 2, 3, 4, 7, 9};
        Algorithms.heapSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void t11() {
        int arr[] = {};
        int expected[] = {};
        Algorithms.insertionSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void t12() {
        int arr[] = {5, 4, 3, 2, 1};
        int expected[] = {1, 2, 3, 4, 5};
        Algorithms.insertionSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void t13() {
        int arr[] = {4, 1, 7, 3, 1, 2, 4};
        int expected[] = {1, 1, 2, 3, 4, 4, 7};
        Algorithms.insertionSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void t14() {
        int arr[] = {};
        int expected[] = {};
        Algorithms.mergeSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void t15() {
        int arr[] = {5};
        int expected[] = {5};
        Algorithms.mergeSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void t16() {
        int arr[] = {4, 1, 7, 3, 9, 2};
        int expected[] = {1, 2, 3, 4, 7, 9};
        Algorithms.mergeSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void t17() {
        int arr[] = {4, 1, 7, 3, 1, 2, 4};
        int expected[] = {1, 1, 2, 3, 4, 4, 7};
        Algorithms.mergeSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void t18() {
        int arr[] = {};
        int expected[] = {};
        Algorithms.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void t19() {
        int arr[] = {4, 1, 7, 3, 9, 2};
        int expected[] = {1, 2, 3, 4, 7, 9};
        Algorithms.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void t20() {
        int arr[] = {4, 1, 7, 3, 1, 2, 4};
        int expected[] = {1, 1, 2, 3, 4, 4, 7};
        Algorithms.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void t21() {
        int arr[] = {};
        int expected[] = {};
        Algorithms.radixsort(arr, arr.length);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void t22() {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int expected[] = {2, 24, 45, 66, 75, 90, 170, 802};
        Algorithms.radixsort(arr, arr.length);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void t23() {
        int arr[] = {4, 1, 7, 3, 1, 2, 4};
        int expected[] = {1, 1, 2, 3, 4, 4, 7};
        Algorithms.radixsort(arr, arr.length);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void t24() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(0)));
        boolean[] ans = Algorithms.bfs(adj, 1, 0);
        assertTrue(Arrays.equals(new boolean[]{true}, ans));
    }

    @Test
    public void t26() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 1)));
        boolean[] ans = Algorithms.bfs(adj, 3, 0);
        assertTrue(Arrays.equals(new boolean[]{true, true, true}, ans));
    }

    @Test
    public void t27() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(0)));
        boolean[] visited = new boolean[1];
        Algorithms.bfsDisconnected(adj, 0, visited);
        assertTrue(Arrays.equals(new boolean[]{true}, visited));
    }

    @Test
    public void t28() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        boolean[] visited = new boolean[3];
        Algorithms.bfsDisconnected(adj, 0, visited);
        assertTrue(Arrays.equals(new boolean[]{true, false, false}, visited));
    }

    @Test
    public void t29() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 1)));
        boolean[] visited = new boolean[3];
        Algorithms.bfsDisconnected(adj, 0, visited);
        assertTrue(Arrays.equals(new boolean[]{true, true, true}, visited));
    }

    @Test
    public void t30() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 1)));
        boolean[] visited = new boolean[3];
        Algorithms.dfsRecursion(adj, 0, visited);
        assertTrue(Arrays.equals(new boolean[]{true, true, true}, visited));
    }
}
