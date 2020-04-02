package crackingTheCodingInterview;

import java.util.ArrayList;

public class Q05_03_B {

    public static int longestSequence(int n) {
        if( n == -1) return Integer.BYTES * 8;
        ArrayList<Integer> sequence = getAlternatingSequences(n);
        return findLongestSequence(sequence);
    }

    private static int findLongestSequence(ArrayList<Integer> sequence) {
        int maxSeq = 1;

        for (int i = 0; i < sequence.size(); i+= 2) {
            int zerosSeq = sequence.get(i); //0의 연속 개수

            int onesSeqRight = i - 1 >= 0 ? sequence.get(i - 1) : 0;
            int onesSeqLeft = i + 1 < sequence.size() ? sequence.get(i + 1) : 0;

            int thisSeq = 0;
            if( zerosSeq == 1) {
                thisSeq = onesSeqLeft + 1 + onesSeqRight;
            } else if( zerosSeq > 1) {
                thisSeq = Math.max(onesSeqLeft, onesSeqRight) + 1;
            } else if( zerosSeq == 0) {
                thisSeq = Math.max(onesSeqLeft, onesSeqRight);
            }

            maxSeq = Math.max(maxSeq, thisSeq);
        }

        return maxSeq;
    }

    private static ArrayList<Integer> getAlternatingSequences(int n) {
        ArrayList<Integer> sequences = new ArrayList<>();

        int searchingFor = 0;
        int counter = 0;

        for ( int i = 0; i < Integer.BYTES * 8; i++) { //ex 10011101
            if ((n & 1) != searchingFor) {
                sequences.add(counter);
                searchingFor = n & 1; //이전 n의 비트가 0이었으면 1로 1이었으면 0으로
                counter = 0;
            }
            counter++;
            n >>>= 1;
        }

        sequences.add(counter);

        return sequences;
    }

    public static void main(String[] args) {


    }
}
