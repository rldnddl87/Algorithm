package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 오름차순으로 정렬된 배열이 있다.
 * 배열안에 들어 있는 요소는 정수이며, 중복된 값이 없다고 가정했을때, 높이가 최소가 되는 이진 탐색 트리를 만드는
 * 알고리즘을 작성하라.
 * */

//이진트리 : 모든 노드가 가질 수 있는 자식 노드의 최대 개수가 2
//이진 탐색 트리 : 왼쪽 자식 <= 부모 노드 < 오른쪽 자식
//높이가 최소가 되려면 모든 노드의 왼쪽과 오른쪽 자식의 갯수가 같을것, Root를 기준으로 왼쪽 자식 노드의 총 갯수와 오른쪾 자식 노드의총갯수가 같다.

public class Q04_02_A {

    public static TreeNode createMinimalTree(int[] num) {

        TreeNode node = new TreeNode(0);
        for(int i = 0; i < num.length; i++) {
            sort(node,num[i]);
        }
        return node;
    }

    //트리 노드의 깊이가 최소가 된다는 것은 결국 정렬하라는 의미
    public static void sort(TreeNode node, int n) {

        if(node.data <= n) {
            if(node.parent == null) {
                TreeNode newNode = new TreeNode(n);

                node.parent = newNode;
            }

            //해당 노드보다 값이 크지만 부모보다 작을경우 오른쪽에 추가

            //해당 노드보다 크고

        } else if(node.data > n) {
            if(node.left == null) {
                TreeNode newNode = new TreeNode(n);
                node.left = newNode;
            }else {
                sort(node.left, n);
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};

        TreeNode node = createMinimalTree(arr);

        System.out.println("1");

    }
}
