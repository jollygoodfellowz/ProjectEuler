/*
 * This program finds the largest sum in pyramid
 * for Euler problem 18 as well as problem 67
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MaxPathSum {

	public final static int N = 100;
	public Number numbers[][];
	
	public MaxPathSum() {
		
	}
	
	/**Holds the left and right paths for the number as well as the total from previous choices*/
	static class Number {
		
		int i;
		int j;
		int left;
		int right;
		int total;
		
		public Number(int i, int j, int left, int right) {
			
			// i and j are the positions within the table array
			this.i = i;
			this.j = j;
			this.left = left;
			this.right = right;
			this.total = 0;
		}
	}
	
	/** Choose the best path and add the total from the previous best path */
	public void choose(int i, int j) {
		
		int left = numbers[i][j].left + numbers[i+1][j].total;
		int right = numbers[i][j].right + numbers[i+1][j+1].total;
		
		if(left > right)
			numbers[i][j].total = left;
		else
			numbers[i][j].total = right;

	}
	
	/** Create the paths */
	void createTable(int table[][]) {
		
		numbers = new Number[N][N];
		
		// Create the table
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < i+1 && i+1 < N && j+1 < N; j++) 
				numbers[i][j] = new Number(i, j, table[i+1][j], table[i+1][j+1]);
			
		// Initialize the last row 
		for(int i = 0; i < N; i++)
			numbers[N-1][i] = new Number(N-1, i, 0, 0);
	}
	
	/** Search from bottom to top returning the best choice */
	int search() {

		for(int i = N-2; i >= 0; i--) 
			for(int j = 0; j <= i; j++) 
				choose(i, j);

		return numbers[0][0].total;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		MaxPathSum path;
		Scanner sc = new Scanner(new File("Table.txt"));
		int table[][] = new int[N][N];
		
		// Read in the data
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < i+1; j++) 
				table[i][j] = sc.nextInt();
			
		path = new MaxPathSum();
		path.createTable(table);
		int answer = path.search();
		
		// Don't forget to add the tip of the pyramid
		System.out.println(answer + table[0][0]);
		
	}
}
