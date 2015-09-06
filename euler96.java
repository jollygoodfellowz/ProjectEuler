/**
 * 
 * This program solves a Sudoku board using backtracking
 * 10/31 Made a few changes to adapt this program to solve Euler 96
 * */

import java.util.Scanner;

public class Sudoku {
	
	/**Fields
	 * @param board stores the Sudoku board
	 * @param row the number of rows in the board
	 * @param col the number of columns in the board 
	 * @param N represents the size of the Sudoku board
	 **/
	private int[][] board;
	private int row = 0;
	private int col = 0;
	private final static int N = 9;
	private int caseNum;
	
	/**Constructor for the Sudoku solver. Starts the recursive search
	 * @param board passed in from main to save
	 * @param caseNum passed in for printing each case 
	 **/
	public Sudoku (int[][] board, int caseNum) {
		this.board = board;
		this.caseNum = caseNum;
		wrapRecSolve();
	}
	
	/**Wrapper class for the recursive method
	 * Print board if recSolve returns true. Otherwise print no solution
	 **/
	public void wrapRecSolve() {
		if(recSolve()) {
			//System.out.println("Test case "+caseNum+":");
			//printIt();
		}
		else
			System.out.println("Test case "+caseNum+":\n\nNo solution possible\n\n");
	}
	
	/**The board has been solved. Print it out.*/
	public void printIt() {
		for(int i = 0; i < N; i++) {
			System.out.println();
			for(int j = 0; j < N; j++)
				System.out.print(board[i][j]+ " ");
		}
		
		System.out.println("\n\n");
	}
	
	/**Exra function to handle Euler problem 96*/
	public int top3() {
		String s1 = "" + board[0][0];
		String s2 = "" + board[0][1];
		String s3 = "" + board[0][2];
		String s4 = s1 + s2 + s3;
		
		return Integer.parseInt(s4);
	}
	
	/**Backtracking implemented here*/
	public boolean recSolve() {
		
		//If no positions left to check we are done!
		if(!findNextPos())
			return true;
		
		//Saves the row and column found in findNextPos.
		//tempRow and tempCol save the information lost in the recursive calls.
		int tempRow = row;
		int tempCol = col;
		
		//Try to find a number to insert
		for(int i = 1; i <= N; i++) {
			
			//If the number is valid put it on the board
			if(isValid(tempRow,tempCol,i)) {
				board[tempRow][tempCol] = i;
				
				//Puzzle solved!
				if(recSolve())
					return true;
				
				//Reset previous work
				board[tempRow][tempCol] = 0;
			}
		}
		//We did not find a valid number to use. Start backtracking.
		return false;
	}
	
	/**Checks the current row passed in
	 * @param row the current row to check for validity
	 * @param num the number being tested
	 **/
	public boolean checkRow(int row, int num) {
		for(int i = 0; i < N; i++) {
			if(board[row][i] == num)
				return false;
		}
		return true;
	}
	
	/**Calls all three check methods. If all three methods return true then we have a valid number
	 * @param row the row to check
	 * @param col the column to check
	 * @param num the number being tested
	 **/
	boolean isValid(int row, int col, int num) {
	    return checkRow (row, num) &&
	           checkCol(col, num) &&
	           check3x3(row - row%3, col - col%3, num);
	}
	
	/**Find the next open spot and save it*/
	public boolean findNextPos() {
		for(this.row = 0; this.row < N; this.row++)
			for(this.col = 0; this.col < N; this.col++)
				if(board[this.row][this.col] == 0)
					return true;
		return false;
	}
	
	/**Check the boards columns
	 * @param col the desired column to check
	 * @param num the number being tested
	 **/
	boolean checkCol(int col, int num) {
	    for (int row = 0; row < N; row++)
	        if (board[row][col] == num)
	            return false;
	    return true;
	}
	
	/**Checks the 3x3 Sudoku box. True if it works. False otherwise.
	 * @param boxStartRow where the current box row starts at
	 * @param boxStartCol where the current box column starts at
	 * @param num the number being tested
	 **/
	boolean check3x3(int boxStartRow, int boxStartCol, int num) {
	    for (int row = 0; row < 3; row++)
	        for (int col = 0; col < 3; col++)
	            if (board[row+boxStartRow][col+boxStartCol] == num)
	                return false;
	    return true;
	}

	/**Sets up the board to be scanned in using standard input through a Scanner
	 **/
	public static void main(String[] args) {
		
		Sudoku sudokuSolver;
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[N][N];
		int sum = 0;
		
		for(int i = 0; i < 50; i++) {
			
			// Eat the line containing no sudoku board numbers
			String s = sc.nextLine();
	
			for(int j = 0; j < 9; j++) {
				
				String next = sc.nextLine();
				
				for(int k = 0; k < 9; k++) 
					board[j][k] = Character.getNumericValue(next.charAt(k));
				
			}
			
			sudokuSolver = new Sudoku(board, i+1);
			sum += sudokuSolver.top3();
		}	
		
		System.out.println(sum);
	}
}
