import java.util.ArrayList;
import java.util.List;

// 9 Palindrome Number --- https://leetcode.com/problems/palindrome-number/description
// See bottom for problem statement
public class P_0009 {

    /**
     * Convert the int into a char array. Then use two points to compare the beginning of the array to the end
     * Time complexity: O(n) (where n is number of digits in x)
     * Space complexity: O(n)
     */
    public boolean isPalindrome(int x) {
        if (x < 0) { return false; } // Quick fail
        char[] digitArray = String.valueOf(x).toCharArray();

        int p1 = 0;
        int p2 = digitArray.length - 1;

        while(p1 < p2) {
            if (digitArray[p1] != digitArray[p2]) {
                return false;
            }

            p1++;
            p2--;
        }

        return true;
    }
    /**
     * Same as above but uses a List of Integers instead of a char array
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public boolean isPalindrome2(int x) {
        if (x < 0) { return false; } // Quick fail
        List<Integer> digitList = toDigitArray(x);

        int p1 = 0;
        int p2 = digitList.size() - 1;

        while(p1 < p2) {
            if (!digitList.get(p1).equals(digitList.get(p2))) {
                return false;
            }

            p1++;
            p2--;
        }

        return true;
    }

    /**
     * Converts an integer into an array of the digits that compose it
     */
    private List<Integer> toDigitArray(int x) {
        List<Integer> digitArray = new ArrayList<>();
        int currValue = x;

        while (currValue > 0) {
            digitArray.add(currValue % 10);
            currValue /= 10;
        }

        return digitArray;
    }
}

/*
Given an integer x, return true if x is a
palindrome
, and false otherwise.



Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.



Constraints:

    -231 <= x <= 231 - 1


Follow up: Could you solve it without converting the integer to a string?
*/
