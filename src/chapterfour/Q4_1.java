package chapterfour;

import chapterfour.BinaryTree.Node;

//Implement a function to check if a tree is balanced. For the purposes of this question,
//a balanced tree is defined to be a tree such that no two leaf nodes differ in distance
//from the root by more than one.

public class Q4_1 {
	
	public boolean isBalanced(Node root) {
		if(root==null) {
			return false;
		}
		return (maxDepth(root) - minDepth(root) <= 1);
	}
	
	private int maxDepth(Node node) {
		if(node == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(node.getLeft()), maxDepth(node.getRight()));
	}
	
	private int minDepth(Node node) {
		if(node == null) {
			return 0;
		}
		return 1 + Math.min(minDepth(node.getLeft()), minDepth(node.getRight()));
	}
	
}
