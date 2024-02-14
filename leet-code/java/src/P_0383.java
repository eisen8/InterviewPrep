import java.util.HashMap;
import java.util.Map;

// 383. Ransom Note --- https://leetcode.com/problems/ransom-note/description
// See bottom for problem statement
public class P_0383 {

    /**
     * This solution stores the count of available characters (from magazine) into a map. Then it goes through the ransomNote
     * decrementing the available count of each character.
     * Time complexity: O(n + m)
     * Space complexity: O(n + m)
     *
     * Notes: Hashing can be slow. Since only english lowercase letters are allowed, it would be faster to use a 26 item array
     * for the counts and use the char to index into the array (i.e. 'a' = 0, 'z' = 25).
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null || ransomNote.length() > magazine.length()) {
            return false; // fast fail
        }

        Map<Character, Integer> charCounts = new HashMap<>();

        // Add mag chars to map
        for (char c : magazine.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        // Verify enough counts for ransom Note
        for (char c : ransomNote.toCharArray()) {
            int count = charCounts.getOrDefault(c, 0) - 1;
            if (count < 0) {
                return false;
            } else {
                charCounts.put(c, count);
            }
        }


        return true;
    }

}

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true



Constraints:

    1 <= ransomNote.length, magazine.length <= 105
    ransomNote and magazine consist of lowercase English letters.

*/


