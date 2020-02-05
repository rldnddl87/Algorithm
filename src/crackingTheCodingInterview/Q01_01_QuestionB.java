package crackingTheCodingInterview;


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
