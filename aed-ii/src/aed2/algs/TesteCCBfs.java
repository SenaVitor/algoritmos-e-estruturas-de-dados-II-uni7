package aed2.algs;

import aed2.Graph;
import aed2.UndirectedGraphAsMatrix;

public class TesteCCBfs {
	public static void main(String[] args) {
		Graph graph = new UndirectedGraphAsMatrix(12);

		graph.addEdge(0, 2);
		graph.addEdge(0, 4);
		graph.addEdge(0, 5);
		
		graph.addEdge(1, 5);
		graph.addEdge(1, 4);

		graph.addEdge(2, 3);
		graph.addEdge(2, 4);

		graph.addEdge(4, 5);

		graph.addEdge(6, 8);
		graph.addEdge(6, 9);
		
		graph.addEdge(7, 10);
		graph.addEdge(7, 11);

		graph.addEdge(8, 9);

		graph.addEdge(11, 10);
		
		ConnectedComponents cc = new ConnectedComponents(graph);
		
		for (int v = 0; v < graph.getNumberOfVertices(); v++) {
			System.out.println(v + " está em " + cc.id(v));
		}
		
		System.out.println(0 + " e " + 3 + " estão conectados? " + cc.connected(0, 3));
		System.out.println(0 + " e " + 4 + " estão conectados? " + cc.connected(0, 4));
		System.out.println(0 + " e " + 6 + " estão conectados? " + cc.connected(0, 6));
		System.out.println(0 + " e " + 10 + " estão conectados? " + cc.connected(0, 10));
		System.out.println(8 + " e " + 9 + " estão conectados? " + cc.connected(8, 9));
		System.out.println(9 + " e " + 10 + " estão conectados? " + cc.connected(9, 10));
	}
}
