//a stack is a linked list with *less* functionality. So start with LList and remove stuff.

import java.io.*;
import java.util.*;

public class Scratch1535 {
	private Node head;
	int size = 0;
	
/* 	public Scratch1535() {
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
	
	public static void main(String[] args) {
		Scratch1535 g = new Scratch1535();
		g.push("hello");
		g.push("who's next?");
		System.out.println(g.top());
		System.out.println(g.pop());
		System.out.println(g.isEmpty());
		System.out.println(g.size());
		System.out.println(g.pop());
		System.out.println(g.isEmpty());
		System.out.println(g.size());
	}
}