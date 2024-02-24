// 66. Plus One --- https://leetcode.com/problems/plus-one/description
// See bottom for problem statement
public class P_0066 {

    /**
     * Go to the least significant digit and add 1. If the digit is 9 then we turn it to 0 and
     * try to add one to the next significant digit. Repeat if necessary.
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) { // if less than 9 at current digit, add 1 and we are done
                digits[i]++;
                return digits;
            }
            digits[i] = 0; // turn this digit to 0 and move to the next
        }

        // if we made it to the end... all of the other digits were incremented to 0. Now we just need to add 1 to the
        // front. I.e. 99-> 00 -> 100
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}

/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.



Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].



Constraints:

    1 <= digits.length <= 100
    0 <= digits[i] <= 9
    digits does not contain any leading 0's.


*/
