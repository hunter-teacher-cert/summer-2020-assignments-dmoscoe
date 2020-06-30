import java.io.*;
import java.util.*;
public class DailyWork0630 {
	public static int rowSum(int[][] a, int r) {
		int sum = 0;
		for (int c = 0; c < a[r].length; r++) {
			sum += a[r][c];
		}//end for c
		return sum;
	}//end rowSum
	
	public static int colSum(int[][] a, int c) {
		int sum = 0;
		for (int r = 0; r < a.length; r++) {
			sum += a[r][c];
		}//end for r
		return sum;
	}//end colSum
	
	public static void printArray(int[][] a) {
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[r].length; c++) {
				System.out.printf("%03d ", a[r][c]);
			}//end for c
			System.out.println();
		}//end for r
	}//end printArray
	
	public static void popArray(int[][] a) {
		int value = 111;
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[r].length; c++) {
				a[r][c] = value;
				value++; //depends on how you want to populate the array
			}//end for c
		}//end for r
	}//end popArray

	public static void rowPop(int[][] d2, int r, int value) { //populates row r in d2 with value
		for (int c = 0; c < d2[r].length; c++) {
			d2[r][c] = value;		
		}//end for c
	} //end rowPop
	
	public static void colPop(int[][] d2, int c, int value) {
		for (int r = 0; r < d2.length; r++) {
			d2[r][c] = value;
		}//end for r
	}//end colPop

	public static void invert(int[][] d2) {
		for (int r = 0; r < d2.length; r++) {
			for (int c = 0; c < d2[r].length; c++) {
				if (d2[r][c] == 0) {
					d2[r][c] = 255;
				} else {
					d2[r][c] = 0;
				}				
			}//end for c
		}//end for r
	}//end invert

	public static void diagonal(int[][] d2, int r, int c, int direction, int value) {
		if (direction == 3) {
			for (int i = r; i < d2.length && c < d2[r].length; i++) {
				d2[i][c] = value;
				c++;	
			}//end for i
		}//end if
		else if (direction == 2) {
			for (int i = r; i < d2.length && c >= 0; i++) {
				d2[i][c] = value;
				c--;
			}//end for i
		}//end else if
		else if (direction == 1) {
			for (int i = r; i >= 0; i--) {
				d2[i][c] = value;
				c++;
			}//end for i
		}//end else if
		else {
			for (int i = r; i >= 0; i--) {
				d2[i][c] = value;
				c--;
			}//end for i
		}//end else	
	}//end diagonal

	public static void main(String[] args) {
		int[][] arr = new int[20][20];
		popArray(arr);
		printArray(arr);
		System.out.println();
		System.out.println();
		diagonal(arr, 8, 9, 0, 0);
		diagonal(arr, 8, 9, 1, 1);
		diagonal(arr, 8, 9, 2, 2);
		diagonal(arr, 8, 9, 3, 3);
		printArray(arr);
		System.out.println();
	}//end main
}//end class