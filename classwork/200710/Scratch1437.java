//Create a class that represents a stack data structure and includes methods below. Make sensible decisions for situations that could result in an error, and add methods as needed.

//I'm going to try building on the Java class LinkedList. Then maybe I will try it using different underlying data structures.

import java.util.*;
import java.io.*;

public class Scratch1437 { //replace with MyStack. Add your internal data structure here.
	public Scratch1437() { 	//Constructor. List all the instance variables that make up a stack and set their default values. But I don't need to include instance variables that already exist for the underlying LinkedList. So I will exclude size, for example.
		top = null;
	}
	public void push(String data) { //Add code to push data on to the stack.
		
	}
	
	public String pop() { //remove and return the item on the top of the stack.
	
	}
	
	public String top() { //Return but don't remove the item on the top of the stack.
	
	}
	
	public boolean isEmpty() { //Return true if the stack has no data, false otherwise
	
	}
	
	public int size() { //return the number of items on the stack.
	
	}
	
	public static void main(String[] args) { //move this to another driver file when you're done. The driver file should test all the methods of the class.
	
	LinkedList<String> g = new LinkedList<String>();
	g.add("new element");
	System.out.println(g);
	
	
	
	}//end main
}//end class