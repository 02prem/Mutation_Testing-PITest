package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Leetcode {

    public static int largestPalindrome(int n) {
        int max = (int)Math.pow(10, n) - 1;
        int min = max - (int)Math.pow(10, (n + 1) >> 1);
            
        Comparator<int[]> cmp = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Long.compare((long)b[0] * b[1], (long)a[0] * a[1]);
            }
        };
            
        PriorityQueue<int[]> pq = new PriorityQueue<>(max - min, cmp);
            
        for (int i = max; i > min; i--) {
            int r = i % 10;
                
            if (r == 3 || r == 7) {
                pq.offer(new int[] {i, i});
            } else if (r == 1) {
                pq.offer(new int[] {i, i - 2});
            } else if (r == 9) {
                pq.offer(new int[] {i, i - 8});
            }
        }
            
        while (!pq.isEmpty()) {
            int[] a = pq.poll();
            long p = (long)a[0] * a[1];
                
            if (isPalindrome(p)) return (int)(p % 1337);
                
            if (a[1] > min) {
                a[1] -= 10;
                pq.offer(a);
            }
        }
        
        return 0;
    }
        
    private static boolean isPalindrome(long z) {
        long r = 0;
        for (long x = z; x != 0; r = r * 10 + x % 10, x /= 10);
        return r == z;
    }

    // *********************************************************************************************************

    private static int mod = 1000000007;
    
    private static int gcd(int a, int b) {
        if (a == b)
            return a;
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        
        if (a > b)
            return gcd(a%b, b);
        
        return gcd(a, b%a);
    }

    public static int nthMagicalNumber(int n, int a, int b) {
        if (n <= 0){
            return 0;
        }

        int hcf = gcd(a, b);
        int lcm = (a*b)/hcf;
        
        long l = Math.min(a, b);
        long r = Math.max(a, b);
        r = r*n;
        
        while (l <= r) {
            long mid = l + (r-l)/2;
            
            long count = (mid/a) + (mid/b) - (mid/lcm);
            
            if (count == n) {
                if (mid%a == 0 || mid%b == 0)
                    return (int)(mid%mod);
                else
                    r = mid-1;
            } else if (count < n) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        
        return (int)(l%mod);
    }

    // **********************************************************************************************

    public static int atmostNGivenDigitSet(String[] D, int N) {
        int B = D.length; // bijective-base B
        char[] ca = String.valueOf(N).toCharArray();
        int K = ca.length;
        int[] A = new int[K];
        int t = 0;

        for (char c: ca) {
            int c_index = 0;  // Largest such that c >= D[c_index - 1]
            boolean match = false;
            for (int i = 0; i < B; ++i) {
                if (c >= D[i].charAt(0))
                    c_index = i+1;
                if (c == D[i].charAt(0))
                    match = true;
            }

            A[t++] = c_index;
            if (match) continue;

            if (c_index == 0) { // subtract 1
                for (int j = t-1; j > 0; --j) {
                    if (A[j] > 0) break;
                    A[j] += B;
                    A[j-1]--;
                }
            }

            while (t < K)
                A[t++] = B;
            break;
        }

        int ans = 0;
        for (int x: A)
            ans = ans * B + x;
        return ans;
    }

    // **********************************************************************************************************

    public static int numDupDigitsAtMostN(int n) {
        if(n <= 0){
            return 0;
        }

        String str = String.valueOf(n);
        int len = str.length();
        
        // all number with no repeat and length < len
        int unique = 0;
        for (int i = 1; i < len; i++) {
            unique += totalNoRepeat(i);
        }
        
		// all number with no repeat and length == len
        Set<Integer> set = new HashSet<>();
        int i = 0;
        for (i = 0; i < len; i++) {
            int d = str.charAt(i) - '0';
            
            int temp = pivotChoice(set, d, i == 0);
            for (int j = i+1; j < len; j++) {
                temp *= (10 - j);
            }
            
            unique += temp;
            if (!set.add(d)) break;       // no need to continue after seeing repeated digits
        }
        
        if (i == len) unique++;      // the number n itself
        
        return n - unique;
    }
    
    private static int totalNoRepeat(int d) {
        int res = 9;
        for (int i = 1; i < d; i++) {
            res *= (10 - i);
        }
        return res;
    }
    
    private static int pivotChoice(Set<Integer> set, int d, boolean first) {
        int res = 0;
        int i = (first ? 1 : 0);
        
        while (i < d) {
            if (!set.contains(i++)) res++;
        }
        
        return res;
    } 

    // ********************************** N QUEENS ****************************************************************

    public static List<List<String>> solveNQueens(int n) 
    {  
        if (n < 0){
            return null;
        }  

        char [][] board = new char[n][n];
        for(int i = 0; i < board.length; i++) 
        {
            for(int j = 0; j < board.length; j++) 
            {
                board[i][j] = '.';
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        queen(board, 0, ans);
        return ans;
    }

    static void queen(char[][] board, int row, List<List<String>> list) 
    {

        if(row == board.length) 
        {
            list.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) 
        {
            if(isSafe(board, row, col)) 
            {
                board[row][col] = 'Q';
                queen(board, row + 1, list);
                board[row][col] = '.';
            }
        }
    }

    static List<String> construct(char[][] board) 
    {
        List<String> internal = new ArrayList<>();
        for (int i = 0; i < board.length; i++) 
        {
            String row = new String(board[i]);
            internal.add(row);
        }

        return internal;
    }

    static boolean isSafe(char[][] board, int row, int col) 
    {
        //for checking vertical row
        for (int i = 0; i < row; i++) 
        {
            if(board[i][col] == 'Q') 
            {
                return false;
            }
        }

        //for checking left diagonal

        int maxLeft = Math.min(row, col);

        for (int i = 1; i <= maxLeft; i++) 
        {
            if(board[row - i][col - i] == 'Q') 
            {
                return false;
            }
        }

        //for checking right diagonal

        int maxRight = Math.min(row, board.length - 1 - col);

        for (int i = 1; i <= maxRight; i++) 
        {
            if(board[row - i][col + i] == 'Q') 
            {
                return false;
            }
        }

        return true;
    }

    // ********************************************* N QUEENS-II **********************************************************

    public static List<List<String>> solveNQueensII(int n) 
    {
        char board[][] = new char[n][n];

        for(char i[] : board)
        {
            Arrays.fill(i, '.');
        }
        List<List<String>> res = new ArrayList<>();
        dfs(0, board, res);
        return res;
    }

    public static void dfs(int col, char board[][], List<List<String>> res)
    {
        if(col == board.length)
        {
            res.add(counter(board));
            return;
        }
        
        for(int row = 0; row < board.length; row++)
        {
            if(isSafeII(board, row, col))
            {
                board[row][col] = 'Q';
                dfs(col + 1, board, res);
                board[row][col] = '.';
            }
        }
    }

    public static boolean isSafeII(char board[][], int row, int col)
    {
        int dupRow = row;
        int dupCol = col;
        
        while(row >= 0 && col >= 0)
        {
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;
        while(col >= 0)
        {
            if(board[row][col] == 'Q') return false;
            col--;
        }
        
        row = dupRow;
        col = dupCol;
        while(col >= 0 && row < board.length)
        {
            if(board[row][col] == 'Q') return false;
            col--;
            row++;
        }

        return true;
    }

    public static List<String> counter(char board[][])
    {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++)
        {
            String s = new String(board[i]);
            res.add(s);
        }

        return res;
    }

    // ***************************************************************************************


}
