package chapterfour;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
	
	
	public static void main(String args[]) {
		IntTree tree = new IntTree();
		int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		IntTreeNode head = createTree(arr);
		System.out.println("Display binary tree: ");
		printTree(head);
		System.out.println();
		
		System.out.println();
		System.out.println("Display each level of tree: ");
		ArrayList<LinkedList<IntTreeNode>> result = new ArrayList<LinkedList<IntTreeNode>>();
		result = listNodesAtDepth(head);
		for(LinkedList<IntTreeNode> l : result) {
			for(IntTreeNode n : l) {
				System.out.print(n.data + " ");
			}
			System.out.println();
		}
	}
	
//	4.5 Write an algorithm to find the ‘next’ node (i.e., in-order successor) of a 
//	given node in a binary search tree where each node has a link to its parent.
	
//	4.4 Given a binary search tree, design an algorithm which creates a linked list of all
//	the nodes at each depth.
	
	public static ArrayList<LinkedList<IntTreeNode>> listNodesAtDepth(IntTreeNode root) {
		ArrayList<LinkedList<IntTreeNode>> lists = new ArrayList<LinkedList<IntTreeNode>>();
		LinkedList<IntTreeNode> list = new LinkedList<IntTreeNode>();
		list.add(root);
		int level = 0;
		lists.add(level, list);
		
		while(!list.isEmpty()) {
		//list for the next level
		list = new LinkedList<IntTreeNode>();
		int numInLevel = lists.get(level).size();
		//get all children for all in current list
			for(int i = 0; i < numInLevel; i++) {
				IntTreeNode n = lists.get(level).get(i);
				if(n.left!=null) {
					list.add(n.left);
				}
				if(n.right!=null) {
					list.add(n.right);
				}
			}
			level++;
			//add level's list
			if(list.size()>0) {
				lists.add(level, list);
			}
		}
		return lists;
	}
	
	public static IntTreeNode createTree(int [] arr) {
		return createTree(arr, 0, arr.length - 1);
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

	public static void printTree(IntTreeNode root) {
		if(root==null) 
			return;
		Queue<IntTreeNode> q = new LinkedList<IntTreeNode>();
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
