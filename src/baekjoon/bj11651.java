package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 분류 정렬
 * 문제 번호 11651
 * */
public class bj11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));

        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            list.add(new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])});
        }


        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        for(int[] i : list) {
            bw.write(i[0] + " " + i[1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
