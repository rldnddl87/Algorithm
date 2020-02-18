package crackingTheCodingInterview;

import making.MyStack;

import java.util.Stack;

/**
 * 기본적인 push와 pop기능이 구현된 스택에서 최솟값을 반환하는 min 함수를 추가하려고 한다. 어떻게 설계할 수 있겠는가?
 * push,pop,min 연산은 모두 O(1)시간에 동작해야 한다.
 * */
public class Q03_02_A extends Stack<Integer> { //새로운 클래스를 정의하고 기존의 Stack을 상속받는다.
    private Stack<Integer> minStack;

    public Q03_02_A() {
        minStack = new Stack<>();
    }
    public void push(int value){
        int min = min();
        if( value < min) {
            minStack.push(value);
        }
        super.push(value);

    }

    public Integer pop(){
        int value = super.pop();
        if( value == min()) {
            minStack.pop();
        }

        return value;
    }

    public int min() {
        if( minStack == null)
            return Integer.MAX_VALUE;
        return minStack.peek();
    }

}
