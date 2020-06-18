public class Time {
	
	public static void main(String[] args) {
		double hour, min, second, secSinceMdnt, secRemaining;
		hour = 18.0;
		min = 18.0;
		second = 45.0;
		secSinceMdnt = (60*60*hour) + (60*min) + (second);
		secRemaining = (24*60*60) - secSinceMdnt;
		System.out.println(secSinceMdnt + " seconds have elapsed since midnight.");
		System.out.println("There are " + secRemaining + " seconds remaining until midnight.");
		System.out.println("The time between midnights is " + (100*secSinceMdnt) / (24*60*60) + "% complete.");
		double secSinceStartWork;
		secSinceStartWork = 60.0*60.0*(hour - 18.0) + 60.0*(min - 5.0) + (second - 30.0);
		System.out.println("The number of seconds since I began working on this exercise is " + secSinceStartWork + ".");
		
	}
}