package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.AssortedMethods;
import crackingTheCodingInterview.CtCILibrary.TreeNode;

/**
 * 균형 확인
 * 이진 트리가 균형 잡혀있는지 확인하는 함수를 작성하라.
 * 균형 잡힌 트리란 모든 노드에 대해서 왼쪽 부분 트리의 높이와 오른쪽 부분 트리의 높이의 차이가 최대 하나인 트리를 의미한다.
 * */
public class Q04_04_A {
    //하나의 노드에서 검증할 수 있는가? 그렇다면 모든 노드에서는?


    public static boolean isBalanced(TreeNode root) {
        int leftHeight = checkHeight(root.left, 0);
        int rightHeight = checkHeight(root.right, 0);

        int minus = Math.abs(leftHeight - rightHeight);

        if( minus == 0 || minus == 1) return true;

        return false;
    }


    public static int checkHeight(TreeNode root, int depth) {
        if(root == null) return depth;

        int left = checkHeight(root.left, depth + 1);
        int right = checkHeight(root.right, depth + 1);

        return left >= right ? left : right;
    }

    public static void main(String[] args) {
        // Create balanced tree
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        System.out.println("Root? " + root.data);
        System.out.println("Is balanced? " + isBalanced(root));

        // Could be balanced, actually, but it's very unlikely...
        TreeNode unbalanced = new TreeNode(10);
        for (int i = 0; i < 10; i++) {
            unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
        }
        System.out.println("Root? " + unbalanced.data);
        System.out.println("Is balanced? " + isBalanced(unbalanced));
    }
}
