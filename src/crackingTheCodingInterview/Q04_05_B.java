package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.AssortedMethods;
import crackingTheCodingInterview.CtCILibrary.TreeNode;

/**
 * 모든 왼쪽 노드가 현재 노드보다 같거나 작고, 모든 오른쪽 노드가 현재 노드보다 커야 BST에 충족한다.
 * */

public class Q04_05_B {

    //재귀적으로 탐색하면서 최소값과 최대값을 함께 넘겨주면서 탐색한다.
    //왼쪽 노드들은 min = 무한대 , max = root.data
    //오른쪽 노드들은 min = root.data, max = 무한대 이다.

    public static boolean isBST(TreeNode n, Integer min, Integer max) {
        if( n == null) return true;

        if( (min != null && n.data <= min) || (max != null && n.data > max)) return false;

        if(!isBST( n.right, n.data, max) || !isBST( n.left, min, n.data)) return false;

        return true;
    }

    public static boolean isBST(TreeNode node) {
        return isBST(node, null, null);
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3};

        TreeNode node = AssortedMethods.createTreeFromArray(arr);

        System.out.println(isBST(node));

    }

}
