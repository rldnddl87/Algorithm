package leetcode;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.
 */

/**
 * Input: [3,4,5,1,2] Output: 1
 */
public class n153 {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        if (nums[lo] < nums[hi])
            return nums[lo];
        if (nums.length == 1)
            return nums[0];

        while (lo < hi) {
            if (nums[lo] > nums[hi]) {
                hi--;
            } else {
                return nums[hi + 1];
            }
        }
        return nums[hi + 1];
    }

}