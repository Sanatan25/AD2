import java.util.LinkedList;
import java.util.Stack;

public class dfs_path {
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

	public dfs_path(int cnt) {
		count = cnt;
		Adj = new LinkedList<LinkedList<Edge>>();
		for (int i = 0; i < cnt; i++) {
			Adj.add(new LinkedList<Edge>());
		}
	}

	private void addDirectedEdge(int source, int dest, int cost) {

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
			System.out.print(" Vertex " + i + " is connected to : ");
			for (Edge adn : ad) {
				System.out.print("(" + adn.dest + "," + adn.cost + ") ");
			}
			System.out.println();
		}
	}

	public static int countAllPathDFS(dfs_path gph, boolean[] visited, int source, int dest) {
		if (source == dest) {
			return 1;
		}
		int count = 0;
		visited[source] = true;
		LinkedList<dfs_path.Edge> adl = gph.Adj.get(source);
		for (dfs_path.Edge adn : adl) {
			if (visited[adn.dest] == false) {
				count += countAllPathDFS(gph, visited, adn.dest, dest);
			}
			visited[source] = false;
		}
		return count;
	}

	public static int countAllPath(dfs_path gph, int src, int dest) {
		int count = gph.count;
		boolean[] visited = new boolean[count];
		return countAllPathDFS(gph, visited, src, dest);
	}

	public static void main(String[] args) {
		dfs_path gph = new dfs_path(4);
		gph.addUndirectedEdge(0, 1, 1);
		gph.addUndirectedEdge(0, 2, 1);
		gph.addUndirectedEdge(1, 2, 1);
		gph.addUndirectedEdge(2, 3, 1);
		gph.print();
		System.out.println(gph.countAllPath(gph, 0, 2));
	}
}