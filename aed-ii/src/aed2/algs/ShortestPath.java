package aed2.algs;

import java.util.Stack;

import aed2.DirectedEdge;
import aed2.EdgeWeightedDigraph;

public abstract class ShortestPath {
	protected EdgeWeightedDigraph graph;
	protected int source;
	protected double[] distTo;
	protected DirectedEdge[] edgeTo;
	
	public ShortestPath(EdgeWeightedDigraph graph, int source) {
		this.graph = graph;
		this.source = source;
		this.distTo = new double[graph.getNumberOfVertices()];
		this.edgeTo = new DirectedEdge[graph.getNumberOfEdges()];
		
		distTo[source] = 0;
		for (int i = 0; i < distTo.length; i++) {
			if (i != source) {
				distTo[i] = EdgeWeightedDigraph.INFINITY;	
			}
		}
		
		execute();
	}
	
	protected abstract void execute();

	public double distTo(int v) {
		return distTo[v];
	}
	
	public double[] getDistTo() {
		return distTo;
	}
	
	public DirectedEdge[] getEdgeTo() {
		return edgeTo;
	}
	
	public Iterable<DirectedEdge> pathTo(int v){
		Stack<DirectedEdge> path = new Stack<>();
		
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
			path.push(e);
		}
		
		return path;
	}
}