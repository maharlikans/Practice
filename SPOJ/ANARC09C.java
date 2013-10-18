import java.util.*;

class ANARC09C {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int first, second;
		boolean [] sieve = new boolean[1001];
		int [] powers    = new int[1001];
		for(int i = 0; i < sieve.length; i++) {
			sieve[i] = true;
		}
		// build the sieve of erastosthenes for prime numbers
		for(int i = 2; i < sieve.length; i++) {
			for(int j = i; j < sieve.length; j += i) {
				sieve[j] = false; // mark all non-primes false
			}
		}
		
		while(true) {
			first = input.nextInt();
			second = input.nextInt();
			if(first == 0 && second == 0)
				break;
			
			// find all the prime factors which can build each individual number
			
			// take the intersection of the two sets of factors (these are the planes which they can be plotted in)
		
			// then take the distance between the two points (abs(difference between unique prime factor's exponents) + abs(diff between unique prime factor's exp)
		}
	}
}
