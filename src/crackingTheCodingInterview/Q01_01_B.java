package crackingTheCodingInterview;

public class Q01_01_B {

    public static boolean isSubString(String s1, String s2) {
        if(s1.indexOf(s2) >= 0) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean isRotation(String s1, String s2) {
        int length = s1.length();

        if(length == s2.length() && length > 0) {
            String str = s1 + s1;

            return isSubString(str, s2);
        }

        return false;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }
}
