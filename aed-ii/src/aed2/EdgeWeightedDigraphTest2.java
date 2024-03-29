package aed2;

import java.util.List;

import aed2.EdgeWeightedDigraph;
import aed2.algs.BellmanFord;
import aed2.algs.Dijkstra;
import aed2.algs.ShortestPath;

public class EdgeWeightedDigraphTest2 {
	public static void main(String[] args) {
		EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(8);

		digraph.addEdge(0, 1, 5);
		digraph.addEdge(0, 7, 8);
		digraph.addEdge(0, 4, 9);
		digraph.addEdge(1, 3, 15);
		digraph.addEdge(1, 2, 12);
		digraph.addEdge(1, 7, 4);
		digraph.addEdge(2, 3, 3);
		digraph.addEdge(2, 6, 11);
		digraph.addEdge(3, 6, 9);
		digraph.addEdge(4, 7, 5);
		digraph.addEdge(4, 5, 4);
		digraph.addEdge(4, 6, 20);
		digraph.addEdge(5, 2, 1);
		digraph.addEdge(5, 6, 13);
		digraph.addEdge(7, 2, 7);
		digraph.addEdge(7, 5, 6);

		System.out.println(digraph);

		int source = 0;
		ShortestPath sp = new Dijkstra(digraph, 0);
		showDistances(digraph, source, sp);
		
		System.out.println();
		
		source = 0;
		sp = new BellmanFord(digraph, 0);
		showDistances(digraph, source, sp);
	}

	private static void showDistances(EdgeWeightedDigraph digraph, int source, ShortestPath sp) {
		List<Integer> vertices = digraph.getVertices();
		for (Integer vertex : vertices) {
			System.out.println("A distancia de " + source + " para " + vertex + " é:" + sp.distTo(vertex) + " com path:"
					+ sp.pathTo(vertex));
		}
	}
}