import java.util.*;

public class BagHard {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for (int t = 0; t < cases; t++) {
			int n = input.nextInt();
			int half = n/2;
			int[] bags = new int[n];
			int goal = input.nextInt();

			for (int i = 0; i < n; i++) {
				bags[i] = input.nextInt();
			}
			
		}
	}

	public static boolean subsets (int[] setsum, int[] bags, int n, int goal) {
		int sum = 0;
		boolean canFill = false;
		for (int i = 0; i < pow(2, n); i++) {
			for (int j = 0; j < n; j++) {
				if ((i & pow(2, j)) > 0)
					sum += bags[j];
			}
			if (sum == goal) {
				canFill = true;
			}
			setsum[i] = sum;
			sum = 0;
		}
		return canFill;
	}
	
	public static int pow (int b, int r) {
		int res = b;
		for (int i = 0; i < r; i++) {
			res *= b;
		}
		
		return res;
	}
}
