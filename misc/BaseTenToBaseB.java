import java.util.*;
public class BaseTenToBaseB {
	/* input is an int n in base-10. Output is an int array of the digits of n expressed in base-b. */
	
	public static int arrayLength(int n, int b) {
	/* How many digits is the base-b representation of n? To do: rewrite using logs. */
		int i = 0;
		while (Math.pow(b,i) < n) {
			i++;
		}
		return i;
	}
	
	public static int multipleOfPowOfB(int n, int b, int exp) {
		/* What is the greatest integer multiple of b^exp less than n? */
		int i = 0;
		while (n >= i*Math.pow(b,exp)) {
			i++;
		}
		return i - 1;
	}
	
	public static int[] baseBMe(int n, int b) {
		int decliner = n;
		int length = arrayLength(n, b);
		int[] digits = new int[length];
		int i = 0;
		while (i < length) {
			digits[i] = multipleOfPowOfB(decliner, b, length - (i + 1));
			decliner -= digits[i] * Math.pow(b, length - (i + 1));
			i++;
		}
		return digits;
	}
	
	public static void main(String[] args) {
		int n;
		int b;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the base-10 integer: ");
		n = in.nextInt();
		System.out.print("Enter the new base: ");
		b = in.nextInt();
		System.out.println(n + " expressed in base " + b + " = " + Arrays.toString(baseBMe(n,b)));
	}
}