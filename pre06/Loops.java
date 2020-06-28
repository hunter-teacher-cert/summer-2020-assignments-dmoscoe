import java.util.Scanner;
public class Loops {
	
	/** Exercise 3: an iterative method that takes in double x and int n and returns x^n. */
	public static double power(double x, int n) {
		double power = x;
		while (n > 1) {
			power *= x;
			n -= 1;
		} return power;
	}
	
	/** Exercise 4: an iterative method that takes in int y and returns y!. */
	public static int factorial(int y) {
		int factorial = 1;
		while (y > 1) {
			factorial *= y;
			y -= 1;
		} return factorial;
	}
	
	/**
	myexp works for small x, n, but something goes weird when n gets large. For x = 5 and x = 7 this happens when n > 12. 
	*/
	
	/** Exercise 5 part 1: takes int x and int n and estimates e^x by summing the first n terms of the Taylor series. */
	public static float myexp(int x, int n) {
		float myexp = 1;
		while (n > 0) {
			myexp += power(x,n)/factorial(n);
			//System.out.println("next term is " + power(x,n)/factorial(n) + ", n = " + n + ", myexp = " + myexp);
			n -= 1;
		} return myexp;
	}

	/**A different strategy for approximating e^a: notice that the numerator of each term = 
	its predecessor * a. Denominator of each term is predecessor * i. b is the number of terms*/
	
	
	public static double myexpv2 (int a, int b) {
		double term = 1;
		int i = 1;
		double sum = 1;
		while (i <= b) {
			term *= ((double) a/i);
			i += 1;
			sum += term;
		}
		return sum;
	}
	/** c is the number of terms in the series for myexp. */
	public static void check(int x, int c) {
		System.out.println(x+ "\t" + myexp(x,c) +"\t" + Math.exp(x));
	}


/**gets input for each of the methods above and prints output. */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the base: ");
		double base = in.nextDouble();
		System.out.print("Enter the exponent: ");
		int exponent = in.nextInt();
		System.out.println(base + "^" + exponent + " = " + power(base, exponent));
		
		System.out.print("Enter the arg for factorial: ");
		int arg = in.nextInt();
		System.out.println(arg + "! = " + factorial(arg));
		
		System.out.print("myexp. Enter the exponent number on e: ");
		int tiny = in.nextInt();
		System.out.print("Enter the number of terms: ");
		int terms = in.nextInt();
		System.out.println("e^" + tiny + " is approx. equal to " + myexp(tiny, terms));
		
		System.out.print("myexpv2. Enter the exponent on e: ");
		int a = in.nextInt();
		System.out.print("Enter the number of terms: ");
		int b = in.nextInt();
		System.out.println("according to myexpv2, e^" + a + " is approx. equal to " + myexpv2(a,b));
		
		System.out.print("check! Enter the exponent: ");
		int d = in.nextInt();
		System.out.print("check! Enter the number of terms: ");
		int e = in.nextInt();
		check(d,e);
		System.out.println("check(1,4) = ");
		check(1,4);
		System.out.println("check(1,5) = ");
		check(1,5);
		System.out.println("check(1,6) = ");
		check(1,6);
		System.out.println("check(1,7) = ");
		check(1,7);
		System.out.println("check(1,8) = ");
		check(1,8);
		System.out.println("check(1,9) = ");
		check(1,9);
		System.out.println("check(1,10) = "); 
		check(1,10); //10 terms is within 0.000001 of the correct answer.
		
		/**double f = 0.1;
		for (f<1000) {
			Haven't finished part 5 and 6 yet, since I realize that some of my ints need to be doubles or
			floats. But this is a pretty good draft of pre06. */
	}
}
		