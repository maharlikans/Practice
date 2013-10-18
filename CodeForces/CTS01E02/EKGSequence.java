import java.util.*;

/*
 * i calculate the entire sequence first by brute force
 * then reference all the locations of the numbers I store 
 * in the locations array and print them out 
 *
 * I did some quick calculations and here's why this crap works:
 * 		Max # factors: 7 on 510510, average # factors: 2.853714 
 * 		factorization for 510510: [2, 3, 5, 7, 11, 13, 17]
 * 		worst case, then, is 7 iterations for minimum check, which is low
 * 		average case 3 for minimum check
 * 		average # iterations in factorization per number: 178.693392
 * 		number of iterations to get all numbers <= 300000 in sequence: 584896
 * 		584896*178*3 = 312334464 
 * 		hence: small enough to be done without timing out in 1 second
 */

public class EKGSequence {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		//long start = System.currentTimeMillis();
		//System.err.println(start);
		int[] locations = new int[2000000];
		int[] pointers = new int[1000001];
		int count = 2;
			//numIterations = 0;

		locations[0] = -1;
		locations[1] = 1;
		locations[2] = 2;
		pointers[2] = 2;

		int n,
			currNum = 2,
			currLocation = 3;

		ArrayList<Integer> factors;
		int nextNumber = Integer.MAX_VALUE, 
			potentialNext = 0, 
			iterations = 0,
			factor = 0,
			currentFactor;
		while (count < 300000) {
			// System.out.printf("Currently looking at %d in EKGS\n", currNum);
			 factors = factor(currNum);

			/*
			System.out.println("The locations");
			for (int i = 0; i < 20; i++) {
				System.out.printf("%d in location %d\n", i, locations[i]);
			}
			*/

			nextNumber = Integer.MAX_VALUE;
			potentialNext = 0;
			iterations = 0;
			factor = 0;

			for (int i = 0; i < factors.size(); i++) {

				currentFactor = factors.get(i);
				potentialNext = pointers[currentFactor];// + factors.get(i);
				// System.out.printf("Currently looking at factor %d \n", factors.get(i));

				while (locations[potentialNext] != 0) {
					potentialNext += currentFactor;
					// System.out.printf("PotentialNext val iterating %d \n", potentialNext);
				}

				if (potentialNext < nextNumber) {
					nextNumber = potentialNext;
					factor = currentFactor;
				}
			}

			pointers[factor] = nextNumber;
			locations[nextNumber] = currLocation++;
			currNum = nextNumber;

			if (currNum <= 300000) {
				count++;
			}
			//numIterations++;

			/*
			System.out.println("The sequence so far: ");
			for (int i = 0; i < seq.size(); i++)
				System.out.println(seq.get(i));
			*/

			/*
			if (currNum == n) {
				System.out.printf("The number %d appears in location %d.\n", n, locations[n]);
				break;
			}
			*/
		}

		//System.err.println(numIterations);
		// read input and print the location of the number
		while (true) {
			n = Integer.parseInt(input.next());
			if (n == 0)
				break;
			System.out.printf("The number %d appears in location %d.\n", n, locations[n]);
		}

		// System.out.println(System.currentTimeMillis() - start);
	}

	public static ArrayList<Integer> factor (int num) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int factor = 2; factor*factor <= num; factor++) {
			if (num % factor == 0) {
				factors.add(factor);
				num /= factor;
				while (num % factor == 0) 
					num /= factor;
			}
		}
		if (num != 1) 
			factors.add(num);
		return factors;
	}
}


/* to derive the results in the comments, I used the following test program
import java.util.*;

public class Test {
	static int totalIterations = 0;
	public static void main (String[] args) {
		int maxFactors = -1,
			totalFactors = 0,
			currFactors = 0,
			number=0;
		ArrayList<Integer> maxFactorization = new ArrayList<Integer>();

		for (int i = 2; i <= 1000000; i++) {
			currFactors = factor(i).size();	
			if (currFactors > maxFactors) {
				maxFactors = currFactors;
				maxFactorization = factor(i);
				number = i;
			}
			totalFactors += currFactors;
		}

		System.out.printf("Max # factors: %d on %d, average # factors: %f\n", maxFactors, number, totalFactors/999998.0);
		System.out.printf("Average iterations per number: %f\n", totalIterations/999998.0);
		System.out.println(maxFactorization.toString());
	}

	public static ArrayList<Integer> factor (int num) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int factor = 2; factor*factor <= num; factor++) {
			totalIterations++;
			if (num % factor == 0) {
				factors.add(factor);
				num /= factor;
				while (num % factor == 0) 
					num /= factor;
			}
		}
		if (num != 1) 
			factors.add(num);
		return factors;
	}
}
*/
