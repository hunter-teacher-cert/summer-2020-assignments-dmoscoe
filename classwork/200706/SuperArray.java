import java.util.*;

public class SuperArray {
	private int[] data;
	private int numberElements;

	public SuperArray() {
		data = new int[10];
		numberElements = 0;
	}
	
	public SuperArray(int capacity) {
		data = new int[capacity];
		numberElements = 0;
	}

	public void add(int value) {
		if (this.numberElements < this.data.length) {
			this.data[numberElements] = value;
			this.numberElements++;
		} else {
			this.grow();
			this.add(value);
		}
	}

	public void set(int index, int value) { //look at Topher's setter. It saves the oldVal using return. Never seen that before.
		if (index < this.data.length) {
			this.data[index] = value;
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
	
	private void grow() { //Topher made this private, since you would only ever call it from this class. But I'm not sure exactly what that means. I think it means that only other methods in this class can call grow. This is a difference between testing this class with a main method here as opposed to only in a driver. In a driver, you cannot directly test private methods. But with a main method here, you can directly test private methods.
		SuperArray that = new SuperArray(this.data.length + 5); //see if you can increase by a percentage.
		int i = 0;
		while (i < this.data.length) {
			that.data[i] = this.data[i];
			i++;
		}
		this.data = that.data;
	}
	
	public void add(int index, int value) {
		if (this.numberElements == this.data.length) {
			this.grow();
		}
		int i = this.numberElements;
		while (i > index) {
			this.data[i] = this.data[i - 1];
			i--;
		}
		this.data[index] = value;
		this.numberElements++;
	}	
	public void remove (int index) {
		if (index < this.data.length) {
			int i = index;
			while (i < this.data.length - 1) {
				this.data[i] = this.data[i + 1];
				i++;
			}
			this.numberElements--;
		}
	}
}