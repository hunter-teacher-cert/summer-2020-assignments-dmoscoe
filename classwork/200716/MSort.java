import java.util.*;
import java.io.*;

public class MSort {
	
	// BEGIN METHODS FOR MERGESORT
	
	public static ArrayList<Integer> mergeSort(ArrayList<Integer> al) {
		
		// base case:
		
		if (al.size() <= 1) {
			return al;
		}
		
		// find mid and create two sublists:
		
		int mid = al.size() / 2;
		ArrayList<Integer> botHalf = slice(al, 0, mid);
		ArrayList<Integer> topHalf = slice(al, mid, al.size());
		
		// recursive step:
		
		return merge(mergeSort(botHalf), mergeSort(topHalf));
		
	}
	
	public static ArrayList<Integer> slice(ArrayList<Integer> al, int lo, int hi) {
		ArrayList<Integer> sub = new ArrayList<Integer>();
		for (; lo < hi; lo++) {
			sub.add(al.get(lo));
		}
		return sub;
	}
	
	//prestoArrayListo returns an unsorted ArrayList of random Integers on [lo, hi].
	
	public static ArrayList<Integer> prestoArrayListo(int numItems, int lo, int hi) {
		ArrayList<Integer> retArr = new ArrayList<Integer>();
		for (int i = 0; i < numItems; i++) {
			retArr.add(lo + (int)((hi - lo + 1) * Math.random()));
		}
		return retArr;
	}
	
	public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		
		// initialize variables
		
		ArrayList<Integer> retArr = new ArrayList<Integer>();
		int aPointer = 0;
		int bPointer = 0;
		
		// while both arrays contain uncompared elements:
		
		while (aPointer < a.size() && bPointer < b.size()) {
			if (a.get(aPointer) < b.get(bPointer)) {
				retArr.add(a.get(aPointer));
				aPointer++;
			} else {
				retArr.add(b.get(bPointer));
				bPointer++;
			}
		}
		
		// when one array is exhausted:
		
		while (aPointer < a.size()) {
			retArr.add(a.get(aPointer));
			aPointer++;
		}
		
		while (bPointer < b.size()) {
			retArr.add(b.get(bPointer));
			bPointer++;
		}
	
		return retArr;
	}
	
	//END METHODS FOR MERGESORT
	
	//BEGIN METHODS FOR SELECTIONSORT
	
	//findSmallest returns the index of the minimum value on the region of al with indexes on [lo, hi].
	
	public static int findSmallest(ArrayList<Integer> al, int lo, int hi) {
		int maxIndexSoFar = lo;
		for (int i = lo; i <= hi; i++) {
			if (al.get(i) < al.get(maxIndexSoFar)) {
				maxIndexSoFar = i;
			}
		}
		return maxIndexSoFar;
	}
	
	public static void selectionSort(ArrayList<Integer> al) {
		
		int lo = 0;
		int temp;
		
		for (int i = 0; i < al.size() - 1; i++) {
			lo = findSmallest(al, i, al.size() - 1);
			temp = al.get(i);
			al.set(i, al.get(lo));
			al.set(lo, temp);
		}
	}
	
	//END METHODS FOR SELECTIONSORT
	
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		ArrayList<Integer> e = new ArrayList<Integer>();
		ArrayList<Integer> aa = new ArrayList<Integer>();
		ArrayList<Integer> bb = new ArrayList<Integer>();
		ArrayList<Integer> cc = new ArrayList<Integer>();
		ArrayList<Integer> dd = new ArrayList<Integer>();
		ArrayList<Integer> ee = new ArrayList<Integer>();
		
		a = prestoArrayListo(10,0,100000);
		b = prestoArrayListo(100,0,100000);
		c = prestoArrayListo(1000,0,100000);
		d = prestoArrayListo(10000,0,100000);
		e = prestoArrayListo(100000,0,100000);
	
		long aStartMerge = System.currentTimeMillis();
		aa = mergeSort(a);
		long aEndMerge = System.currentTimeMillis();
		
		long bStartMerge = System.currentTimeMillis();
		bb = mergeSort(b);
		long bEndMerge = System.currentTimeMillis();
		
		long cStartMerge = System.currentTimeMillis();
		cc = mergeSort(c);
		long cEndMerge = System.currentTimeMillis();
		
		long dStartMerge = System.currentTimeMillis();
		dd = mergeSort(d);
		long dEndMerge = System.currentTimeMillis();
		
		long eStartMerge = System.currentTimeMillis();
		ee = mergeSort(e);
		long eEndMerge = System.currentTimeMillis();
		
		System.out.println("(size, time to mergeSort (ms)): (10," + " " + (aEndMerge - aStartMerge) + ")");
		System.out.println("(size, time to mergeSort (ms)): (100," + " " + (bEndMerge - bStartMerge) + ")");
		System.out.println("(size, time to mergeSort (ms)): (1000," + " " + (cEndMerge - cStartMerge) + ")");
		System.out.println("(size, time to mergeSort (ms)): (10000," + " " + (dEndMerge - dStartMerge) + ")");
		System.out.println("(size, time to mergeSort (ms)): (100000," + " " + (eEndMerge - eStartMerge) + ")");
		
		long aStartSelect = System.currentTimeMillis();
		selectionSort(a);
		long aEndSelect = System.currentTimeMillis();
		
		long bStartSelect = System.currentTimeMillis();
		selectionSort(b);
		long bEndSelect = System.currentTimeMillis();
		
		long cStartSelect = System.currentTimeMillis();
		selectionSort(c);
		long cEndSelect = System.currentTimeMillis();
		
		long dStartSelect = System.currentTimeMillis();
		selectionSort(d);
		long dEndSelect = System.currentTimeMillis();
		
		long eStartSelect = System.currentTimeMillis();
		selectionSort(e);
		long eEndSelect = System.currentTimeMillis();
		
		System.out.println("(size, time to selectionSort (ms)): (10," + " " + (aEndSelect - aStartSelect) + ")");
		System.out.println("(size, time to selectionSort (ms)): (100," + " " + (bEndSelect - bStartSelect) + ")");
		System.out.println("(size, time to selectionSort (ms)): (1000," + " " + (cEndSelect - cStartSelect) + ")");
		System.out.println("(size, time to selectionSort (ms)): (10000," + " " + (dEndSelect - dStartSelect) + ")");
		System.out.println("(size, time to selectionSort (ms)): (100000," + " " + (eEndSelect - eStartSelect) + ")");
		
		}
}