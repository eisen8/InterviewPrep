// 69. Sqrt(x) --- https://leetcode.com/problems/sqrtx/description
// See bottom for problem statement
public class P_0069 {

    /**
     * Brute force it. Start at 1 and try to find the closest value squared that gives us x.
     */
    public int mySqrt(int x) {
        if (x <= 0) { return 0; }

        int i = 1;
        while (true) {
            long squared = (long) i*i;

            if (squared == x) {
                return i;
            } else if (squared > x) {
                return i-1;
            }
            i++;
        }
    }

    /**
     * Instead of checking every number in order, do a binary search for the correct number. So we start in the middle and then move the middle
     * up or down depending on if it is too low or too high.
     */
    public int mySqrt2(int x) {
        if (x <= 0) { return 0; }

        int start = 1;
        int end = x;
        while (start <= end) {
            int mid = start+(end-start)/2;
            long squared = (long) mid*mid;

            if (squared == x) {
                return mid;
            } else if (squared < x) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return end;
    }

}

/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

    For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.



Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.

Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.



Constraints:

    0 <= x <= 231 - 1


*/
