/** Think Java Chapter 8 exercises 1, 4, 5.

1. The goal of this exercise is to practice encapsulation with some of the examples in this chapter.
(1) Starting with the code in section 8.6, write a method called powArray that takes a double array, a, 
and returns a new array that contains the elements of a squared. Generalize it to take a second argument
and raise the elements of a to the given power.

(2) Starting with the code in section 8.10, write a method called histogram that takes an int array of scores
from 0 to (but not including) 100, and returns a histogram of 100 counters. Generalize it to take the number
of counters as an argument.

4. Write a method called indexOfMax that takes an array of integers and returns the index of the largest
element. Can you write this method using an enhanced for loop? Why or why not?

5. The Sieve of Eratosthenes is "a simple, ancient algorithm for finding all prime numbers up to any given limit,"
which you can read about at .... Write a method called sieve that takes an integer parameter, n, and returns a
boolean array that indicates, for each number from 0 to n - 1, whether the number is prime.

Plan: for every int i from 1 to n-1, build a boolean array with the sqrt of i (truncated) elements. Each element
is TRUE or FALSE if its index is a factor of i. Then build a new array where each element in the array is the 
union of the elements of each of i's arrays.

Step 1: for every int i from 1 to n-1, build a boolean array with the sqrt of i elements.
Step 2: set each element of these arrays to be the remainder when i is divided by 2, 3, .... (did this with method remainders.)
Step 3: if the array from remainders contains 0, then n is not prime. Build a method ZeroDetector, that returns FALSE if
the array contains 0 and TRUE if it does not.
Step 4: Build an array of the TRUEs and FALSEs returned when you loop through ZeroDetector and remainders. method main

*/
import java.util.Arrays;
import java.lang.Math;
import java.util.Scanner;
import java.util.Random;
public class ArrayExample {
	public static double[] powArray(double[] a, double exponent) {
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.pow(a[i], exponent);
		}
		return a;
	}
	
	public static int[] histogram(int[] scores, int counters) {
		int[] counts = new int[counters];
		for (int score : scores) {
			counts[(int) (score*(counters/100.0))]++;
		}
		return counts;
	}
	
	public static int indexOfMax(int[] values) {
		int climbingMax = values[0];
		int climbingIndexOfMax = 0;
		for (int i = 0; i < values.length; i++) { //Can't use an enhanced for loop here. That's because the enhanced for loop iterates across the values in the array, and not the indices of the array. But since we need to return the index of the max value, we can't use an enhanced for loop.
			if (values[i] > climbingMax) {
				climbingMax = values[i];
				climbingIndexOfMax = i; //should return last index of max value
			}
		}
		return climbingIndexOfMax;
	}
	public static int[] remainders(int n) { //if remainders contains an element of 0 then n is not prime.
		int[] remainders = new int[(int) Math.sqrt(n)];
		int i = 0;
		while (i < remainders.length) { //you confuse the while and for loops.
			remainders[i] = n%(i + 2);
			i++;
		}
		return remainders; //the element of remainders at index = i is the remainder after division by i + 2.
	}
	public static boolean zeroDetector(int[] n) { //returns True if the array does not contain 0 and false if the array does contain 0.
		int i = 0;
		while (i < n.length) {
			if (n[i] == 0) {
				break;
			} else {
				i++;
			}
		}
			return (i == n.length);
	}
	public static boolean[] sieve(int n) {
		boolean[] TFArray = new boolean[n];
		TFArray[0] = false; //1 is not prime
		TFArray[1] = true; //2 is prime
		int i = 2;
		while (i < n) {
			TFArray[i] = zeroDetector(remainders(i + 1));
			i++;
		}
		return TFArray;
	}
	public static void main(String[] args) {
		double[] a = new double[4]; //an example of powArray
		a[0] = 2.3;
		a[1] = 4*3;
		a[2] = 0.333;
		a[3] = -1.0;
		double[] b = new double[4];
		b = powArray(a, 2);
		System.out.println(Arrays.toString(b));
		
		int[] c = new int[100]; //an example of histogram
		Random random = new Random();
		for (int i = 0; i < c.length; i++) {
			c[i] = random.nextInt(100);
		}
		System.out.println(Arrays.toString(c));
		System.out.println(indexOfMax(c));
		int[] d = new int[100];
		d = histogram(c, 10);
		System.out.println(Arrays.toString(d));
		Scanner in = new Scanner(System.in); //example of sieve
		System.out.print("What int will you put in the sieve? ");
		int n = in.nextInt();
		System.out.println(Arrays.toString(sieve(n)));
	}
}