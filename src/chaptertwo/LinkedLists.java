package chaptertwo;

import java.util.Hashtable;
import java.util.LinkedList;

/*2.1 Write code to remove duplicates from an unsorted linked list.
 *How would you solve this problem if a temporary buffer is not allowed?
 */

/*2.2 Implement an algorithm to find the nth to last 
 * element of a singly linked list*/

/*2.3 Implement an algorithm to delete a node in the middle of a single linked list, 
 * given only access to that node.
*/

/*2.5 Given a circular linked list, implement an algorithm which returns node at 
 * the beginning of the loop.
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
	
	//2.5
	public static Node findBegOfLoop(Node head) {
		Node p1 = head;
		Node p2 = head;
		
		//find meeting point
		while(p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			//check for meeting point
			if(p1 == p2) {
				//stop searching
				break;
			}
		}
		
		//set p1 to head
		p1 = head;
		while(p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1; 
	}
	
	//2.4 
	public static Node addListsRecursive(int carry, Node n1, Node n2) {
		
		//base case
		if(n2 == null && n2 == null) {
			return null;
		}
		LinkedLists l = new LinkedLists();
		Node result = l.new Node();
		int value = carry;
		if(n1 != null) {
			value += n1.data;
		}
		if(n2 != null) {
			value += n2.data;
		}
		//data should be only 1 digit
		result.data = value % 10;
		Node next = l.new Node();
		next = addListsRecursive(value >= 10 ? 1 : 0, n1.next, n2.next);
		result.next = next;
		
		return result;
	}
	
	//2.4 iterative
	public static Node addListsIterative(Node head, int l1, int l2) {
		int n1 = 0;
		int n2 = 0; 
		int sum = 0;
		int multiplier = 1;
		
		Node current = head;
		
		for(int i = 0; i < l1; i++) {
			int digit = current.data * multiplier;
			n1 += digit;
			multiplier *= 10;
			current = current.next;
		}
		
		multiplier = 1;
		for(int i = 0; i < l2; i++) {
			int digit = current.data * multiplier;
			n1 += digit;
			multiplier *= 10;
			current = current.next;
		}
		
		sum = n1 + n2;
		//populate new head
		LinkedLists l = new LinkedLists();
		Node currentLast = l.new Node();
		int digitToAdd = sum % 10;
		sum = sum % 10;
		currentLast.setData(digitToAdd);
		Node h = currentLast; 
		while(sum > 0) {
			Node next = l.new Node();
			digitToAdd = sum % 10;
			next.data = digitToAdd;
			current.next = next;
			currentLast = next;
		}
		return h;
	}
	
	
	//2.3 delete middle node
	public static void deleteMiddleNode(Node mid) {
		if(mid==null || mid.next == null) return;
		
		//copy next node's data to mid
		mid.data = mid.next.data;
		mid.next = mid.next.next;	
	}
	
	//2.2 nth to last element 
	public static Node findNthToLast(Node head, int n) {
		//create two pointers
		Node p1 = head;
		Node p2 = head;
		
		//distance p2 by n
		for(int i = 0; i < n - 1; i++) {
			//check that n is within list size
			if(p2 == null) {
				return null;
			}
			//move p2
			p2 = p2.getNext();
		}
		
		//while p2 has not reached the last node
		while(p2.getNext() != null){
			//move both p1 and p2 
			p1 = p1.getNext();
			p2 = p2.getNext();
		} 
		return p1;
	}
	
	//solution with hash table
	public static void removeDupes1(Node head) {
		Hashtable tracker = new Hashtable();
		Node current = head;
		Node prev = null;
		while(current != null) {
			//check for duplicate
			if(tracker.containsKey(current.getData())) {
				//remove pointer to current
				prev.setNext(current.getNext());
			} else {
				//add new value 
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
