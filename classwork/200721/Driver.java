import java.io.*;
import java.util.*;


public class Driver {
	public static void main(String[] args) {
		BSTree t = new BSTree();

		t.seed();
		int value;

/* 		value = t.search(10);
		System.out.println(value);

		value = t.search(15);
		System.out.println(value);

		try {
			value = t.search(17);
			System.out.println(value);
		} catch (NullPointerException e) {
			System.out.println("17 not in tree");
		}
 */	
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
			
		t.preorderTraverse();
	
	}
}