/**
   classwork -- Day 10 | 0b1010 | 0x10
   class: Boogle
   A tester class for code analysis and search exploration.
   USAGE:
   Read through at least once.
   Compile, run.
   Comment/uncomment lines, recompile, run to explore functionality.
   "Lather, rinse, repeat" until comprehension achieved.
   Rename methods to indicate purpose.
   Insert comment preceding each method to summarize functionality.
   T. Mykolyk, F. Dragon
   June 2020
**/

import java.io.*;
import java.util.*;

public class BoogleScratch2016
{

  //return index of first occurence of target, or -1 if not found
  public static int linSearch( ArrayList al, int target )
  {
    for( int pos=0; pos<al.size(); pos++) {
      if (al.get(pos).equals(target))
        return pos;
    }
    return -1;
  }//end linSearch()






/*Commented out this method 200715 2045 to make way for new draft.

  //return index of target, or -1 if not found
  public static int binSearch( ArrayList al, int target ) { //if there are multiple occurrences of target, this might not find the first occurrence. Also this doesn't work in some cases. Like when target is at index 0, or when al is very short. Actually it seems to be working now, except for length = 0.
//	if (al.size() < 3) {
//		return linSearch(al, target);
//	}
	if (al.size() == 0) {
		return -1;
	}
	int leftBound = 0;
	int rightBound = al.size() - 1;
	while (rightBound - leftBound > 1) {
		if ((int) al.get((leftBound + rightBound) / 2) == target) {
			return (leftBound + rightBound) / 2;
		} else if ((int) al.get((leftBound + rightBound) / 2) < target) {
			leftBound = ((leftBound + rightBound) / 2) + 1; //+1?
		} else if ((int) al.get((leftBound + rightBound) / 2) > target) {
			rightBound = ((leftBound + rightBound) / 2 - 1); //-1? You need to make sure that the search space shrinks on every round.
		}
	}
	if ((int)al.get(leftBound) == target) {
		return leftBound;
	} else if ((int)al.get(rightBound) == target) {
		return rightBound;
	}
		return -1;
	}
    // <INSERT YOUR MACHINERY HERE>...
	//placeholder to get past compiler
  //end binSearch()

End 200715 2045 comment */

  // subgoal: recognize target found (and take what action?)
  // subgoal: recognize search space exhausted (and take what action?)
  // subgoal: recognize target in lower portion of range (and do what?)
  // subgoal: recognize target in upper portion of range (and do what?)

  //nota bene: A helper method could be very useful.
  // Q: Why?
  // Q: What would the parameters be for such a method?

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


  //return ArrayList of random ints, sorted in ascending order
  public static ArrayList prestoSortedArrayListo(int numItems,
                                                 int lo, int hi)
  {
    ArrayList retArr = new ArrayList();

    //if requested, return empty ArrayList
    if ( numItems<1 )
      return retArr;

    //populate index 0
    retArr.add( (int)(lo + lo * Math.random()) ); //!!! added lo +

    //populate rest of indices, each one greater than last
    for(int i=1; i<numItems; i++) {
      //System.out.println(i);  //diagnostic under-the-hood view
      //retArr.add( Math.random() ); // [0,1)
      //retArr.add( (int)Math.random() ); // 0
      //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
      //retArr.add( lo + (int)(hi * Math.random()) ); // [lo,lo+hi)
      //System.out.println(retArr.get(i-1));
      retArr.add( (int)retArr.get(i-1)
                  + lo + (int)(hi * Math.random()) ); // ["left neighbour",hi). Each successive entry in the array is at least lo greater than the preceding entry and at most lo + hi greater than the preceding entry.
    }

    return retArr; //the array is constructed so that it is "born sorted."
  }//end prestoSortedArrayListo()


  public static void main( String[] args )
  {
    /*~~~~v~~~~~~move~me~down~~~1~block~at~a~time~~~~~~~~~~v~~~~*/
    System.out.println("\n"+"al000"+":");
    ArrayList al000 = prestoArrayListo(0,0,0);
    System.out.println(al000);
    System.out.println(linSearch(al000,3));
    System.out.println("\n"+"al01"+":");
    ArrayList al01 = prestoArrayListo(5,0,100);
    System.out.println(al01);
    System.out.println(linSearch(al01,3));
    System.out.println("\n"+"al02"+":");
    ArrayList al02 = prestoArrayListo(5,3,10);
    System.out.println(al02);
    System.out.println(linSearch(al02,3));
    System.out.println("\n"+"al05"+":");
    ArrayList al05 = prestoArrayListo(20,1,5);
    System.out.println(al05);
    System.out.println(linSearch(al05,3));
    /*  ~~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~~*/


   //  test battery using sorted ArrayLists as search space
   // ~~~~v~~~~~~move~me~down~~~1~block~at~a~time~~~~~~~~~~v~~~~
    System.out.println("\n"+"sal000"+":");
    ArrayList sal000 = prestoSortedArrayListo(1,2,4);
    System.out.println(sal000);
    System.out.println(linSearch(sal000,3));
    System.out.println(binSearch(sal000,3));
    System.out.println("\n"+"sal00"+":");
    ArrayList sal00 = prestoSortedArrayListo(3,2,5); //
    System.out.println(sal00);
    System.out.println(linSearch(sal00,3));
    System.out.println(binSearch(sal00,3));
    System.out.println("\n"+"sal01"+":");
    ArrayList sal01 = prestoSortedArrayListo(5,0,100);
    System.out.println(sal01);
    System.out.println(linSearch(sal01,3));
    System.out.println(binSearch(sal01,3));
    System.out.println("\n"+"sal02"+":");
    ArrayList sal02 = prestoSortedArrayListo(5,3,100);
    System.out.println(sal02);
    System.out.println(linSearch(sal02,3));
    System.out.println(binSearch(sal02,3));
    System.out.println("\n"+"sal03"+":");
    ArrayList sal03 = prestoSortedArrayListo(5,0,100);
    System.out.println(sal03);
    System.out.println(linSearch(sal03,3));
    System.out.println(binSearch(sal03,3));
    System.out.println("\n"+"sal04"+":");
    ArrayList sal04 = prestoSortedArrayListo(20,0,3);
    System.out.println(sal04);
    System.out.println(linSearch(sal04,3));
    System.out.println(binSearch(sal04,3));
    System.out.println("\n"+"sal05"+":");
    ArrayList sal05 = prestoSortedArrayListo(20,1,5);
    System.out.println(sal05);
    System.out.println(linSearch(sal05,3));
    System.out.println(binSearch(sal05,3));
 //     ~~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~~*/

    //batch of commands for easier test case generation:
    /*
    System.out.println("\n"+"al"+":");
    ArrayList al = prestoArrayListo(,,);
    System.out.println(al);
    System.out.println(linSearch(al, ));
    System.out.println(binSearch(al, ));
    */
  }//end main

}//end class