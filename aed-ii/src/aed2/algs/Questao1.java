package aed2.algs;

import java.util.Arrays;
import java.util.List;

import aed2.EdgeWeightedDigraph;

public class Questao1 {

	public static void main(String[] args) {
		EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(6);

		//grafo do trabalho VP2
		digraph.addEdge(0, 1, 3);
        digraph.addEdge(0, 2, 8);
        digraph.addEdge(0, 3, 4);
        digraph.addEdge(0, 5, 10);
        digraph.addEdge(1, 0, 3);
        digraph.addEdge(1, 3, 6);
        digraph.addEdge(2, 0, 8);
        digraph.addEdge(2, 4, 7);
        digraph.addEdge(3, 0, 4);
        digraph.addEdge(3, 1, 6);
        digraph.addEdge(3, 4, 1);
        digraph.addEdge(3, 5, 3);
        digraph.addEdge(4, 2, 7);
        digraph.addEdge(4, 3, 1);
        digraph.addEdge(4, 5, 1);
        digraph.addEdge(5, 0, 10);
        digraph.addEdge(5, 3, 3);
        digraph.addEdge(5, 4, 1);
		
		System.out.println(digraph);

		//1-a
		System.out.println("Q1 Item A");
		getDijkstra(digraph, 0);
		//1-b
		System.out.println("\nQ1 Item B");
		getDijkstra(digraph, 4);
		
	}
	
	public static void getDijkstra(EdgeWeightedDigraph digraph, int source) {
		ShortestPath sp = new Dijkstra(digraph, source);

		List<Integer> vertices = digraph.getVertices();
		for (Integer vertex : vertices) {
			System.out.println("A distancia de " + source + " para " + vertex + " é:" + sp.distTo(vertex) + " com path:"
					+ sp.pathTo(vertex));
		}
		
		System.out.println(Arrays.toString(sp.getDistTo()));
	}
}
