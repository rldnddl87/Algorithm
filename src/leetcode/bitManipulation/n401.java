package leetcode.bitManipulation;

import java.util.*;

/*
* 401. Binary Watch
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.
* */

/*
Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
* */
public class n401 {
    public List<String> readBinaryWatch(int num) {
        List<String> time = new ArrayList<>();

        int tmp;
        for(int Hour = 0; Hour < 12; Hour++) {
            for(int Minute = 0; Minute < 60; Minute++) {
                tmp = (Hour << 6) + Minute;
                if( Integer.bitCount(tmp) == num) {
                    time.add(String.format("%d:%02d", Hour, Minute));
                }
            }
        }

        return time;
    }
}
