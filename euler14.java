
public class Collatz {

	static int answer = 0;
	static final int N = 1000001;
	static int array[] = new int[N];
	
	static public int collatz(Long num, int ops) {
		
		int index = 0;
		
		// The current number
		int loc = Integer.valueOf(num.intValue());
		
		// Breaking condition
		while(num != 1) {
			
			// We have already found this answer before
			if(num < N) {
				
				index = Integer.valueOf(num.intValue());
				
				// We have found an answer with this index before
				if(array[index] != 0) 
					return array[index] + ops;
				
			}
			
			// The even case
			if(num % 2 == 0) 
				num = num /2;
			
			// The odd case
			else 
				num = 3*num + 1;
			
			// Each time we are in the loop we must increment
			ops++;
		}
		
		// Save the number of operations it took to hit 1
		array[loc] = ops;
		
		// This is the number of operations
		return ops;
	}
	
	public static void main(String[] args) {
		
		int check = 0, ans = 0;
		
		for(int i = N-1; i > 1; i--) {
			
			// Save the number of operations
			check = collatz((long)i, 0);
			
			// If there were more operations in the current iteration than previous best
			if(check > ans) {
				ans = check;
				
				// For fun print out the current best number of steps
				System.out.println(check);
				answer = i;
			}
		}

		// The answer is here!!
		System.out.println(answer);
	}

}
