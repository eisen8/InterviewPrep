// 125. Valid Palindrome --- https://leetcode.com/problems/valid-palindrome
// See bottom for problem statement
public class P_0125 {


    /**
     * Use two pointers (1 at start and 1 at end). Go through the string comparing the two (ignoring case while comparing)
     * and skipping non-alphanumerics.
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean isPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length()-1;

        while (p1 < p2) {
            char c1 = s.charAt(p1);
            char c2 = s.charAt(p2);

            if (!isAlphanumeric(c1)) {
                p1++;
                continue;
            } if (!isAlphanumeric(c2)){
                p2--;
                continue;
            }

            if (lowerCase(c1) != (lowerCase(c2))) {
                return false;
            }

            p1++;
            p2--;
        }

        return true;
    }

    private char lowerCase(char c) {
        if (c >= 'a' && c <= 'z') {
            return c;
        }

        return (char)(c + 32);
    }

    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.



Constraints:

    1 <= s.length <= 2 * 105
    s consists only of printable ASCII characters.


*/
