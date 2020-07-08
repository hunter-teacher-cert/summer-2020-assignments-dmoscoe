import java.io.*;
import java.util.*;

public class LList {
	private Node head; //a linked list is defined by the node at the head of the list.
	
	public LList() { //is this the only constructor we need? We don't need a value constructor?
		head = null;
	}
	
	public void add(String data) {
		Node newnode = new Node(data);
		newnode.setNext(head); //first point the new node to the head of the LList.
		head = newnode; //point head to the new node.
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
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public int length() { //needed this to check whether index is out of bounds in get(int index).
		int i = 0;
		Node tmp;
		tmp = head;
		while (tmp != null) {
			tmp = tmp.getNext();
			i++;
		}
		return i;
	}
	
	public String get(int index) {
		if (index < this.length()) {
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
		if (index < this.length()) {
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
		if (index == 0) {
			this.addFront(value);
		} else {
			if (index <= this.length()) {
				int i = 1;
				Node inserter = new Node(value);
				Node tmp;
				tmp = head;
				while (i < index) {
					tmp = tmp.getNext();
					i++;
				}
				inserter.setNext(tmp.getNext());
				tmp.setNext(inserter);
			}
		}
	}
}//end class