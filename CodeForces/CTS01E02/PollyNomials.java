import java.util.*;

public class PollyNomials {
	public static void main (String[] args) {
		Scanner input = new Scanner (System.in);
		int count = 1;
		while (true) {
			int n = input.nextInt();
			if (n == 0) 
				break;

			int[] coeff = new int[n+1];
			for (int i = 0; i <= n; i++) 
				coeff[i] = input.nextInt();

			int x = input.nextInt(),
				result = 1,
				numPresses = 0;

			// i start numPresses at 0 because my solution overcounts the first press of x as 
			// *, x, when it should just be x only

			for (int i = 1; i <= n; i++) {
				// System.err.println("coeff: " + coeff[i]);
				result = coeff[i] + result*x;
				numPresses += Integer.toString(coeff[i]).length() + 3; // 3 presses: *, x, +
				if (coeff[i] == 0) 
					numPresses -= 2;
				// System.err.println(result);
				// System.err.println(numPresses);
			}

			System.out.printf("Polynomial %d: %d %d\n", count++, result, numPresses);
		}
	}
}
