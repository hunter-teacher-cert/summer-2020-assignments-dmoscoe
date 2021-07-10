import java.util.*;
import java.io.*;

public class binSearchTester {
	
	public static int binSearch(ArrayList al, int target) {
		/* Check some initial conditions: */
		
		if (al.size() == 0 || target < (int) al.get(0) || target > (int) al.get(al.size() - 1)) {
			return -1;
		}
		
		/* Set up variables */
		
		int loBound = 0;
		int hiBound = al.size() - 1;
		int compareToTarget = (loBound + hiBound) / 2;
		
		/* Start searching! */
		
		while (loBound <= hiBound) {
			if ((int) al.get(compareToTarget) == target) {
				return compareToTarget;
			} else if ((int) al.get(compareToTarget) < target) {
				loBound = compareToTarget + 1;
				compareToTarget = (loBound + hiBound) / 2;
			} else if ((int) al.get(compareToTarget) > target) {
				hiBound = compareToTarget - 1;
				compareToTarget = (loBound + hiBound) / 2;
			}
		}
		
		/* If you didn't find it: */
		
		return -1;
	}
	
	
	public static ArrayList sortedArrayList(int size, int lo, int hi) {
		ArrayList retArr = new ArrayList();
		
		/* populate 0th position */
		
		retArr.add((int) (lo + Math.random())); //different than Topher's.
		
		/* populate remainder of ArrayList */
		
		for (int i = 1; i < size; i++) {
			retArr.add((int) retArr.get(i - 1) + lo + (int) (hi * Math.random())); //Each successive element is its predecessor plus at least lo, and at most lo + hi.
		}
		return retArr;
	}
	
	public static void main(String[] args) {
		
		for (int i = 100; i < 200; i++) {
			ArrayList al = new ArrayList();
			al = sortedArrayList(i,0,10);
			System.out.println(al.toString());
			System.out.println("Java found 41 at index = " + al.indexOf(41));
			System.out.println("binSearch found 41 at indes = " + binSearch(al,41));
			System.out.println("**********");
			System.out.println("");
		}
	}
}