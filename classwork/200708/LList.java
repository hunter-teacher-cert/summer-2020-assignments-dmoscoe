// 200711: Replaced the method length() with just a getter. Length now gets incremented live every time a node is added or removed. Added testing for length to the Driver file.

import java.io.*;
import java.util.*;

public class LList {
	private Node head; //a linked list is defined by the node at the head of the list.
	private int length; //Why does length get initialized here and not in public LList() ?
	
	public LList() { //is this the only constructor we need? We don't need a value constructor?
		head = null;
		length = 0;
	}
	
	public void add(String data) {
		Node newnode = new Node(data);
		newnode.setNext(head); //first point the new node to the head of the LList.
		head = newnode; //point head to the new node.
		length++;
	}
	
	public String toString() {
		String s = "";
		Node tmp;
		tmp = head;
		while (tmp != null) {
			s = s + tmp.getData() + "-->"; //Now we need to move tmp to the next node. This is the magic linked list idiom! It moves the pointer to the next node! It's analogous to i++ for an array (for loop).
			tmp = tmp.getNext();
		}
		s = s + "null"; //indicates that you've reached the end of the LList.
		return s;
	}

	public void addFront(String value) { //we actually already had this with add(String data) above.
		Node newnode = new Node(value);
		newnode.setNext(head);
		head = newnode;
		length++;
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public int length() { //needed this to check whether index is out of bounds in get(int index).
		return length;
	}
	
	public String get(int index) {
		if (index < length) {
			int i = index;
			Node tmp;
			tmp = head;
			while (i > 0) {
				tmp = tmp.getNext();
				i--;
			}
			return tmp.getData();
		} else {
			return null;
		}
	}
	
	public void set(int index, String value) {
		if (index < length) {
			int i = index;
			Node tmp;
			tmp = head;
			while (i > 0) {
				tmp = tmp.getNext();
				i--;
			}
			tmp.setData(value);
		}
	}
	
	public void insert(int index, String value) {
		//plan: if index == 0 then just use addFront. If index > 0 and valid, then make a new node, inserter(value). Traverse the LList using tmp to index - 1. Set inserter's next to be tmp's next. And set tmp's next to be inserter.
		if (index == 0) {
			this.addFront(value);
		} else {
			if (index <= length) {
				int counter = 1;
				Node inserter = new Node(value);
				Node tmp;
				tmp = head;
				while (counter < index) {
					tmp = tmp.getNext();
					counter++;
				}
				inserter.setNext(tmp.getNext());
				tmp.setNext(inserter);
				length++;
			}
		}
	}
	
	public int search(String key) {
		//plan: traverse the LList. At each node, ask whether getData() equals key. If yes, return the index. If index == length, return -1.
		int i = 0;
		Node tmp;
		tmp = head;
		while (i < length) {
			if (key.equals(tmp.getData())) {
				return i;//stop after you've found the first instance of the search term.
			}
			tmp = tmp.getNext();
			i++;
		}
		return -1;
	}
	
	public void remove(int index) {
		//plan: make a tmp node. Traverse to index - 1. set this node's Next to the next of its successor. (Skip a node.)
		if (index == 0) { //be- and re-heading the LList.
			head = head.getNext();
			length--;
		} else {
			if (index <= length) {
				int i = 1;
				Node tmp;
				tmp = head;
				while (i < index) {
					tmp = tmp.getNext();
					i++;
				}
			tmp.setNext(tmp.getNext().getNext());
			length--;
			}
		}
	}
		
	
}//end class