import java.util.HashMap;

// 62. Unique Paths --- https://leetcode.com/problems/unique-paths/description/
// See bottom for problem statement
public class P_0062 {

    /**
     * Recursively go through each path
     */
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) { return 0; } // out of bounds: 0 paths
        if (m == 1 && n == 1) { return 1; } // 1x1: 1 path

        return uniquePaths(m-1, n)+uniquePaths(m, n-1);
    }

    /**
     * Same as above but uses a cache so we don't have to recalculate duplicate values
     */
    public int uniquePathsWithCache(int m, int n) {
        if (m <= 0 || n <= 0) { return 0; } // out of bounds, 0 paths
        if (m == 1 && n == 1) { return 1; } // 1x1, 1 path
        if (cache.get(generateKey(m, n)) != null) {
            return cache.get(generateKey(m, n));
        }

        int value = uniquePaths(m-1, n)+uniquePaths(m, n-1);
        cache.put(generateKey(m, n), value);
        cache.put(generateKey(n, m), value); // put keys both ways since m x n =  n x m
        return value;
    }

    private String generateKey(int m, int n) {
        return m+","+n;
    }

    private static HashMap<String, Integer> cache;

    public P_0062() {
        cache = new HashMap<>();
    }
}

/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.



Example 1:

Input: m = 3, n = 7
Output: 28

Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down



Constraints:

    1 <= m, n <= 100


*/
