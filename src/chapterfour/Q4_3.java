package chapterfour;

import chapterfour.BinaryTree.Node;

//Given a sorted array, write an algorithm to create a binary tree with minimal height.

public class Q4_3 {

	public Node buildTree(int [] arr, int beg, int end) {
		//no elements left in array
		if(end < beg) {
			return null;
		}
		int mid = (end - beg)/2;
		Node node = new Node(arr[mid]);
		node.setLeft(buildTree(arr, beg, mid - 1));
		node.setRight(buildTree(arr, mid + 1, end));
		return node;
	}
		
}
