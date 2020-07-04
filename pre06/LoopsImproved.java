/* rewrite Think Java Ch. 7 exercises 3, 4, 5. */
import java.util.*;
public class LoopsImproved {
	public static double power(double x, int n) {
		/* takes double x, int n, and returns double power = x^n. */
		double power = 1.0;
		if (n > 0) {
			while (n > 0) {
				power *= x;
				n -= 1;
			}
		} else if (n < 0) {
			while (n < 0) {
				power /= x;
				n += 1;
			}
		}
		return power;
	}
	
	public static int factorial (int y) {
		/* takes int y and returns int factorial = y!. */
		int factorial = 1;
		if (y > 0) {
			while (y > 1) {
				factorial *= y;
				y -= 1;
			}
		} else if (y < 0) {
			while (y < 0) {
				factorial *= y;
			y += 1;
			}
		}
		return factorial;
	}
	
	public static double myexp(double x, int n) {
		/* takes double x and int n and returns an estimate of e^x, double myexp = sum(i=0 to n, x^i/i!). */
		double myexp = 0.0;
		double term = 0.0;
		int i = 0;
		while (i <= n) {
			term = power(x,i)/factorial(i);
			myexp += term;
			i++;
		}
		return myexp;
	}//end myexp
	
	public static double myexpv2(double x, int n) {
		/* takes double x and int n and returns an estimate of e^x, double myexpv2 = sum(i=0 to n, x^i/i!). Calculates each term by multiplying its predecessor by x/i. */
		double myexpv2 = 1.0;
		double term = 1.0;
		int i = 1;
		while (i <= n) {
			term *= (x/i);
			myexpv2 += term;
			i++;
		}
		return myexpv2;
	}
	
	public static void check(double x, int n) {
	/* prints x, n, myexp(x,n), %error for myexp, myexpv2(x,n), % error for myexpv2. */
	
	double perErrmyexp = 100*(myexp(x,n)-Math.exp(x))/Math.exp(x);
	double perErrmyexpv2 = 100*(myexpv2(x,n)-Math.exp(x))/Math.exp(x);
	
	System.out.println("x = " + x + ", n = " + n);
	System.out.println("myexp(" + x + "," + n + ") = " + myexp(x,n));
	System.out.println("percent error for myexp = " + perErrmyexp);
	System.out.println("myexpv2(" + x + "," + n + ") = " + myexpv2(x,n));
	System.out.println("percent error for myexpv2 = " + perErrmyexpv2);
	}
	
	public static void main(String[] args) {
		/* testing power */
		System.out.println("Testing power:");
		System.out.println("3^5 = " + power(3,5));
		System.out.println("3.02^4 = " + power(3.02,4));
		System.out.println("3^(-5) = " + power(3,-5));
		System.out.println("(1/2)^(-3) = " + power(0.5,-3));
		System.out.println();
		System.out.println();
		
		/* testing factorial */
		System.out.println("Testing factorial:");
		System.out.println("5! = " + factorial(5));
		System.out.println("(-5)! = " + factorial(-5));
		System.out.println("(-4)! = " + factorial(-4));
		System.out.println("8! = " + factorial(8));
		System.out.println();
		System.out.println();
		
		/* testing myexp */
		System.out.println("Testing myexp:");
		System.out.println("myexp(5,10) = " + myexp(5,10));
		System.out.println("myexp(3.5,10) = " + myexp(3.5,10));
		System.out.println("myexp(-2,10) = " + myexp(-2,10));
		System.out.println("myexp(0,10) = " + myexp(0,10));
		System.out.println("myexp(5,0) = " + myexp(5,0));
		System.out.println();
		System.out.println();
		/* myexp doesn't work for large n. For what n is myexp(3,n) closest to e^3? Answer: n = 12. */
		
		System.out.println("When does myexp start behaving strangely for x = 3?:");
		System.out.println("n           myexp(3,n)          e^3");
		int n = 25;
		while (n >= 0) {
			System.out.printf("%2d  %20.10f  %.10f\n",n,myexp(3,n),Math.exp(3));
			n--;
		}	
		System.out.println();
		System.out.println();
		/*end comparing myexp(3,n) to e^3. */
		
		/* testing myexpv2. */
		System.out.println("Testing myexpv2:");
		System.out.println("myexpv2(5,10) = " + myexpv2(5,10));
		System.out.println("myexpv2(3.5,10) = " + myexpv2(3.5,10));
		System.out.println("myexpv2(-2,10) = " + myexpv2(-2,10));
		System.out.println("myexpv2(0,10) = " + myexpv2(0,10));
		System.out.println("myexpv2(5,0) = " + myexpv2(5,0));
		System.out.println();
		System.out.println();
		System.out.println("Check(5,15):");
		check(5,15);
		System.out.println();
		System.out.println();
			
		
		/* a loop that invokes check for x = +/- powers of 10, 10^(-1) to 10^2, and n = 10. */
		
		int i = -1;
		while (i <= 2) {
			check(Math.pow(10,i),10);
			System.out.println();
			System.out.println();
			check((-1)*Math.pow(10,i),10);
			i++;
			System.out.println();
			System.out.println();
		}
		
		/* myexp and myexpv2 just don't work for large values of x or n. Sad! */
			
	}
}
