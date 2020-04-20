package leetcode;
/*
* 387. First Unique Character in a String
* Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
* */

/*
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
* */

import java.util.*;

public class n387 {
    public int firstUniqChar(String s) {
        int length = s.length();

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < length; i++) {
            char c  = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for(int i = 0; i < length; i++) {
            if(map.get(s.charAt(i)) == 1) return i;
        }

        return -1;
    }
}
