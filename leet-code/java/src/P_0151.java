import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 151. Reverse Words in a String --- https://leetcode.com/problems/reverse-words-in-a-string/description
// See bottom for problem statement
public class P_0151 {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length-1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                sb.append(words[i]);
                sb.append(' ');
            }
        }

        if (!sb.isEmpty()) {
            sb.delete(sb.length() - 1, sb.length()); // remove last white space
        }
        return sb.toString();
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
