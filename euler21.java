import java.util.Scanner;

// Used to solve Euler 21. Its very messy

public class CommonFactors {

	public final static int MAX = 1000000;
	int [] factors;
	int[]commonFactors;
	int[] powers;
	boolean[] squares;
	boolean[] isPrime;
	int num;
	int totalFactors = 0;
	int sumOfFactors = 0;
	int[] lookup;
	
	public CommonFactors(int num, boolean[] isPrime) {
		
		lookup = new int[MAX];
		this.isPrime = isPrime;
		squares = new boolean[MAX];
		factors = factors(num);
		
	}
	
	public int countFactors() {
		
		if(isPrime[num])
			return 2;
		
		int total = 1;
		for(int i = 0; powers[i] != 0; i++) 
			total = (powers[i]+1) * total;
		
		totalFactors = total;
		return total;
	}
	
	public void saveFactors() {
		
		commonFactors = new int[10001];
		
		int pos = 0;
		int check = num/2;
		for(int i = 2; i < check; i++) {
			if(num % i == 0) {
				commonFactors[pos++] = i;
				commonFactors[pos++] = num/i;
				check = num/i;
			}
		}
	}
	
	public void checkSquares() {
		for(int i = 2; i < Math.sqrt(MAX); i++)
			squares[i*i] = true;
	}
	
	public void sumFactors() {
		for(int i = 0; i < commonFactors.length; i++)
			sumOfFactors += commonFactors[i];
		
		if(squares[num])
			sumOfFactors -= Math.sqrt(num);
		
		lookup[num] = sumOfFactors + 1;
		
	}
	
	static public boolean[] sieve(boolean[] isPrime) {
		int i, j;
		for (i = 0; i < MAX; i++)
			isPrime[i] = true;

		// Sieve Marks off all multiples of i
		for (i = 2; i <= Math.sqrt(MAX); i++)
			if (isPrime[i])
				for (j = 2 * i; j <= MAX; j += i)
					isPrime[j] = false;

		return isPrime;
	}

	static public int countPrimes(boolean[] isPrime) {

		int count = 0;
		// Count how many primes
		for (int i = 0; i < MAX; i++)
			if (isPrime[i])
				count++;

		return count;

	}

	// Find the prime factors of num
	public int[] factors(int num) {
		factors = new int[20];
		for (int i = 2, j = 0; i < num / 2; i++)
			// Changed from MAX
			if (isPrime[i] && num % i == 0) {
				factors[j] = i;
				j++;

			}

		return factors;
	}

	// Test to see if the prime factors multiply to equal num
	public boolean testFactors(int num, int[] factors) {
		int sum = 1;
		for (int i = 0; factors[i] != 0; i++)
			sum *= factors[i];

		if (sum == num)
			return true;
		else
			return false;
	}

	// Test to see if the prime factors and their powers multiply out to num
	public int testFactors(int num, int[] factors, int[] powers) {
		int sum = 1, temp = 1;
		for (int i = 0; factors[i] != 0; i++) {

			if (powers[i] != 0) {
				temp = factors[i];
				for (int j = 1; j < powers[i]; j++)
					temp *= factors[i];

				sum *= temp;
			}

			else
				sum *= factors[i];
		}

		if (sum != num)
			return num / sum;
		else
			return 0;
	}

	// Find what powers the primes are raised to
	public int[] powersOfFactors(int[] factors, int num) {
		int temp = 1, power, k = 0;
		int[] powers = new int[20];
		for (int i = 0; factors[i] != 0; i++) {
			// Save the index of factors as the power long temp and power
			power = factors[i];
			temp = factors[i];

			// check to see if the prime factor has more factors
			// keep raising the factor by the index and keep track
			// of how many times this is done with k
			while (num % temp == 0) {
				temp *= power;
				k++;
			}

			// Save the number of times we raised temp to power and reset k
			powers[i] = k;
			k = 0;
		}

		// Check to make sure the powers of factors have a product of num
		int test = testFactors(num, factors, powers);
		if (test != 0) {
			int i;
			for (i = 0; factors[i] != 0; i++) {
			}
			factors[i] = test;
			powers[i] = 1;
		}

		// return the results
		return powers;
	}
	
	static boolean isAmicable(int[] lookup, int num, int num2) {
		
		if(num == num2)
			return false;
		
		if(lookup[num] == num2 && lookup[num2] == num)
			return true;
		return false;
	}
	public static void main(String[] args) {

		boolean[] isPrime = new boolean[MAX+1];
		isPrime = sieve(isPrime);
		Scanner sc = new Scanner(System.in);
		CommonFactors cf = new CommonFactors(1, isPrime);
		cf.checkSquares();
		for(int i = 2; i <= 10000; i++) {
			cf.num = i;
			cf.saveFactors();
			cf.sumFactors();
			cf.sumOfFactors = 0;
		}
		
		int sum = 0;
		for(int i = 5; i < 10000; i++) {
			for(int j = 5; j < 10000; j++) {
				if(isAmicable(cf.lookup, i, j))
					sum += cf.lookup[i];
			}
		}
		
		System.out.println(sum);
	}

}
