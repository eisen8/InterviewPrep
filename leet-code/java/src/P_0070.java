import java.util.HashMap;
import java.util.Map;

// 70. Climbing Stairs --- https://leetcode.com/problems/climbing-stairs/description
// See bottom for problem statement
public class P_0070 {

    /**
     * Recursion solution using a memo.
     */
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();

        // Add break cases
        memo.put(0, 1);
        memo.put(1, 1);
        memo.put(2, 2);

        return climbStairs(n, memo);
    }

    private int climbStairs(int n, Map<Integer, Integer> memo) {
        if (!memo.containsKey(n)) {
            memo.put(n, climbStairs(n-1, memo)+climbStairs(n-2, memo));
        }
        return memo.get(n);
    }

    /**
     * Uses iteration from bottom up. f(n)=f(n-1)+f(n-2). Start summing up from the bottom to n.
     */
    public int climbStairs2(int n) {
        int prev, curr;
        prev = curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev+curr;
            prev = temp;
        }
        return curr;
    }
}

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step



Constraints:

    1 <= n <= 45



*/
