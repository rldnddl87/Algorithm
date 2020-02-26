package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.TreeNode;

/**
 * 오름차순으로 정렬된 배열이 있다.
 * 배열안에 들어 있는 요소는 정수이며, 중복된 값이 없다고 가정했을때, 높이가 최소가 되는 이진 탐색 트리를 만드는
 * 알고리즘을 작성하라.
 * */

//이진트리 : 모든 노드가 가질 수 있는 자식 노드의 최대 개수가 2
//이진 탐색 트리 : 왼쪽 자식 <= 부모 노드 < 오른쪽 자식
//높이가 최소가 되려면 모든 노드의 왼쪽과 오른쪽 자식의 갯수가 같을것, Root를 기준으로 왼쪽 자식 노드의 총 갯수와 오른쪾 자식 노드의총갯수가 같다.

public class Q04_02_A {


    public static TreeNode createMinimalTree(int[] arr) {
        return createMinimalTree(arr, 0, arr.length - 1);
    }

    //정렬은 이미 되어 있기 때문에, 순차적으로 트리에 넣어주면 된다.
    public static TreeNode createMinimalTree(int[] arr, int startIdx, int endIdx) {
        if( endIdx < startIdx) {
            return null;
        }

        int mid = (startIdx + endIdx) / 2;
        TreeNode n = new TreeNode(arr[mid]); // Root 트리에 정렬된 값의 중간값을 넣어준다.
        n.left = createMinimalTree(arr, startIdx, mid - 1);
        n.right = createMinimalTree(arr, mid + 1, endIdx);
        return n;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};

        TreeNode node = createMinimalTree(arr);

        System.out.println("1");

    }
}
