import java.util.*;

public class Intersections {
	public static void main (String[] args) {
		Scanner input = new Scanner (System.in);

		int n = input.nextInt();
		int numInter = n*(n-1)/2;

		ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
		boolean[][] inset = new boolean[n+1][10000+1];
		int[][][] intersections = new int[n+1][n+1][];

		for (int i = 0; i <= n; i++) {
			sets.add(new ArrayList<Integer>());
		}

		// iterate over all given intersections
		for (int z = 0; z < numInter; z++) {
			int x = input.nextInt();
			int y = input.nextInt();
			int k = input.nextInt();
			int v;
			intersections[x][y] = new int[k];
			intersections[y][x] = new int[k];

			for (int i = 0; i < k; i++) {
				v = input.nextInt();
				
				// add this value to the intersection
				intersections[x][y][i] = v;
				intersections[y][x][i] = v;

				// only add to each individual set if the value wasn't already there
				if (!inset[x][v]) {
					sets.get(x).add(v);
					inset[x][v] = true;
				} 
				if (!inset[y][v]) {
					sets.get(y).add(v);
					inset[y][v] = true;
				}
			}
		}
			
		// recheck after we've established all our sets using
		// the data given to us by the intersections
		for (int i = 1; i < intersections.length; i++) {
			for (int j = 1; j < intersections[i].length; j++) {
				if (intersections[i][j] != null) {
					if(!checkSets(i, j, sets, intersections)) {
						System.out.println("No");
						return;
					}
				}
			}
		}

		System.out.println("Yes");
		int sizeSet;
		for (int i = 1; i < sets.size(); i++) {
			sizeSet = sets.get(i).size();
			System.out.print(sizeSet + " ");
			for (int j = 0; j < sizeSet; j++)
				System.out.print(sets.get(i).get(j) + " ");
			System.out.println();
		}
	}

	public static boolean checkSets(int x, int y, ArrayList<ArrayList<Integer>> sets, int[][][] intersections) {
		// build the intersection that exists so far
		ArrayList<Integer> buildInter = new ArrayList<Integer>();

		for (int i = 0; i < sets.get(x).size(); i++) {
			if (sets.get(y).contains(sets.get(x).get(i))) {
				buildInter.add(sets.get(x).get(i));
			}
		}

		/*
		System.out.println("Set " + x + ": " + sets.get(x).toString());
		System.out.println("Set " + y + ": " + sets.get(y).toString());
		System.out.println("Actual Intersection: " + buildInter.toString());
		System.out.print("Given Intersection: ");
		for (int e : intersections[x][y]) {
			System.out.print(e + " ");
		}
		System.out.println();
		*/
		
		// if the intersection we build doesn't have the same # 
		// of elements as the intersection given to us, it's not possible
		if (buildInter.size() != intersections[x][y].length) {
			return false;
		}

		// now check the elements in the actual intersection built
		// against those in the given intersection
		for (int i = 0; i < buildInter.size(); i++) {
			int element = buildInter.get(i);
			boolean found = false;
			for (int j = 0; j < intersections[x][y].length; j++) 
				if (element == intersections[x][y][j])
					found = true;

			if (!found) {
				System.out.println("No");
				return false;
			}
		}
		return true;
	}
}
