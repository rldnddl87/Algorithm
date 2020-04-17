package leetcode;
/*
169. Majority Element
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
* */

/*
Input: [3,2,3]
        Output: 3
*/

// Using HashMap
import java.util.*;

public class n169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countedMap = countNums(nums);

        Map.Entry<Integer, Integer> majorMap = null;

        for(Map.Entry<Integer, Integer> entry : countedMap.entrySet()) {
            if( majorMap == null || entry.getValue() > majorMap.getValue()) {
                majorMap = entry;
            }
        }

        return majorMap.getValue();

    }

    public Map<Integer, Integer> countNums(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map;
    }

}
