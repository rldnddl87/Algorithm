package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 분류 정렬
 * 문제 번호 1427
 * 스트림 사용하지 않고 Character.getNumericValue() 이용해보기
 * */
public class bj1427_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));

        char[] input = br.readLine().toCharArray();

        List<Integer> list = new ArrayList<>();

        for(char c : input) {
            list.add(Character.getNumericValue(c));
        }

        Collections.sort(list, Collections.reverseOrder());

        for(int i : list) {
            bw.write(String.valueOf(i));
        }

        bw.flush();
    }
}
