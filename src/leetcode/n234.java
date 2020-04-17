package leetcode;
/*
234. Palindrome Linked List
Given a singly linked list, determine if it is a palindrome.
* */

/*
* Input: 1->2
Output: false
*
* Input: 1->2->2->1
Output: true
* */

import leetcode.Util.ListNode;

/*
* 예를들어
1 -> 2 -> 2 -> 1
s
f

1 -> 2 -> 2 -> 1 ->
          s       f

1 -> 2  // reverse 1 -> 2 -> null
head

reverse를 null일 때 까지 head부터 1개씩 비교해나가면 된다.

* */
public class n234 {
    public boolean isPalindrome(ListNode head) {
        if( head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverse(slow);

        while(reversed != null) {
            if( head.val != reversed.val) {
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode current = head;


        while(head != null) {
            current = head;

            head = head.next;
            //current에 head주소값을 주고 current.next값을 할당하기 때문에 next값을 설정하기 전에 head에 다음 주소값을 넣어주어야 한다.
            current.next = prev;

            prev = current;
        }

        return prev;
    }
}
