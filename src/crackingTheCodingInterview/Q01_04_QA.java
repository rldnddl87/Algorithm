package crackingTheCodingInterview;
/**
 * Q01_04 : 주어진 문자열이 회문의 순열인지 아닌지 확인하는 함수
 * */
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
