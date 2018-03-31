package chapterfour;

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
	}

}
