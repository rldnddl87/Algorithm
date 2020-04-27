package leetcode;

/*
20. Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
* */

/*
Input: "()"
Output: true

Input: "(]"
Output: false
*/

import java.util.*;

public class n20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isOpen(c)) {
                stack.add(getPair(c));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char saved = stack.pop();

                if (c != saved) return false;
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    public boolean isOpen(char c) {
        if (c == '(' || c == '{' || c == '[') {
            return true;
        }

        return false;
    }

    public char getPair(char c) { // 그냥 HashMap으로 구현해도 되고
        if (c == '(') {
            return ')';
        } else if (c == '{') {
            return '}';
        } else {
            return ']';
        }
    }
}
