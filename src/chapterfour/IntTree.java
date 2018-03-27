package chapterfour;

public class IntTree {
	
	class IntTreeNode {
		public int data;
		public IntTreeNode left;
		public IntTreeNode right;
		
		//constructs leaf node
		public IntTreeNode(int data) {
			this(data, null, null);
		}
		
		//constructs branch node
		public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
	}
	
	IntTreeNode treeRoot;
	
	public static boolean isBalanced(IntTreeNode head) {
		//balanced if max - 1 <= 1
		return (maxDepth(head) - minDepth(head) <= 1); 
	}
	
	private static int maxDepth(IntTreeNode node) {
		//base case, null node
		if(node == null)
			return 0; 
		//current + max children
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}
	
	private static int minDepth(IntTreeNode node) {
		if(node.left == null && node.right == null) 
			return 0;
		return 1 + Math.min(minDepth(node.left), minDepth(node.right));
	}

}
