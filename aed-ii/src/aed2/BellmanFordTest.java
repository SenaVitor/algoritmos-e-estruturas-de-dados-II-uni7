package aed2;

import java.util.Arrays;
import java.util.List;

import aed2.EdgeWeightedDigraph;
import aed2.algs.BellmanFord;
import aed2.algs.ShortestPath;

public class BellmanFordTest {
	public static void main(String[] args) {
//		EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(6);
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
		
		//grafo da atividade
		digraph.addEdge(0, 1, 2);
		digraph.addEdge(0, 4, 3);
		digraph.addEdge(0, 5, 2);
		digraph.addEdge(1, 2, 1);
		digraph.addEdge(2, 3, 1);
		digraph.addEdge(3, 4, 1);
		digraph.addEdge(3, 6, 1);
		digraph.addEdge(4, 2, 1);
		digraph.addEdge(4, 5, 1);
		digraph.addEdge(4, 6, 2);
		digraph.addEdge(5, 6, 3);

		System.out.println(digraph);

		int source = 1;
		ShortestPath sp = new BellmanFord(digraph, 1);

		List<Integer> vertices = digraph.getVertices();
		for (Integer vertex : vertices) {
			System.out.println("A distancia de " + source + " para " + vertex + " é:" + sp.distTo(vertex) + " com path:"
					+ sp.pathTo(vertex));
		}
		
		System.out.println(Arrays.toString(sp.getDistTo()));
	}
}