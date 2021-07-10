/* lingering questions:

 Why do we need to declare instance variables at the top of the class and not in the constructor? I guess I'm confused about the sequence of operations when a new LList is declared. Do we first look at public class LList, or do we first look at public LList() ?
 
 When an exception is thrown, it derails the entire program (unless it's caught?). But this makes the driver less useful, because it stops testing as soon as it encounters an exception. So I guess this means I have to catch the exceptions, right? */

import java.io.*;
import java.util.*;

public class LList {
	private Node head;
	private int length;
	
	public LList() {
		head = null;
		length = 0;
	}
	
	public void add(String data) {
		Node newnode = new Node(data);
		newnode.setNext(head);
		head = newnode;
		length++;
	}
	
	public Node nodeAt(int index) {
		if (index == 0) {
			return head;
		} else if (0 < index && index < length) {
			int i = index;
			Node tmp;
			tmp = head;
			while (i > 0) {
				tmp = tmp.getNext();
				i--;
			}
			return tmp;
		} else {
			
			throw new IndexOutOfBoundsException();
			
		}
	}

	public String toString() {
		String s = "";
		int i = 0;
		while (i < length) {
			s += (this.nodeAt(i).getData() + " ");
			i++;
		}
		return s;
	}

	public void addFront(String value) {
		
		if (value == null) {
			
			throw new IllegalArgumentException();
		
		}
		Node newnode = new Node(value);
		newnode.setNext(head);
		head = newnode;
		length++;
		
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public int length() {
		return length;
	}
	
	public String get(int index) {
		if (0 <= index && index < length) {
			return this.nodeAt(index).getData();
		} else{
			
			throw new IndexOutOfBoundsException();
			
		}
	}
	
	public void set(int index, String value) {
		this.nodeAt(index).setData(value);
	}
	
	public void insert(int index, String value) {
		if (index == 0) {
			this.addFront(value);
		} else if (index < length) {
				Node inserter = new Node(value);
				inserter.setNext(this.nodeAt(index));
				this.nodeAt(index - 1).setNext(inserter);
				length++;
			} else if (index == length) {
				Node inserter = new Node(value);
				this.nodeAt(index - 1).setNext(inserter);
				length++;			
			} else if (index > length) {
				
				throw new IndexOutOfBoundsException();
				
		}
	}
	
	public int search(String key) {
		int i = 0;
		while (i < length) {
			if (key.equals(this.nodeAt(i).getData())) {
				return i;
			}
			i++;
		}
		
		throw new NoSuchElementException();
		
	}
	
	public void remove(int index) {
		if (index == 0) {
			head = head.getNext();
			length--;
		} else if (index < length - 1) {
			this.nodeAt(index - 1).setNext(this.nodeAt(index + 1));
			length--;
		} else if (index == length - 1) {
			this.nodeAt(index - 1).setNext(null);
			length--;
		} else if (index < 0 || index >= length) {
			
			throw new IndexOutOfBoundsException();
		
		}
	}
}