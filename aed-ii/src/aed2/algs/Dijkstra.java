package aed2.algs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import aed2.DirectedEdge;
import aed2.EdgeWeightedDigraph;

public class Dijkstra extends ShortestPath {

	public Dijkstra(EdgeWeightedDigraph graph, int source) {
		super(graph, source);
	}

	@Override
	protected void execute() {
		List<Integer> open = graph.getVertices();
		List<Integer> closed = new ArrayList<>();
		
		while (!open.isEmpty()) {
			Integer v = getVertexByMinDistance(open);
			closed.add(v);
			open.remove(v);
			System.out.println("\nvértice = " + v);
	        System.out.println("abertos: " + open);
	        System.out.println("fechados: " + closed);
			Iterable<DirectedEdge> neighbors = graph.adj(v);
			System.out.println("Vizinhos " + neighbors);
			for(DirectedEdge edge: neighbors) {
				if (!closed.contains(edge.to())) {
					if (distTo[v] + edge.weight() < distTo[edge.to()]) {
						distTo[edge.to()] = distTo[v] + edge.weight();
						edgeTo[edge.to()] = edge;
//						System.out.println("Dist To = " + distTo[edge.to()]);
//						System.out.println("Edge To = " + edgeTo[edge.to()]);
					}
				}
			}
			System.out.println("Dist To = " + Arrays.toString(distTo));
			System.out.print("Edge To = [");
			for(int i=0;i<distTo.length; i++) {
				System.out.print(edgeTo[i]);
				if(i != distTo.length - 1) System.out.print(", ");
			}
			System.out.println("]");
		}
	}

	private int getVertexByMinDistance(List<Integer> open) {
		Collections.sort(open, new Comparator<Integer>() {
			@Override
			public int compare(Integer v1, Integer v2) {
				int result = 0;
				if (distTo[v1] < distTo[v2]) {
					result = -1;
				} else if (distTo[v1] > distTo[v2]) {
					result = +1;
				}
				return result;
			}
		});
		
		return open.get(0);
	}
}