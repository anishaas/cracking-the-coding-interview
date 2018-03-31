package chapterfour;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	
	private HashMap<Integer, Vertex> lookup = new HashMap<Integer, Vertex>();

	public Graph() {
	}
	
	public static class Vertex {
		private int id;
		private List<Vertex> adjacent;
		
		public Vertex(int id) {
			this.id = id;
		}
	}
	
	private Vertex getVertex(int id) {
		Vertex result = lookup.get(id);
		return result;
	}
	
	public void addEdge(int source, int dest) {
		Vertex s = getVertex(source);
		Vertex d = getVertex(dest);
		s.adjacent.add(d);
	}
	
	public boolean hasPathBFS(int source, int destination) { 
		Vertex s = lookup.get(source);
		Vertex d = lookup.get(destination);
		HashSet<Integer> visited = new HashSet<Integer> ();
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		
		if(s == null || d == null) {
			return false;
		}
		
		queue.add(s);
		while(!queue.isEmpty()) {
			Vertex v = queue.remove();
			if(v == d) {
				return true;
			} 
			
			if(visited.contains(s)) {
				continue;
			}
			
			visited.add(v.id);
			
			for(Vertex neighbor : v.adjacent) {
				queue.add(neighbor);
			}
		}
		return false;
	}
	
	public boolean hasPathDFS(int source, int destination) {
		Vertex s = getVertex(source);
		Vertex d = getVertex(destination);
	
		if(s == null || d == null) {
			return false;
		}
		
		HashSet<Integer> visited = new HashSet<Integer>();
		return hasPathDFS(s, d, visited);
	} 
	
	public boolean hasPathDFS(Vertex child, Vertex destination, HashSet<Integer> visited) {
		if(visited.contains(child.id)) {
			return false;
		}
		visited.add(child.id);
		if(child == destination) {
			return true;
		}
		for(Vertex v : destination.adjacent) {
			if(hasPathDFS(v, destination, visited)) {
				return true;
			}
		}
		return false; 
	}
}
