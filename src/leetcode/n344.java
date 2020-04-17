package leetcode;
/*
344. Reverse String
Write a function that reverses a string. The input string is given as an array of characters char[].
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
You may assume all the characters consist of printable ascii characters.
* */

/*
Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
* */
public class n344 {

    public void reverseString(char[] s) {
        //재귀 풀이
        recur(s, 0, s.length - 1);


        //또 다른 풀이
        int start = 0;
        int end = s.length - 1;

        char ch;
        while(start < end) {
            ch = s[start];
            s[start] = s[end];
            s[end] = ch;

            start++;
            end--;
        }

    }
    public void recur(char[] s, int begin, int end) {

        if(begin >= end) return;

        char ch = s[begin];
        s[begin++] = s[end];
        s[end--] = ch;

        recur(s, begin, end );
    }
}
