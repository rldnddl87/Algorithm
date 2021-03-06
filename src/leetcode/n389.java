package leetcode;
/*
389. Find the Difference
Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.
*/

import java.util.HashMap;
import java.util.Map;

/*
Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.
* */

//해쉬 맵을 이용해서 풀었는데 어떻게 이 문제를 비트 조작으로 풀 수 있을까?
public class n389 {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int k = 0; k < t.length(); k++) {
            map.put(t.charAt(k), map.getOrDefault(t.charAt(k), 0) - 1);
        }

        return minimumCount(map);
    }

    public char minimumCount(Map<Character, Integer> map) {

        int count = Integer.MAX_VALUE;

        Map.Entry<Character, Integer> entry = null;

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (entry == null || e.getValue() == -1) {
                entry = e;
            }

        }

        return entry.getKey();

    }

}
