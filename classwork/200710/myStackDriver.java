import java.io.*;
import java.util.*;

public class myStackDriver {

	public static void main(String[] args) {
		System.out.println("Testing push: Building a stack with pancake 1 on the bottom and syrup on top.");
		MyStack g = new MyStack();
		g.push("pancake 1");
		g.push("pancake 2");
		g.push("pancake 3");
		g.push("butter");
		g.push("syrup");
		System.out.println("Testing top: What's on top of the stack? Expected: syrup");
		System.out.println("g.top() = " + g.top());
		System.out.println("Does top() also pop? If not, output = syrup.");
		System.out.println("g.top() = " + g.top());
		System.out.println("Testing size(), pop(), isEmpty(). Expected output: ");
		System.out.println("g.size() = 5, g.pop() = syrup, g.isEmpty() = false");
		System.out.println("g.size() = 4, g.pop() = butter, g.isEmpty() = false");
		System.out.println("g.size() = 3, g.pop() = pancake 3, g.isEmpty() = false");
		System.out.println("g.size() = 2, g.pop() = pancake 2, g.isEmpty() = false");
		System.out.println("g.size() = 1, g.pop() = pancake 1, g.isEmpty() = false");
		System.out.println("g.size() = 0, g.pop() = null, g.isEmpty() = true");
		System.out.println("Actual output:");
		int i = 5;
		while (i > 0) {
			System.out.println("g.size() = " + g.size() + ", g.pop() = " + g.pop() + ", g.isEmpty() = " + g.isEmpty());
			i--;
		}
	}
}