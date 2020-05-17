package leetcode;

import java.util.*;

/**
 * 347. Top K Frequent Elements Given a non-empty array of integers, return the
 * k most frequent elements.
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2]
 */
public class n347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // count
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            int max = Integer.MIN_VALUE;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (max < entry.getValue()) {
                    result[i] = entry.getKey();
                    max = entry.getValue();
                }
            }

            map.put(result[i], -1);

        }

        return result;
    }
}