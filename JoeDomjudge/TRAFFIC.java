import java.util.*;

public class TRAFFIC {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		// cases
		int T = input.nextInt();
		for (int z = 0; z < T; z++) {
			int N = input.nextInt();
			Intersection[] intersections = new Intersection[N+1];
			// value at time[N+1] is the answer
			int[] time = new int[N+2];
			
			// initialize time array for pseudo-Dijkstra
			for (int i = 0; i < time.length; i++) 
				time[i] = Integer.MAX_VALUE;

			// read in intersections
			// where y is the current intersection
			for (int y = 1; y <= N; y++) {
				int K = input.nextInt();
				intersections[y] = new Intersection(K);
				
				// read in paths for intersection
				for (int x = 1; x <= K; x++) {
					intersections[y].paths[x] = input.nextInt();
				}
			}

			int[] mins = mindex(intersections[1].paths); 
			int pathTaken = mins[1];
			time[2] = mins[0];
			time[1] = 0; // time from the first intersection to itself is 0
			int pathTakenNew = 1; // some dummy value
			int currentIntersection = 2; // starting at intersection 2 since we tok care of 1 already

			// do pseudo-dijkstra
			while (currentIntersection < N+1) {
				int[] paths = intersections[currentIntersection].paths;
				for (int i = 1; i <= paths.length - 1; i++) {
					int tentTime;
					if (i == pathTaken) 
						tentTime = time[currentIntersection] + paths[i];
					else
						tentTime = time[currentIntersection] + paths[i] + Math.abs(i - pathTaken);
					if (tentTime < time[currentIntersection + 1]) {
						time[currentIntersection + 1] = tentTime; // i.e. time from the first to the next intersection
						pathTakenNew = i;
					}
				}
				// after iterating through all paths from this intersection to 
				// the next, update pathTaken to the new path we take
				pathTaken = pathTakenNew;
				currentIntersection++;
			}

			System.out.println("It will take no more than " + time[N+1] + " seconds to reach campus from here.");
		}
	}

	// will return a length two array with minimum value at index 0
	// and the index of the minimum value at index 1
	public static int[] mindex (int[] paths) {
		int mindex = -1;
		int minimum = Integer.MAX_VALUE;
		for (int i = 1; i <= paths.length - 1; i++) {
			if (paths[i] < minimum) {
				minimum = paths[i];
				mindex = i;
			}
		}
		int[] r = {minimum, mindex};
		return r;
	}
}

class Intersection {
	// array of paths from this intersection to the next
	public int[] paths;

	public Intersection (int K) {
		paths = new int[K + 1];
	}
}
