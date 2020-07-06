import java.util.*;

public class SuperArray {
	private int[] data; //Since int[]s are immutable, how will we update the length of this array?
	private int numberElements;

	public SuperArray() { //constructor with no parameters. Why do we need a constructor with no parameters?
		data = new int[10]; //Why am I making a new array here? No "this." here.
		numberElements = 0;
	}
	
	public SuperArray(int capacity) { //value constructor. No "this" here.
		data = new int[capacity];
		numberElements = 0;
	}

	public void add(int value) { //setter
		if (this.numberElements < this.data.length) {
			this.data[numberElements] = value;
			this.numberElements++;
		}
	}

	public int get (int index) { //getter
		if (index < this.data.length) {
			return this.data[index];
		} else {
			return -1;
		}
	}
	
	public boolean isEmpty() {
		return (this.numberElements == 0);
	}
	
	public String toString() {
		String output = new String();
		output = "[" + this.data[0];
		int i = 1;
		while (i < this.numberElements) {
			output += ", " + this.data[i]; //nope. Or could use +=
			i++;
		}
		output += "]";
		return output;
	}
	
	public static void main(String[] args) {
		SuperArray bop = new SuperArray(8);
		bop.add(3);
		bop.add(1);
		bop.add(4);
		System.out.println(bop.get(1));
		System.out.println(bop.toString());
		System.out.println(bop.isEmpty());
	}
		
}//end class

/* Questions: When do we use "new" ? Why do we need a constructor with no parameters? Why can we write Superarray sa? and not Superarray(sa)? Why do we initialize the variables before the constructors? (I think this is so that those variables get touched by all the methods in the class.) What does "static" mean? 