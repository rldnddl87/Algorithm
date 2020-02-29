package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.TreeNode;

public class Q04_08_C {
    //두개의 노드가 Root로부터 양쪽에 있을경우(더이상 한쪽에 있지 않으면) 해당 Root가 최소 공통 조상이다.

    public static TreeNode firstCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(!covers(root, p) || !covers(root, q)) return null;

        if(root == p || root == q) return root;


        boolean pIsLeft = covers(root.left, p);
        boolean qIsRight = covers(root.right, q);

        if( pIsLeft != qIsRight) { //두개의 결과가 같다면 해당 root가 공통 조상
            return root;
        }

        //둘다 같은 방향에 있는 것이므로..
        TreeNode childNode = pIsLeft ? root.left : root.right;
        return firstCommonAncestor(childNode, p, q);
    }



    public static boolean covers(TreeNode root, TreeNode n) {
        if( root == null) return false;
        if( root == n) return true;

        return covers(root.left, n) || covers(root.right, n);
    }
}
