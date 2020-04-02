package crackingTheCodingInterview;

/*
* 두개의 32비트 수 N과 M이 주어지고, 비트 위치 i와 j가 주어졌을 때, M을 N에 삽입하는메서드를 구현하라
* N의 i부터 j까지 M을 삽입하는 것.
* */
public class Q05_01_A {

    public static int mergeBit(int N, int M, int i, int j) {
        //N의 i~j 까지를 0으로 만든다.
        for(int k = i; k <= j; k++) {
            N = clearBit(N, k);
        }

        //3. M을 i만큼 시프트 연산을 한다.
        M = M << i;

        //4 N과 M을 or 연산해 준다.
        return  N | M;
    }

    public static int clearBit(int base, int idx) {
        return base & ~(1 << idx);
    }

    public static void main(String[] args) {
        int result = mergeBit(Integer.parseInt("10000000000",2), Integer.parseInt("10011",2),2,6);
        System.out.println(Integer.toBinaryString(result)); //10001001100
    }

}
