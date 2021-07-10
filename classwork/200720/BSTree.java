import java.io.*;
import java.util.*;

public class BSTree {
    private TreeNode root;

    public BSTree(){
	root = null;
    }

/*  	public void insert(int key) {
		TreeNode newNode = new TreeNode(key); //the TreeNode that we're going to insert, set to its value.
		
		//If the tree is empty, manually insert the new node as the root.
		
		if (root == null) {
			root = newNode;
			return;
		}
		
		//Set up two pointers for "piggybacking":
		
		TreeNode front = root;
		TreeNode trailer;
		
		// Use the basic idea from search to find the right spot at the remotest leaves of the tree to place the new TreeNode. It's always possible to place a new TreeNode at the top of the tree.
		
		while (front != null) {
			int frontValue = front.getData();
			if (frontValue == key) {
				return; //This value already exists in the tree, so there's no need to insert it.
			} else if (frontValue < key) {
				trailer = front;
				front = front.getRight();
			} else {
				trailer = front;
				front = front.getLeft();
			}
			
			//At this point, either front == null, or we found the value somewhere else in the tree. So we're at the top of the tree. Now the trailer does its job: it's still on the tree, while front has at this point fallen off the upper leaves.
			
			if (key > trailer.getData()) {
				trailer.setRight(newNode);
			} else {
				trailer.setLeft(newNode);
			}
		}
	} */
	
	public void insert(int key) {

	/* Plan: Make a new TreeNode with data = key. If the tree is empty, add newNode as the root. Move down the tree using front and trailer as pointers s.t. pointer is always one behind trailer. When trailer falls off the tree, pointer is at the correct final leaf of the tree. Set either left or right of trailer to the new TreeNode. */
	
		TreeNode newNode = new TreeNode(key);
		
		if (root == null) {
			root = newNode;
			return;
		}
		
		TreeNode front = root;
		TreeNode trailer = null; //Thank you, Joshua.
		
		while (front != null) {
			System.out.println("Entered while loop.");
			if (front.getData() == key) {
			return;
		} else if (front.getData() < key) {
			trailer = front;
			front = front.getRight();
		} else {
			trailer = front;
			front = front.getLeft(); //But if front is at the edge of the tree, there is no getLeft(). If you want to insert 3, front goes from 10 to 5, and then it attempts to getLeft. but 5 has no getLeft. So what happens? Actually, this is working, you just still don't seem to understand it.
		}
		}
		
		if (trailer.getData() < key) {
			trailer.setRight(newNode);
		} else {
			trailer.setLeft(newNode);
		}
	}

 	public int search(int key){
	
	/* run-time for search: In the worst case, the while loop would examine every node (each node has one child, and the key is the last node in the tree). This is linear run-time. In the best case, the while loop would examine log2 n nodes, where n is the number of "generations" or levels of the tree. This is logarithmic run-time. */
	
		TreeNode current = root;

		while (!(current == null)){
		

			int currentValue = current.getData();
			if (currentValue == key){
				return currentValue;
			} else if (currentValue < key){
				current = current.getRight();
			} else {
				current = current.getLeft();
			}
		

		
		}
		throw new NullPointerException();
    }
		
    public void seed(){
	TreeNode t;

	t = new TreeNode(10);
	root = t;
	t = new TreeNode(5);
	root.setLeft(t);
	t = new TreeNode(20);
	root.setRight(t);

	root.getLeft().setRight( new TreeNode(7));
	root.getLeft().setLeft(new TreeNode(3));
	root.getLeft().getRight().setRight(new TreeNode(8));
	root.getRight().setRight(new TreeNode(25));
	
	}
    
    
}