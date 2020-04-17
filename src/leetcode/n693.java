package leetcode;
/*
* 693. Binary Number with Alternating Bits
* Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
* */

/*
Input: 5
        Output: True
        Explanation:
        The binary representation of 5 is: 101
*/
public class n693 {
    public boolean hasAlternatingBits(int n) {

        int k;

        while( n > 0) {
            k = getRightDigit(n);
            n >>= 1;
            if( isCommonBit(n, k)) {
                return false;
            }
        }
        return true;
    }

    public static int getRightDigit(int n) {
        int k = (n & 1) == 1 ? 1 : 0;
        return k;
    }

    public static boolean isCommonBit(int n, int k) {
        int z = getRightDigit(n);

        if((z ^ k) == 0) return true;
        return false;
    }
}
