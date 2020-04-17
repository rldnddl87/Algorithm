package leetcode;

import java.util.*;

/*
13. Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II.
The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead,
the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine,
which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
* */

/*
Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
* */
public class n13 {
    public int romanToInt(String s) {

        Map<Character, Integer> Roman = new HashMap<>();

        Roman.put('I', 1);
        Roman.put('V', 5);
        Roman.put('X', 10);
        Roman.put('L', 50);
        Roman.put('C', 100);
        Roman.put('D', 500);
        Roman.put('M', 1000);

        int length = s.length();

        int ans = 0;


        for(int i = 0; i < length; i++) {
            if( i < length - 1 && Roman.get(s.charAt(i)) - Roman.get(s.charAt(i + 1)) < 0  ) {
                ans += Roman.get(s.charAt(i + 1)) - Roman.get(s.charAt(i));
                i++;
            } else {
                ans += Roman.get(s.charAt(i));
            }
        }
        return ans;
    }
}
