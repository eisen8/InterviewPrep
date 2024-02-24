import java.util.HashMap;
import java.util.Map;

// 205. Isomorphic Strings --- https://leetcode.com/problems/isomorphic-strings/description
// See bottom for problem statement
public class P_0205 {

    /**
     * Keep a running map of s characters to t characters. As we go through the strings we create the map and verify
     * that the mapping holds true for the entire string.
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) { return false; }
        if (s.length() <= 1) { return true; }

        // mappings from s characters to t characters and vice versa
        Map<Character, Character> sCharMap = new HashMap<>();
        Map<Character, Character> tCharMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sCharMap.containsKey(sChar)) {
                if (tChar != sCharMap.get(sChar)) { // verify mapping holds
                    return false;
                }
            } else if (tCharMap.containsKey(tChar)) {
                if (sChar != tCharMap.get(tChar)) { // verify mapping holds
                    return false;
                }
            } else {
                sCharMap.put(sChar, tChar);
                tCharMap.put(tChar, sChar);
            }
        }

        return true;
    }

    /**
     * Same as above but uses 1 map
     */
    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) { return false; }
        if (s.length() <= 1) { return true; }

        // mappings from s characters to t characters
        Map<Character, Character> sCharMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sCharMap.containsKey(sChar)) {
                if (tChar != sCharMap.get(sChar)) { // verify mapping holds
                    return false;
                }
            } else {
                if (sCharMap.containsValue(tChar)) { return false; } // tChar is already mapped

                sCharMap.put(sChar, tChar);
            }
        }

        return true;
    }
}

/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"
Output: true

Example 2:

Input: s = "foo", t = "bar"
Output: false

Example 3:

Input: s = "paper", t = "title"
Output: true



Constraints:

    1 <= s.length <= 5 * 104
    t.length == s.length
    s and t consist of any valid ascii character.


*/
