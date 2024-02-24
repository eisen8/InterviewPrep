// 12. Integer to Roman --- https://leetcode.com/problems/integer-to-roman
// See bottom for problem statement
public class P_0012 {

    /**
     * Brute force arrays for solution 1. First index represents the place (0 = ones, 1 = tens, etc) and second
     * represents the roman numeral value of corresponding digit.
     */
    private static final String[][] _toRomanNumerals = new String[][]{
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}, //ones - 0, 1, 2, 3 ...
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, //tens - 0, 10, 20, 30 ...
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, //hundreds - 0, 100, 200, 300 ...
            {"", "M", "MM", "MMM", "", "", "", "", "", ""} // thousands - 0, 1000, 2000, 3000, unsupported
    };

    /**
     * Use a lookup table to get each group of values
     */
    public String intToRoman(int num) {
        if (num <= 0) { return ""; }
        if (num > 3999) { throw new IllegalArgumentException("Num must be less than 4000"); }

        // Note: Could turn this into a for loop
        String sb = _toRomanNumerals[3][num/1000]+
                _toRomanNumerals[2][num%1000/100]+
                _toRomanNumerals[1][num%100/10]+
                _toRomanNumerals[0][num%10];
        return sb;
    }

    // Partial Brute force arrays for Solution 2: First array corresponds to the decimal place, 2nd gets the corresponding roman numeral
    private static final String[][] _toRomanNumerals2 = new String[][]{
            {"IX", "V", "IV", "I"}, //one places - 9, 5, 4, 1
            {"XC", "L", "XL", "X"}, //tens - 90, 50, 40, 10
            {"CM", "D", "CD", "C"}, //hundreds - 900, 500, 400, 100
            {"", "", "", "M"} // thousands -Unsupported, Unsupported, Unsupported, 1000
    };

    /**
     * Same as solution 3 below but refactored into a for loop for less repeated code.
     * Chops up the number 1 piece at a time and converts it to the corresponding roman numerals.
     */
    public String intToRoman2(int num) {
        if (num <= 0) { return ""; }
        if (num > 3999) { throw new IllegalArgumentException("Num must be less than 4000"); }

        StringBuilder sb = new StringBuilder();
        int currTotal = num;

        // This outer loop represents the decimal place, starting at thousands, then hundreds, then tens, then ones
        for (int j = 3; j >= 0; j--) {
            int currentDigit = currTotal/tenToTheX(j); // extract the digit of the current decimal place
            if (currentDigit == 9) {
                sb.append(_toRomanNumerals2[j][0]);
            } else if (currentDigit == 4) {
                sb.append(_toRomanNumerals2[j][2]);
            } else {
                if (currentDigit >= 5) {
                    sb.append(_toRomanNumerals2[j][1]);
                }

                for (int i = 0; i < currentDigit%5; i++) {
                    sb.append(_toRomanNumerals2[j][3]);
                }
            }
            currTotal -= tenToTheX(j)*currentDigit;
        }

        return sb.toString();
    }

    /**
     * Returns 10 to the power of X.
     */
    private int tenToTheX(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("X must be greater than 0");
        }

        int total = 1;
        for (int i = 0; i < x; i++) {
            total *= 10;
        }
        return total;
    }

    /**
     * Chops up the number 1 piece at a time and converts it to the corresponding roman numerals.
     * Slightly less brute force than the above but much more difficult to read and much more code.
     */
    public String intToRoman3(int num) {
        if (num <= 0) { return ""; }
        if (num > 3999) { throw new IllegalArgumentException("Num must be less than 4000"); }

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

            for (int i = 0; i < hundreds%5; i++) {
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

            for (int i = 0; i < tens%5; i++) {
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

            for (int i = 0; i < ones%5; i++) {
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
