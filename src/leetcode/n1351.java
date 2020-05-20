package leetcode;
/**
 * level : easy
 * url : https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 * 
 * 1351. Count Negative Numbers in a Sorted Matrix
 * Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise. 

Return the number of negative numbers in grid.
 */

/**
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]] Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 */

public class n1351 {
    public int countNegatives(int[][] grid) {
        int r = grid.length - 1;
        int c = 0;
        int count = 0;
        int length = grid[0].length;

        while (r >= 0 && c < length) {

            if (grid[r][c] >= 0) {
                c++;
            } else {
                count += length - c;
                r--;
            }

        }
        return count;
    }
}