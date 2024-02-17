import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 58. Length of Last Word --- https://leetcode.com/problems/length-of-last-word/description
// See bottom for problem statement
public class P_0058 {

    /**
     * Instead of splitting string (like below 2 and 3), just start at the end of string and count until we find
     * the first whitespace.
     * Time complexity: O(n) (where n is number of characters in s)
     * Space complexity: O(1)
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) { return 0; }

        s = s.trim();
        for (int i = s.length()-1; i > 0; i--) {
            if(s.charAt(i) == ' ') {
                return s.length()-1-i;
            }
        }

        return s.length(); // this case occurs when there is only one word
    }

    /**
     * Split the string into words, then get the last word and return its length.
     * Time complexity: O(n) (where n is number of characters in s)
     * Space complexity: O(n)
     */
    public int lengthOfLastWord2(String s) {
        if (s == null || s.isEmpty()) { return 0; }

        String[] words = Arrays.stream(s.split(" ")).filter(i -> !i.isEmpty()).toArray(String[]::new);

        if (words.length == 0) { return 0; }
        return words[words.length-1].length();
    }
    /**
     * Same as above but manually splits the string into words
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int lengthOfLastWord3(String s) {
        if (s == null || s.isEmpty()) { return 0; }

        List<String> words = splitIntoWords(s);

        if (words.isEmpty()) { return 0; }
        return words.getLast().length();
    }

    /**
     * Converts a string of words into a list of words
     */
    private List<String> splitIntoWords(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (!sb.isEmpty()) {
                    words.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(c);
            }
        }

        if (!sb.isEmpty()) {
            words.add(sb.toString());
        }

        return words;
    }
}

/*
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal
substring
consisting of non-space characters only.



Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.



Constraints:

    1 <= s.length <= 104
    s consists of only English letters and spaces ' '.
    There will be at least one word in s.


*/
