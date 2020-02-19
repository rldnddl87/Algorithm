package crackingTheCodingInterview;

import making.MyQueue;

import java.util.Stack;

/**
 * Stack 2개로 Queue하나를 구현한 MyQueue클래스를 구현하라
 * */
public class Q03_04_A {
    //이러한 방식은 단순히 한개의 원소만 옮기더라도 모든 원소를 전부 이동시켜야하기 때문에 비효율적이다.
    static class MyQueue{
        private Stack stack;
        private Stack reveredStack;

        MyQueue(){
            stack = new Stack();
            reveredStack = new Stack();
        }
        //add 아이템을 리스트의 끝 부분에 추가
        public void add(int data) {
            stack.push(data);
        }

        //remove 리스트의 첫번째 아이템 삭제 & 반환
        public int remove() {
            setReversed();
            int v = (int)reveredStack.pop();

            reversToNomal();

            return v;
        }


        //peek 큐에서 가장 위에 있는 항목을 반환
        public int peek() {
            while(!stack.isEmpty()) {
                int v = (int)stack.pop();
                reveredStack.push(v);
            }
            int n = (int)reveredStack.peek();

            reversToNomal();

            return n;
        }

        public void setReversed(){
            while(!stack.isEmpty()) {
                reveredStack.push(stack.pop());
            }
        }

        public void reversToNomal() {
            while(!reveredStack.isEmpty()) {
                int v = (int)reveredStack.pop();
                stack.push(v);
            }
        }

        //isEmpty
        public boolean isEmpty() {
            return stack.isEmpty();
        }

    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        for(int i = 0; i < 5; i++) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}
