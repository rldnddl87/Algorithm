package leetcode;

/**
 * 78. Subsets
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.
 */

/**
 * 
 Input: nums = [1,2,3]
Output:
[
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
]
 */

import java.util.*;

public class n78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backtrack(nums, list, tmp, 0);
        return list;
    }

    public void backtrack(int[] nums, List<List<Integer>> list, List<Integer> tmp, int start) {
        // save
        list.add(new ArrayList<>(tmp));

        // backtrack
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(nums, list, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

}