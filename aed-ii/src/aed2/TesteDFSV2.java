	package aed2;

import aed2.algs.DepthFirstSearchV2;
import aed2.algs.Searcher;

public class TesteDFSV2 {
	public static void main(String[] args) {
		Graph graph = new UndirectedGraphAsMatrix(6);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);

		graph.addEdge(1, 2);

		graph.addEdge(2, 3);
		graph.addEdge(2, 4);

		graph.addEdge(3, 4);
		graph.addEdge(3, 5);

		int source = 0;
		Searcher searcher = new DepthFirstSearchV2(graph, source);
		int numberOfVertices = graph.getNumberOfVertices();
		int w = 0;
		System.out.println("DepthFirstSearch V2");
		while (w < numberOfVertices) {
			if (searcher.hasPathTo(w)) {
				System.out.print("Path from " + source + " to " + w + ": ");
				Iterable<Integer> path = searcher.pathTo(w);
				for (Integer v : path) {
					System.out.print(v + ", ");
				}

				System.out.println();
			}

			w++;
		}

	}
}