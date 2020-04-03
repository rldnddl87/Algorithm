package leetcode.bitManipulation;

//Using Divide and Qonquer
public class n169_a {
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    public int majorityElementRec(int[] nums, int lo, int hi) {
        if( lo == hi) {
            return nums[lo];
        }

        int mid = (lo + hi) / 2;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        if( left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;

    }

    public int countInRange(int[] nums, int num, int lo, int hi) {

        int count = 0;

        for(int i = lo; i <= hi; i++) {
            if( nums[i] == num) count++;
        }

        return count;
    }

}
