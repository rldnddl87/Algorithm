package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.AssortedMethods;
import crackingTheCodingInterview.CtCILibrary.LinkedListNode;
/**
 * 각 자리수가 정상적으로 배열된다고 가정한다면..?
 * (6->1->7) : 617
 * (1->2->4->5) : 1245
 * */
public class Q02_05_B {
    //길이가 다른 만큼 짧은 노드에 0을 앞쪽에 덧붙인다.
    //10을 넘어가면 앞쪽 노드에 1을 덧붙인다.

    public static LinkedListNode sum = null; //이전 노드의 주소를 저장
    public static int carry = 0; //올림수 저장

    //static 변수를 사용하는 것 보다 클래스의 멤버변수를 통해 저장하는 방식이 좋을것 같다.
    public static LinkedListNode plusNode(LinkedListNode l1, LinkedListNode l2) {
        int length1 = getLength(l1);
        int length2 = getLength(l2);

        int difference;
        if( length1 > length2) {
            difference = length1 - length2;
            l2 = addPadding(l2, difference);
        }

        if( length2 > length1) {
            difference = length2 - length1;
            l1 = addPadding(l1, difference);
        }
        //두개의 리스트의 길이를 맞춰주고(빈 노드는 0으로 채움)

        addHelper(l1, l2); //각 자리수를 더해주고

        if(carry != 0) { //마지막 자리수를 더한뒤 한번더 자리수를 올려줘야 한다면..
            sum = insertPrevious(sum, carry); //자리수를 올려주고
        }

        LinkedListNode result = sum; //자리수를 올릴 필요가 없다면 그대로 return; void로 선언하고 static변수를 직접 접근해도 상관 없겠쥥

        return result;
    }

    public static void addHelper(LinkedListNode l1, LinkedListNode l2) {

        if( l1 == null && l2 == null) {
            carry = 0;
            sum = null;
            return;
        }

        addHelper(l1.next, l2.next);

        int val = l1.data + l2.data + carry;

        sum = insertPrevious(sum, val % 10);
        carry = val / 10;

    }

    public static LinkedListNode addPadding(LinkedListNode node, int cnt) {

        for(int i = 0; i < cnt; i++) {
            node = insertPrevious(node, 0);
        }

        return node;
    }

    public static LinkedListNode insertPrevious(LinkedListNode node, int x) {
        LinkedListNode result = new LinkedListNode();

        result.data = x;
        result.next = node;

        return result;
    }

    public static int getLength(LinkedListNode node) {

        int cnt = 0;
        while(node != null) {
            cnt++;
            node = node.next;
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] arr1 = {3,6,4,8};
        int[] arr2 = {2,3,6};

        LinkedListNode node1 = AssortedMethods.createLinkedListFromArray(arr1);
        LinkedListNode node2 = AssortedMethods.createLinkedListFromArray(arr2);

        System.out.println("node1 : " + node1.printForward());
        System.out.println("node2 : " + node2.printForward());

        System.out.println("insert");

        LinkedListNode plusNode = plusNode(node1, node2);
        System.out.println(plusNode.printForward());
    }
}
