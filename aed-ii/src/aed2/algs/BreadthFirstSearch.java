package aed2.algs;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import aed2.Graph;

public class BreadthFirstSearch extends Searcher{
	public BreadthFirstSearch(Graph graph, int source) {
		super(graph, source);
		
		bfs(source);
	}

	private void bfs(int s) {
		Queue<Integer> queue = new PriorityQueue<>();
		
		queue.add(s);
		marked[s] = true;
		
		while (!queue.isEmpty()) {
			Integer v = queue.poll();
			
			Iterable<Integer> adj = graph.getAdjacents(v);
			for (Integer w : adj) {
				if (!marked[w]) {
					queue.add(w);
					marked[w] = true;
					edgeTo[w] = v;
					
					if (distTo[v] == -1) {
						distTo[w] = 1;	
					} else {
						distTo[w] = distTo[v] + 1;
					}
					
					System.out.println(Arrays.toString(edgeTo));
				}
			}
		}
		
	}
}