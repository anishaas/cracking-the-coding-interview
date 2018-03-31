package chapterfour;

import java.util.ArrayList;
import java.util.LinkedList;

import chapterfour.BinaryTree.Node;

//Given a binary search tree, design an algorithm which creates a linked list of all the
//nodes at each depth (i.e., if you have a tree with depth D, you’ll have D linked lists).

public class Q4_4 {
	
	public ArrayList<LinkedList<Node>> getTreeLevels(Node root) {
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		int level = 0; 
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
		lists.add(level, list);
		//add current lists's children in new list
		while(!lists.get(level).isEmpty()) {
			list = new LinkedList<Node>();
			//add children to new list
			for(Node n : lists.get(level)) {
				if(n.getLeft() != null) list.add(n.getRight());
				if(n.getRight() != null) list.add(n.getRight());
			}
			//add new list 
			level++;
			lists.add(level, list);
		}
		return lists;
	}
}
