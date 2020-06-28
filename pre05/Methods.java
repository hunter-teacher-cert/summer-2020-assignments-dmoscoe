import java.util.Scanner;
public class Methods {
	public static boolean isDivisible(int n, int m) { //n dividend, m divisor.
		return (m * (n/m) == n);
	}
	
	/**
	public static boolean isTriangle(double a, double b, double c) {
		boolean firstCheck = ((a + b) > c);
		boolean secondCheck = ((a + c) > b);
		boolean thirdCheck = ((b + c) > a);
		return firstCheck && secondCheck && thirdCheck;
	}
	*/
	public static boolean isTriangle(int a, int b, int c) {
	if (a + b < c) {
		return false;
	} else if (a + c < b) {
		return false;
	} else if (b + c < a) {
		return false;
	} else {
		return true;
	}
}
	
	public static int Ack(int m, int n) {
		if (m == 0) {
			return n + 1;
		} else if ((m > 0) && (n == 0)) {
			return Ack(m-1, 1);
		} else {
			return Ack(m-1, Ack(m,n-1));
		}
	}
	
	public static void main(String[] args) {
		int dividend, divisor;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the dividend: ");
		dividend = in.nextInt();
		System.out.print("Enter the divisor: ");
		divisor = in.nextInt();
		System.out.println("It is " + isDivisible(dividend, divisor) + " that " + divisor + " evenly divides " + dividend + ".");
		
		int d, e, f;
		//Scanner in = new Scanner(System.in);
		System.out.print("Enter a: ");
		d = in.nextInt();
		System.out.print("Enter b: ");
		e = in.nextInt();
		System.out.print("Enter c: ");
		f = in.nextInt();
		System.out.println("It is " + isTriangle(d, e, f) + " that there is a triangle with sides " + d + ", " + e + ", and " + f + ".");
	
		int g, h;
		System.out.print("Enter the first argument for the Ackerman function: ");
		g = in.nextInt();
		System.out.print("Enter the second argument for the Ackerman function: ");
		h = in.nextInt();
		System.out.println("Ack(" + g + "," + h + ") = " + Ack(g,h));
	}
}



