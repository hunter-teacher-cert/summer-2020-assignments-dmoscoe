import java.io.*;
import java.util.*;


public class Driver {
	public static void main(String[] args) {
		BSTree t = new BSTree();

		t.seed();
		int value;

 		value = t.search(10);
		System.out.println(value);

		value = t.search(15);
		System.out.println(value);

		try {
			value = t.search(17);
			System.out.println(value);
		} catch (NullPointerException e) {
			System.out.println("17 not in tree");
		}
	
		//Testing insert:
		
//		t.insert(3);
		
		//If 3 is in the right place, then we should be able to search for it:
		
//		System.out.println(t.search(3));
		
		//And if 3 is in the right place we should also be able to search for 5:
		
//		System.out.println(t.search(5));
		
	
// 		t.insert(11);
//		t.insert(50);
		
//		System.out.println(t.search(11));
//		System.out.println(t.search(50));
		
		System.out.println("preorderTraverse: ");
		t.preorderTraverse();
		System.out.println();
		System.out.println();
		
		System.out.println("postorderTraverse: ");
		t.postorderTraverse();
		System.out.println();
		System.out.println();
		
		System.out.println("inorderTraverse: ");
		t.inorderTraverse();
		System.out.println();
		System.out.println();
		
		//build a fresh tree each time and test delete on each element of a fresh tree.
		
		System.out.println("Testing t.delete(20): ");
		t.delete(20);
		t.inorderTraverse();
		System.out.println();
		
 		BSTree u = new BSTree();
		u.seed();
		System.out.println("Testing u.delete(10): ");
		u.delete(10);
		u.inorderTraverse();
		System.out.println(); 
		
		BSTree v = new BSTree();
		v.seed();
		System.out.println("Testing v.delete(5): ");
		v.delete(5);
		v.inorderTraverse();
		System.out.println();
		
		BSTree w = new BSTree();
		w.seed();
		System.out.println("Testing w.delete(8): ");
		w.delete(8);
		w.inorderTraverse();
		System.out.println();
	
		BSTree x = new BSTree();
		x.seed();
		System.out.println("Testing x.delete(15): ");
		x.delete(15);
		x.inorderTraverse();
		System.out.println();
		
		BSTree y = new BSTree();
		y.seed();
		System.out.println("Testing y.delete(22): ");
		y.delete(22);
		y.inorderTraverse();
		System.out.println();
		
		BSTree z = new BSTree();
		z.seed();
		System.out.println("Testing z.delete(99): ");
		z.delete(99);
		z.inorderTraverse();
		System.out.println();
	}
}