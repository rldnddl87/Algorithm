package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.TreeNode;

/**
 *  첫 번째 공통 조상
 *  이진 트리에서 노드 두 개가 주어졌을 때 이 두 노드의 첫 번째 공통 조상을 찾는 알고리즘을 설계하고
 *  그 코드를 작성하라. 자료구조 내에 추가로 노드를 저장해 두면 안 된다. 반드시 이진 탐색 트리일 필요는 없다.
 * */

//첫 번째 공통 조상은 Root 노드에서 가장 깊이 있는 공통 노드이다.

public class Q04_08_A {

    public static TreeNode firstCommonAncestor(TreeNode n1, TreeNode n2) {
        int delta = getDepth(n1) - getDepth(n2);
        TreeNode lowerNode = delta < 0 ? n2 : n1;
        TreeNode upperNode = delta < 0 ? n1 : n2;
        upperNode = moveUp(upperNode, Math.abs(delta));

        while( lowerNode != null && upperNode != null && lowerNode != upperNode) {
            lowerNode = lowerNode.parent;
            upperNode = upperNode.parent;
        }

        return upperNode == null || lowerNode == null ? null : upperNode;
    }

    public static int getDepth(TreeNode n) {
        int depth = 0;

        while(n != null) {
            n = n.parent;
            depth++;
        }
        return depth;
    }

    public static TreeNode moveUp(TreeNode n, int depth) {
        while( n != null && depth > 0) {
            n = n.parent;
            depth--;
        }
        return n;
    }


}
