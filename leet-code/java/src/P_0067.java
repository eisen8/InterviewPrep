// 67. Add Binary --- https://leetcode.com/problems/add-binary/description
// See bottom for problem statement
public class P_0067 {

    /**
     * Two pointer method starting at end of both strings and processing each binary digit 1 at a time.
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1; // keeps track of the current index into a
        int j = b.length()-1; // keeps track of the current index into b
        boolean carry = false; // keep tracks of the carry to the next digit

        while (i >= 0 || j >= 0) {
            char c1, c2, next;
            c1 = c2 = next = '0';

            if (i >= 0) { c1 = a.charAt(i); }
            if (j >= 0) { c2 = b.charAt(j); }

            // Calculate the carry and next binary digit to add by summing the previous carry, the digit from a, and the digit for b; getting a value
            // from 0 to 3.
            // sum   nextDigit, nextCarry
            //  0 -> 0,0
            //  1 -> 1,0
            //  2 -> 0,1
            //  3 -> 1,1
            int sum = boolToInt(c1 == '1')+boolToInt(c2 == '1')+boolToInt(carry);
            carry = (sum == 2 || sum == 3);
            if (sum == 1 || sum == 3) {
                next = '1';
            }

            sb.append(next);
            i--;
            j--;
        }

        if (carry) { sb.append('1'); }
        return sb.reverse().toString();
    }

    private int boolToInt(boolean b) {
        return (b) ? 1 : 0;
    }

}

/*
Given two binary strings a and b, return their sum as a binary string.



Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"



Constraints:

    1 <= a.length, b.length <= 104
    a and b consist only of '0' or '1' characters.
    Each string does not contain leading zeros except for the zero itself.


*/
