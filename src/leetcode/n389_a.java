package leetcode;

//XOR연산은 연산의 순서에 상관없다.

public class n389_a {
    public char findTheDifference(String s, String t) {

        char c = t.charAt(t.length() - 1); //base

        for(int i = 0; i < t.length() - 1; i++) {

            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }

}
