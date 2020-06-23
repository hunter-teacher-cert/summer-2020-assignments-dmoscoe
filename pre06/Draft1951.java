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
	}
}
		