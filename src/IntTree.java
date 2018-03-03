
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
	
	public IntTree(int numNodes) {
		treeRoot = buildTree(1, numNodes);
	}
	
	//pass the root of subtree being constructed, pass tree total nodes
	private IntTreeNode buildTree(int currentRoot, int numNodes) {
		//tree has reached numNodes already
		if(currentRoot > numNodes) {
			return null;
		} else {
			//create subtree left and right
			IntTreeNode left = buildTree(2 * currentRoot, numNodes);
			IntTreeNode right = buildTree(2 * currentRoot + 1, numNodes);
			//constructor call
			return new IntTreeNode(currentRoot, left, right);
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
