package chaptertwo;

import java.util.Hashtable;

/*1.2 Write code to remove duplicates from an unsorted linked list.
 *How would you solve this problem if a temporary buffer is not allowed?
 */

public class LinkedLists {
	
	class Node {
		int data;
		Node next;
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
	}
	
	//solution with hash table
	public static void removeDupes1(Node head) {
		Hashtable tracker = new Hashtable();
		Node current = head;
		Node prev = null;
		while(current != null) {
			if(tracker.containsKey(current.getData())) {
				prev.setNext(current.getNext());
			} else {
				tracker.put(current.getData(), true); 
				prev = current;
			}
			current = current.getNext();
		}
	}
	
	//go through and remove every dupe of current node's data
	public static void removeDupes2(Node head) {
		if(head==null) return;
		Node prev = head;
		Node current = prev.getNext();
		while(current != null) {
			//check current against head
			if(head.getData() == current.getData()) {
				prev.setNext(current.getNext());
			}
			//check all nodes to the right
			Node pointer = current.getNext();
			while(pointer != null) {
				if(pointer.getData() == current.getData()) {
					prev.setNext(current.getNext());
					current = prev.getNext();
				}
				pointer = pointer.getNext();
			}
		}
	}
	
	//1.2 - no buffer
	//remove one dupe at a time
	public static void removeDupesBookSolution(Node head) {
		if(head==null) return;
		Node prev = head;
		Node current = prev.getNext();
		while(current != null) {
			//always resent pointer to head
			Node pointer = head;
			while(pointer != current) {
				//check for duplicate
				if(pointer.getData() == current.getData()) {
					prev.setNext(current.getNext());
					current = prev.getNext();
				}
				pointer = pointer.getNext();
			}
			if(pointer == current) {
				//move to the next node 
				prev = current;
				current = current.getNext();
			}
		}
	}

}
