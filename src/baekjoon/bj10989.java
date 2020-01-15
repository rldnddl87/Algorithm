package baekjoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 분류 정렬
 * 문제 번호 10989
 * */
public class bj10989 {
    public static void main( String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));

        Map<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            int tmp = Integer.parseInt( br.readLine());
            map.put(tmp, map.getOrDefault(tmp,0) + 1);
        }

        Map<Integer, Integer> sorted = map
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for(Map.Entry<Integer, Integer> e: sorted.entrySet()) {
            for(int i = 0; i < e.getValue(); i++) {
                bw.write(e.getKey() +"\n");
            }
        }

        bw.flush();
    }

}
