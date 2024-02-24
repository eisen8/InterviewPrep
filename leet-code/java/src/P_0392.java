import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 392. Is Subsequence --- https://leetcode.com/problems/is-subsequence/description/
// See bottom for problem statement
public class P_0392 {

    /**
     * Two pointer solution.
     */
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) { return true; }
        if (s.length() > t.length()) { return false; }

        int i = 0;
        for (char c : t.toCharArray()) {
            if (c == s.charAt(i)) {
                i++;
            }

            if (i == s.length()) {
                return true;
            }
        }

        return false;
    }
}

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false



Constraints:

    0 <= s.length <= 100
    0 <= t.length <= 104
    s and t consist only of lowercase English letters.

*/
