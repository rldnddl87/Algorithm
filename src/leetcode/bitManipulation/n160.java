package leetcode.bitManipulation;

/*
* 160. Intersection of Two Linked Lists
* Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A;
There are 3 nodes before the intersected node in B.
* */

import java.util.*;

public class n160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //교차점이 없으면 null을 반환한다.
        //원본의 두 노드는 함수 실행 뒤에도 동일하다.
        //기본적으로 주어진 LinkedList에는 cycle이 없다고 가정한다.
        //수행시간 O(n)과 공간복잡도O(1)을 가져야 한다.



        Set<ListNode> set = new HashSet<>();
        while(headA != null) {
            if(set.contains(headA)) {
                return headA;
            } else {
                set.add(headA);
            }

            headA = headA.next;
        }

        while(headB != null) {
            if(set.contains(headB)){
                return headB;
            } else {
                set.add(headB);
            }

            headB = headB.next;
        }

        return null;

    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while( a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
        /*
        * 예를들어 2,4,5,9,11 과 3,9,11이 있을 경우 intersectino은 9가 되고 a는 11까지 b 보다 2개의 노드를 더 가지고 있다.
        * 두개의 노드가 같은 횟수만큼 움직인다면 같은 위치에 있을것이다.(cycle처럼 가정하고, intersection이 있다고 가정한다면)
        * 한개의 노드가 마지막 노드에 도착한다면 다른 노드의 head로 위치시켜준다면 결국 두 노드는 같은 횟수만큼 움직이고 같은 intersectino에서
        * 만나게 된다.
        * */
    }
}
