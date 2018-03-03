
public class BinaryTrees {
	
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
	
	//pre-order traversal
	public void printPreOrder(IntTreeNode root) {
		if(root!=null) {
			//print root 
			System.out.print(root.data + " ");
			//print left 
			printPreOrder(root.left);
			//print right 
			printPreOrder(root.right);
		}
	}
	
	//in-order traversal
	public void printInOrder(IntTreeNode root) {
		if(root !=null) {
			//print left node data
			printInOrder(root.left);
			//print the root 
			System.out.print(root.data + " ");
			//print right
			printInOrder(root.right);
		}
	}
	
	//post-order traversal
	public void printPostOrder(IntTreeNode root) {
		if(root != null) {
			//print left
			printInOrder(root.left);
			//print right
			printInOrder(root.right);
			//print root
			System.out.print(root + " ");
		}
	}

}
