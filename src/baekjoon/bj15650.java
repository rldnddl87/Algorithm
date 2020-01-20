package baekjoon;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 분류 백트래킹
 * 문제 번호 15650
 * */
public class bj15650 {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt( st.nextToken());
        int M = Integer.parseInt( st.nextToken());

        process(0, 1, N, M, "");

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    public static void process(int cnt, int crt, int n, int m, String str) {

        if( cnt == m) {
            str += "\n";
            str.trim();
            sb.append(str);
            return;
        }

        for(int i = crt; i <= n; i++) {
            process(cnt + 1, i + 1, n, m, str + i + " ");
        }



    }
}
