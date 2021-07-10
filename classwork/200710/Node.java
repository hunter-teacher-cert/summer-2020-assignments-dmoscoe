/*Copies some of the code on the class Node that MZ posted in day2day/05/II/. I will add on to this to elaborate the class Node, where a node is an element in a linked list. */

import java.io.*;
import java.util.*;

public class Node {
	private String data; //why do we declare these variables outside the constructors? Is it to show that they get updated by any method, and then their values are available globally to any other method in the class?
	private Node next;
	
	public Node() {
		this.data = "";
		this.next = null;
	}
	
	public Node(String data) {
		this.data = data;
		this.next = null;
	}
	
	public Node(String data, Node next) { //also not clear why the second argument here is a Node. It's because the name of any instance of a class refers only to an address in memory, so we are just storing a memory address here, and not the entire object.
	this.data = data;
	this.next = next;
	}
	
	public String getData() {
		return this.data; //When do we use this., and when do we just write data? In MZ's version, he just writes return data.
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public String toString() { //this is MZ's toString, but I want toString to also include information about next.
		return this.data;
	}
}