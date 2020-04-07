package leetcode.bitManipulation;
/*
190. Reverse Bits
Reverse bits of a given 32 bits unsigned integer.
* */

/*
Input: 00000010100101000001111010011100
Output: 00111001011110000010100101000000
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596,
so return 964176192 which its binary representation is 00111001011110000010100101000000.
* */
public class n190 {
    public int reverseBits(int n) {
        int mask = 1;
        int ans = 0;

        for(int i = 0; i < 31; i++) {

            ans = ans | (n & mask);
            n >>= 1;
            ans <<=1;
        }
        ans = ans | (n & mask);


        return ans;
    }
}
