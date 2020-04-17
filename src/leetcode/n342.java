package leetcode;
/*
342. Power of Four
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
* */

/*
Input: 16
Output: true
* */
public class n342 {
    class Solution {
        public boolean isPowerOfFour(int num) {

            return num > 0 && (num &(num-1)) == 0 && OnlyOddBitExist(num);
        }

        public boolean OnlyOddBitExist(int num) {
            for(int i = 0; i < 32; i++) {
                if( i % 2 == 0) {
                    if( bitExist(num, i)) return true;
                }
            }

            return false;
        }

        public boolean bitExist(int num, int idx) {

            num >>= idx;

            return (num & 1) == 1 ? true : false;
        }
    }
}
