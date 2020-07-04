import java.io.*;
import java.util.*;

/*To compile: write javac Driver.java Time.java. To run write java Driver. */

public class Driver {
	public static void main(String[] args) {
		Time t = new Time(12,10,35);
		System.out.println("t.getHour() = " + t.getHour() + ". t.getMinute() = " + t.getMinute() + ". t.getSecond() = " + t.getSecond() + ".");
		System.out.println("Setting t to 1:23:45:");
		t.setHour(1);
		t.setMinute(23);
		t.setSecond(45);
		System.out.println("Getting new attributes of t:");
		System.out.println("t.getHour() = " + t.getHour() + ". t.getMinute() = " + t.getMinute() + ". t.getSecond() = " + t.getSecond() + ".");
		
		System.out.println("t.toString = " + t.toString());
		
		System.out.println("Initializing? Invoking? new time variables u and v: ");
		Time u = new Time(2,34,56);
		Time v = new Time(1,23,45);
		System.out.println("u = " + u.toString());
		System.out.println("v = " + v.toString());
		
		System.out.println("Are t and u equal? " + t.equals(u));
		System.out.println("Are t and v equal? " + t.equals(v));
		System.out.println("Are u and v equal? " + u.equals(v));
		
		System.out.println("t + u = " + t.toString() + " + " + u.toString() + " = " + t.add(u).toString());
		System.out.println("t + v = " + t.toString() + " + " + v.toString() + " = " + t.add(v).toString());
		System.out.println("u + v = " + u.toString() + " + " + v.toString() + " = " + u.add(v).toString());
		System.out.println();
		System.out.println();
		System.out.println("t - u = " + t.toString() + " - " + u.toString() + " = " + t.subtract(u).toString());
		System.out.println("t - v = " + t.toString() + " - " + v.toString() + " = " + t.subtract(v).toString());
		System.out.println("u - v = " + u.toString() + " - " + v.toString() + " = " + u.subtract(v).toString());
		System.out.println();
		System.out.println();
		
		System.out.println("incrementing v by 23 seconds: ");
		v.increment(23);
		System.out.println("v = " + v.toString());
		
		System.out.println("incrementing v by 4.83792 minutes: ");
		v.addMinutes(4.83792);
		System.out.println("v = " + v.toString());
		System.out.println();
		System.out.println();
		
	}//end main
}//end class