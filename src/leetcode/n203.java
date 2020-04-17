package leetcode;
/*
203. Remove Linked List Elements
Remove all elements from a linked list of integers that have value val.
 * */

import leetcode.Util.ListNode;

/*
* Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
* */
public class n203 {
    //recursive
    public ListNode removeElementes(ListNode head, int val) {
        if( head == null) return head;
        ListNode next = removeElementes(head.next, val);
        if(head.val == val) return next;
        head.next = next;
        return head;
    }

    //iterative
    public ListNode removeElementsIteratively(ListNode head, int val) {
        ListNode node = new ListNode(0);

        node.next = head; // 0 -> original head..

        ListNode prev = node;
        ListNode current = head;

        while(current != null) {

            if(current.val == val) {
                prev.next = current.next;
            } else {
                prev = prev.next;
            }

            current = current.next;
        }
        return node.next;
    }
}
