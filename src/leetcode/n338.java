package leetcode;

/*
*338. Counting Bits
* Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
* */

/*
Input: 2
Output: [0,1,1]
* */
public class n338 {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];

        for(int i = 0; i <= num; i++) {
            //ans[i] = bitCount(i); 해당 수의 모든 비트를 카운트하는 메서드를 이용
            //ans[i] = Integer.bitCount(i); 라이브러리 이용
            ans[i] = ans[i / 2] + (i & 1); //메모이제이션 이용 ,, 2의승수 단위로 자리수가 바뀌는 점을 이용
        }

        return ans;
    }

    public int bitCount(int n) {
        int mask = 1;
        int count = 0;

        while( n > 0) {

            if( (n & mask) == 1) {
                count++;
            }
            n >>= 1;
        }

        return count;
    }
}
