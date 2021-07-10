//a stack is a LList with *less* functionality. So start with Node and do less than what you did with LList.

import java.io.*;
import java.util.*;

public class MyStack {
	private Node head;
	int size = 0;
	
/*
I thought this constructor was necessary, but it seems like it isn't. And when I uncomment it, it actually produces errors. Why?!

 	public MyStack() {
		head = null;
		int size = 0;

	} */
	
	public void push(String data) {
		Node newnode = new Node(data);
		newnode.setNext(head);
		head = newnode;
		size++;
	}
	
	public String pop() {
		String toReturn = head.getData();
		head = head.getNext();
		size--;
		return toReturn;
	}
	
	public String top() {
		return head.getData();
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int size() {
		return size;
	}
}