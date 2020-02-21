package crackingTheCodingInterview.CtCILibrary;
//트리와 달리 root부터 시작하여 모든 인접한 Node를 탐색할 수 없을 수도 있기 때문에
//Graph클래스에 Node를 멤버변수로 선언
public class Graph {
    public static int MAX_VERTICES = 6; //최대 자식노드 개수
    private Node[] vertices;
    public int count;

    public Graph() {
        vertices = new Node[MAX_VERTICES];
        count = 0;
    }

    public void addNode(Node x) {
        if( count < vertices.length) {
            vertices[count] = x;
            count++;
        } else {
            System.out.println("Graph is full!!");
        }
    }

    public Node[] getNodes() {
        return vertices;
    }
}
