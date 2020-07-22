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
	
	//base case: the tree is empty.
	
	if (root == null) {
		return;
	}
	
	//if front is a right child, fromTrailerToFront = 1. If front is a left child, -1.
	
	int fromTrailerToFront = 0;
	
	//Use piggybacking to place front at the target for deletion, and trailer at its parent.
	
	TreeNode front = root;
	TreeNode trailer = root;
	
	while ((front != null) && (front.getData() != key)) {
		if (front.getData() < key) {
			trailer = front;
			front = front.getRight();
			fromTrailerToFront = 1;
		} else {
			trailer = front;
			front = front.getLeft();
			fromTrailerToFront = -1;
		}
	}
	
	//now front is the deletion target, and trailer is its parent. Or, if the deletion target is the root, then front and trailer both equal root, and fromTrailerToFront = 0.
	
	//if the key was not in the tree:
	
	if (front == null) {
		return;
	}
	
	//case 1: the deletion target is a leaf.
	
	if ((front.getLeft() == null) && (front.getRight() == null)) {
		
		//set corresponding pointer on trailer to null.
		
		if (fromTrailerToFront == 1) {
			trailer.setRight(null);
		} else {
			trailer.setLeft(null);
		}
	}
	
	//case 2: the deletion target has one child.
	
	if (!((front.getRight() == null && front.getLeft() == null) && (front.getRight() != null && front.getLeft() != null))) {
		
		//set corresponding pointer on trailer to front's child.
		
			//case 2a: deletion target is a right child and has a right child
			
			if ((fromTrailerToFront == 1) && (front.getLeft() == null)) {
				trailer.setRight(front.getRight());
			}
			
			//case 2b: deletion target is a right child and has a left child
			
			else if ((fromTrailerToFront == 1) && (front.getRight() == null)) {
				trailer.setRight(front.getLeft());
			}
			
			//case 2c: deletion target is a left child and has a right child
			
			else if ((fromTrailerToFront == -1) && (front.getLeft() == null)) {
				trailer.setLeft(front.getRight());
			}
			
			//case 2d: deletion target is a left child and has a left child
			
			else if ((fromTrailerToFront == -1) && (front.getRight() == null)) {
				trailer.setLeft(front.getLeft());
			}
	}
	
	//case 3: the deletion target has two children.
	
	if ((front.getRight() != null) && (front.getLeft() != null)) {
		
		//declare usurper and usurperTrailer. Usurper will point to the greatest-valued TreeNode less than the value of the deletion target. usurperTrailer will point to usurper's parent.
		
		TreeNode usurper;
		usurper = front;
		TreeNode usurperTrailer;
		usurperTrailer = front;
		
		int fromUsurperTrailerToUsurper = 0;
		
		//while usurper isn't a leaf, climb the tree starting at front. Move left first, then right.
		
		while (!((usurper.getLeft() == null) && (usurper.getRight() == null))) {
		
			//at first, usurper == front, so move left.
			
			if (usurper == front) {
				usurperTrailer = usurper;
				usurper = usurper.getLeft();
				fromUsurperTrailerToUsurper = -1;
			}
			
			//then, move right until usurper is a leaf.
			
			else {
				usurperTrailer = usurper;
				usurper = usurper.getRight();
				fromUsurperTrailerToUsurper = 1;
			}
		}
			
		//detach the leaf usurper from its parent.
	
		if (fromUsurperTrailerToUsurper == -1) {
			usurperTrailer.setLeft(null);
		}
		
		else if (fromUsurperTrailerToUsurper == 1) {
			usurperTrailer.setRight(null);
		}
		
		//attach usurper to its new children.
		
		usurper.setRight(front.getRight());
		usurper.setLeft(front.getLeft());
		
		//detach front from its children.
		
		front.setRight(null);
		front.setLeft(null);
		
		//detach front from its parent and attach the parent to usurper.
		
		if (fromTrailerToFront == -1) {
			trailer.setLeft(usurper);
		}
		
		else if (fromTrailerToFront == 1) {
			trailer.setRight(usurper);
		}
	
		//if the deletion target is root, then point root to the new root.
		
		if (root.getLeft() == null && root.getRight() == null) {
			root = usurper;
		}
	}
}


	
	}

