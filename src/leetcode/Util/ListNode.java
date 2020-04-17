package leetcode.Util;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode arrayToListNode(int[] arr) {

        ListNode node = new ListNode(0);
        ListNode dummy = node;
        for (int i : arr) {
            ListNode tmp = new ListNode(i);
            dummy.next = tmp;
            dummy = dummy.next;
        }

        return node.next;
    }
}
