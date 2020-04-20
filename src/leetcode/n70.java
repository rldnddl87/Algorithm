package leetcode;
/*
70. Climbing Stairs
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Note: Given n will be a positive integer.
* */

/*
Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
* */
public class n70 {
    public int climbStairs(int n) {


        return process(n);
    }
    //brute force
    public int process(int n) {
        if (n == 0) return 1;
        int sum = 0;
        if (n - 1 >= 0) {
            sum += process(n - 1);
        }
        if (n - 2 >= 0) {
            sum += process(n - 2);
        }
        return sum;
    }
    //memoization
    public int process2(int current, int target, int[] memo) {
        if(current > target) return 0;

        if(current == target) return 1;

        if(memo[current] > 0 ) {
            return memo[current];
        }

        memo[current] = process2(current + 1, target, memo) + process2(current + 2, target, memo);
        return memo[current];
    }


}
