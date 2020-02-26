package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.AssortedMethods;
import crackingTheCodingInterview.CtCILibrary.TreeNode;
import sun.awt.image.ImageWatched;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class Q04_03_B {
    public static ArrayList<LinkedList<TreeNode>> process(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();


        LinkedList<TreeNode> current = new LinkedList<>(); //current를 통해 bfs의 작업을 저장하고 진행한다.

        if( root != null) {
            current.add(root);
        }

        while( current.size() > 0) {

            result.add(current);

            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();

            for(TreeNode parent : parents) {
                if(parent.left != null) {
                    current.add(parent.left);
                }

                if(parent.right != null) {
                    current.add(parent.right);
                }

            }
        }
        return result;
    }

    public static void print(ArrayList<LinkedList<TreeNode>> lists) {
        int depth = 0;
        for( LinkedList<TreeNode> linkedList : lists) {
            Iterator<TreeNode> i = linkedList.iterator();
            System.out.println("depth " + depth);
            while(i.hasNext()) {
                System.out.print(i.next().data + " ");
            }
            System.out.println();
            depth++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};

        TreeNode treeNode = AssortedMethods.createTreeFromArray(arr);

        ArrayList<LinkedList<TreeNode>> lists = process(treeNode);

        print(lists);
    }
}
