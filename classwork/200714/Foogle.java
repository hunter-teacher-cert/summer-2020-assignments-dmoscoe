/**
   classwork -- Day 10 | 0b1010 | 0x10
   class: Foogle
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

public class FoogleScratch2016
{

  //  <Returns the position of a specific integer element in an ArrayList. If the element isn't there, returns -1.>
  public static int Search( ArrayList al, int target )
  {
    for( int pos=0; pos<al.size(); pos++) {
      if (al.get(pos).equals(target))
        return pos;
    }
    return -1;
  }//end Search()


  //  <Returns an ArrayList of random ints on [lo, lo + hi).>
  public static ArrayList makeRandomArray(int numItems, int lo, int hi)
  {
    ArrayList retArr = new ArrayList();

    for(int i=0; i<numItems; i++) {
      //System.out.println(i);  //diagnostic under-the-hood view
      //retArr.add( Math.random() ); // [0,1)
      //retArr.add( (int)Math.random() ); //0
      //retArr.add( (int)(hi * Math.random()) ); // [0, hi)
      retArr.add( lo + (int)(hi * Math.random()) ); // [lo, lo + hi)
    }
    return retArr;
  }//end makeRandomArray()


  //  <Returns an ArrayList of random ints on [lo, (numItems * lo) + hi * (numItems - 1)>
  public static ArrayList randomStaircase(int numItems, int lo, int hi)
  {
    ArrayList retArr = new ArrayList();

    // <A zero-element ArrayList special case>
    if ( numItems<1 )
      return retArr;

    // <Adds to the array an int between [0,lo - 1]>
    retArr.add( (int)(lo * Math.random()) );

    // <You're generating a list of numbers that's non-decreasing, and the change over the previous number is a random int between lo and lo + hi - 1>
    for(int i=1; i<numItems; i++) {
      //System.out.println(i);  //diagnostic under-the-hood view
      //retArr.add( Math.random() ); // [0,1)
      //retArr.add( (int)Math.random() ); //0
      //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
      //retArr.add( lo + (int)(hi * Math.random()) ); // [lo,hi+lo)
      //System.out.println(retArr.get(i-1));  //diag.
      retArr.add( (int)retArr.get(i-1)
                  + lo + (int)(hi * Math.random()) );
    }

    return retArr;
  }//end randomStaircase()


  public static void main( String[] args )
  {
    System.out.println("test battery for makeRandomArray()");
    /*~~~~v~~~~~~move~me~down~~~1~block~at~a~time~~~~~~~~~~v~~~~ */
    System.out.println("\n"+"al000"+":");
    ArrayList al000 = makeRandomArray(0,0,0);
    System.out.println(al000);
    System.out.println(Search(al000,3));
    System.out.println("\n"+"al01"+":");
    ArrayList al01 = makeRandomArray(5,0,100);
    System.out.println(al01);
    System.out.println(Search(al01,3));
    System.out.println("\n"+"al02"+":");
    ArrayList al02 = makeRandomArray(5,3,10);
    System.out.println(al02);
    System.out.println(Search(al02,3));
    System.out.println("\n"+"al05"+":");
    ArrayList al05 = makeRandomArray(20,1,5);
    System.out.println(al05);
    System.out.println(Search(al05,3));
      


    System.out.println("test battery for randomStaircase()");
    /*~~~~v~~~~~~move~me~down~~~1~block~at~a~time~~~~~~~~~~v~~~~ */
    System.out.println("\n"+"sal000"+":");
    ArrayList sal000 = randomStaircase(0,0,0);
    System.out.println(sal000);
    System.out.println(Search(sal000,3));
    System.out.println("\n"+"sal00"+":");
    ArrayList sal00 = randomStaircase(5,0,100);
    System.out.println(sal00);
    System.out.println(Search(sal00,3));
    System.out.println("\n"+"sal01"+":");
    ArrayList sal01 = randomStaircase(5,0,100);
    System.out.println(sal01);
    System.out.println(Search(sal01,3));
    System.out.println("\n"+"sal02"+":");
    ArrayList sal02 = randomStaircase(5,3,100);
    System.out.println(sal02);
    System.out.println(Search(sal02,3));
    System.out.println("\n"+"sal03"+":");
    ArrayList sal03 = randomStaircase(5,0,100);
    System.out.println(sal03);
    System.out.println(Search(sal03,3));
    System.out.println("\n"+"sal04"+":");
    ArrayList sal04 = randomStaircase(20,0,3);
    System.out.println(sal04);
    System.out.println(Search(sal04,3));
    System.out.println("\n"+"sal05"+":");
    ArrayList sal05 = randomStaircase(20,1,5);
    System.out.println(sal05);
    System.out.println(Search(sal05,3));
      

    
    System.out.println("\n"+"al"+":");
    ArrayList al = makeRandomArray(32,0,100);
    System.out.println(al);

  }//end main

}//end class