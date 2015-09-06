import java.math.BigInteger;

// A simple dynamic programming approach to solve Euler 25
public class BigFib {
	
	BigInteger[] fib = new BigInteger[10000];
	
	public BigFib() {
		fib[0] = new BigInteger("1");
		fib[1] = new BigInteger("1");
		addFibs();
	}
	
	public void addFibs() {
		int i;
		for(i = 2; fib[i-1].toString().length() < 1000; i++)
			fib[i] = new BigInteger(fib[i-1].add(fib[i-2]).toString());
		
		System.out.println(i);
	}
	public static void main(String[] args) {
		BigFib bf = new BigFib();
	}

}
