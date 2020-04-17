package leetcode;

import java.util.*;

public class n242 {

    //Using sorting
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        for(int i = 0; i < s.length(); i++) {
            if(c1[i] != c2[i]) return false;
        }

        return true;
    }

    //Using HashTable
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; //0부터 시작하기 위해 -a
            count[t.charAt(i) - 'a']--;
        }

        for (int n : count) {
            if (n != 0) return false;
        }

        return true;

    }
}