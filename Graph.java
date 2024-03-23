import java.util.LinkedList;

public class Graph {
	int count;
	LinkedList<LinkedList<Edge>> Adj;

	static class Edge {
		private int dest;
		private int cost;

		public Edge(int dst, int cst) {
			dest = dst;
			cost = cst;
		}
	}

	public Graph(int cnt) {
		count = cnt;
		Adj = new LinkedList<LinkedList<Edge>>();
		for (int i = 0; i < cnt; i++) {
			Adj.add(new LinkedList<Edge>());
		}
	}

	void addDirectedEdge(int source, int dest, int cost) {

		Edge edge = new Edge(dest, cost);
		Adj.get(source).add(edge);
	}

	public void addDirectedEdge(int source, int dest) {
		addDirectedEdge(source, dest, 1);
	}

	public void addUndirectedEdge(int source, int dest, int cost) {
		addDirectedEdge(source, dest, cost);
		addDirectedEdge(dest, source, cost);
	}

	public void addUndirectedEdge(int source, int dest) {
		addUndirectedEdge(source, dest, 1);
	}

	public void print() {
		for (int i = 0; i < count; i++) {
			LinkedList<Edge> ad = Adj.get(i);
			System.out.print("\n Vertex " + i + " is connected to : ");
			for (Edge adn : ad) {
				System.out.print("(" + adn.dest + ", " + adn.cost + ") ");
			}
		}
	}

	public static void main(String args[]) {
		Graph gph = new Graph(5);
		gph.addDirectedEdge(0, 1, 1);
		gph.addDirectedEdge(0, 2, 1);
		gph.addDirectedEdge(1, 3, 1);
		gph.addDirectedEdge(2, 3, 1);

		gph.print();
	}
}



