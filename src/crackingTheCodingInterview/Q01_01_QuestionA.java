package crackingTheCodingInterview;

import java.util.HashSet;
import java.util.Set;

/**
 *  Q01_01 : 문자열이 주어 젔을 때, 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘
 * */
public class Q01_01_QuestionA {
    public static boolean isUnique(String input) {
        boolean result = false;

        Set<Character> chSet = new HashSet<>();

        for(char s : input.toCharArray()) {
            chSet.add(s);
        }

        if(input.length() == chSet.size()) {
            result = true;
        }

        return result;

    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};

        for(String str : words) {
            System.out.println(str + " is unique ? : " + isUnique(str));
        }
    }
}
