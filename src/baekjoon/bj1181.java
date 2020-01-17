package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 분류 정렬
 * 문제 번호 1181
 * */

public class bj1181 {
    public static void main( String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));

        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if( o2.length() == o1.length()) {
                    char[] o2ch = o2.toCharArray();
                    char[] o1ch = o1.toCharArray();

                    for(int i = 0; i < o2.length(); i++) {
                        if(o1ch[i] != o2ch[i]){
                            return o1ch[i] - o2ch[i];
                        }
                    }
                }

                return o1.length() - o2.length();
            }
        });

        String firstStr = list.get(0);
        bw.write(firstStr +"\n");
        for(int i = 1; i < list.size(); i++) {
            if( !firstStr.equals(list.get(i))) {
                bw.write(list.get(i) + "\n");
            }
            firstStr = list.get(i);
        }


        bw.flush();
        bw.close();
    }

}
