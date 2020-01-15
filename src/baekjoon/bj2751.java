package baekjoon;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * 분류 정렬
 * 문제 번호 2751
 */

public class bj2751 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add( Integer.parseInt( br.readLine()));
        }

        Collections.sort(list);

        for(int i : list) {
            System.out.println(i);
        }

        bw.flush();
    }
}
