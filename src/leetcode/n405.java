package leetcode;
/*
405. Convert a Number to Hexadecimal
Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
* */

/*
Input:
26

Output:
"1a"
* */
public class n405 {
    class Solution {
        public String toHex(int num) {

            String[] hex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

            StringBuilder sb = new StringBuilder();
            //16진법은 1개의 10진법 정수를 16개의 수로 표현
            //2진법은 1개의 10진법 정수를 2개의 수로 표현
            // 즉 2진법 4자리수(16개 수를 표현 가능)로 16진법 1자리를 표현할 수 있다.
            if(num == 0) return "0";

            while (num != 0) {
                sb.insert(0, hex[(num & 15)]);
                num >>>= 4;
            }

            return sb.toString();
        }
    }

}
