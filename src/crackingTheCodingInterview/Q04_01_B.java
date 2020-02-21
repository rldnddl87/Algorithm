package crackingTheCodingInterview;

import crackingTheCodingInterview.CtCILibrary.Graph;
import crackingTheCodingInterview.CtCILibrary.Node;

import java.util.LinkedList;

public class Q04_01_B {
    public static boolean search(Graph g, Node start, Node end) {
        if( start == end) return true;

        LinkedList<Node> q = new LinkedList<>();

        //null로 초기화 되어 있는 Node의 값들을 unvisited로 설정해준다.
        for(Node u : g.getNodes()) {
            u.state = Node.State.Unvisited;
        }

        start.state = Node.State.visiting;
        q.add(start);
        Node u; //초기화 X
        while( !q.isEmpty()) {
            u = q.removeFirst();
            if( u != null) {
                for( Node v : u.getAdjacent()) {
                    if( v.state == Node.State.Unvisited) {
                        if( v == end) {
                            return true;
                        } else {
                            v.state = Node.State.visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = Node.State.visited;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
