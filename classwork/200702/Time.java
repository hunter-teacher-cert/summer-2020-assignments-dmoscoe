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
		if (this.hour == 0) {
			return String.format("12:%02d:%04.1f AM", this.minute, this.second);
		} else if (Math.abs(this.hour) > 0 && Math.abs(this.hour) < 12) {
			return String.format("%02d:%02d:%04.1f AM", this.hour, this.minute, this.second);
		} else {
			return String.format("%02d:%02d:%04.1f PM", this.hour-12, this.minute, this.second);
		}
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

	public Time subtract(Time that) {
		Time diff = new Time();
		diff.hour = this.hour - that.hour;
		diff.minute = this.minute - that.minute;
		diff.second = this.second - that.second;
		
		if (diff.second < 0.0) {
			diff.second += 60.0;
			diff.minute -= 1;
		}
		
		if (diff.minute < 0) {
			diff.minute += 60;
			diff.hour -= 1;
		}
		
		if (diff.hour < 0) {
			diff.hour += 24;
		}

		return diff;
	}//end subtract

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

	public void addMinutes(double minutes) {
		double seconds = 60 * minutes;
		increment(seconds);
	}//end addMinutes

}//end class