import java.util.*;
public class PiecewiseLinearFunctionDiv2 {
	public static int[] countSolutions(int[] Y, int[] query) {
		int[] count = new int[query.length];			// count the number of solutions to a given query i of N queries
		for (int i = 0; i < Y.length; i++) {			// for each point
			for (int j = 0; j < query.length; j++) {	// check each query to see if the y value matches this query
				if (Y[i] == query[j]) 					// if the y value matches the query
					count[j] += 1;						// then add to the number of solutions possible 
			} 											// for this query across the piecewise function 
		}
		
		for (int i = 1; i < Y.length; i++) {					// iterate over each segment
			System.err.println("Checking segment (" + i + ", " + Y[i-1] + ") to (" + (i+1) + ", " + Y[i] + ")");
			long slope = (Y[i] - Y[i-1]);						// calculate the slope
			long intercept = (long)(Y[i]) - slope*(i+1);		// calc the intercept: y = mx + b <=> b = y - mx; 
			System.err.println("Slope = " + slope);
			System.err.println("intercept = " + intercept);
			for (int q = 0; q < query.length; q++) {			// for each query
				double x = ((long)(query[q]) - intercept)/(double)slope;
				System.err.println("query = " + query[q]);
				if (slope == 0 && intercept == query[q]) { // check for infinite solutions, i.e. m == 0 & b == q
					System.err.println("Had infinite solutions");
					count[q] = -1;								 
				}
				else if ((count[q] != -1) && (i < x) && (x < i+1)){ // if the solution found is in range, then add to count
					System.err.println("Had one solution since x = " + x);
					count[q] += 1;
				}
			}
		}
		return count;
	}
	
	public static void main (String[] args) {
		int[] arg1 = {-6, -14, 7, 12, 2, -5, -24, 12, -12, -6, 20, 11, 0, -10, -11, 17, 9, -24, -8, 21, -14, 18, 14, 8, 10, 18, -6, -8, 1, 1, -22, 16, -16, -10, -5, 4, 3, -12, -24, -3, 23, 1, -15, -1, 2, -5};
		int[] arg2 = {-8, 12, 8, -3, 16, -1, 2, 8, 16, -25, -10, 5, -24, 6, 18, 21, 12, 20, -1, 22, 6, -12, -24, -20, -1, 7, -8, -24, 3, -10, -24, 17, 0, -15, 0, -5, 14, -14, 23, 15, -6, 22, 4, -21, -13, 9, -1, -11, -15, 1};
		int[] counts = countSolutions(arg1, arg2);
		System.err.println(Arrays.toString(counts));
	}
}
