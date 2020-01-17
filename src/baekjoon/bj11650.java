package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 분류 정렬
 * 문제 번호 11650
 * */

public class bj11650 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));


        int n = Integer.parseInt(br.readLine());

        List<Location> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            list.add(new Location(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
        }

        Collections.sort(list);

        for(Location lo : list) {
            bw.write(lo.x + " " + lo.y + "\n");
        }

        bw.flush();
    }

}

class Location implements Comparable<Location> {

    int x;
    int y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Location o) {
        if(o.x == this.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }
}
