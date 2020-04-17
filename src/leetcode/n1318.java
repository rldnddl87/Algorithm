package leetcode;
/*
1318. Minimum Flips to Make a OR b Equal to c
Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
* */

/*
Input: a = 2, b = 6, c = 5
Output: 3
Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
*/
public class n1318 {
    public int minFlips(int a, int b, int c) {
        //if c == 0 then a and b also 0
        //if c == 1 then a 0 b 1 or a 1 b 0

        if( a == 0 && b == 0 && c == 0) return 0;

        int bitA = a & 1;
        int bitB = b & 1;
        int bitC = c & 1;

        int count = 0;

        if(bitC == 0) {
            if(bitA != 0) count++;
            if(bitB != 0) count++;
        } else {
            if(bitA == 0 && bitB == 0) count++;
        }
        return count + minFlips(a>>=1, b>>=1, c>>=1);
    }
}
