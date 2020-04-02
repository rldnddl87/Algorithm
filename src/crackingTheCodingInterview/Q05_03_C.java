package crackingTheCodingInterview;

public class Q05_03_C {

    public static int flipBit(int n) {
        if( ~n == 0) return Integer.BYTES * 8;

        int currentLength = 0;
        int previousLength = 0;
        int maxLength = 1; // 1이 최소 1개는 있다.

        while( n != 0) {
            if ((n & 1) == 1) {
                currentLength++;
            } else if((n & 1) == 0) {
                previousLength = (n & 2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }

            // maxLength 설정
            maxLength = Math.max(maxLength, previousLength + currentLength + 1);
            n >>>= 1;

        }

        return maxLength;
    }
}
