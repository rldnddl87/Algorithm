package baekjoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 분류 백트래킹
 * 문제 번호 15649
 * */
public class bj15649 {
    public static void main( String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        //1~n까지의 숫자로 이루어진 list 생성
        List<Integer> list = IntStream.range(1, n + 1).distinct().boxed().collect(Collectors.toList());

        //중복된 숫자가 없고(Set) 오름차순으로 정렬해야 하기 때문에(TreeSet)
        //Comparator 구현
        Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        //총 몇개의 숫자를 구해야 하는지
        int size = getFactorial(n, n - m + 1);

        while(true) {

            if(set.size() == size) break;

            StringBuilder st = new StringBuilder();

            //m개의 자리수로 이루어지는 중복이 없는 숫자를 생성
            while(true){
                if(st.length() == m) break;
                int random = (int)(Math.random() * n);

                String tmp = String.valueOf(list.get(random));

                if( !st.toString().contains(tmp)) {
                    st.append(tmp);
                }

            }

            set.add(Integer.parseInt(st.toString()));

        }

        //출력
        for(int i  : set) {
            char[] ch = String.valueOf(i).toCharArray();

            for(char c : ch) {
                bw.write(c + " ");
            }

            bw.write("\n");
        }


        bw.flush();
        bw.close();
    }

    public static int getFactorial(int from , int to) {
        if (from == to) {
            return to;
        }

        if( from == 1) {
            return 1;
        }

        return from * getFactorial(from - 1, to);


    }

}


