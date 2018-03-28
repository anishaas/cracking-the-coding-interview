package chapterfour;

import java.util.ArrayList;
import java.util.LinkedList;

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
	
//	4.5 Write an algorithm to find the ‘next’ node (i.e., in-order successor) of a 
//	given node in a binary search tree where each node has a link to its parent.
	
//	4.4 Given a binary search tree, design an algorithm which creates a linked list of all
//	the nodes at each depth.
	
	public static ArrayList<LinkedList<IntTreeNode>> listNodesAtDepth(IntTreeNode node) {
		ArrayList<LinkedList<IntTreeNode>> lists = new ArrayList<LinkedList<IntTreeNode>>();
		LinkedList<IntTreeNode> list = new LinkedList<IntTreeNode>();
		list.add(node);
		//list index
		int level = 0;
		while(list.size() > 0) {
			LinkedList<IntTreeNode> list = new LinkedList<IntTreeNode>();
			int numChildren = lists.get(level).size();
			for(int i = 0; i < numChildren; i++) {
				//retrieve child node 
				IntTreeNode n = lists.get(level).get(i);
				if(n!=null) {
					if (n.left != null) {
						list.add(n.left);
					}
					if(n.right != null) {
						list.add(n.right);
					}
				}
				if(list.size() > 0) {
					lists.add(level, list);
					//leaf nodes reached
				} else {
					break;
				}
			}
			level++;
		}
		return lists; 
			//keep track of how many children at each level
			//b/c need to access every child's left and right
			
			//store each child
			
			//make a new list
			
			//add each child's children
			
			//create new list with previous list's nodes
			
			//when the list is empty, that means there were no children on that level
	}
	
	public static void createTree(int [] arr) {
		createTree(arr, 0, arr.length - 1);
	}
	
	private static IntTreeNode createTree(int [] arr, int beg, int end) {
		//base case, empty array
		if(end < beg)
			return null;
		//find middle element
		int mid = (beg + end)/2;
		//middle element is root			
		IntTreeNode node = new IntTree().new IntTreeNode(arr[mid]);
		//build left tree, 0 up to mid 
		node.left = createTree(arr, beg, mid - 1);
		//build right tree
		node.right = createTree(arr, mid + 1, end);
		return node; 
	}
	
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
