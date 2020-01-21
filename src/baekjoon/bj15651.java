package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 분류 백트래킹
 * 문제 번호 15651
 * */
public class bj15651 {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        process(0, N, M, "");

        bw.write(sb.toString());

        bw.close();
    }

    public static void process(int cnt, int N, int M, String str) {
        if(cnt == M) {
            str += "\n";
            sb.append(str);
            return;
        }

        for(int i = 1; i <= N; i++) {
            process(cnt + 1, N, M, str + i +" ");
        }

    }
}
