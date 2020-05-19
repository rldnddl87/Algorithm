package leetcode;

import leetcode.Util.TreeNode;
import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal
 * 
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * For example: Given binary tree [3,9,20,null,null,15,7], 3 / \ 9 20 / \ 15 7
 * 
 * return its level order traversal as: [ [3], [9,20], [15,7] ]
 */

public class n102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    // dfs
    public void dfs(TreeNode root, List<List<Integer>> list, int idx) {
        if (root == null) {
            return;
        }
        if (list.size() == idx) {
            list.add(new ArrayList<Integer>());
        }

        List<Integer> current = list.get(idx);

        current.add(root.val);

        dfs(root.left, list, idx + 1);
        dfs(root.right, list, idx + 1);
    }

    // bfs
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return list;
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                tmp.add(current.val);

                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }

            list.add(tmp);
        }

        return list;
    }

}