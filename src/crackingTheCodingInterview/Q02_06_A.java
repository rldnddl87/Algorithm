package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.AssortedMethods;
import crackingTheCodingInterview.CtCILibrary.LinkedListNode;

/**
 * 주어진 연결 리스트가 회문인지 검사하는 함수
 * */

//회문은 앞으로 읽으나 뒤로 읽으나 동일하다 리스트를 뒤집어 본다면?

//스택을 사용하라
//연결리스트의 길이를 알고 있다고 가정하고 재귀적으로 풀이가 가능한가?

public class Q02_06_A {
    public static boolean isPalindrome(LinkedListNode node) {

        LinkedListNode reversedClone = reversedClone(node);

        while(node != null) {
            if(reversedClone.data != node.data) {
                return false;
            }

            reversedClone = reversedClone.next;
            node = node.next;
        }

        return true;
    }

    public static LinkedListNode reversedClone(LinkedListNode node) {

        LinkedListNode head = null;
        while( node != null) {
            LinkedListNode next = node.next;

            LinkedListNode n = new LinkedListNode();
            n.data = node.data;

            n.next = head;
            head = n;

            node = next;
        }

        return head;
    }


    public static void main(String[] args) {
        int[] arr1 = {1,2,1};

        LinkedListNode node1 = AssortedMethods.createLinkedListFromArray(arr1);

        System.out.println(node1.printForward());

        System.out.println("================");
        System.out.println(isPalindrome(node1));
    }
}
