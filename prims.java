import java.util.*;

class Graph {
    private int V;
    private List<List<Edge>> adjList;

    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Edge(v, weight));
        adjList.get(v).add(new Edge(u, weight)); // Undirected graph
    }

    public List<Edge> primMST() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        int src = 0; // Start Prim's algorithm from vertex 0

        boolean[] inMST = new boolean[V];
        Arrays.fill(inMST, false);

        List<Edge> MST = new ArrayList<>();
        pq.add(new Edge(src, -1, 0)); // Add dummy edge with weight 0

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.dest;

            if (inMST[u])
                continue;

            inMST[u] = true;
            if (edge.src != -1)
                MST.add(edge);

            for (Edge neighbor : adjList.get(u)) {
                if (!inMST[neighbor.dest]) {
                    pq.add(new Edge(u, neighbor.dest, neighbor.weight));
                }
            }
        }
        return MST;
    }

    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
}

public class prims {
    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(V);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        List<Graph.Edge> MST = graph.primMST();
        System.out.println("Minimum Spanning Tree Edges:");
        for (Graph.Edge edge : MST) {
            System.out.println(edge.src + " - " + edge.dest + ": " + edge.weight);
        }
    }
}
