import java.io.*;
import java.util.*;

/*

Use Java's built-in Stack class and String methods to implement methods for:
x (1) public static String reverse(String s): takes in a String and returns a String s.t. chars are in reverse order.
x (2) public static boolean isPalindrome(String s): takes in a String and returns true if s is a palindrome of chars. Returns false otherwise.
(3) public static boolean parenCheck(String s): Assumes s a mathematical expression containing only letters, numbers, ()+-/*. Returns true if parentheses are correctly matched. Returns false otherwise.

(4) (extension) Modify reverse and isPalindrome s.t. (a) words, not chars, are in reverse order; and (b) words, not chars, are palindromic.
(5) (extension) Modify parenCheck to include [] and {}.

*/

public class StackApps {
	
	public static String reverse(String s) {
		/* Plan: load chars left to right into a stack. Then create a new string so that each element in the stack is popped and added to the right of the new string. */
		
		Stack<Character> t = new Stack<Character>(); //Why don't we use char here?
		String reversedString = new String();
		for (int i = 0; i < s.length(); i++) {
			t.push(s.charAt(i));
		}
		
		for (int j = 0; j < s.length(); j++) {
			reversedString += t.pop();
		}
		
		return reversedString;		
	}

	public static boolean isPalindrome(String s) {
		return s.equals(reverse(s));
	}
	
	public static boolean parenCheck(String s) {
		/* Plan: Traverse the string. Every time you encounter (, push to stack. Every time you encounter ), pop stack. If pop throws an exception before the string is completely traversed, return false. If pop throws an exception after the string is completely traversed, return true. Otherwise return false.*/
		
		Stack<Character> parens = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (((Character) s.charAt(i)).equals('(')) { //could I have done this without casting?
				parens.push('(');
			} else if (((Character) s.charAt(i)).equals(')')) {
				try { //if you throw an exception here, then return false.
				parens.pop();
				} catch (Exception e) {
					return false;
				}
			}
		}
		try {  //if you throw an exception here, then return true.
			parens.pop();
		} catch (Exception e) {
			return true;
		}
		return false;
	}





	public static void main(String[] args) {
		String reverse = new String();
		reverse = "abcdef";
		System.out.println(reverse(reverse));
		
		String palindrome = new String();
		palindrome = "hannah";
		String notPal = new String();
		notPal = "Think Java";
		System.out.println(isPalindrome(palindrome));
		System.out.println(isPalindrome(notPal));
		
	}
}