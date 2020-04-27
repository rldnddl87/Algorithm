package leetcode;
/*
125. Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.
* */

/*
Input: "A man, a plan, a canal: Panama"
Output: true
* */
public class n125 {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;

        int head = 0;
        int tail = s.length() - 1;

        char c1, c2;
        while( head <= tail) {
            c1 = s.charAt(head);
            c2 = s.charAt(tail);

            if(!Character.isLetterOrDigit(c1)) {
                head++;
            } else if(!Character.isLetterOrDigit(c2)) {
                tail--;
            } else {
                if(Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                    return false;
                }

                head++;
                tail--;
            }
        }

        return true;
    }
}
