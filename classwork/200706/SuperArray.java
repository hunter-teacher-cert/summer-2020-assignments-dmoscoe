import java.util.*;

public class SuperArray {
	private int[] data; //Since int[]s are immutable, how will we update the length of this array?
	private int numberElements;

	public SuperArray() { //constructor with no parameters. Why do we need a constructor with no parameters?
		this.data = new int[10]; //Why am I making a new array here?
		this.numberElements = 0;
	}
	
	public SuperArray(int size) { //value constructor.
		this.data = new int[size];
		this.numberElements = 0;
	}

	public void add(int value) { //is this a setter?
		if (this.numberElements < this.data.length) {
			this.data[numberElements] = value;
			this.numberElements++;
		}
	}

	public int get (int index) {
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
		output = ("[" + this.data[0]);
		int i = 1;
		while (i < this.numberElements) {
			output += (", " + this.data[i]); //nope. Or could use +=
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
	}
		
}//end class