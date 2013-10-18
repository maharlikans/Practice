import java.util.*;

public class Bag {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for (int t = 0; t < cases; t++) {
			int n = input.nextInt();
			int[] bags = new int[n];
			int goal = input.nextInt();

			for (int i = 0; i < n; i++) {
				bags[i] = input.nextInt();
			}

			// all possible subsets can be represented in binary numbers
			// because we either add the bag to the sum, or we don't
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
				sum = 0;
			}
			System.out.println(canFill);
		}
	}
	
	public static int pow (int b, int r) {
		int res = b;
		for (int i = 0; i < r; i++) {
			res *= b;
		}
		
		return res;
	}
}
