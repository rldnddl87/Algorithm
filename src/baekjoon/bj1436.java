package baekjoon;

import java.io.*;

/**
 * 분류 브루트 포스
 * 문제 번호 1436
 * */
public class bj1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));

        int n = Integer.parseInt(br.readLine());

        // 666, 1666, 2666, 3666, 4666, 5666, 6660, 6661, 6662, 6663, 6664, 6665, 6666, 6667, 6668..과 같다.
        // N은 N번쨰로 작은 종말의 숫자와 같다.

        int i = 0;
        int cnt = 0;

        while(true) {
            i++;

            String str = String.valueOf(i);
            if(str.length() >= 3 && str.contains("666")) cnt++;

            if( cnt == n) {
                bw.write(String.valueOf(i));
                break;
            }

        }


        bw.flush();
    }
}
