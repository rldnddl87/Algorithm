package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.Graph;
import crackingTheCodingInterview.CtCILibrary.Node;

import java.util.LinkedList;

/**
 * 노드 사이의 경로
 * 방향 그래프가 주어졌을때 두 노드 사이에 경로가 존재하는지 확인하는 알고리즘을 작성하라.
 * */
public class Q04_01_A {
    //경로이기 때문에 DFS 보단 BFS가 효율적이고, 방향 그래프 이기 때문에 시작점과 종료점에서 양방향 탐색을 할 수 없다.
    //중복되는 코드가 존재하며 잘 푼 문제가 아니라고 생각된다.
    //나는 시작점이 그래프에 없을수도 있다고 가정해서 우선 start노드를 그래프에서 찾고 시작했지만.
    //해법을 보니 두 노드는 무조건 그래프에 존재한다고 가정되어 있다. 그렇다면 단순히 start노드의 adjacent부터 탐색하면되서 메서드를
    //두개로 나눈 필요도 없이 하나의 메서드로 작성 가능하다.
    public static boolean isConnected(Graph g, Node start, Node end) {
        start = findStart(g, start);

        if(start == null) return false;

        LinkedList<Node> nodes = new LinkedList<>();
        for(Node n  : start.getAdjacent()) {
            nodes.add(n);
        }


        for(int i = 0; i < nodes.size(); i++) {
            Node n = nodes.get(i);
            if(n == end) return true;
            n.state = Node.State.visited;

            for(Node tmp : n.getAdjacent()) {
                if(tmp.state == Node.State.Unvisited || tmp.state == null) {
                    tmp.state = Node.State.visited;
                    nodes.add(tmp);
                }
            }
        }

        return false;
    }

    public static Node findStart(Graph g, Node start) {
        LinkedList<Node> nodes = new LinkedList<>();

        for( Node n : g.getNodes()) {
            nodes.add(n);
        }

        for(int i = 0; i < nodes.size(); i++) {
            Node n =  nodes.get(i);
            if( n == start) return n;
            n.state = Node.State.visited;

            for( Node tmp : n.getAdjacent()) {
                if(tmp.state == Node.State.Unvisited || tmp.state == null) {
                    tmp.state = Node.State.visited;
                    nodes.add(tmp);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Graph g = createNewGraph();
        Node[] node = g.getNodes();
        Node start = findStart(g, node[3]);
        Node end = node[5];
        //System.out.println(n.getVertex());
        //생성된 그래프는 d -> e -> f
        System.out.println(node[3].getVertex());
        System.out.println(node[5].getVertex());
        System.out.println(isConnected(g, start, end));
    }

    public static Graph createNewGraph()
    {
        Graph g = new Graph();
        Node[] temp = new Node[6];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }
}
