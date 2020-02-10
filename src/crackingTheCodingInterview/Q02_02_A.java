package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.AssortedMethods;
import crackingTheCodingInterview.CtCILibrary.LinkedListNode;


/**
* 단방향 연결리스트가 주어젔을때에 뒤에서 k번째 원소를 찾는 알고리즘을 구현하라
 * (재귀풀이)
*/
public class Q02_02_A {
    public static int printKthToLast(LinkedListNode head, int k) {
        System.out.println("call printKthToLast Method");
        if (head == null) {
            return 0;
        }
        int index = printKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is " + head.data);
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
        //head.printForward();
        for (int i = 0; i <= array.length + 1; i++) {
            //printKthToLast(head, i);
        }
        printKthToLast(head, 2);
    }


}
