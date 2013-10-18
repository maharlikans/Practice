import java.util.*;

public class FlippingGame {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] flippers = new int[n+1];

		// read in input
		int countOnes = 0;
		for (int i = 1; i <= n; i++) {
			int read = input.nextInt();
			if (read == 1) {
				countOnes++;
				flippers[i] = -10;
			} else {
				flippers[i] = 10;
			}
		}

		// implement contiguous sum
		int[] sum = new int[n+1];
		sum[1] = flippers[1];
		int max = sum[1];
		for(int i = 2; i <= n; i++) {
			sum[i] = max(sum[i-1] + flippers[i], flippers[i]);
			if (sum[i] > max)
				max = sum[i];
		}

		System.out.println(countOnes + max/10);
	}

	public static int max(int m, int n) {
		return (m < n) ? n : m;
	}
}
