import java.util.LinkedList;
import java.util.Stack;

public class bfs {
	int count;
	private LinkedList<LinkedList<Edge>> Adj;

	private static class Edge {
		private int dest;
		private int cost;

		public Edge(int dst, int cst) {
			dest = dst;
			cost = cst;
		}
	}

	public bfs(int cnt) {
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

	public void print() {
		for (int i = 0; i < count; i++) {
			LinkedList<Edge> ad = Adj.get(i);
			System.out.print("\n Vertex " + i + " is connected to : ");
			for (Edge adn : ad) {
				System.out.print("(" + adn.dest + ") ");
			}
		}
	}

	public static boolean BFS(bfs gph, int source, int target) {
		int count = gph.count;
		boolean[] visited = new boolean[count];
		LinkedList<Integer> que = new LinkedList<Integer>();
		que.add(source);
		visited[source] = true;
		while (que.isEmpty() == false) {
			int curr = que.remove();
			LinkedList<bfs.Edge> adl = gph.Adj.get(curr);
			for (Edge adn : adl) {
				if (visited[adn.dest] == false) {
					visited[adn.dest] = true;
					que.add(adn.dest);
				}
			}
		}
		return visited[target];
	}

	public static void main(String[] args) {
		bfs gph = new bfs(4);
		gph.addUndirectedEdge(0, 1, 1);
		gph.addUndirectedEdge(0, 2, 1);
		gph.addUndirectedEdge(1, 2, 1);
		gph.addUndirectedEdge(2, 3, 1);
		gph.print();
		System.out.println();
		System.out.println(gph.BFS(gph, 0, 3));
	}
}

