package leetcode;
/*
* 141. Linked List Cycle
* Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
* If pos is -1, then there is no cycle in the linked list.
* */

/*
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.
* */

import leetcode.Util.ListNode;

import java.util.*;

public class n141 {

    //Using HashTable
    public boolean hasCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();

        while(head != null) {
            if( set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }

            head = head.next;
        }
        return false;

    }

    //Using Two Pointers
    public boolean hasCycleUsingPointer(ListNode head) {

        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;

    }
}
