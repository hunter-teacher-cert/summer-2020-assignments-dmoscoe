import java.io.*;
import java.util.*;

public class BSTree {
    private TreeNode root;

    public BSTree(){
	root = null;
    }

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
	
	private void preorderTraverse(TreeNode current) {
		if (current == null) {
			return;
		}
		System.out.print(current.getData() + ", ");
		preorderTraverse(current.getLeft());
		preorderTraverse(current.getRight());
	}

	public void preorderTraverse(){
		preorderTraverse(root);
		System.out.println();
    }
	
	private void postorderTraverse(TreeNode current){
		if (current == null)
			return;

	// recursively print out the left subtree
		postorderTraverse(current.getLeft());

	// recursively print out the right subtree
		postorderTraverse(current.getRight());

	//process the current node
		System.out.print(current.getData()+", ");
    }

    public void postorderTraverse(){
		postorderTraverse(root);
		System.out.println();
    }

    private void inorderTraverse(TreeNode current){
		if (current == null)
			return;


	// recursively print out the left subtree
		inorderTraverse(current.getLeft());

	//process the current node
		System.out.print(current.getData()+", ");

	// recursively print out the right subtree
		inorderTraverse(current.getRight());
    }

    public void inorderTraverse(){
		inorderTraverse(root);
		System.out.println();
    }
	
    public void seed(){
	TreeNode t;

	t = new TreeNode(10);
	root = t;
	t = new TreeNode(5);
	root.setLeft(t);
	t = new TreeNode(20);
	root.setRight(t);

	root.getLeft().setRight( new TreeNode(8));

	t = new TreeNode(15);
	root.getRight().setLeft(t);

	t = new TreeNode(22);
	root.getRight().setRight(t);
	
	}

	public void delete(int key){

	// if the tree is empty, nothing to delete
		if (root==null){
			return;
	}


	
		int fromTrailerToFront = 0; //will change to +1 if front is right of trailer, and -1 if front is left of trailer.

	// find the node that we want to delete
	// and the node above it using piggybacking
		TreeNode front = root;
		TreeNode trailer = root;

	// do the piggyback loop
	// until we either find the node or null
	// if the key isn't present
		while (front != null && front.getData() != key ){
			if (front.getData() < key){
			trailer = front;
			front = front.getRight();
			fromTrailerToFront = 1;
			} else {
			trailer = front;
			front = front.getLeft();
			fromTrailerToFront = -1;
			}
		}

	// if the key wasn't in the tree
		if (front == null){
			return;
		}

	// if we get here
	// front points to the node we want to delete
	// and trailer points to the one above it

	// case 1 -- the node we want to delete is a leaf
		if (front.getLeft() == null &&
			front.getRight() == null) {

	    // repoint front's parent to null
			if (fromTrailerToFront == 1) {
				trailer.setRight(null);
			} else {
				trailer.setLeft(null);
			}
			
		
		} else if ( /* check to see if front has one child */ !((front.getRight() == null && front.getLeft() == null) && (front.getRight() != null && front.getLeft() != null))){
	    // repoint front's parent to front's child
		
			if ((fromTrailerToFront == 1) && (front.getLeft() == null)) { //del target is a right child and has a right child
				trailer.setRight(front.getRight());
		
			} else if ((fromTrailerToFront == 1) && (front.getRight() == null)) { //del target is a right child and has a left child
			
				trailer.setRight(front.getLeft());
			} else if ((fromTrailerToFront == -1) && (front.getLeft() == null)) { //del target is a left child and has a right child
				trailer.setLeft(front.getRight());
			} else if ((fromTrailerToFront == -1) && (front.getRight() == null)) { //del target is a left child and has a left child
				trailer.setLeft(front.getLeft());
			}
		}
	    // front has two children
	    
		if ((front.getRight() != null) && (front.getLeft() != null)) {
			// make a new pointer (usurper) and send it to the appropriate leaf.
			// set the pointers of the leaf to the getRight and getLeft of the del target. But in some cases this means that you're setting a node's pointer to itself.
			// set the appropriate pointer of the Trailer to usurper.
			
			TreeNode usurper;
			usurper = front;
			while (!(usurper.getLeft() == null && usurper.getRight() == null)) { //while usurper isn't a leaf
				//if usurper = front, move left. The move right until you are at a leaf.
				if (usurper == front) {
					usurper = usurper.getLeft();
				} else {
					usurper = usurper.getRight();
				}
			} //now usurper is at the greatest value less than the del target, which is front. And we know this exists, because front has two children.
				
			usurper.setRight(front.getRight());
			
			if (!(front.getLeft() == usurper)) {
				usurper.setLeft(front.getLeft());
			}
			
			
			// if (front != root) { Last problem with delete: you get an infinite loop when you try to delete the head. It has something to do with setting the pointers of the trailer. I haven't figured it out yet. Other than that it seems to work.
				if (trailer.getLeft() == front) {
					trailer.setLeft(usurper);
				} else {
					trailer.setRight(usurper);
				}
				//if usurper = front, and front 
			}
		
	    // find the node with the largest value
	    // on fronts left subtree
	    // and replace front with it.
		
	
		}


	
	}
}