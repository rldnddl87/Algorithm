package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.TreeNode;

public class Q04_08_B {
    public static TreeNode commonAncestor(TreeNode p, TreeNode q) {
        if(p == null || q == null) return null;
        if(covers(p,q)) return p;
        if(covers(q,p)) return q;

        TreeNode sibling = getSibling(p);
        TreeNode parent = p.parent;
        while(!covers(sibling,q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    public static boolean covers(TreeNode root, TreeNode p){
        if( root == null) return false;
        if( root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }

    public static TreeNode getSibling(TreeNode n) {
        if( n == null) return null;

        TreeNode parent = n.parent;

        return parent.left == n ? parent.right : parent.left;
    }
}
