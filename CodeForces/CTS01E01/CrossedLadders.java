import java.util.*;

/* 2013-2014 CT S01E01: Extended 2000 ACM-ICPC East Central North America Regional Contest (ECNA 2000) 
 *
 * this solution binary searches the possible bases after setting up a proper equation
 *
 * a few lessons learned:
 * 		if you can't come up with the math for an answer, don't try to
 * 		setting too low of an acceptable error will cause the binary search to run forever
 *		not setting right and left to desired value +- epsilon will also make it run forever
 *		only binary search VALID values (i.e. make sure your value in sqrt is not negative at any time)
 *		rounding errors are dumb and doubles are also kind of dumb
 */

public class CrossedLadders {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			double x = input.nextDouble(),
				   y = input.nextDouble(),
				   c = input.nextDouble();
			double epsilon = 0.00000000001;

			double left = 0,
				   right = x > y ? y : x,
				   base = (left+right)/2.0;

			double value = Math.sqrt(Math.pow(x, 2) - Math.pow(base, 2))*(1.0 - ((double)c)/Math.sqrt(Math.pow(y, 2) - Math.pow(base, 2)));

			while (true) {
				base = (left+right)/2;
				value = Math.sqrt(Math.pow(x, 2) - Math.pow(base, 2))*(1.0 - ((double)c)/Math.sqrt(Math.pow(y, 2) - Math.pow(base, 2)));
				if (((c - epsilon) < value) && (value < (c + epsilon))) 
					break;
				else if (value < (c - epsilon)) {
					right = base - epsilon;
				} else {
					left = base + epsilon;
				}
			}

			base = Math.rint(base*1000.0)/1000.0;
			System.out.printf("%.3f\n", base);
		}
	}
}
