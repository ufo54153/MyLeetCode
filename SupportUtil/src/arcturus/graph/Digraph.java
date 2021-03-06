package arcturus.graph;

import java.util.ArrayList;
import java.util.List;

public class Digraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int vertices;
    private int edges;
    private final List<Integer>[] adj;
    private final int[] indegree;

    public Digraph(int V) {
        this.vertices = V;
        this.edges = 0;
        this.adj = (List<Integer>[]) new ArrayList[V];
        this.indegree = new int[V];
        for (int v = 0; v < vertices; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        edges++;
        indegree[w]++;
    }

    public List<Integer> adjacencies(int v) {
        validateVertex(v);
        return adj[v];
    }

    public int verticesCount() {
        return vertices;
    }

    public int edgesCount() {
        return edges;
    }

    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= vertices)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (vertices - 1));
    }

    public Digraph reverse() {
        Digraph reverse = new Digraph(vertices);
        for (int v = 0; v < vertices; v++) {
            for (int w : adjacencies(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices).append(" vertices, ").append(edges).append(" edges ").append(NEWLINE);
        for (int v = 0; v < vertices; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
