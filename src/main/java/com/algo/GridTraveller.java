package com.algo;

import java.util.HashMap;

/**
 * There is a traveller in a grid that can only go RIGHT or DOWN. How many possible ways the traveller can go
 * from 1x1 position to nxn.
 *
 * This is quite similar to Fibonacci solution, which also uses recursion as the main goal and the way to optimize it
 * is using MEMOIZATION.
 *
 * The Big O is O(m*n).
 */
public class GridTraveller {
    public static void main(String[] args) {

        System.out.println(gridTraveller(1,1, new HashMap<>())); //1
        System.out.println(gridTraveller(2,3, new HashMap<>())); //3
        System.out.println(gridTraveller(3,2, new HashMap<>())); //3
        System.out.println(gridTraveller(3,3, new HashMap<>())); //6
        System.out.println(gridTraveller(18, 18, new HashMap<>())); //2333606220

    }

    public static long gridTraveller(int m, int n, HashMap<String, Long> memo) {

        var key = m + "," + n;

        if (memo.get(key) != null) { return memo.get(key); }
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;

        memo.put(key, gridTraveller(m - 1, n, memo) + gridTraveller(m, n - 1, memo));

        return memo.get(key);
    }
}