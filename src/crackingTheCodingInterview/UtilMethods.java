package crackingTheCodingInterview;

import com.sun.org.apache.regexp.internal.RE;

public class UtilMethods {

    public static void printMatrix(int[][] n) {
        System.out.println("==print start==");
        for(int[] arr : n) {
            for(int m = 0; m < arr.length; m++) {
                System.out.printf("%3s",arr[m]);
            }
            System.out.println();
        }
        System.out.println("==end==");
    }

    public static int[][] makeMatrix(int N, int M) {
        int[][] n = new int[N][M];
        int i = 1;
        for(int k = 0; k < n.length; k++) {
            for(int j = 0; j < n[0].length; j++) {
                n[k][j] = i++;
            }
        }

        return n;
    }
}
