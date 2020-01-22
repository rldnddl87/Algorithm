package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class bj15652 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( System.out));

    public static void main( String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        process(0,1, N, M, "");
        bw.close();

    }

    public static void process (int cnt, int pos, int N, int M,String str) throws IOException {

        if(cnt == M) {
            str += "\n";
            bw.write(str);
            return;
        }

        for(int i = pos; i <= N; i++) {
            process(cnt + 1 , i, N, M, str + i +" ");
        }
    }





}
