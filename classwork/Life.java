import java.util.*;
import java.io.*;
class Scratch1337 {

/*actually createNewBoard just seems to be filling the board, not creating it. */
	public static int[][] createNewBoard(int rows, int cols) {
		int[][] board = new int[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				board[r][c] = 0;
			}//end for c
		}//end for r
		return board;
	}//end createNewBoard
	
	public static void printBoard(int[][] board) {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				System.out.print(board[r][c]);
			}//end for c
			System.out.println();
		}//end for r
	}//end printBoard
	
	
	public static void printCharBoard(char[][] board) {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				System.out.print(board[r][c]);
			}//end for c
			System.out.println();
		}//end for r
	}//end printCharBoard
	
	
	
	public static void setCell(int[][] board, int r, int c, int val) {
		if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
			board[r][c] = val;
		}//end if
	}//end setCell
	
	public static int countNeighbors(int[][] board, int r, int c) {
	
	/*count and return the number of living neighbors around board[r][c].*/
	int neighborhoodPop = 0;
	for (int i = Math.max(0,r - 1); i <= r + 1 && i < board[0].length; i++){
		for (int j = Math.max(0,c - 1); j <= c + 1 && j < board.length; j++) {
			neighborhoodPop += board[i][j];		
		}//end for j
	}//end for i
	if (board[r][c] == 1) {
		return neighborhoodPop - 1;
	} else {
		return neighborhoodPop;	
	}
	}//end countNeighbors

	public static int getNextGenCell(int[][] board, int r, int c){
		//determine if board[r][c] is living or dead
		if ((board[r][c] == 1 && (countNeighbors(board,r,c) == 2 || countNeighbors(board,r,c) == 3)) || (board[r][c] == 0 && countNeighbors(board,r,c) == 3)) {
			return 1;
		} else {
			return 0;
		}
		//if living and 2 or 3 neighbs then remain alive, else die
		
		//if dead and 3 neighbs then live, else stay dead
		
	}//end getNextGenCell

	public static int[][] generateNextBoard(int[][] board) {
		int newBoard[][] = new int[board.length][board[0].length];
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				newBoard[r][c] = getNextGenCell(board,r,c);
			}//end for c
		}//end for r
		return newBoard;
	}//end generateNextBoard
	
	public static char[][] toChar(int[][] board) {
		char[][] a = new char[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					a[i][j] = ' ';
				} else {
					a[i][j] = 'X';
				}
			}
		}
		return a;
	}
	
	
	
	public static void main(String[] args) {
	int boardRows;
	int boardCols;
	Scanner boardDims = new Scanner(System.in);
	System.out.print("boardRows = ");
	boardRows = boardDims.nextInt();
	System.out.print("boardCols = ");
	boardCols = boardDims.nextInt();
	int[][] board = createNewBoard(boardRows,boardCols);
	printBoard(board);
	setCell(board,7,8,1); //"small exploder"
	setCell(board,8,7,1);
	setCell(board,8,8,1);
	setCell(board,8,9,1);
	setCell(board,9,7,1);
	setCell(board,9,9,1);
	setCell(board,10,8,1);
	System.out.println();
	printCharBoard(toChar(board));
	System.out.println();
	System.out.println("---------------");
	for (int i = 0; i < 10; i++) {
		board = generateNextBoard(board);
		printCharBoard(toChar(board));
		System.out.println();
		System.out.println("---------------");
		System.out.println();
	}
	}//end main








}//end class