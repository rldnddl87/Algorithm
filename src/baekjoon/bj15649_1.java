package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 분류 백트래킹
 * 문제 번호 15649
 * recursive를 이용해서 풀어보자.
 * */

public class bj15649_1 {
    private static int[] num;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();
    private static  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( System.out));


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        num = new int[n];
        visited = new boolean[n];
        //0, 4, 2
        process(0, n, m);

        bw.write(sb.toString());

        bw.flush();
        bw.close();

    }

    public static void process (int idx, int n, int m) {

        if( idx == m) {
            for(int i = 0; i < m; i++) {
                sb.append(num[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;

            num[idx] = i + 1;

            process(idx + 1 , n, m);

            visited[i] = false;
        }



    }
}
