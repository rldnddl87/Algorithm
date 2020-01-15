package baekjoon;

import java.io.*;

/**
 * 분류 브루트 포스
 * 문제 번호 1018
 * */
public class bj1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt( input[0]); // EX 10
        int M = Integer.parseInt( input[1]); // EX 13

        char[][] ch = new char[N][M];
        for(int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            ch[i] = tmp;
        }

        //최초 시작점을 기준으로 몇 칸씩 움직여봐야 하는지 확인
        int moveRight = M - 8;
        int moveDown = N - 8;

        int cnt = N * M; //모든 체스판의 색을 바꾸는 경우보다는 항상 적을 것이다.


        for(int i = 0; i <= moveDown; i++) {

            for(int j = 0; j <= moveRight; j++) { //
                int cntB = 0; //첫 시작이 B일경우 cnt 변수
                int cntW = 0; //첫 시작이 W일경우 cnt 변수
                //첫 시작이 B일 경우
                for(int m = 0; m < 8; m++) { //세로 축
                    for(int k = 0; k < 8; k++) { //가로축
                        if( m % 2 == 0){
                            //BWBW인지확인
                            if( k % 2 == 0 && ch[i+m][j+k] != 'B') {
                                cntB++;
                            }
                            if( k % 2 != 0 && ch[i+m][j+k] != 'W') {
                                cntB++;
                            }
                        } else {
                            //WBWB인지 확인
                            if( k % 2 == 0 && ch[i+m][j+k] != 'W') {
                                cntB++;
                            }
                            if( k % 2 != 0 && ch[i+m][j+k] != 'B') {
                                cntB++;
                            }
                        }
                    }
                }

                //첫 시작이 W일 경우
                for(int m = 0; m < 8; m++) { //세로 축
                    for(int k = 0; k < 8; k++) { //가로축
                        if( m % 2 == 0){
                            //WBWB인지확인
                            if( k % 2 == 0 && ch[i+m][j+k] != 'W') {
                                cntW++;
                            }
                            if( k % 2 != 0 && ch[i+m][j+k] != 'B') {
                                cntW++;
                            }
                        } else {
                            //BWBW인지 확인
                            if( k % 2 == 0 && ch[i+m][j+k] != 'B') {
                                cntW++;
                            }
                            if( k % 2 != 0 && ch[i+m][j+k] != 'W') {
                                cntW++;
                            }
                        }
                    }
                }

                if( cnt > cntB) cnt = cntB;
                if( cnt > cntW) cnt = cntW;
            }


        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

/*    public static char[][] copyArray(char[][] origin) {
        if(origin == null) return null;

        char[][] result = new char[origin.length][origin[0].length];

        for(int i = 0; i < origin.length; i++) {
            System.arraycopy(origin[i], 0, result[i], 0, origin[i].length);
        }

        return result;

    }*/
}
