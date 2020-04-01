package bitOperation;


import com.sun.org.apache.regexp.internal.RE;

public class ex1 {
    //해당 idx에 있는 비트 반환
    public static boolean getBit(int base, int idx) {
        return (base & (1 << idx)) != 0; // and 연산
    }

    //해당 idx에 있는 비트를 1로 조작
    public static int setBit(int base, int idx) {
        return  base | (1 << idx); // or 연산
    }

    //해당 idx에 있는 비트를 0로 조작
    public static int clearBit(int base, int idx) {
        return base & ~(1 << idx); //해당 idx만 0이고 나머지는 1로채워져 있는 비트
    }

    //해당 idx 왼쪽의 비트를 전부 0으로
    public static int clearLeftBit(int base, int idx) {
        return base & ((1 << idx) - 1);
    }

    public static int clearRightBit(int base, int idx) { //include idx bit
        //return base & ~(( 1 << idx + 1) - 1);
        return base & (-1 << (idx + 1));
    }

    public static void main(String[] args) {
        // 1 0 0 1 = 9
        System.out.println(getBit(9,3));
        System.out.println(setBit(9, 3));
        System.out.println(clearBit(9, 3));

        System.out.println();

        //10101001 169
        System.out.println(clearLeftBit(169,3));
        System.out.println(clearRightBit(169,3));




    }

}
