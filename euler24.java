
// This does not print permutations in lexographic order
// I actually solved this problem by hand using combinatorics
public class Permutations {

	char[] perm = new char[10];
	int count = 0;
	public final static int N = 1000000;
	String number = "0123456789";
	int pos = 0;
	
	public Permutations (String perm) {
		this.perm = perm.toCharArray();
		permute(0);
	}
	
	 public void swap(int i, int j) {
		char temp = perm[i];
		perm[i] = perm[j];
		perm[j] = temp;
	}
	
	public void permute(int k) {
		
		if(k == perm.length) {
			count++;
			if(count == N-1) {
				System.out.println(perm);
				return;
			}
		}
		
		for(int i = k; i < perm.length; i++) {
			
			swap(k, i);
			permute(k+1);
			swap(i, k);
		}
	}
	public static void main(String[] args) {
		Permutations perm = new Permutations("0123456789");

	}

}
