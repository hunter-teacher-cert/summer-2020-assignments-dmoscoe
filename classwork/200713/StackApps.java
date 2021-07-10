import java.io.*;
import java.util.*;

/*

Use Java's built-in Stack class and String methods to implement methods for:
x (1) public static String reverse(String s): takes in a String and returns a String s.t. chars are in reverse order.
x (2) public static boolean isPalindrome(String s): takes in a String and returns true if s is a palindrome of chars. Returns false otherwise.
x (3) public static boolean parenCheck(String s): Assumes s a mathematical expression containing only letters, numbers, ()+-/*. Returns true if parentheses are correctly matched. Returns false otherwise.

x (4) (extension) Modify reverse and isPalindrome s.t. (a) words, not chars, are in reverse order; and (b) words, not chars, are palindromic.
x (5) (extension) Modify parenCheck to include [] and {}.

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

	public static String wordReverser(String s) {
		/*Reverses the order of words in a String. */
		/*Plan: Push words to a stack, then construct new string by repeatedly popping the stack. */
		
		String reverseWords = new String();
		Stack<String> words = new Stack<String>();
		
		for (int i = 0; i < s.split(" ").length; i++) {
			words.push(s.split(" ")[i]);
		}
		
		while (!words.isEmpty()) {
			reverseWords += (words.pop() + " ");
		}
		
		return reverseWords.trim();
	}
	
	public static boolean wordsPalindrome(String s) {
		/*Returns true if s is a word-by-word palindrome, false otherwise. */
		
		return s.equals(wordReverser(s));
	}

	public static boolean grouperCheck(String s) { /*Input: a mathematical expression. Output: true if the arrangement of grouping symbols is legal. False otherwise. Assumes (), [], {} are not hierarchical and do not pair with symbols outside their species. (I.e., (] is not well-formed, but [{}] is.)
	
	Plan: Traverse the string, pushing left grouping symbols to the stack and popping at right grouping symbols. If pop corresponds to the right grouping symbol, continue. If not, return false. If pop throws an exception before the string is fully traversed, return false. If pop throws an exception after the string is completely traversed, return true. Otherwise return false. */
	
		Stack<Character> groupers = new Stack<Character>();
		boolean keepGoing = true;
		
		for (int i = 0; i < s.length(); i++) {
			if (((Character) s.charAt(i)).equals('(')) {
				groupers.push('(');
			} else if (((Character) s.charAt(i)).equals('[')) {
				groupers.push('[');
			} else if (((Character) s.charAt(i)).equals('{')) {
				groupers.push('{');
			} else if (((Character) s.charAt(i)).equals(')')) {
				try {
					keepGoing = (groupers.pop() == '(');
					if (keepGoing = false) {
						return false;
					}
				} catch (Exception e) {
					return false;
				}
			} else if (((Character) s.charAt(i)).equals(']')) {
				try {
					keepGoing = (groupers.pop() == '[');
					if (keepGoing = false) {
						return false;
					}
				} catch (Exception e) {
					return false;
				}
			} else if (((Character) s.charAt(i)).equals('}')) {
				try {
					keepGoing = (groupers.pop() == '{');
					if (keepGoing = false) {
						return false;
					}
				} catch (Exception e) {
					return false;
				}
			}
			}
		
			try {
				groupers.pop();
			} catch (Exception e) {
				return true;
			}
			return false;
	}
		
	public static void main(String[] args) { //this is a little messy but it tests some of this stuff.
		String reverse = new String();
		reverse = "abcdef";
		System.out.println(reverse(reverse));
		
		String palindrome = new String();
		palindrome = "hannah";
		String notPal = new String();
		notPal = "Think Java";
		System.out.println(isPalindrome(palindrome));
		System.out.println(isPalindrome(notPal));
		String wffParens = new String(); //well-formed formula
		String iffParens1 = new String(); //ill-formed formula
		String iffParens2 = new String();
		String iffParens3 = new String();
		String wffGroupers = new String();
		String iffGroupers1 = new String();
		String iffGroupers2 = new String();
		String iffGroupers3 = new String();
		wffParens = "((x*x) + 2(x) + (3 * (32 - 89)))";
		iffParens1 = "((x*x) + 2(x) + (3 * (32 - 89)))))";
		iffParens2 = "((x*x) + 2(x) + 3 * (32 - 89)))";
		iffParens3 = "()()(";
		wffGroupers = "{[x*x] + 2(x) + {3 * (32 - 89)}}";
		iffGroupers1 = "{[x*x] + 2(x) + {3 * (32 - 89)}}])";
		iffGroupers2 = "{[x*x] + 2(x) + 3 * (32 - 89)}}";
		iffGroupers3 = "}[x*x] + 2(x) + {3 * (32 - 89)}}";
		System.out.println("wffParens" + parenCheck(wffParens));
		System.out.println("iffParens1" + parenCheck(iffParens1));
		System.out.println("iffParens2" + parenCheck(iffParens2));
		System.out.println("iffParens3" + parenCheck(iffParens3));
		System.out.println("wffGroupers" + grouperCheck(wffGroupers));
		System.out.println("iffGroupers1" + grouperCheck(iffGroupers1));
		System.out.println("iffGroupers2" + grouperCheck(iffGroupers2));
		System.out.println("iffGroupers3" + grouperCheck(iffGroupers3));
		String s = "today yesterday today";
		System.out.println(wordReverser(s)+"x");
		System.out.println(wordsPalindrome(s));
	}
}