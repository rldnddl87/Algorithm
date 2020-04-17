package leetcode;

import leetcode.Util.TreeNode;

/*
* 108. Convert Sorted Array to Binary Search Tree
* Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
* */

/*
* Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
* */


public class n108 {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) { //정열 되어 있는 배열이 주어진다.
            if(nums == null) return null;

            TreeNode treeNode = helper(nums, 0, nums.length - 1); //인덱스의 처음과 마지막 값

            return treeNode;
        }

        public TreeNode helper(int[] nums, int low, int high) {
            if( high < low) return null; //low가 high보다 높다는것은 이미 노드의 생성이 완료 된것이므로.

            int mid = (low + high) / 2;

            TreeNode treeNode = new TreeNode(nums[mid]); //정렬된 노드의 가운데 값으로 노드를 생성해 나아간다.
            treeNode.left = helper(nums, low, mid - 1); //정렬된 노드의 왼쪽과 오른쪽노드를 추가해 나아간다.
            treeNode.right = helper(nums, mid + 1, high);

            return treeNode; //생성된 노드 반환
        }


    }
}
