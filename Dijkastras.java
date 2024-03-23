import java.util.*;

public class Dijkastras {
    private int V; // Number of vertices
    private List<List<Node>> adjList;

    // Node class to represent vertices and their weights
    class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public Dijkastras(int V) {
        this.V = V;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        adjList.get(source).add(new Node(destination, weight));
    }

    public List<Integer> shortestPath(int source, int destination) {
        int[] dist = new int[V];
        int[] prev = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);

        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        dist[source] = 0;
        minHeap.add(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            int u = node.vertex;

            if (u == destination) break;

            for (Node neighbor : adjList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                int alt = dist[u] + weight;
                if (alt < dist[v]) {
                    dist[v] = alt;
                    prev[v] = u;
                    minHeap.add(new Node(v, alt));
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        for (int at = destination; at != -1; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        int V = 5;
        Dijkastras graph = new Dijkastras(V);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);

        int source = 0;
        int destination = 4;
        List<Integer> shortestPath = graph.shortestPath(source, destination);

        System.out.println("Shortest Path from " + source + " to " + destination + ": " + shortestPath);
    }
}
