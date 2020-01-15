package baekjoon;

import java.io.*;
/**
 *  분류 재귀
 *  문제 번호 10870
 */

public class bj10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));

        int n = Integer.parseInt( br.readLine());
        int rst = getPivonacci(n);
        bw.write(String.valueOf(rst));
        bw.flush();
    }

    public static int getPivonacci(int n) {
        if( n == 0 || n == 1) return n;


        return getPivonacci(n - 1) + getPivonacci(n - 2);

    }
}
