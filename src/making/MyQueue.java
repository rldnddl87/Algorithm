package making;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    public static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    //add
    public void add(T item) {
        QueueNode<T> node = new QueueNode<>(item);
        if( last != null) {
            last.next = node;
        }

        last = node;

        if( first == null) {
            first = last;
        }
    }

    //remove
    public T remove() {
        if( first == null) throw new NoSuchElementException();

        T data = first.data;
        first = first.next;

        if( first == null) {
            last = null;
        }
        return data;
    }

    //peek
    public T peek() {
        if( first == null) throw new NoSuchElementException();
        return first.data;
    }

    //isempty
    public boolean isEmpty() {
        return first == null;
    }

}
