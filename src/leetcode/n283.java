package leetcode;
/*
 * 283. Move Zeroes
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * */

/*
* Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
* */

import java.util.*;


public class n283 {

    public void moveZeroes(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) stack.push(nums[i]);
        }

        for (int j = 0; j < nums.length; j++) {
            if (stack.isEmpty()) {
                nums[j] = 0;
            } else {
                nums[j] = stack.pop();
            }
        }
    }

    public void moveZeroes2(int[] nums) {

        int pos = 0;

        for (int num : nums) {
            if (num != 0) nums[pos++] = num;
        }

        while (pos < nums.length) nums[pos++] = 0;


    }


}
