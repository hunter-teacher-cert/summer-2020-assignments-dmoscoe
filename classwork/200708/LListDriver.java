import java.io.*;
import java.util.*;

public class LListDriver {
  public static void main(String[] args) {

    LList g = new LList();

    System.out.println("Test Empty list print & isEmpty:");
    System.out.println(g);
    System.out.println(g.isEmpty());
	System.out.println("Does g.length() = 0? g.length() = " + g.length());


    System.out.println("\nTest addFront 3x & isEmpty():");
    g.addFront("good");
	System.out.println("Does g.length() = 1? g.length() = " + g.length());
    g.addFront("news");
	System.out.println("Does g.length() = 2? g.length() = " + g.length());
    g.addFront("everyone!");
	System.out.println("Does g.length() = 3? g.length() = " + g.length());
    System.out.println(g);
    System.out.println(g.isEmpty());

   System.out.println("\nTest get 0, 1, 5:");
   System.out.println(g.get(0));
   System.out.println(g.get(1));
   System.out.println(g.get(5)); //returns an exception


   System.out.println("\nTest set 0, 1, 5:");
   g.set(0, "me!");
   g.set(1, "job");
   g.set(5, "wow"); //returns an exception
   System.out.println(g);

   System.out.println("\nTest insert 0, 2, 5, 10:");
   g.insert(0, "woo!");
   System.out.println("Does g.length() = 4? g.length() = " + g.length());
   g.insert(2, "go");
   System.out.println("Does g.length() = 5? g.length() = " + g.length());
   g.insert(5, "cool");
   System.out.println("Does g.length() = 6? g.length() = " + g.length());
   g.insert(10, "too far"); //returns an exception
   System.out.println(g);

   System.out.println("\nTest search \"woo!\", \"cool\", \"too far\"");
   System.out.println(g.search("woo!"));
   System.out.println(g.search("cool"));
   System.out.println(g.search("too far")); //returns an exception

   System.out.println("\nTest remove 0, 2:");
   g.remove(0);
   System.out.println("Does g.length() = 5? g.length() = " + g.length());
   System.out.println(g);
   g.remove(2);
   System.out.println("Does g.length() = 4? g.length() = " + g.length());
   System.out.println(g);

  }//main
}//LListDriver