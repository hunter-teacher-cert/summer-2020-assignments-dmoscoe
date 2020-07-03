import java.io.*;
import java.util.*;


public class Time {
	private int hour;
	private int minute;
	private double second;
	
	public Time() {
		this.hour = 0;
		this.minute = 0;
		this.second = 0.0;
	}//end constructor. This constructor initializes the values of the attributes of a Time object.
	
	public Time(int hour, int minute, double second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}//end value constructor. This constructor sets the attributes of the Time object to the arguments of Time(...).

	/*Getters*/
	
	public int getHour() {
		return this.hour;
	}
	
	public int getMinute() {
		return this.minute;
	}
	
	public double getSecond() {
		return this.second;
	}//end getters
	
	/*Setters*/
	
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	public void setSecond(double second) {
		this.second = second;
	}//end setters
	
	public String toString() {
		return String.format("%02d:%02d:%04.1f\n", this.hour, this.minute, this.second);
	}

	public boolean equals(Time that) {
		return (this.hour == that.hour && this.minute == that.minute && this.second == that.second);
	}
	
	public Time add(Time that) {
		Time sum = new Time();
		sum.hour = this.hour + that.hour;
		sum.minute = this.minute + that.minute;
		sum.second = this.second + that.second;
		
		if (sum.second >= 60.0) {
			sum.second -= 60.0;
			sum.minute += 1;
		}
		
		if (sum.minute >= 60) {
			sum.minute -= 60;
			sum.hour += 1;
		}
		
		if (sum.hour >= 24) {
			sum.hour -= 24;
		}

		return sum;
	}//end add

	public void increment(double seconds) {
		this.second += seconds;
		while (this.second >= 60.0) {
			this.second -= 60.0;
			this.minute += 1;
		}
		while (this.minute >= 60) {
			this.minute -=60;
			this.hour += 1;
		}
		while (this.hour >=24) {
			this.hour -= 24;
		}
	}//end increment

}//end class