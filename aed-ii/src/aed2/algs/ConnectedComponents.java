package aed2.algs;

import java.util.PriorityQueue;
import java.util.Queue;

import aed2.Graph;

public class ConnectedComponents {
	private boolean[] marked;
	private int[] id;
	protected int[] edgeTo;
	private int count;
	
	public ConnectedComponents(Graph graph) {
		marked = new boolean[graph.getNumberOfVertices()];
		id = new int[graph.getNumberOfVertices()];
		edgeTo = new int[graph.getNumberOfVertices()];
		for (int v = 0; v < id.length; v++) {
			if (!marked[v]) {
				//dfs(graph, v);
				bfs(graph, v);
				count++;
			}
			System.out.println("count = " + count);
			System.out.print("Marked = ");
			for(boolean i : marked) {
				System.out.print(i + ", ");						
			}
			System.out.println("");
			System.out.print("Id = ");
			for(Integer j : id) {
				System.out.print(j + ", ");						
			}
			System.out.println("");
		}
	}

	private void dfs(Graph graph, int v) {
		marked[v] = true;
		
		id[v] = count;
		for (Integer w : graph.getAdjacents(v)) {
			if (!marked[w]) {
				dfs(graph, w);
			}
		}
	}
	
	private void bfs(Graph graph, int s) {
		Queue<Integer> queue = new PriorityQueue<>();
		
		queue.add(s);
		marked[s] = true;
		id[s] = count;

		while (!queue.isEmpty()) {
			Integer v = queue.poll();
			
			Iterable<Integer> adj = graph.getAdjacents(v);
			for (Integer w : adj) {
				if (!marked[w]) {
					queue.add(w);
					marked[w] = true;
					edgeTo[w] = v;
					id[w] = count;
				}
			}
		}
	}
	
	public int count() {
		return count;
	}
	
	public int id(int v) {
		return id[v];
	}
	
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}
}