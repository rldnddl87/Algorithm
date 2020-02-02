package crackingTheCodingInterview;

public class Q01_04_QA {
    public static boolean isPermutationOfPalindrome(String str) {

        int cntOdd = 0;
        int[] letters = new int[128];

        for(char c : str.toCharArray()) {
            letters[c]++;

            if(letters[c] % 2 == 1) {
                cntOdd++;
            }else {
                cntOdd--;
            }
        }

        return cntOdd <= 1;
    }



}
