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

	public void add(int value) { //setter.
		if (this.numberElements < this.data.length) {
			this.data[numberElements] = value;
			this.numberElements++;
		} else {
			this.grow();
			this.add(value);
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
			output += ", " + this.data[i];
			i++;
		}
		output += "]";
		return output;
	}
	
	public void grow() { //create a new array with extra room. Copy the data from the original array to a new one. Set the internal instance variable data to the new array.
		SuperArray that = new SuperArray(this.data.length + 1);
		int i = 0;
		while (i < this.data.length) {
			that.data[i] = this.data[i];
			i++;
		}
		this.data = that.data;
	
	
	
	}//end grow
	
//	public void remove(int index) { //delete the element at location index from the array. Don't forget to shift down elements to remove the open space.
//	}
	
	public static void main(String[] args) {
		SuperArray sa = new SuperArray(8);
		System.out.println("Adding eight elements to the SuperArray: 3, 1, 4, 1, 5, 9, 2, 6.");
		sa.add(3);
		sa.add(1);
		sa.add(4);
		sa.add(1);
		sa.add(5);
		sa.add(9);
		sa.add(2);
		sa.add(6);
		System.out.println("sa.get(8) = " + sa.get(8) + ". The array internal to superarray sa has less than 9 elements.");
		System.out.println("sa.toString() = " + sa.toString());
		System.out.println("sa.isEmpty() = " + sa.isEmpty());
		System.out.println("Adding 13 as the ninth element in the superarray sa. This causes sa to grow.");
		sa.add(13);
		System.out.println(sa.toString());
		System.out.println("sa.get(8) = " + sa.get(8) + ". sa now has at least 9 elements.");
	}
		
}//end class

/* Questions: When do we use "new" ? Why do we need a constructor with no parameters? Why can we write Superarray sa? and not Superarray(sa)? Why do we initialize the variables before the constructors? (I think this is so that those variables get touched by all the methods in the class.) What does "static" mean? */