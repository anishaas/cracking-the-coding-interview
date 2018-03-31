package chapterfour;

import chapterfour.BinaryTree.Node;

//Write an algorithm to find the ‘next’ node (i.e., in-order successor) of a given node in
//a binary search tree where each node has a link to its parent.

public class Q4_5 {

	public Node findNext(Node node) {
		if(node.getRight() !=null ) {
			//successor in right subtree
			Node current = node.getRight();
			while(current.getLeft() != null) {
				current = current.getLeft();
			}
			return current;
		} else {
			//successor = parent
			Node parent = node.getParent();
			while(parent != null) {
				if(parent.getLeft() == node) {
					break;
				}
				node = parent; 
				parent = parent.getParent();
			}
		}
		//no successor
		return null;
	}
	
}
