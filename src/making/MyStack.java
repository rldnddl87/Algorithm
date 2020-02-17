package making;

import java.util.EmptyStackException;

public class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode next;
        public StackNode(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if( top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek() {
        if( top == null) throw new EmptyStackException();
        return top.data;
    }

    public void push(T data) {
        StackNode st = new StackNode(data);
        st.next = top;
        top = st;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
