package leetcode;

import leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//iterative solution
public class n94_b {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            list.add(node.val);
            node = node.right; //어렵당..

        }

        return list;
    }
}
