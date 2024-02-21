import java.util.Map;

// 12. Integer to Roman --- https://leetcode.com/problems/integer-to-roman
// See bottom for problem statement
public class P_0012 {
    private final static String[] _ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    private final static String[] _tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    private final static String[] _hundreds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    private final static String[] _thousands = {"","M","MM","MMM"};

    /**
     * Use a lookup table to get each group of values
     * Time complexity: O(1)
     * Time complexity: O(1)
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(_thousands[num/1000]);
        sb.append(_hundreds[num%1000/100]);
        sb.append(_tens[num%100/10]);
        sb.append(_ones[num%10]);
        return sb.toString();
    }

    /**
     * Chop up the number 1 piece at a time and convert it to the corresponding roman numerals.
     * Slightly less brute force than the above but much more difficult to read and much more code.
     */
    public String intToRoman2(int num) {
        if (num <= 0) { return ""; }
        StringBuilder sb = new StringBuilder();
        int currTotal = num;

        // thousands Place
        int thousands = currTotal/1000;
        currTotal -= 1000*thousands;
        for (int i = 0; i < thousands; i++) {
            sb.append("M");
        }

        // hundreds place
        int hundreds = currTotal/100;
        if (hundreds == 9) {
            sb.append('C');
            sb.append('M');
        } else if (hundreds == 4) {
            sb.append('C');
            sb.append('D');
        } else {
            if (hundreds >= 5) {
                sb.append('D');
            }

            for (int i = 0; i < hundreds % 5; i++) {
                sb.append("C");
            }
        }
        currTotal -= 100*hundreds;

        // tens place
        int tens = currTotal/10;
        if (tens == 9) {
            sb.append('X');
            sb.append('C');
        } else if (tens == 4) {
            sb.append('X');
            sb.append('L');
        } else {
            if (tens >= 5) {
                sb.append('L');
            }

            for (int i = 0; i < tens % 5; i++) {
                sb.append("X");
            }
        }

        currTotal -= 10*tens;

        // ones place
        int ones = currTotal;
        if (ones == 9) {
            sb.append('I');
            sb.append('X');
        } else if (ones == 4) {
            sb.append('I');
            sb.append('V');
        } else {
            if (ones >= 5) {
                sb.append('V');
            }

            for (int i = 0; i < ones % 5; i++) {
                sb.append("I");
            }
        }


        return sb.toString();
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
