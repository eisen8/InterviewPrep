package misc;

import java.util.*;

/**
 * Different implementations of a Fibonacci number calculator. For this implementation, f(0) through f(4) are 0, 1, 1, 2, 3.
 * Any n less than 1 results in 0 (including negative n). Older definitions of Fibonacci often omit f(0) or start with
 * f(1) = 0. So this implementation might not exactly match other ones using a different definition.
 */
public class Fibonacci {

    /**
     * A slow recursive implementation of fibonacci numbers
     * @param n The Nth instance of the fibonacci number to return
     * @return The Fibonacci number at N
     */
    public int recursiveFib(int n) {
        if (n <= 0) { return 0; }
        if (n <= 2) { return 1; }
        return (recursiveFib(n-1) + recursiveFib(n-2)); // f(n) = f(n-1) + f(n-2)
    }

    /**
     * Same as the recursive implementation above but uses a cache to avoid recalculating previously calculated values.
     */
    public int cachedRecursiveFib(int n) {
        if (n <= 0) { return 0; }

        if (cacheArray.length < n) { resizeCacheArray(n); }

        if (cacheArray[n] != UNCACHED) { return cacheArray[n]; }

        int fibVal = cachedRecursiveFib(n-1) + cachedRecursiveFib(n-2); // f(n) = f(n-1) + f(n-2)
        cacheArray[n] = fibVal;
        return fibVal;
    }

    /**
     * Iteratively calculates the fib instead of recursively.
     */
    public int iterativeFib(int n) {
        if (n <= 0) { return 0; }
        if (n <= 2) { return 1; }

        int next, prev1, prev2;
        next = prev1 = prev2 = 1;

        for (int i = 3; i <= n ; i++) {
            next = prev1 + prev2; // f(n) = f(n-1) + f(n-2)
            prev2 = prev1;
            prev1 = next;

        }

        return next;
    }

    /**
     * Iteratively calculates the fib using a stack.
     */
    public int iterativeStackFib(int n) {
        if (n <= 0) { return 0; }

        Stack<Integer> stack = new Stack<>();
        stack.push(1); //f(1)
        stack.push(1); //f(2)

        for (int i = 3; i <= n; i++) { //f(3+)
            int prev1 = stack.pop();
            int prev2 = stack.pop();
            int next = prev1 + prev2;
            stack.push(prev1);
            stack.push(next);
        }

        return stack.pop();
    }

    /**
     * Another implementation using a stack. This time starting at n and going "backwards".
     */
    public int iterativeStackFib2(int n) {
        if (n <= 0) { return 0; }

        int fibVal = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(n);

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (curr <= 2) {
                fibVal += 1;
            } else {
                stack.push(curr - 1);
                stack.push(curr - 2);
            }
        }

        return fibVal;
    }


    // Using an int[] is much faster than hashmap since it doesn't require hashing.
    // We use n as the index of the array and the value is the cached fibonacci value. A value of -1 means no value is cached.
    public int[] cacheArray;

    public static final int UNCACHED = -1;
    public static final int DEFAULT_CACHE_SIZE = 100;

    public Fibonacci() {
        this(DEFAULT_CACHE_SIZE);
    }

    public Fibonacci(int cacheSize) {
        if (cacheSize < 5) {
            cacheSize = 5;
        }

        cacheArray = new int[cacheSize];
        Arrays.fill(cacheArray, UNCACHED);
        cacheArray[0] = 0;
        cacheArray[1] = 1;
        cacheArray[2] = 1;
    }

    /**
     * Resizes the cache array
     */
    private void resizeCacheArray(int minSize) {
        int[] newCacheArray = new int[(cacheArray.length + minSize) * 2];
        Arrays.fill(newCacheArray, UNCACHED);
        System.arraycopy(cacheArray, 0, newCacheArray, 0, cacheArray.length);

        cacheArray = newCacheArray;
    }

}
