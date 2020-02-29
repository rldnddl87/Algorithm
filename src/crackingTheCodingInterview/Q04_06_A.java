package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.TreeNode;

/**
 * 후속자 : 이진 탐색 트리에서 주어진 노드의 '다음' 노드(중위 후속자)를 찾는 알고리즘을 작성하라.
 * 각 노드에는 부모 노드를 가리키는 링크가 존재한다고 가정하자.
 *
 *
 * 중위 순회 left -> root -> right 으로 순회한다
 *
 * */
public class Q04_06_A {
    public static TreeNode inorderSucc(TreeNode n) {
        if ( n == null) return null;

        if( n.right != null) {
            return leftMostChild(n.right);
        } else { //만일 오른쪽 노드가 없다면(방문할 곳이 없으니까) 부모 노드중 아직 탐색되지 않는 노드를 찾는다.
            TreeNode q = n;
            TreeNode x = q.parent; //부모노드 참조주소 할당
            while( x != null && x.left != q) {
                q = x;
                x = x.parent; // 부모노드를 계속해서 참고하고
            }
            return x;
        }
    }

    public static TreeNode leftMostChild(TreeNode n) {
        if ( n == null) return null;

        while( n.left != null) {
            n = n.left;
        }

        return n;
    }

    public static void main(String[] args) {

    }
}
