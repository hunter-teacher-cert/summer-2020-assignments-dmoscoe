import java.io.*;
import java.util.*;

public class BSTree {
    private TreeNode root;

    public BSTree(){
	root = null;
    }

	public int search(int key){
		TreeNode current = root;

		while (!(current.getLeft() == null && current.getRight() == null)){ //This doesn't search the last leaves on the tree. I have to change it but I don't know how yet.
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