package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.AssortedMethods;
import crackingTheCodingInterview.CtCILibrary.TreeNode;

/**
 * BST검증
 * 주어진 이진 트리가 이진 탐색 트리인지 확인하는 함수를 작성하라.
 * */
public class Q04_05_A {

    //이진 트리 : 자식 노드의 개수가 2개
    //탐색 트리 leftNode.data <= rootNode.data < rightNode.data -> 모든 노드에 대해서도 적용되야 한다.

    private static Integer last = null; // 항상 왼쪽에 있는 노드의 데이터를 저장

    public static boolean isBST(TreeNode root) {
        //모든 노드에 대해서 전위순회를 하면서 left -> root -> right 하나라도 조건에 부합하지 않으면 false
        if(root == null) return true;

        if( !isBST(root.left)) return false;

        if(last != null && root.data <= last) return false;
        last = root.data;

        if( !isBST(root.right)) return false;

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};

        TreeNode node = AssortedMethods.createTreeFromArray(arr);

        //System.out.println(isBST(node));

        System.out.println();

    }
}
