package aed2.algs;

import java.util.Arrays;

import aed2.DirectedEdge;
import aed2.EdgeWeightedDigraph;

public class BellmanFord extends ShortestPath{
	public BellmanFord(EdgeWeightedDigraph graph, int source) {
		super(graph, source);
	}

	@Override
	protected void execute() {
		for (int i = 0; i < distTo.length; i++) {
			if (i != source) {
				if (graph.containsEdge(source, i)) {
					distTo[i] = graph.getWeight(source, i);
					edgeTo[i] = graph.getEdge(source, i);
				} else {
					distTo[i] = EdgeWeightedDigraph.INFINITY;		
				}
			}
		}
		
		for (int k = 0; k < graph.getNumberOfVertices(); k++) {
			boolean changed = false;
			
			System.out.println("\nvértice = " + k);
			for (int j = 0; j < graph.getNumberOfVertices(); j++) {
				if (j == source) {
					continue;
				}
				
				Iterable<DirectedEdge> pred = graph.predecessors(j);
				System.out.println("predecessores = " + pred);
				for (DirectedEdge edge : pred) {
					if (distTo[edge.from()] + edge.weight() < distTo[j]) {
						distTo[j] = distTo[edge.from()] + edge.weight();
						edgeTo[j] = edge;
						changed = true;
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
			
			if (!changed) {
				System.out.println("Bye com i: "+ k);
				break;
			}
		}
	}
}