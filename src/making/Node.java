package making;

/**
 * 단방향 연결 리스트( Util)
 * */
public class Node {
    Node next = null;
    int data;

    public Node(int data) {
        this.data = data;
    }

    void appendToTail(int data) {
        Node end = new Node(data);
        Node n = this;
        while( n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void delete(int data) {
        Node n = this;

        while (n.next != null) {
            if(n.next.data == data) { //n.data를 비교하는것이 아닌 다음 노드(n.next.data)를 비교하는것은
                                        // 다른 곳에서도 head노드를 참고할 수 있기 때문
                n.next = n.next.next;
            } else {
                n = n.next;
            }

        }
    }

    //현재 모든 노드들에 있는 값을 나열하는 메서드
    void retrieve() {
        Node n = this;
        while(n.next != null){
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println(n.data); //마지막으로 할당받은 노드는 next값이 없으므로 한번더 출력해줘야 한다.
    }

    //test

    public static void main(String[] args) {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.retrieve(); //1->2->3->4

        head.delete(2);
        head.retrieve(); //1->3->4
    }
}
