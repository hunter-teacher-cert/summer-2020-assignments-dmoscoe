import java.util.*;
import java.io.*;

/* Working on selection sort */

public class Scratch0843 {

  //return ArrayList of random ints on range [lo,lo+hi)
  public static ArrayList prestoArrayListo(int numItems, int lo, int hi)
  {
    ArrayList retArr = new ArrayList();

    for(int i=0; i<numItems; i++) {
      //System.out.println(i);  //diagnostic under-the-hood view
      //retArr.add( Math.random() ); // [0,1)
      //retArr.add( (int)Math.random() ); // 0
      //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
      retArr.add( lo + (int)(hi * Math.random()) ); // // At each location in the array, add a random int on [lo,lo+hi). The lower bound occurs when Math.random() returns 0. The upper bound is approached when Math.random approaches 1.
	}
    return retArr; //the array is not sorted.
  }//end prestoArrayListo()
  
// 	public static ArrayList swapper(ArrayList al, int a, int b) { //Topher said this should be void, I think.
	/* Takes an ArrayList of ints called al, and returns an ArrayList of ints in which the entries at index = a and index = b are exchanged. */
	
		/* check conditions */
		
/* 		if (al.size() < 2 || a < 0 || b < 0 || a > (al.size() - 1) || b > (al.size() - 1)) {
			return al;
		}
		
		/* initialize variables */
/* 		ArrayList returnArray = new ArrayList();
		int i = 0; //a counter for traversing al
		int endValAta = (int) al.get(b); //in the returned array, the value at index a is the value in al at b.
		int endValAtb = (int) al.get(a); //in the returned array, the value at index b is the value in al at a.
				
		while (i < al.size()) {
			if (i == a) {
				returnArray.add(i, endValAta);
			} else if (i == b) {
				returnArray.add(i, endValAtb);
			} else if ((i != a) && (i != b)) {
				returnArray.add(i, al.get(i));
			}
			i++;
		}
		return returnArray;
	}  */

	
	public static void swapper(ArrayList al, int a, int b) {
		
		if (!(al.size() < 2 || a < 0 || b < 0 || a > (al.size() - 1) || b > (al.size() - 1))) {
					
		int endValAta = (int) al.get(b);
		int endValAtb = (int) al.get(a);
		al.set(a, endValAta);
		al.set(b, endValAtb);
		}
	}
	
	public static int min(ArrayList al, int left, int right) {
		/* Takes an ArrayList of ints and returns the index of the minimum value occurring between indices left and right, inclusive. */
		
		/* check conditions */
		
		if (al.size() == 0 || left > right || left < 0 || right < 0 || left > (al.size() - 1) || right > (al.size() - 1)) {
			return -1;
		}
		
		/* initialize variables */
		
		int min = (int) al.get(left);
		
		for (int i = left; i <= right; i++) {
			if ((int) al.get(i) < min) {
				min = (int) al.get(i);
			}
		}
		return min;
	}
	
	
	
	public static void selectionSort(ArrayList al) {
		/* Takes an ArrayList of ints and sorts it in ascending order. */
	}
		
	
	
	
	
/* 	public static void main(String[] args) {
		ArrayList sample = new ArrayList();
		sample = prestoArrayListo(10,0,50);
		System.out.println(sample.toString());
		System.out.println(swapper(sample, 2, 6).toString());
		System.out.println();
		System.out.println("Testing min");
		System.out.println("min(sample, 0, 9) = " + min(sample, 0, 9));
		System.out.println("min(sample, 1, 9) = " + min(sample, 1, 9));
		System.out.println("min(sample, 2, 9) = " + min(sample, 2, 9));
		System.out.println("min(sample, 2, 8) = " + min(sample, 2, 8));
		System.out.println("min(sample, 2, 7) = " + min(sample, 2, 7));
		System.out.println("min(sample, 0, 0) = " + min(sample, 0, 0));
		System.out.println("min(sample, 9, 9) = " + min(sample, 9, 9));
		System.out.println("min(sample, -2, 9) = " + min(sample, -2, 9));
		System.out.println("min(sample, 0, 15) = " + min(sample, 0, 15));
		
		
	
	} */
	
	public static void main(String[] args) {
		ArrayList sample = new ArrayList();
		sample = prestoArrayListo(10,0,50);
		System.out.println(sample.toString());
		swapper(sample, 4, 6);
		System.out.println(sample.toString());
		swapper(sample, 3, 7);
		System.out.println(sample.toString());
	}
		
}
	