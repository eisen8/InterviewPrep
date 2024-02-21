// 28. Find the Index of the First Occurrence in a String
// See bottom for problem statement
public class P_0028 {

    /**
     * Goes through the haystack, for each letter it checks if that is the start of the needle.
     * Time complexity: O(n*m) where n is length of haystack and m is length of needle
     * Space complexity: O(1)
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.isEmpty()) { return -1; }

        int index = -1;
        for (int i = 0; i < haystack.length(); i++) {
            boolean found = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.length()-1 < i+j || haystack.charAt(i+j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }

        return index;
    }

    /**
     * Uses the framework indexOf method. Handles edge cases slightly different from the above(i.e. nulls, empty strings).
     */
    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

}

/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.



Constraints:

    1 <= haystack.length, needle.length <= 104
    haystack and needle consist of only lowercase English characters.


*/
