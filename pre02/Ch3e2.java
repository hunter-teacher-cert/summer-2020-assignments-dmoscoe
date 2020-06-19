import java.util.Scanner;
public class Ch3e2 {
	public static void main(String[] args) {
		double celsius;
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a Celsius temperature: ");
		celsius = in.nextDouble();
		double fahrenh = 1.8*celsius + 32.0;
		System.out.printf("%.1f degrees C = %.1f degrees F", celsius, fahrenh);
	}
}