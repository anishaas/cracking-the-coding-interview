package chapterfour;

import chapterfour.BinaryTree.Node;

public class Q4_6 {
	
	public static void main(String args[]) {
		Q4_6 test = new Q4_6();
		BinaryTree tree = new BinaryTree();
		int [] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
		Node root = tree.buildTree(arr, 0, 11);
		System.out.println("Display Tree");
		tree.printTree(root);
//			   6
//			 /   \
//		   3       9 
//		 /	\    /   \
//		1    4   7     11 
//		 \	  \   \   /  \
//		  2	   5   8  10  12 
		System.out.println();
		System.out.println("First Common Ancestor of 3 and 5: ");
		Node result = test.firstCommonAncestor(root, root.getLeft().getLeft(), root.getLeft().getRight().getRight());
		System.out.println(result.getData());
	}
	
	public Node firstCommonAncestor(Node root, Node n1, Node n2) {
		if(root == null) {
			return null;
		}
		
		if(n1.getData() < root.getData() && n2.getData() < root.getData()) {
			return firstCommonAncestor(root.getLeft(), n1, n2);
		}
		
		if(n1.getData() > root.getData() && n2.getData() > root.getData()) {
			return firstCommonAncestor(root.getRight(), n1, n2);
		}
		
		//either root == n1 or n2, or one is greater, one is smaller
		return root;
	}
	
}
