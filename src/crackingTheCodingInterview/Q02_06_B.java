package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.AssortedMethods;
import crackingTheCodingInterview.CtCILibrary.LinkedListNode;

import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

//스택을 이용해서 풀어보면
//노드의 절반까지 스택에 넣고 그 다음 노드부터 스택에 있는 값들과 비교하면 된다.
public class Q02_06_B {

    public static boolean isPalindrome(LinkedListNode node) {
        LinkedListNode slow = node;
        LinkedListNode fast = node;

        Stack<Integer> stack = new Stack<>();
        while(fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next;
        }

        //1->2->3->2->1 일경우
        //1회전 slow = 2 fast = 3
        //2회전 slow = 3 fast = 1 fast.next == null이기 때문에 이 상태에서 while문을 벗어난다.
        if( fast != null) {
            slow = slow.next; //노드의 개수가 홀수개 일 경우 가운데 요소는 확인할 필요가 없기 때문에 넘어서고
        }

        while( slow != null) {
            int val = stack.pop().intValue();
            if( slow.data != val) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,1};
        //nodes[length - 2].data = 9; // Uncomment to ruin palindrome

        LinkedListNode head = AssortedMethods.createLinkedListFromArray(arr);
        System.out.println(head.printForward());
        System.out.println(isPalindrome(head));
    }
}