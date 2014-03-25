/*
 
It can be seen that the number, 125874, and its double, 
251748, contain exactly the same digits, but in a different order.

Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 
 */

public class Problem54 {

	public static void main(String[] args) {
		Problem54 prob = new Problem54();
		prob.run();
	}

	private void run() {

		long x = 100000l;

		while (Boolean.TRUE) {
			checkIdentical(x);
			x++;
		}
	}

	private boolean checkIdentical(long x) {
		long dx = x*2; 
				
		int lenX = (int) (Math.log10(x)+1);
		int lenDX = (int) (Math.log10(dx)+1);
		
		if(lenX == lenDX){
			int digits[] = new int[lenX];
			 
		    for (int i = 0; i < lenX; i++)      // Init all counts to zero.
		    	digits[i] = 0;
		 
		    
		    while (x != 0) {     
		    	int n = (int) (x%10L); 
		        digits[n]++;        
		        x /= 10;               
		    }
		    
		    System.out.println("x=" + x + " dx=" + dx);
		}
		
		return false;
	}
}
