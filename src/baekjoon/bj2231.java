package baekjoon;

import java.io.*;
/**
 * 분류 브루트 포스
 * 문제 번호 2231
 * */
public class bj2231 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));

        int n = Integer.parseInt(br.readLine());

        int min = 1000000;

        for(int i = n; i >= 0; i--) {
            int sum = 0;
            char[] ch = String.valueOf(i).toCharArray();
            for(int j = 0; j < ch.length; j++) {
                sum += Character.getNumericValue(ch[j]);
            }

            if( i + sum == n && i < min) {
                min = i ;
            }
        }

        if( min == 1000000) min = 0;
        bw.write(String.valueOf(min));


        bw.flush();
    }
}
