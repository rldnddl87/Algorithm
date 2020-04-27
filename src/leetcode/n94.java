package leetcode;
/*
* 94. Binary Tree Inorder Traversal
* Given a binary tree, return the inorder traversal of its nodes' values.
* */

/*
*Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
* */

import leetcode.Util.TreeNode;
import java.util.*;

//recursive solution
public class n94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        //inorder left->root->right

        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if(root != null) {
            if(root.left != null) {
                helper(root.left, list);
            }

            list.add(root.val);

            if(root.right != null) {
                helper(root.right, list);
            }
        }
    }


}
