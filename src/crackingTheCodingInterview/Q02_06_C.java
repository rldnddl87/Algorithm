package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.AssortedMethods;
import crackingTheCodingInterview.CtCILibrary.LinkedListNode;

//재귀적으로 구현한다면
public class Q02_06_C {
    public static class Result {
        public LinkedListNode node;
        public boolean result;
        public Result(LinkedListNode node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }

    public static int getLength(LinkedListNode node) {
        int sum = 0;

        while(node != null) {
            sum++;
            node = node.next;
        }

        return sum;
    }

    public static boolean isPelindrome(LinkedListNode node) {
        int length = getLength(node);
        Result result = recursive(node, length);

        return result.result == true ? true : false ;
    }

    public static Result recursive(LinkedListNode node, int length) {
        if( node == null || length <= 0) {
            return new Result(node, true);
        } else if(length == 1){
            return new Result(node.next, true);
        }

        Result result = recursive(node.next, length - 2);

        //판단하는 부분
        if( !result.result || result.node == null) {
            return result;
        }

        result.result = node.data == result.node.data;

        result.node = result.node.next;


        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {0,1,2,3,2,1,1};
        int[] arr2 = {0,1,2,3,4,3,2,1,0};

        LinkedListNode node1 = AssortedMethods.createLinkedListFromArray(arr1);
        LinkedListNode node2 = AssortedMethods.createLinkedListFromArray(arr2);

        System.out.println("node 1 judge : " + isPelindrome(node1));
        System.out.println("node 2 judge : " + isPelindrome(node2));
    }
}
