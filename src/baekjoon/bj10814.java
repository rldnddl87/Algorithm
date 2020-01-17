package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 분류 정렬
 * 문제 번호 10814
 * */

public class bj10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out));

        int n = Integer.parseInt( br.readLine());

        //age, name, input index
        List<Member> members = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            members.add(new Member(Integer.parseInt(str[0]), str[1], i));
        }

        Collections.sort(members);

        for( Member m : members) {
            bw.write(m.age + " " + m.name + "\n");
        }

        bw.flush();
        bw.close();
    }
}

class Member implements Comparable<Member>{
    int age;
    String name;
    int idx;

    Member(int age, String name, int idx) {
        this.age = age;
        this.name = name;
        this.idx = idx;
    }


    @Override
    public int compareTo(Member o) {
        if(this.age == o.age) {
            return this.idx - o.idx;
        }
        return this.age - o.age;
    }
}
