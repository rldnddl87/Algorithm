package crackingTheCodingInterview;

import java.util.NoSuchElementException;
import java.util.Stack;

//Queue는 단순히 가장 처음 입력된 요소부터 차례대로 출력되면 되므로
//newStack에는 새롭게 추가된 요소가 저장된다.
//OldStack에서는 peek나 pop을 호출할시 && Old요소가 비어있을경우에만  new -> old한뒤 old스택에서 요소를 추출한다.

public class Q03_04_B {

    //public class MyQueue
    //내부 클래스로 풀기 위해 static추가
    static class MyQueue<T> {
        Stack<T> newStack;
        Stack<T> oldStack;

        public MyQueue() {
            newStack = new Stack();
            oldStack = new Stack();
        }

        //isEmpty
        public boolean isEmpty() {
            if(oldStack.isEmpty() && newStack.isEmpty()) {
                return true;
            }
            return false;
        }

        //add
        public void add(T data) {
            newStack.push(data);
        }

        //peek
        public T peek() {
            if(isEmpty()) throw new NoSuchElementException();
            shiftStacks();
            return oldStack.peek();
        }


        //remove
        public T remove() {
            if(isEmpty()) throw new NoSuchElementException();
            shiftStacks();
            return oldStack.pop();
        }

        public void shiftStacks(){
            if(isOldEmpty()) {
                newToOldStack();
            }
        }

        public boolean isOldEmpty() {
            return oldStack.isEmpty();
        }

        public void newToOldStack() {
            while(!newStack.isEmpty()) {
                oldStack.push(newStack.pop());
            }
        }

    }

}
