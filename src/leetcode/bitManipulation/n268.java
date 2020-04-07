package leetcode.bitManipulation;
/*
268. Missing Number
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
*/

/*
Input: [3,0,1]
Output: 2
* */
public class n268 {
    public int missingNumber(int[] nums) {
        int ans = nums.length;
        for(int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
            ans ^= i;
        }
        return ans;
    }
}
