package aed2.algs;

import java.util.Stack;

import aed2.Graph;

public class DepthFirstSearchV2 extends Searcher{
	public DepthFirstSearchV2(Graph graph, int source) {
		super(graph, source);
		
		dfs(source);
	}

	private void dfs(int v) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(v);
		while(!stack.empty()) {
			int w = stack.pop();
			if(!marked[w]) {
				Stack<Integer> stackW = new Stack<Integer>();
				Iterable<Integer> adj = graph.getAdjacents(w);
				for (Integer s : adj) {
					stackW.add(s);
				}

				while (!stackW.isEmpty()){
					Integer x = stackW.pop();
					if (!marked[x]) {
						stack.push(x);
						edgeTo[x] = w;
					}
				}
				marked[w] = true;
			}
		}			
			
	}
}