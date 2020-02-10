package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.AssortedMethods;
import crackingTheCodingInterview.CtCILibrary.LinkedListNode;

/**
 * 단방향 연결 리스트가 주어졌을 때 중간 노드하나를 삭제하는 알고리즘
 * 단 삭제할 노드에만 접근할 수 있다.
 * */
public class Q02_03_A {
    //삭제할 노드에만 접근할 수 있다는 것은 매개변수로 삭제할 노드를 받는다는 뜻
    public static boolean deleteInnerNode(LinkedListNode n) {

        if(n == null || n.next == null) return false;

        LinkedListNode next = n.next;

        n.next = next.next; // next가 아닌 이유는 0,1,2,3,4에서 2를 지운다고 하면 next를 할당하면 0,1,3,3,4가 되버린다.
        n.data = next.data;


        return true;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
        System.out.println(head.printForward());

        deleteInnerNode(head.next.next);

        System.out.println(head.printForward());


    }

}
