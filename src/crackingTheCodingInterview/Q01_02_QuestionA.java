package crackingTheCodingInterview;

import java.util.Arrays;

/**
 * 문 자열 2개가 주어 젔을때 서로 순열관계에 있는지 확인하는 메서드
 * */
public class Q01_02_QuestionA {
    public static boolean isPermutation(String str, String anotherStr) {
        return sort(str).equals(sort(anotherStr));
    }

    public static String sort(String str) {
        char[] tmp = str.toCharArray();
        Arrays.sort(tmp);
        return new String(tmp);
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }

}
