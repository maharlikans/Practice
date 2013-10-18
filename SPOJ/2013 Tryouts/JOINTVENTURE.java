import java.util.*;
import java.io.*;

class JOINTVENTURE {
	public static void main (String[] args) throws Exception{
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int x = Integer.parseInt(input.next());
			int n = Integer.parseInt(input.next());
			int l1 = 0, 
				l2 = 0;
			int count = 0;
			int maxDiff = 0;
			boolean[] paired = new boolean[n];
			int[] length = new int[n];
			
			for (int i = 0; i < n; i++) {
				length[i] = Integer.parseInt(input.next());
			}

			Arrays.sort(length);
			
			for (int i = 0; i < n; i++) {
				// if the piece hasn't already been paired with another
				if (!paired[i]) {
					paired[i] = true;
					int diff = x*10000000 - length[i];
					int low = 0;
					int high = length.length - 1;
					int mid = (low + high)/2;

					while (low <= high) {
						mid = (low + high)/2;
						// if a value has been found that matches the difference we're looking for
						if (length[mid] == diff) {
							// then we check if the length has already been looked at or paired with a 
							// separate length.
							if (!paired[mid]) {
								// if so, we update the count, pair the other piece, and update the 
								// maxDifference found if necessary
								count++;
								paired[mid] = true;

								// the maxDiff update must be greater than or equal to for the base
								// condition when maxDiff = 0 and we find a match that actually has 
								// two different pieces of the same length
								if (Math.abs(length[mid] - length[i]) >= maxDiff) {
									l1 = length[i];
									l2 = length[mid];
									maxDiff = Math.abs(l1 - l2);
								}

							// if the piece was a match but it has already been matched,
							// then we look at another piece below this one to see if 
							// we can find another match
							} else if ((mid - 1 >= 0) && (length[mid-1] == diff)) {
								count++;
								paired[mid-1] = true;
								if (Math.abs(length[mid-1] - length[i]) >= maxDiff) {
									l1 = length[i];
									l2 = length[mid-1];
									maxDiff = Math.abs(l1 - l2);
								}

							// if we can't do that, then we look below our current piece
							// and try to match the piece below with our piece we're currently
							// looking at
							} else if ((mid + 1 < length.length) && (length[mid+1] == diff)) {
								count++;
								paired[mid+1] = true;
								if (Math.abs(length[mid+1] - length[i]) >= maxDiff) {
									l1 = length[i];
									l2 = length[mid+1];
									maxDiff = Math.abs(l1 - l2);
								}
							}
							break;
						} else if (length[mid] < diff) {
							low = mid + 1;
						} else {
							high = mid - 1;
						}
					}
				}
			}

			if (count == 0) 
				System.out.println("danger");
			else if (l1 < l2)
				System.out.println("yes " + l1 + " " + l2);
			else 
				System.out.println("yes " + l2 + " " + l2);
		}
	}
}
