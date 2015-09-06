
public class QuadtraticPrimes {

	public final static int N = 10000000;
	public final static int out = 1000;
	public boolean[] isPrime = new boolean[N+1];
	int count = 0;
	int answer = 0;
	
	public QuadtraticPrimes() {
		sieve();
		nextAB();
	}
	public boolean quadratic(int a, int b, int n) {
		return isPrime[Math.abs(((n*n) + a*n + b))];
	}
	
	public void cycle(int a, int b) {
		int i, temp = 0, check = Math.abs(a);
		
		for(i = 0; i < check; i++) {
			if(quadratic(a,b,i)) 
				temp++;
			else
				break;
		}
		
		if(temp > count) {
			count = temp;
			answer = a*b;
		}
	}
	
	public void nextAB() {
		
		int i, j;
		for(i = -999; i < out; i++) 
			if(isPrime[Math.abs(i)])
				for(j = -999; j < out; j++)
					if(isPrime[Math.abs(j)])
						cycle(i, j);
		
	}
	public void sieve() {
		int i, j;
		for (i = 0; i < N; i++)
			isPrime[i] = true;

		for (i = 2; i <= Math.sqrt(N); i++)
			if (isPrime[i])
				for (j = 2 * i; j <= N; j += i)
					isPrime[j] = false;

	}
	
	public static void main(String[] args) {
		QuadtraticPrimes qp = new QuadtraticPrimes();
		System.out.println(qp.answer);

	}

}
