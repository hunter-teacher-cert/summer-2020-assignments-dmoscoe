import java.io.*;
import java.util.*;

public class BSTree {
    private TreeNode root;

    public BSTree(){
	root = null;
    }

 	public int search(int key){
	
	/* run-time for search: In the worst case, the while loop would examine every node (each node has one child, and the key is the last node in the tree). This is linear run-time. In the best case, the while loop would examine log2 n nodes, where n is the number of "generations" or levels of the tree. This is logarithmic run-time. */
	
		TreeNode current = root;

		while (!(current == null)){
		

			int currentValue = current.getData();
			if (currentValue == key){
				return 1;
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

	root.getLeft().setRight( new TreeNode(8));

	t = new TreeNode(15);
	root.getRight().setLeft(t);

	t = new TreeNode(22);
	root.getRight().setRight(t);
	}
    
    
}