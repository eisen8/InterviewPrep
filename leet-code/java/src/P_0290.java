import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 290. Word Pattern --- https://leetcode.com/problems/word-pattern/description
// See bottom for problem statement
public class P_0290 {

    /**
     * Split the s String into words. Then keep a running map of pattern characters to words characters. As we go through
     * the pattern we create the map and verify that the mapping holds true for the entire string.
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public boolean wordPattern(String pattern, String s) {
        String[] words = Arrays.stream(s.split(" ")).filter(w -> !w.isEmpty()).toArray(String[]::new);
        if (pattern.length() != words.length) { return false; }
        if (pattern.length() <= 1) { return true; }

        // mappings from pattern characters to words  and vice versa
        Map<Character, String> pMap = new HashMap<>();
        Map<String, Character> wordMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char pChar = pattern.charAt(i);
            String word = words[i];
            if (pMap.containsKey(pChar)) {
                if (!word.equals(pMap.get(pChar))) { // verify mapping holds
                    return false;
                }
            } else if (wordMap.containsKey(word)) {
                if (pChar != wordMap.get(word)) { // verify mapping holds
                    return false;
                }
            } else {
                pMap.put(pChar, word);
                wordMap.put(word, pChar);
            }
        }

        return true;
    }

    /**
     * Same as above but uses 1 map
     */
    public boolean wordPattern2(String pattern, String s) {
        String[] words = Arrays.stream(s.split(" ")).filter(w -> !w.isEmpty()).toArray(String[]::new);
        if (pattern.length() != words.length) { return false; }
        if (pattern.length() <= 1) { return true; }

        // mappings from pattern characters to words
        Map<Character, String> pMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char pChar = pattern.charAt(i);
            String word = words[i];
            if (pMap.containsKey(pChar)) {
                if (!word.equals(pMap.get(pChar))) { // verify mapping holds
                    return false;
                }
            } else {
                if (pMap.containsValue(word)) { return false; } // another char is mapped to this word

                pMap.put(pChar, word);
            }
        }

        return true;
    }
}

/*
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.



Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true

Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false



Constraints:

    1 <= pattern.length <= 300
    pattern contains only lower-case English letters.
    1 <= s.length <= 3000
    s contains only lowercase English letters and spaces ' '.
    s does not contain any leading or trailing spaces.
    All the words in s are separated by a single space.


*/
