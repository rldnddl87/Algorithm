package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.AssortedMethods;
import crackingTheCodingInterview.CtCILibrary.LinkedListNode;

public class Q02_04_B {
    public static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;

        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while(node != null) {
            LinkedListNode next = node.next;
            node.next = null;
            if(node.data < x) {
                if( beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if( afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }

            }

            node = next;
        }


        if(beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;

        return  beforeStart;

    }


    public static void main(String[] args) {
        int[] array = {3, 5, 8, 5, 10, 2, 1};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
        System.out.println(head.printForward());

        partition(head, 5);
        System.out.println( head.printForward());

    }
}
