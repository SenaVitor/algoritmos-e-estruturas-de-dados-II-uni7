package aed2.algs;

import java.util.Arrays;
import java.util.List;

import aed2.EdgeWeightedDigraph;

public class DijkstraTest {
	public static void main(String[] args) {
		EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(7);

//		digraph.addEdge(0, 1, 1);
//		digraph.addEdge(0, 2, 3);
//		digraph.addEdge(1, 2, 1);
//		digraph.addEdge(1, 3, 3);
//		digraph.addEdge(1, 4, 2);
//		digraph.addEdge(2, 3, 2);
//		digraph.addEdge(3, 5, 2);
//		digraph.addEdge(4, 3, -3);
//		digraph.addEdge(5, 4, 3);
		
//		//grafo da atividade
//		digraph.addEdge(0, 1, 2);
//		digraph.addEdge(0, 4, 3);
//		digraph.addEdge(0, 5, 2);
//		digraph.addEdge(1, 2, 1);
//		digraph.addEdge(2, 3, 1);
//		digraph.addEdge(3, 4, 1);
//		digraph.addEdge(3, 6, 1);
//		digraph.addEdge(4, 2, 1);
//		digraph.addEdge(4, 5, 1);
//		digraph.addEdge(4, 6, 2);
//		digraph.addEdge(5, 6, 3);

		//grafo do trabalho VP2
		digraph.addEdge(0, 1, 3);
        digraph.addEdge(0, 2, 8);
        digraph.addEdge(0, 3, 4);
        digraph.addEdge(0, 5, 10);
        digraph.addEdge(1, 0, 3);
        digraph.addEdge(1, 3, 6);
        digraph.addEdge(2, 4, 7);
        digraph.addEdge(3, 1, 6);
        digraph.addEdge(3, 4, 1);
        digraph.addEdge(3, 5, 3);
        digraph.addEdge(4, 5, 1);
		
		System.out.println(digraph);

		//1-b
		int source = 4;
		ShortestPath sp = new Dijkstra(digraph, source);

		List<Integer> vertices = digraph.getVertices();
		for (Integer vertex : vertices) {
			System.out.println("A distancia de " + source + " para " + vertex + " é:" + sp.distTo(vertex) + " com path:"
					+ sp.pathTo(vertex));
		}
		
		System.out.println(Arrays.toString(sp.getDistTo()));
	}
}