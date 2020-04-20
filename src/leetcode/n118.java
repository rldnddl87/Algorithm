package leetcode;
/*
118. Pascal's Triangle
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
* */

/*
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
* */

import java.util.*;

public class n118 {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> inner = new ArrayList<>();
        List<List<Integer>> outer = new ArrayList<>();
        if (numRows != 0) {
            outer.add(inner);
        }

        return recursive(outer, numRows);
    }

    public List<List<Integer>> recursive(List<List<Integer>> list, int numRows) {
        if (numRows == 0) return list;

        numRows--;

        List<Integer> inner = null;
        inner = list.get(list.size() - 1); //기존의 마지막 리스트 가져오기


        if (inner.size() == 0) {
            inner.add(1);
        } else {

            int maxSize = inner.size() + 1;

            List<Integer> tmpList = new ArrayList<>(); //추가할 리스트 생성하기
            tmpList.add(1); //최초 1

            //리스트 생성한뒤 더하기
            for (int i = 1; i < inner.size(); i++) {
                int val = inner.get(i - 1) + inner.get(i);

                tmpList.add(val);
            }

            tmpList.add(1); //마지막 1

            list.add(tmpList); //합처주기
        }


        return recursive(list, numRows);
    }
}
