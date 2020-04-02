package crackingTheCodingInterview;

/*
 * 비트 뒤집기
 * 어떤 정수가 주어졌을 때 여러분은 이 정수의 비트 하나를 0에서 1로 바꿀 수 있다.
 * 이떄 1이 나올 수 있는 가장 긴 길이를 구하는 코드를 작성하라
 */

public class Q05_03_A {

    public static int maxLenth(int n) {
        String s = Integer.toBinaryString(n);
        String[] str = s.split("0");

        int max = 0;
        for(int i = 0; i < str.length - 1; i++) {
            int length = str[i].length() + str[i + 1].length();
            if(length > max) {
                max = length;
            }
        }

        return max + 1;

    }

    public static void main(String[] args) {
        System.out.println( maxLenth(1775));
    }
}
