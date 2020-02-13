package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.AssortedMethods;
import crackingTheCodingInterview.CtCILibrary.LinkedListNode;

/**
 * 교집합
 * 단방향 연결 리스트 두개가 주어졌을 때 이 두 리슽의 교집합 노드를 찾은뒤 반환하는 코드를 작성하라.
 * 여기서 교집합이란 노드의 값이 아니라 노드의 주소가 완전히 같은 경우를 말한다.
 *
 * */
public class Q02_07_A {
    //같은 노드 이후 부터는 모두 동일하다
    //길이의 차이가 나는 경우는?
    //교집합이 반드시 존재할 경우 맨 마지막 노드는 반드시 일치한다.

    public static LinkedListNode findIntersection(LinkedListNode l1, LinkedListNode l2) {
        if( l1 == null || l2 == null) return null;

        int length1 = getLength(l1);
        int length2 = getLength(l2);

        LinkedListNode shorter = length1 > length2 ? l2 : l1;
        LinkedListNode longer = length1 > length2 ? l1 : l2;

        longer = makeEqualLenth(longer, Math.abs(length1 - length2));

        while( shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return shorter;
    }

    public static LinkedListNode makeEqualLenth(LinkedListNode longNode, int cnt) {
        for(int i = 0; i < cnt; i++) {
            longNode = longNode.next;
        }
        return longNode;
    }

    public static int getLength(LinkedListNode node) {
        int sum = 0;


        while( node != null) {
            node = node.next;
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        /* Create linked list */
        int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);

        int[] vals2 = {12, 14, 15};
        LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);

        list2.next.next = list1.next.next.next.next;

        System.out.println(list1.printForward());
        System.out.println(list2.printForward());


        LinkedListNode intersection = findIntersection(list1, list2);

        System.out.println(intersection.printForward());
    }
}
