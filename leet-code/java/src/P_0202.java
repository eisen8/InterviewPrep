import java.util.HashSet;
import java.util.Set;

// 202. Happy Number --- https://leetcode.com/problems/happy-number/description
// See bottom for problem statement
public class P_0202 {

    /**
     * Uses a hashset to keep track of previously visited values to find if we are in a loop.
     * Time complexity O(N)
     * Space complexity O(N)
     */
    public boolean isHappy(int n) {
        Set<Integer> previousValues = new HashSet<>();
        while (n != 1) {
            if (previousValues.contains(n)) {
                return false; // found a loop
            }

            previousValues.add(n);
            n = sumSquareOfDigits(n);
        }

        return true;
    }

    /**
     * Uses the rabbit and turtle method to find loops.
     * Time complexity O(N)
     * Space complexity O(1)
     */
    public boolean isHappy2(int n) {
        int slow = n;
        int fast = n;

        do  {
            if (slow == 1 || fast == 1) { return true; }
            slow = sumSquareOfDigits(slow); // goes at +1 rate
            fast = sumSquareOfDigits(sumSquareOfDigits(fast)); // goes at +2 rate

        } while (slow != fast);

        return false;
    }

    private int sumSquareOfDigits(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n%10;
            sum += digit*digit;
            n /= 10;
        }

        return sum;
    }
}

/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

    Starting with any positive integer, replace the number by the sum of the squares of its digits.
    Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy.

Return true if n is a happy number, and false if not.



Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

Example 2:

Input: n = 2
Output: false



Constraints:

    1 <= n <= 231 - 1


*/
