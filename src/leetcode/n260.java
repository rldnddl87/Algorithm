package leetcode;
/*
260. Single Number III
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
Find the two elements that appear only once.
*/

/*
Input:  [1,2,1,3,2,5]
Output: [3,5]
* */
public class n260 {
    public int[] singleNumber(int[] nums) {
        int[] ans = {0,0};

        int mask = 0;
        for(int n : nums) {
            mask ^= n; // 3 XOR 5의 값이 mask에 저장되고..
        }

        mask = getRightestBit(mask); //해당 mask의 최우측에 있는 1비트만 가져온다.

        for(int num : nums) {
            if((num & mask) == 0) { //배열의 모든 수를 mask로 비교하면 서로다른 두 수 3과 5는 if와 else문으로 각각 1개씩 빠지게 되고..
                ans[0] ^= num; //나머지 두개씩 존재하는 같은 수들은 XOR연산을 통해 0가 된다.
            } else {
                ans[1] ^= num; //결국 서로 다른 두 수만 남게 됨
            }
        }
        return ans;
    }

    public int getRightestBit(int n) {
        int mask = 1;

        while((mask & n) != mask) {
            mask <<= 1;
        }
        return mask & n;
    }
}
