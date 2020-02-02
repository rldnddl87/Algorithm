package crackingTheCodingInterview;

public class Q01_02_QuestionB {
    public static boolean isPermutation(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128];

        for(int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i);
            letters[idx]++;
        }

        for(int i = 0; i < t.length(); i++) {
            int idx = t.charAt(i);

            letters[idx]--;

            if(letters[idx] < 0)
                return false;

        }


        return true;

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
