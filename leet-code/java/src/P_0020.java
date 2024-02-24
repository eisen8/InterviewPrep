import java.util.Map;
import java.util.Stack;

// 20. Valid Parentheses --- https://leetcode.com/problems/valid-parentheses
// See bottom for problem statement
public class P_0020 {

    private static final Map<Character, Character> _openCloseParenthesesMap = Map.of(
            '(', ')', // open, close
            '[', ']',
            '{', '}'
    );

    /**
     * Uses a stack
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public boolean isValid(String s) {
        if (s == null || s.length()%2 == 1) { return false; }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isValidCharacter(c)) {
                if (isOpenBracket(c)) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }

                    if (!isClosing(stack.pop(), c)) {
                        return false;
                    }
                }
            } else {
                throw new IllegalArgumentException(String.format("'%c' is an invalid character", c));
            }
        }
        return stack.isEmpty();
    }

    private boolean isValidCharacter(char c) {
        return _openCloseParenthesesMap.containsKey(c) || _openCloseParenthesesMap.containsValue(c);
    }

    private boolean isOpenBracket(char c) {
        return _openCloseParenthesesMap.containsKey(c);
    }

    private boolean isClosing(char opener, char closer) {
        return _openCloseParenthesesMap.get(opener) == closer;
    }
}

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.



Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false



Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.


*/
