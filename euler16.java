import java.math.BigInteger;

// This class was slightly altered to answer Euler 18
public class PowerDig {

	//static final int N = 1000;
	static final int N = 100;
	
	public static void main(String[] args) {
		
		BigInteger x, y;
		y = new BigInteger("100"); 			// This was changed from 2 to 100
		x = new BigInteger("1");   			// this should be 2 for Euler 16
		
		for(int i = 99; i > 0; i--) {		// Change for loop back to 0 and increment to N
			String s = Integer.toString(i); // Remove for Euler 16
			x = new BigInteger(s);  		// Remove for Euler 16
			y = y.multiply(x);
		}
		
		String str = y.toString();
		char []temp = new char[str.length() +1];
		temp = str.toCharArray();
		int answer = 0;
		
		for(int i = 0; i < str.length(); i++) {
			String s = String.valueOf(temp[i]);
			answer += Integer.parseInt(s);
		}
		
		System.out.println(answer);
	}
}
