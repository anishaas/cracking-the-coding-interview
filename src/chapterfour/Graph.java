package chapterfour;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
	
	//HashMap for lookup by id
	private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>;
	
	public static class Node {
		private int id;
		//all neighboring Nodes
		LinkedList<Node> adjacent = new LinkedList<Node>();
		
		private Node(int id){
			this.id = id;
		}
		
	}
	
	private Node getNode(int id) {
		Node result = nodeLookup.get(id);
	}
	
	private Node addEdge(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		//add destination to source's neighbors
		s.adjacent.add(d);
	}
	
	//check for path between two nodes
	public boolean hasPathDepthSearch(int source, int destination) {
		//keep track of visited nodes to avoid re-processing
		HashSet<Integer> visited = new HashSet<Integer>();
		Node s = nodeLookup.get(source);
		Node d = nodeLookup.get(destination);
		return hasPathHelper(s, d, visited);
	}
	
	private boolean hasPathHelper(Node s, Node d, HashSet<Integer> visited) {
		if(visited.contains(s.id)) return false;
		
		//update visited with current node
		visited.add(s.id);
		
		//check if destination node reached
		if(s == d) return true;
		
		//check each child
		for(Node n : s.adjacent) {
			if (hasPathHelper(n, d, visited)) {
				return true;
			}
		}
		
		//all children checked, no path, return false
		return false;
	}
	
}