package leetcode;

/*
101. Symmetric Tree
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
* */

import leetcode.Util.TreeNode;

/*
    1
   / \
  2   2
 / \ / \
3  4 4  3
* */

import java.util.*;
public class n101 {
    public boolean isSymmetric(TreeNode root) {
        return process(root);
    }

    public boolean process(TreeNode node) {
        Map<TreeNode, Boolean> marked = new HashMap<>();

        Queue queue = new LinkedList<>();
        queue.a
    }
}
