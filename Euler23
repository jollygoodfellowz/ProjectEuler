
public class AbundantSums {
	
	public final static int N = 28123;
	Number[] numbers = new Number[N];
	boolean[] squares = new boolean[N];
	int[] sumLookup = new int[N];
	int index = 0;
	boolean[] isPrime = new boolean[N];
	
	public AbundantSums () {
		
	}
	static class Number {
		int num;
		int[] factors;
		int sumOfFactors;
		
		public Number(int num, int[] factors, int sumOfFactors) {
			this.num = num;
			this.factors = factors;
			this.sumOfFactors = sumOfFactors;
		}
	}
	
	public void sieve() {
		
		int i, j;
		for (i = 0; i < N; i++)
			isPrime[i] = true;

		// Sieve Marks off all multiples of i
		for (i = 2; i <= Math.sqrt(N); i++)
			if (isPrime[i])
				for (j = 2 * i; j <= N; j += i)
					isPrime[j] = false;
		
	}
	
	 public void saveFactors(int num) {

		int[] commonFactors = new int[100];

		if (isPrime[num] == false) {
			int pos = 0;
			int check = num / 2;
			for (int i = 2; i < check; i++) {
				if (num % i == 0 && num != i) {
					commonFactors[pos++] = i;

					if (numbers[i] == null)
						saveFactors(i);

					commonFactors[pos++] = num / i;

					if (numbers[num / i] == null)
						saveFactors(num / i);

					check = num / i;
				}
			}
		}
		
		numbers[num] = new Number(num, commonFactors, sumFactors(num,commonFactors));

		
	}
	 
	private int sumFactors(int num, int[] factors) {
		int sumOfFactors = 0;

		for (int i = 0; factors[i] != 0; i++)
			sumOfFactors += factors[i];

		if (squares[num])
			sumOfFactors -= Math.sqrt(num);
		
		sumLookup[num] = sumOfFactors + 1;
		
		return sumLookup[num];
	}
	 
	public void checkSquares() {
		for (int i = 2; i < Math.sqrt(N); i++)
			squares[i * i] = true;
	}


	
	public static void main(String[] args) {
		
		AbundantSums as = new AbundantSums();
		as.checkSquares();
		as.sieve();
		for(int i = 2; i < N; i++)
			as.saveFactors(i);

		int[] abundantSums = new int[N];
		long sum = 0;
		for(int i = 2; i < N; i++)
			if(as.numbers[i].sumOfFactors > as.numbers[i].num)
				for(int j = i; j < N; j++) {
					int temp = i + j;
					if(temp < N && as.numbers[j].sumOfFactors > as.numbers[j].num)
						abundantSums[temp] = temp;     // change i to the index of the sum from the if
				}
		
		for(int i = 1; i < N; i++)
			if(abundantSums[i] == 0)
				sum += i;
		System.out.println(sum);
	}

}
