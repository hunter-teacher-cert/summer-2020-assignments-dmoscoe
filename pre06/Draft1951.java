import java.util.Scanner;
public class Draft1951 {
	public static double power(double x, int n) {
		double power = x;
		while (n > 1) {
			power *= x;
			n -= 1;
		} return power;
	}
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
	public static float myexp(int x, int n) {
		float myexp = 1;
		while (n > 0) {
			myexp += power(x,n)/factorial(n);
			System.out.println("next term is " + power(x,n)/factorial(n) + ", n = " + n + ", myexp = " + myexp);
			n -= 1;
			
		} return myexp;
	}

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
		
		System.out.print("Enter the tiny on e: ");
		int tiny = in.nextInt();
		System.out.print("Enter the number of terms: ");
		int terms = in.nextInt();
		System.out.println("e^" + tiny + " is approx. equal to " + myexp(tiny, terms));
	}
}
		