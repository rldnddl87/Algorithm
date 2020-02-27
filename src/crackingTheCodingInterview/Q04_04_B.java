package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.AssortedMethods;
import crackingTheCodingInterview.CtCILibrary.TreeNode;

/**
 * 답안
 * */
public class Q04_04_B {

    public static int checkHeight(TreeNode root) {
        if( root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if( Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1; //실제 카운트 되는 곳
        }

    }

    public static boolean isBalanced(TreeNode root){
        return checkHeight(root) != Integer.MIN_VALUE;
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
