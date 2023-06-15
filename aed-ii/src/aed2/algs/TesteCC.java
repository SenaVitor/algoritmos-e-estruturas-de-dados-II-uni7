package aed2.algs;

import aed2.Graph;
import aed2.UndirectedGraphAsMatrix;

public class TesteCC {
	public static void main(String[] args) {
		Graph graph = new UndirectedGraphAsMatrix(13);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		graph.addEdge(0, 6);

		graph.addEdge(3, 4);
		graph.addEdge(3, 5);

		graph.addEdge(4, 5);
		graph.addEdge(4, 6);

		graph.addEdge(7, 8);

		graph.addEdge(9, 10);
		graph.addEdge(9, 11);
		graph.addEdge(9, 12);

		graph.addEdge(11, 12);
		
		ConnectedComponents cc = new ConnectedComponents(graph);
		
		for (int v = 0; v < graph.getNumberOfVertices(); v++) {
			System.out.println( v + " est� em " + cc.id(v));
		}
		
		System.out.println(0 + " e " + 3 + " est�o conectados? " + cc.connected(0, 3));
		System.out.println(0 + " e " + 8 + " est�o conectados? " + cc.connected(0, 8));
		System.out.println(0 + " e " + 10 + " est�o conectados? " + cc.connected(0, 10));
	}
}