
public class ConsecutivePrimeSum {

	static final int N = 1000000;
	
	// Largest Prime under N
	static final int largePrime = 999983;
	
	static boolean primes[] = new boolean[N+1];
	
	// Sieve Marks off all multiples of i
	static void findPrimes() {
	
		for(int i = 0; i <= N; i++)
			primes[i] = true;
		
		for (int i = 2; i <= Math.sqrt(N); i++) 
			if (primes[i]) 
				for (int j = 2*i; j <= N; j+=i)
					primes[j] = false;
	}
	
	static boolean isPrime(int num) {
		
		if(num > N)
			return false;
		
		return primes[num];
	}
	
	public static void main(String[] args) {
		
		findPrimes();
		
		int prevCount = 0, sum = 0, count = 0, answer = 0;
		for(int i = 2; i <= N; i++) {
			
			// The next prime sum to attempt
			if(primes[i]) {
				
				// Start the sum at the newly found prime and reset the count
				sum = i;
				count = 0;
				
				// Begin adding up primes 
				for(int j = i + 1; sum + j <= largePrime; j++) {
					
					// The next prime to add
					if(primes[j]) {
						sum += j;
						count++;
						
						// Check to see if the sum is prime
						if(isPrime(sum)) {
							
							// If the sum is prime then lets see if the count > then our previous best
							if(count > prevCount) {
								prevCount = count;
								answer = sum;
								
							}
						}
					}
				}		
			}
		}
		
		System.out.println(answer);
	}
}
