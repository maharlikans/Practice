import java.util.*;

public class MEET {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int i = 0; i < T; i++) {
			int N = input.nextInt();
			int[] members = new int[N];
			for (int j = 0; j < N; j++) {
				members[j] = input.nextInt();
			}
			if (N == 2) 
				System.out.println(1);
			else {
				int best = getBest(members);
				int worst = getWorst(members);
				int sizeBest = countElem(members, best);
					
				// worst and best are the same thing, which means we only take the # diff 
				// combinations of 2 out of the set max or min * 2^(N - (2))
				long result = 0;
				long obsev = 1000000007;
				if (best == worst) {
					result = pow(2, N) - (1 + N);
					System.out.println(result);
				} else {
					int sizeWorst = countElem(members, worst);
					// ((size of max set) * (size of min set) * 2^(N-2)) % 1000000007
					long r1 = ((pow(2, sizeBest) - 1)*(pow(2, sizeWorst) - 1)) % obsev;
					long r2 = (r1*pow(2, N-(sizeBest + sizeWorst))) % obsev;
					System.out.println(r2);
				}
			}
		}
	}

	public static int getBest(int[] a) {
		int best = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > best)
				best = a[i];
		}
		return best;
	}
	
	public static int getWorst(int[] a) {
		int worst = 1001;
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < worst)
				worst = a[i];
		}
		return worst;
	}

	public static int countElem(int[] a, int elem) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == elem)
				count++;
		}
		return count;
	}
	
	/*
	public static long factorial(int n) {
		long result = 1;
		for (long i = 1; i <= n; i++) {
			result *= i;
		}
		return (result);
	}
	*/

	public static long pow(int base, int exp) {
		long r = 1;
		for (int i = 1; i <= exp; i++) {
			r = (r * base) % 1000000007;
		}
		return r;
	}
}
