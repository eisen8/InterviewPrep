import java.util.Map;

// 13. Roman to Integer--- https://leetcode.com/problems/roman-to-integer/description
// See bottom for problem statement
public class P_0013 {

    private static final Map<Character, Integer> _romanNumerals = Map.of(
            'I', 1, // Roman numeral, Corresponding value
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    /**
     * Go through each letter adding the corresponding amount to the total. If the next letter
     * is a larger roman numeral, we subtract instead of add. i.e. IV is -1+5=4
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) { return 0; }
        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = _romanNumerals.get(s.charAt(i));
            int nextValue = (i < s.length()-1) ? _romanNumerals.get(s.charAt(i+1)) : 0;

            if (value < nextValue) {
                total -= _romanNumerals.get(s.charAt(i));
            } else {
                total += _romanNumerals.get(s.charAt(i));
            }
        }

        return total;
    }

}

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.



Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.

Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.



Constraints:

    1 <= s.length <= 15
    s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
    It is guaranteed that s is a valid roman numeral in the range [1, 3999].


*/
