package crackingTheCodingInterview.CtCILibrary;

public class Node {
    private Node[] adjacent; //인접한 노드
    public int adjacentCount; //인접한 노드의 개수 adjacent.length
    private String vertex;
    public State state;

    public enum State{
        Unvisited, visited, visiting
    }

    public Node(String vertex, int adjacentLength) {
        this.vertex = vertex;
        adjacentCount = 0;
        adjacent = new Node[adjacentLength];
    }

    public void addAdjacent(Node x) {
        if(adjacentCount < adjacent.length) {
            //add
            adjacent[adjacentCount] = x;
            this.adjacentCount++;
        } else {
            System.out.println("No more Node can be added");
        }

    }

    public Node[] getAdjacent() {
        return adjacent;
    }
    public String getVertex() {
        return vertex;
    }
}
