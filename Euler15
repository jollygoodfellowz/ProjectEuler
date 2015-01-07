
public class LatticePaths {

	static int N = 20;
	
	// Number of successful paths from each index
	static long[][] lookup = new long[N+1][N+1];
	
	static long search(int x, int y) {
		
		// Breakout when we find an edge with the number of paths already found
		if(lookup[x][y] != 0)
			return lookup[x][y];
		
		// Add up the paths down and to the right
		lookup[x][y] = search(x+1, y) + search(x, y+1);

		// Return what we found
		return lookup[x][y];
	}
	
	public static void main(String[] args) {
		
		// Key for the algorithm above. Mark off all right and downward edges as 1
		for(int i = 0; i <= N; i++) {
			lookup[N][i] = 1;
			lookup[i][N] = 1;
		}
		
		// Start the search at [0][0]
		search(0,0);
		
		// The answer will be added up to the starting point
		System.out.println(lookup[0][0]);
	}

}
