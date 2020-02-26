package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.AssortedMethods;
import crackingTheCodingInterview.CtCILibrary.TreeNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 깊이의 리스트 : 이진 트리가 주어졌을 때, 같은 깊이에 있는 노드를 연결리스트로 연결해주는 알고리즘을 설계하라,
 * 즉 트리의 깊이가 D라면 D개의 연결 리스트를 만들어야 한다.
 *
 * */

public class Q04_03_A {
    //깊이 우선 탑색(DFS)
    //너비 우선 탐색(BFS)


    //깊이 우선 탐색으로 해보면 (depth 표시를 위한 매개변수가 필요할거고..)
    public static void process(TreeNode root, ArrayList<LinkedList<TreeNode>> list, int level) {
        if(root == null) {
            return;
        }

        if( list.get(level).isEmpty()) {
            LinkedList<TreeNode> nodeLinkedList = new LinkedList<>();
            list.add(nodeLinkedList);
        }

        LinkedList<TreeNode> nodeLinkedList = list.get(level);
        nodeLinkedList.add(root);

        process(root.left, list, level + 1);
        process(root.right, list, level + 1);
        
    }

    public static ArrayList<LinkedList<TreeNode>> process(TreeNode root){
        ArrayList<LinkedList<TreeNode>> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        list.add(linkedList);
        process(root, list, 0);
        return list;
    }

    public static void print(ArrayList<LinkedList<TreeNode>> list) {
        int n = 0;
        for(LinkedList<TreeNode> linkedList : list) {
            System.out.print("depth" + n +" ");
            Iterator<TreeNode> i = linkedList.listIterator();
            while(i.hasNext()) {
                TreeNode node = i.next();
                System.out.print(node.data + " ");
            }

            System.out.println();
            n++;
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};

        TreeNode treeNode = AssortedMethods.createTreeFromArray(arr);

        ArrayList<LinkedList<TreeNode>> list = process(treeNode);

        print(list);
    }
}
