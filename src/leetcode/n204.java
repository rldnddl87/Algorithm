package leetcode;
/*
 * 204. Count Primes
 * Count the number of prime numbers less than a non-negative number, n.
 * */

/*
Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
* */

public class n204 {
    public int countPrimes(int n) {
        boolean[] flag = new boolean[n]; //1 ~ n 이하의 자연수 중 소수의 개수를 구하는 문제
        //flag 가 false일 경우 소수 이다.

        int prime = 2;

        for(int i = prime; i < Math.sqrt(n); i++) {
            if(!flag[i]) {
                for(int k = i * i; k < flag.length; k += i) {
                    flag[k] = true;
                }
            }
        }

        int count = 0;

        for(int i = 2; i < flag.length; i++) {
            if(!flag[i]) count++;
        }

        return count;

    }
}
