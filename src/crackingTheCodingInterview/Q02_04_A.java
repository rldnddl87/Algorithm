package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.AssortedMethods;
import crackingTheCodingInterview.CtCILibrary.LinkedListNode;
/**
 * 값 x가 주어젔을 때에 x보다 작은 원소들은 x보다 크거나 같은 노드들 보다 앞에 오도록
 * x가 리스트에 있을 경우 x보다 작은 값들 뒤에만 나오면 된다 즉 x는 오른쪽 그룹의 어딘가에만 있으면 된다.
 * */
public class Q02_04_A {
    public static int index = 0;

    public static void sortByX(LinkedListNode head, int pivot) {


        LinkedListNode small = null;
        LinkedListNode big = head;

        while(big != null) {
            while (big != null) {
                if (big.data >= pivot) {
                    break;
                }
                big = big.next;
            }

            //pivot보다 큰 값을 가진 노드를 찾고..
            small = big.next;
            while (small != null) {
                if (small.data < pivot) {
                    break;
                }
                small = small.next;
            }

            if(small == null) return;

            int tmp = small.data;
            small.data = big.data;
            big.data = tmp;

        }
    }

    public static void main(String[] args) {
            int[] array = {3, 5, 8, 5, 10, 2, 1};
            LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
            System.out.println(head.printForward());

            sortByX(head, 5);
            System.out.println( head.printForward());

    }

}
