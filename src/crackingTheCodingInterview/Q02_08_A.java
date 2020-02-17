package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.LinkedListNode;

/**
 * 순환 연결리스트가 주어졌을 때, 순환되는 부분의 첫 째 노드를 반환하는 알고리즘을 작성하라
 * 순환 연결리스트란 노드의 next포인터가 앞선 노드들 가운데 어느 하나를 가리키도록 설정되어 있는, 엄밀히 말해서 변질된 방식의 연결리스트를 의미
 * ex ) INPUT : A -> B -> C -> D -> E -> C(앞에 나온 C와 동일)
 * OUTPUT : C
 *
 * 잘 이해가 가지 않는다.
 * */
public class Q02_08_A {
    //Runner기법을 사용하면 언젠가 두 러너는 반드시 만난다.
    public static LinkedListNode FindBeginning( LinkedListNode node) {
        LinkedListNode slow = node;
        LinkedListNode fast = node;

        while (fast != null && fast.next != null) {
            slow = slow.next; //1번 이동
            fast = fast.next.next; //2번 이동
            if( slow == fast) {
                break;
            }
        }

        if( fast == null || fast.next == null) {
            return null;
        }

        slow = node;

        while ( slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    public static void main(String[] args) {
        int list_length = 100;
        int k = 10;

        // Create linked list
        LinkedListNode[] nodes = new LinkedListNode[list_length];
        for (int i = 0; i < list_length; i++) {
            nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
        }

        // Create loop;
        nodes[list_length - 1].next = nodes[list_length - k];

        LinkedListNode loop = FindBeginning(nodes[0]);
        if (loop == null) {
            System.out.println("No Cycle.");
        } else {
            System.out.println(loop.data);
        }
    }

}
