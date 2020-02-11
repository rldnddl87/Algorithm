package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.AssortedMethods;
import crackingTheCodingInterview.CtCILibrary.LinkedListNode;

/**
 * 연결리스트로 숫자를 표현할 때 각 노드가 자릿수 하나를 가리키는 방식으로 표현할 수 있다.
 * 각 숫자는 역순으로 배열되어 있는데(712 // 2->1->7) 첫번째 자리수가 리스트의 맨 앞에 위치하도록 배열된다는 뜻이다.
 * 이와 같은 방식으로 표현되는 숫자 두개가 있을때, 이 두 수를 더하여 그 합을 연결 리스트로 반환하는 함수를 작성
 * */
public class Q02_05_A {
    //두개의 리스트를 정수형으로 반환한뒤 다시 연결 리스트로 만들면 쉽지만
    //정수형으로 변환시키지 않고 푼다면
    //자리수가 일치하지 않는 리스트의 연산은?
    //재귀적으로 풀 수 있지 않을까?

    public static LinkedListNode plusNode(LinkedListNode num1, LinkedListNode num2, int x) {

        LinkedListNode node = new LinkedListNode();

        if( num1 == null && num2 == null && x == 0) {
            return null;
        }

        if( num1 != null) {
            x += num1.data;
        }

        if( num2 != null) {
            x += num2.data;
        }


        node.data = x % 10; // 1의자리

        if( num1 != null || num2 != null) {
            node.next  = plusNode(num1 == null ? null : num1.next, num2 == null ? null : num2.next, x >= 10 ? 1 : 0);
        }

        return node;
    }

    public static void main(String[] args) {
        int[] array = {3,5};
        int[] array2 = {7,9,8};

        LinkedListNode num1 = AssortedMethods.createLinkedListFromArray(array);
        LinkedListNode num2 = AssortedMethods.createLinkedListFromArray(array2);

        System.out.println(num1.printForward());
        System.out.println(num2.printForward());

        LinkedListNode rst = plusNode(num1, num2,0);

        System.out.println(rst.printForward());
    }
}
