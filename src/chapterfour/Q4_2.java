package chapterfour;

import java.util.HashSet;
import java.util.LinkedList;

import chapterfour.Graph.Vertex;

//Given a directed graph, design an algorithm to find out whether there is a 
//route between two nodes.

public class Q4_2 {
	
	public boolean hasPath(Vertex source, Vertex destination) {
		HashSet<Integer> visited = new HashSet<Integer>();
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		queue.add(source);
		while(!queue.isEmpty()) {
			Vertex v = queue.remove();
			if(visited.contains(v.getId())) {
				continue;
			}
			visited.add(v.getId());
			if(v == destination) {
				return true;
			}
			for(Vertex neighbor : v.getAdjacent()) {
				queue.add(neighbor);
			}
		}
		return false;
	}
	
}
