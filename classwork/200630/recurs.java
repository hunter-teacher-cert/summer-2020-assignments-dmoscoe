import java.util.*;
import java.io.*;

public class recurs {
	
	//Write and test methods for: recursive factorial, factorial(n); recursive Fibonacci, fib(n);
	
	//Write trace diagrams for factorial and fib. What are similarities? What are differences?
	
	//Add ack() from prework to this file.
	
	//Challenge: Write a recursive function that will find the sum of the elements of an int[].
	
	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
	
	public static int fib(int n) {
		if (n < 1) {
			return -1;
		} else if ((n == 1) || (n == 2)) {
			return 1;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}
	
	public static int ack(int m, int n) {
		if (m == 0) {
			return n + 1;
		} else if ((m > 0) && (n == 0)) {
			return ack(m - 1, 1);
		} else {
			return ack(m - 1, ack(m, n - 1));
		}
	}
	/*
	public static int recursSum(int[] a) {
		if (a.length == 0) {
			return 0;
		} else {
			return a[a.length - 1]  + recurssum
			
			*/
			
	public static int recursSum(int[] a) {
		if (a.length == 0) {
			return 0;
		} else if (a.length == 1) {
			return a[0];
		} else {
			return a[a.length - 1] + recursSum(Arrays.copyOf(a, a.length - 1));
		}
	}
	
	public static void main(String[] args) {
		int[] b = new int[5];
		b[0] = 9;
		b[1] = 8;
		b[2] = 7;
		b[3] = 6;
		b[4] = 5;
		
		System.out.println("recursSum(b) expected output = 35. Actual output = " + recursSum(b));
		
		System.out.println("fib(6) expected output = 8. Actual output = " + fib(6));
		System.out.println("factorial(6) expected output = 720. Actual output = " + factorial(6));
	}
}

/*

4. Trace diagram for factorial:

factorial(5):
  It's not 1, so:
    Return 5 * factorial(4):
	  = 5 * 4 * factorial(3):
	  .
	  .
	  .
	  = 5 * 4 * 3 * 2 * 1!
	  = 5 * 4 * 3 * 2 * 1.
	  = 120.

fib(5):
 n != 1 and n != 2, so:
   return fib(4) + fib(3):
   return fib(3) + fib(2) + fib(2) + fib(1)
   return fib(2) + fib(1) + 1 + 1 + 1
   return 1 + 1 + 1 + 1 + 1
   = 5.

The traces are similar because they both show how the method calls itself for smaller and
smaller values of input, until the method simply returns the base case. They're
different because while factorial has 1 base case, 0! = 1, fib has two base cases: fib(1) = fib(2) = 1.
Each call of fib results in two more instances of fib added to the trace diagram. */