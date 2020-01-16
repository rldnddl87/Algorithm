package baekjoon;

import java.io.*;
import java.util.Comparator;
/**
 * 분류 정렬
 * 문제 번호 1427
 * */
public class bj1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));

        String input = br.readLine();
        //intStream -> Stream<Integer>를 위해 boxed() 사용
        // reverseOrder를 위해서..
        // BufferedWriter에 숫자를 기입하면 자동으로 아스키코드로 인식하여 문자로 변경하므로..
        // Integer로 비교한 뒤에 추가 작업이 필요 없다.
        input.chars().boxed().sorted(Comparator.reverseOrder()).forEach(s -> {
            try {
                bw.write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        bw.flush();
    }
}
