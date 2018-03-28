package chapterfour;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
	
	//HashMap for lookup by id
	private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();
	
	public static class Node {
		//identify node
		private int id;
		//store adjacent nodes
		LinkedList<Node> adjacent = new LinkedList<Node>();
		
		private Node(int id) {
			this.id = id;
		}
	}
	
	private Node getNode(int id) {
		Node result = nodeLookup.get(id);
		return result;
	}
	
	private void addEdge(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		//add destination to source's neighbors
		s.adjacent.add(d);
	}
	
	//depth first
	public boolean hasPathDepthFirst(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		//hash map to track visited nodes
		HashSet<Integer> visited = new HashSet<Integer>();
		return hasPathDepthFirst(s, d, visited);
	}
	
	private boolean hasPathDepthFirst(Node source, Node destination, HashSet<Integer> visited) {
		//node previously checked for path
		if(visited.contains(source.id)) {
			return false; 
		}
		//add source to visited
		visited.add(source.id);
		//check source == destination
		if(source == destination) 
			return true;
		for(Node c: source.adjacent) {
			if(hasPathDepthFirst(c, destination, visited)) {
				return true; 
			}
		}
		//no children == destination
		return false; 
	}
	
	
	//breadth first
	public boolean hasPathBreadthFirst(Node source, Node destination) {
		//trackers
		HashSet<Integer> visited = new HashSet<Integer>();
		LinkedList<Node> nextToVisit = new LinkedList<Node>();
		
		nextToVisit.add(source);
		
		while(!nextToVisit.isEmpty()) {
			Node node = nextToVisit.remove();
			if(node == destination)
				return true;
			
			if(visited.contains(node.id))
					continue;
			
			visited.add(node.id);
			
			//queue neighbors
			for(Node neighbor : node.adjacent) {
				nextToVisit.add(neighbor);
			}
		}
		return false; 
	}
}