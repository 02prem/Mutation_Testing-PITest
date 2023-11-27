package com.mycompany.app;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Algorithms {
    
    public static char[] countsort(char arr[]) 
    { 
        int n = arr.length; 

        // The output character array that will have sorted arr 
        char output[] = new char[n]; 

        // Create a count array to store count of individual 
        // characters and initialize count array as 0 
        int count[] = new int[256]; 
        for (int i = 0; i < 256; ++i) 
            count[i] = 0; 

        // store count of each character 
        for (int i = 0; i < n; ++i) 
            ++count[arr[i]]; 

        // Change count[i] so that count[i] now contains actual 
        // position of this character in output array 
        for (int i = 1; i <= 255; ++i) 
            count[i] += count[i-1]; 

        // Build the output character array 
        // To make it stable, we are operating in reverse order. 
        for (int i = n-1; i >= 0; i--) 
        { 
            output[count[arr[i]]-1] = arr[i]; 
            --count[arr[i]]; 
        } 

        // Create a new array to store the sorted characters
        char sortedArr[] = new char[n];

        // Copy the output array to sortedArr
        System.arraycopy(output, 0, sortedArr, 0, n);

        // Return the sorted array
        return sortedArr;
    } 

    // **************************************************************************************************************

    public static void heapSort(int arr[]) 
    {

        makeMaxHeap(arr);
        int tmp;
        for (int i = arr.length - 1; i > 0; i--) 
        {
            tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapAdjust(arr, 0, i);
        }
    }

    private static void makeMaxHeap(int arr[]) 
    {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; --i) 
        {
            heapAdjust(arr, i, len);
        }
    }

    private static void heapAdjust(int arr[], int i, int n) 
    {
        int j = 2 * i + 1;
        int tmp = arr[i];
        while (j < n) 
        {
            if (j < n - 1 && arr[j] < arr[j + 1])
                j++;
            if (tmp > arr[j])
                break;
            arr[(j - 1) / 2] = arr[j];
            j = 2 * j + 1;
        }

        arr[(j - 1) / 2] = tmp;
    }

    // *************************************************************************************************************************

    public static void insertionSort(int arr[]) 
    {
        int len = arr.length, tmp, j;

        for (int i = 1; i < len; i++) 
        {
            tmp = arr[i];
            for (j = i; j > 0; j--) 
            {
                if (arr[j - 1] > tmp)
                    arr[j] = arr[j - 1];

                else
                    break;
            }

            arr[j] = tmp;
        }
    }

    // ********************************************************************************************************************

    public static void mergeSort(int arr[], int lower, int upper) 
    {
        if (lower >= upper)
            return;

        int m = (lower + upper) / 2;
        mergeSort(arr, lower, m);
        mergeSort(arr, m + 1, upper);
        merge(arr, lower, upper);
    }

    private static void merge(int arr[], int lower, int upper) 
    {
        int m = (lower + upper) / 2;
        int a[] = new int[m - lower + 1];
        int b[] = new int[upper - m];
        int i, k = 0, k1 = 0, k2 = 0;

        for (i = lower; i <= m; i++, k++)
            a[k] = arr[i];

        k = 0;

        for (; i <= upper; i++, k++)
            b[k] = arr[i];

        for (i = lower; i <= upper && k1 < m - lower + 1 && k2 < upper - m; i++) 
        {

            if (a[k1] < b[k2]) {
                arr[i] = a[k1];
                k1++;
            } else {
                arr[i] = b[k2];
                k2++;
            }
        }

        for (; k1 < m - lower + 1; k1++)
            arr[i++] = a[k1];

        for (; k2 < upper - m; k2++)
            arr[i++] = b[k2];
    }

    // **********************************************************************************************************************

    public static void quickSort(int arr[], int lower, int upper) 
    {
        if (lower >= upper)
            return;

        int p = partition(arr, lower, upper);
        quickSort(arr, lower, p - 1);
        quickSort(arr, p + 1, upper);
    }

    private static int partition(int arr[], int lower, int upper) 
    {
        int pivot = arr[upper];
        int j = lower;
        int tmp;

        for (int i = lower; i <= upper; i++) 
        {
            if (arr[i] < pivot) 
            {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                j++;
            }
        }

        tmp = arr[upper];
        arr[upper] = arr[j];
        arr[j] = tmp;

        return j;
    }

    // **************************************************************************************************************************

    // A utility function to get maximum value in arr[] 
    static int getMax(int arr[], int n) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    } 
  
    // A function to do counting sort of arr[] according to 
    // the digit represented by exp. 
    static void sort(int arr[], int n, int exp) 
    { 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) 
            count[ (arr[i]/exp)%10 ]++; 
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
            count[ (arr[i]/exp)%10 ]--; 
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) 
            arr[i] = output[i]; 
    } 
  
    // The main function to that sorts arr[] of size n using 
    // Radix Sort 
    public static void radixsort(int arr[], int n) 
    { 
        if(n == 0)
            return;

        // Find the maximum number to know number of digits 
        int m = getMax(arr, n); 
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m/exp > 0; exp *= 10) 
            sort(arr, n, exp); 
    } 

    // *****************************************************************************************************************

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static boolean[] bfs(ArrayList<ArrayList<Integer>> adj,int v,int s)
    {

        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty())
        {
            int x = queue.poll();

            for (int u:adj.get(x))
            {
                if (!visited[u])
                {
                    queue.add(u);
                    visited[u] = true;
                }
            }
        }

        return visited; 
    }

    public static void bfsDisconnected(ArrayList<ArrayList<Integer>> adj,int s,boolean[] visited)
    {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty())
        {
            int x = queue.poll();

            for (int u:adj.get(x))
            {
                if (!visited[u])
                {
                    queue.add(u);
                    visited[u] = true;
                }
            }
        }
    }

    public static int bfsDisconnected(ArrayList<ArrayList<Integer>> adj,int noOfVertices){
        boolean[] visited = new boolean[noOfVertices];
        int count = 0;

        for (int i = 0; i < noOfVertices; i++) 
        {
            if (!visited[i])
            {
                bfsDisconnected(adj,i,visited);
                count++;
            }
        }
        return count;
    }

    public static void dfsRecursion(ArrayList<ArrayList<Integer>> adj,int source,boolean[] visited)
    {
        visited[source] = true;

        for (int u : adj.get(source)) 
        {
            if (!visited[u])
                dfsRecursion(adj,u,visited);
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj,int vertex,int source)
    {
        boolean[] visited = new boolean[vertex];
        dfsRecursion(adj,source,visited);
    }

    public static int  dfsDisconnected(ArrayList<ArrayList<Integer>> adj,int vertex)
    {
        boolean[] visited = new boolean[vertex];
        int noOfConnectedComponents = 0;

        for (int i = 0; i < vertex; i++) 
        {
            if (!visited[i])
            {
                dfsRecursion(adj,i,visited);
                noOfConnectedComponents++;
            }
        }

        return noOfConnectedComponents;
    }

    // *****************************************************************************************************************

    public static int primsAlgorithm(int[][] graph,int v) 
    {
        if(v == 0)
            return 0;

        int[] key = new int[v];
        Arrays.fill(key,Integer.MAX_VALUE);
        key[0] = 0;
        /*Length of the MST*/
        int minLength = key[0];
        /*
        * It stores the nodes/vertices already visited in the minimum spanning tree*/
        boolean[] mset = new boolean[v];
        for (int i = 0; i < v; i++) 
        {
            /* The current node you are at*/
            int u = -1;
            /* Find the smaller node to move to*/
            for (int j = 0; j < v; j++) 
            {
                /* If mSet does not has the current element*/
                if (!mset[j])
                {
                    if (u == -1 || key[j] < key[u])
                    {
                        u = i;
                    }
                }
            }

            mset[u] = true;
            minLength += key[u];
            for (int j = 0; j < v; j++) 
            {
                /* If mSet does not has the current element
                 * And graph is connected*/
                if (!mset[j] && graph[u][j]!=0)
                {
                    key[j] = Math.min(graph[u][j],key[j]);
                }
            }
        }

        return minLength;
    }

    // **************************************************************************************************************

    private static int[][] impl(final int[][] graph, int source) {
        // Contains the shortest distance from source to each node
        int[] distance = new int[graph.length];

        // Contains the predecessor to each node
        int[] predecessor = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            predecessor[i] = -1;
        }

        distance[source] = 0;
        for (int i = 1; i < graph.length; i++) {
            for (int s = 0; s < graph.length; s++) {
                for (int d = 0; d < graph[s].length; d++) {
                    int weight = graph[s][d];
                    if (distance[s] != Integer.MAX_VALUE && distance[s] + weight < distance[d]) {
                        distance[d] = distance[s] + weight;
                        predecessor[d] = s;
                    }
                }
            }
        }

        // Check for negative-weight circles
        for (int u = 1; u < graph.length; u++) {
            for (int v = 0; v < graph.length; v++) {
                if (distance[u] + graph[u][v] < distance[v]) {
                    return new int[0][];
                }
            }
        }

        return new int[][]{distance, predecessor};
    }

    public static int[][] bellmanFord(final int[][] inGraph) {
        int[][] res = new int[inGraph.length][];
        for (int i = 0; i < inGraph.length; i++) {
            int[][] b_f_res = impl(inGraph, i);
            if (b_f_res.length == 2) {
                // Only fill in the distance, you may use b_f_res[1] to get the nodes visited to
                // get to a specific node
                res[i] = b_f_res[0];
            } else {
                return new int[0][];
            }
        }

        return res;
    }

}
