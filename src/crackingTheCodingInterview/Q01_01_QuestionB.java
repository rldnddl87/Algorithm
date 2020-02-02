package crackingTheCodingInterview;

/**
 * 문자열이 주어 젔을 때, 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘
 * */
public class Q01_01_QuestionB {
    public static boolean isUnique(String str) {

        boolean[] chrSet = new boolean[128];

        for(int i = 0; i < str.length(); i++) {

            int idx = str.charAt(i);

            if(chrSet[idx]) return false;

            chrSet[idx] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};

        for(String str : words) {
            System.out.println(str + " is unique ? : " + isUnique(str));
        }
    }

}
