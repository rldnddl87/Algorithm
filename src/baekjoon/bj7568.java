package baekjoon;

import java.util.*;
import java.io.*;
/**
 * 분류 브루트 포스
 * 문제 번호 7568
 * */
public class bj7568 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));

        int cnt = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < cnt; i++) {
            List<Integer> tmpList = new ArrayList<>();
            String[] str = br.readLine().split(" ");

            tmpList.add(0, Integer.parseInt(str[0]));
            tmpList.add(1, Integer.parseInt(str[1]));

            list.add(i, tmpList);
        }

        //자신의 등수는 자기보다 덩치가 큰 사람의 수 + 1이다.

        for(int i = 0; i < cnt; i++) {
            int rst = 1;
            for(int j = 0; j < cnt; j++) {
                List<Integer> tmpList1 = list.get(i);
                List<Integer> tmpList2 = list.get(j);
                if( tmpList1.get(0) < tmpList2.get(0) && tmpList1.get(1) < tmpList2.get(1)) {
                    rst++;
                }

            }
            bw.write(rst  + " ");

        }

        bw.flush();
    }
}
