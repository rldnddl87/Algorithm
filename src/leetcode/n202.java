package leetcode;
/*
* 202. Happy Number
* Write an algorithm to determine if a number n is "happy".
A happy number is a number defined by the following process: Starting with any positive integer,
* replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
* or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
Return True if n is a happy number, and False if not.
* */

/*
* Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
* */
public class n202 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = getSquareSum(slow);
            fast = getSquareSum(fast);
            fast = getSquareSum(fast);
            if (slow == 1) return true;
        } while (slow != fast);

        return false;
    }

    public int getSquareSum(int n) {
        int sum = 0;
        int q = 0;

        while (n > 0) {
            q = n % 10;
            sum += q * q;
            n = n / 10;

        }

        return sum;
    }
}
