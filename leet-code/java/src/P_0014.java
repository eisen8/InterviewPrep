import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 14. Longest Common Prefix --- https://leetcode.com/problems/longest-common-prefi
// See bottom for problem statement
public class P_0014 {

    /**
     * Start with the first string as the base. Then go through all other strings comparing each character
     * until a single string no longer matches the rest.
     * Time complexity: O(m * n) where m is length of the common prefix and n is number of strings.
     * Space complexity: O(m) where m is the length of the common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) { return ""; }
        if (strs.length == 1) { return strs[0]; }

        StringBuilder longestPrefix = new StringBuilder();
        String firstString = strs[0];

        for (int i = 0; i < firstString.length(); i++) {
            for (String s : strs) {
                if (i >= s.length() || firstString.charAt(i) != s.charAt(i)) { // check if the prefix is the same for all strings
                    return longestPrefix.toString();
                }
            }
            longestPrefix.append(firstString.charAt(i));
        }

        return longestPrefix.toString();
    }

}

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.



Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters.


*/
