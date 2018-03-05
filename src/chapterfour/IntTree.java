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
	
	public IntTree(int numNodes) {
		treeRoot = buildTree(1, numNodes);
	}
	
	public int countNodes(IntTreeNode root) {
		if(root==null) return 0;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	public boolean isBalanced(IntTreeNode treeRoot) {
		return (maxDepth(treeRoot) - minDepth(treeRoot) <= 1);
	}
	
	private int maxDepth(IntTreeNode root) {
		//subtree is empty
		if(root==null) return 0;
		//return max level 
		return(1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
	}

	private int minDepth(IntTreeNode root) {
		if(root==null) return 0;
		//return min level
		return(1 + Math.min( minDepth(root.left), minDepth(root.right)));
	}
	
	public int sumTree(IntTreeNode treeRoot) {
		int sum = 0;
		if(treeRoot==null) {
			return 0;
		} else {
			sum = sum(treeRoot);
		}
		return sum;
	}
	
	private int sum(IntTreeNode root) {
		int sum = 0;
		sum += root.data;
		sum += sum(root.left);
		sum += sum(root.right);
		return sum;
	}
	
	//pass the root of subtree being constructed, pass tree total nodes
	private IntTreeNode buildTree(int currentRoot, int numNodes) {
		//tree has reached numNodes already
		if(currentRoot > numNodes) {
			return null;
		} else {
			//build out left subtree
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
