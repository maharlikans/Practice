// Kyle Maharlika
// NSA2 regular version
import java.util.*;

public class NSA2 {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int x = 0; x < T; x++) {
			int N = input.nextInt();
			int[] exchanges = new int[N+1];
			for (int y = 1; y <= N; y++) {
				exchanges[y] = input.nextInt();
			}
			int K = input.nextInt();
			int[] start = new int[K+1];
			int[] end = new int[K+1];
			int[] numShifts = new int[K+1];
			int[] cycleLengths = new int[K+1];

			for (int y = 1; y <= K; y++) {
				start[y] = input.nextInt();
				end[y] = input.nextInt();
			}

			// given the loop, find the number of steps until the person is at their goal
			// and find the length of the cycle
			for (int i = 1; i <= K; i++) {
				int nShifts;
				int cLength;
				if (exchanges[start[i]] != start[i]) {
					// exchange the first position
					int s = exchanges[start[i]];
					int g = end[i];
					boolean reached = false;
					nShifts = 1;
					cLength = 1;

					while (s != start[i]) {
						if (s == end[i])
							reached = true;
						s = exchanges[s];
						cLength++;
						if (!reached) 
							nShifts++;
					}
				} else {
					nShifts = 1;
					cLength = 1;
				}
				numShifts[i] = nShifts;
				cycleLengths[i] = cLength;
			}

			// calculate value n1*n2*...*n(k-1)*nk
			long ncalc = 1;
			for (int i = 1; i <= K; i++)
				ncalc *= cycleLengths[i];
				
			// final algorithm
			// http://en.wikipedia.org/wiki/Chinese_remainder_theorem#A_constructive_algorithm_to_find_the_solution 
			long answer = 0;
			for (int i = 1; i <= K; i++) 
				answer += ((long)numShifts[i])*(ncalc/(long)cycleLengths[i])*euclidean((long)cycleLengths[i], ncalc/(long)cycleLengths[i]);

			long i = answer % ncalc;
			if (i<0) i += ncalc;
			System.out.println(i);
		}
	}
	
	// will return the si value to be multiplied
	public static long euclidean(long a, long b) {
		ArrayList<Long> R = new ArrayList<Long>();
		ArrayList<Long> S = new ArrayList<Long>();
		ArrayList<Long> T = new ArrayList<Long>();
		int n = 1;
		long r = -1;
		
		// initialize row n = 0 of table
		R.add(a);
		S.add((long)1);
		T.add((long)0);
		
		// initialize row n = 1 of table
		R.add(b);
		S.add((long)0);
		T.add((long)1);
		
		long q = 1; // initialize quotient variable
		while(r != 0) {
			q = R.get(n-1)/R.get(n);
			r = R.get(n-1) % R.get(n); // calc next remainder
			R.add(r); 
			S.add(S.get(n-1) - q*S.get(n)); // calc next s for bezout pair
			T.add(T.get(n-1) - q*T.get(n)); // calc next t for bezout pair
			n++;
		}
		n--; // loop will iterate one over the row needed in the table
		
		return T.get(n);
	}
}
