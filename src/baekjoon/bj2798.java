package baekjoon;

import java.util.*;
import java.io.*;
/**
 * 분류 브루트 포스(모든 경우의 수를 탐색하라..)
 * 문제 번호 2798
 * */
public class bj2798 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));

        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        List<Integer> numList = new ArrayList<>();

        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        for(int i = 0; i < input2.length; i++) {
            numList.add(Integer.parseInt(input2[i]));
        }

        //주어진 숫자 오름차순 정렬
        Collections.sort(numList);
        int rst = 0;
        int tmp;

        for(int i = 0; i < numList.size() - 2; i++) {
            for(int j = i + 1; j < numList.size() - 1; j++) {
                for( int k = j + 1; k < numList.size(); k++) {
                    tmp = numList.get(i) + numList.get(j) + numList.get(k);
                    if(tmp > m) {
                        break;
                    }
                    if( rst < tmp) {
                        rst = tmp;
                    }
                    if(m == rst) {
                        break;
                    }

                }
            }
        }

        bw.write(String.valueOf(rst));


        bw.flush();
    }
}
