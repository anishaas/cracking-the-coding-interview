package chapterfour;

import java.util.LinkedList;
import java.util.Queue;

import chapterfour.BinaryTree.Node;

public class BinaryTree {
	
	private Node root;

	public static class Node {
		private int data;
		private Node left;
		private Node right; 
		private Node parent;
		
		Node() {
			
		}

		public Node(int i) {
			this.data = i;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getParent() {
			return this.parent;
		}
		
		public void setParent(Node parent) {
			this.parent = parent;
		}

		public int getData() {
			return this.data;
		}
	}
	
	public Node buildTree(int [] arr, int beg, int end) {
		//no elements left in array
		if(end < beg) {
			return null;
		}
		int mid = (beg + end)/2;
		Node node = new Node(arr[mid]);
		node.setLeft(buildTree(arr, beg, mid - 1));
		node.setRight(buildTree(arr, mid + 1, end));
		return node;
	}
	
	public void printTree(Node root) {
		if(root==null) 
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		//use null as delimiter
		q.add(null);
		while(!q.isEmpty()) {
			//want to retrieve null, use poll 
			root = q.poll();
			if(root != null) {
				//print root
				System.out.print(root.data + " ");
				//add left and right to queue
				if(root.left != null) {
					q.add(root.left);
				}
				if(root.right != null) {
					q.add(root.right);
				}
				//reached delimiter in queue, print new line
			} else {
				if(!q.isEmpty()) {
					System.out.println();
					//add null back at the end of the queue
					q.add(null);
				}
			}
		}
	}
}
