package crackingTheCodingInterview;

import com.sun.xml.internal.fastinfoset.algorithm.HexadecimalEncodingAlgorithm;
import crackingTheCodingInterview.CtCILibrary.AssortedMethods;
import crackingTheCodingInterview.CtCILibrary.LinkedListNode;
import making.LinkedList;

/**
 * 단방향 연결리스트가 주어젔을때에 뒤에서 k번째 원소를 찾는 알고리즘을 구현하라
 * (재귀풀이)
 */
public class Q02_02_B {

    public static LinkedListNode printKthToLast(LinkedListNode head, int k) {


        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        for(int i = 0; i < k; i++) {
            if( p1 == null) return null;
            p1 = p1.next;
        }

        while(p1 != null) {

            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
        //head.printForward();
        for (int i = 0; i <= array.length + 1; i++) {
            //printKthToLast(head, i);
        }
        LinkedListNode k = printKthToLast(head, 2);

        String rst = k == null? "null" : "" + k.data;

        System.out.println(rst);
    }
}
