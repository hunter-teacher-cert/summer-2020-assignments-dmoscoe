import java.io.*;
import java.util.*;

/* xDiagram the plan for MSort. xImplement subgoals of merge(). */

public class MSort {

	public static ArrayList<Integer> slice(ArrayList<Integer> al, int lo, int hi) {
		ArrayList<Integer> sub = new ArrayList<Integer>();
		for (; lo < hi; lo++) {
			sub.add(al.get(lo));
		}
		return sub;
	}
	
	public static ArrayList<Integer> prestoArrayListo(int numItems, int lo, int hi) {
		ArrayList<Integer> retArr = new ArrayList<Integer>();
		for (int i = 0; i < numItems; i++) {
			retArr.add(lo + (int)(hi * Math.random()));
		}
		return retArr;
	}
	
	public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		
		/* initialize variables */
		
		ArrayList<Integer> retArr = new ArrayList<Integer>();
		int aPointer = 0;
		int bPointer = 0;
		
		while (aPointer < a.size() && bPointer < b.size()) {
			if (a.get(aPointer) < b.get(bPointer)) {
				retArr.add(a.get(aPointer));
				aPointer++;
			} else {
				retArr.add(b.get(bPointer));
				bPointer++;
			}
		}
		
		if (aPointer < a.size() - 1) {
			while (aPointer < a.size()) {
				retArr.add(a.get(aPointer));
				aPointer++;
			}
		} else if (bPointer < b.size() - 1) {
			while (bPointer < b.size()) {
				retArr.add(b.get(bPointer));
				bPointer++;
			}
		}
		
		return retArr;
	}

  public static int findSmallest(ArrayList<Integer> al, int lo, int hi){
    int maxIndexSoFar = lo;
    for (int i = lo; i <=hi; i++) {
      if (al.get(i) < al.get(maxIndexSoFar)){
        maxIndexSoFar = i;
      }
    }
    return maxIndexSoFar;
  }

  public static void selectionSort(ArrayList<Integer> al) {

    int lo = 0;
    int temp;

    for (int i=0; i < al.size() - 1; i++) {
      lo = findSmallest(al, i, al.size()-1);
      temp = al.get(i);
      al.set(i, al.get(lo));
      al.set(lo, temp);
    }

  }//selectionSort


	public static void main(String[] args) {
		ArrayList<Integer> test = new ArrayList<Integer>();
		ArrayList<Integer> sub = new ArrayList<Integer>();
		test.add(36);
		test.add(49);
		System.out.println(test.toString());
		
		int lo = 1;
		int hi = 2;
		
		for(; lo < hi; lo++) {
			sub.add(test.get(lo));
			System.out.println(sub.toString());
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		ArrayList<Integer> aa = new ArrayList<Integer>();
		ArrayList<Integer> bb = new ArrayList<Integer>();
		aa = prestoArrayListo(9,50,150);
		bb = prestoArrayListo(15,100,200);
		selectionSort(aa);
		selectionSort(bb);
		System.out.println(aa.toString());
		System.out.println(slice(aa,2,5).toString());
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("aa = " + aa.toString());
		System.out.println("bb = " + bb.toString());
		System.out.println("merge(aa,bb) = " + merge(aa, bb));
}
}