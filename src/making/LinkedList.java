package making;

public class LinkedList {
    Node header;

    static class Node { //LinkedList 객체가 생성될때마다 헤더역할을 하는 노드
        int data;
        Node next = null;
    }

    LinkedList() {
        header = new Node();
    }

    void appendToTail(int data) {
        Node end = new Node();
        end.data = data;
        Node n = header;
        while( n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void delete(int data) {
        Node n = header;

        while (n.next != null) {
            if(n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }

        }
    }

    //현재 모든 노드들에 있는 값을 나열하는 메서드
    void retrieve() {
        Node n = header.next;
        while(n.next != null){
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println(n.data); //마지막으로 할당받은 노드는 next값이 없으므로 한번더 출력해줘야 한다.
    }

    //test
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(4);
        list.retrieve();

        list.delete(2);

        list.retrieve();

        LinkedList ll = new LinkedList();
        ll.appendToTail(11);
        ll.appendToTail(12);
        ll.appendToTail(13);
        ll.retrieve();
        System.out.println("====");
        list.retrieve();



    }
}
