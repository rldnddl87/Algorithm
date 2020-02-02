package baekjoon;

import java.io.*;

public class bj9663 {

    private static int cnt;
    private static int[] queen;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));

        N = Integer.parseInt( br.readLine());

        queen = new int[N];

        for(int i = 0; i < N; i++) {
            queen[0] = i; //
            process(0);
        }
        bw.write(String.valueOf(cnt));
        bw.close();
    }

    public static void process(int row) {
        if(row == N - 1) {
            cnt++;
            return;
        }

        for(int i = 0; i < N; i++) {
            queen[row + 1] = i;
            if(isPossible(row + 1)) {
                process(row + 1);
            }
        }
    }

    public static boolean isPossible(int row) {
        for(int k = 0; k < row; k++) {
            if(Math.abs(queen[row] - queen[k]) == row - k)
                return false;
            if( queen[row] == queen[k]) {
                return false;
            }
        }
        return true;
    }
}
