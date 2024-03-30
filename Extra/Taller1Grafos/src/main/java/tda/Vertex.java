package tda;

import java.util.LinkedList;
import java.util.List;

class Vertex<V, E> {

    private V content;
    private List<Edge<E, V>> edges;
    private boolean visited;
    private int distance;
    private Vertex<V, E> before;

    public Vertex(V content) {
        this.content = content;
        this.edges = new LinkedList<>();
        this.visited = false;
        this.distance = Integer.MAX_VALUE;
        this.before = null;
    }

    public V getContent() {
        return content;
    }

    public void setContent(V content) {
        this.content = content;
    }

    public List<Edge<E, V>> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge<E, V>> edges) {
        this.edges = edges;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex<V, E> getBefore() {
        return before;
    }

    public void setBefore(Vertex<V, E> before) {
        this.before = before;
    }
    
    @Override
    public String toString() {
        return content.toString();
    }

}
