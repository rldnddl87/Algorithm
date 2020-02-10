package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.AssortedMethods;
import crackingTheCodingInterview.CtCILibrary.LinkedListNode;

public class Q02_04_C {
    public static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode smaller = null;
        LinkedListNode bigger = null;


        while(node != null) {
            LinkedListNode next = node.next;

            if(node.data < x) {
                node.next = smaller;
                smaller = node;
            } else { //node.data >= x
                node.next = bigger;
                bigger = node;
            }
            node = next;
        }

        if(smaller == null) {
            return bigger;
        }

        LinkedListNode rst = smaller;

        while(smaller.next != null) {
            smaller = smaller.next;
        }

        smaller.next = bigger;

        return rst;
    }


    public static void main(String[] args) {
        int[] array = {3, 5, 8, 5, 10, 2, 1};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
        System.out.println(head.printForward());

        LinkedListNode rst = partition(head, 5);
        System.out.println( rst.printForward());

    }
}
