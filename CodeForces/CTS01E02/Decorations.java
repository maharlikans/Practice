import java.util.*;

public class Decorations {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {

			String[] first = input.nextLine().split(" ");
			
			int n = Integer.parseInt(first[0]),
				l = Integer.parseInt(first[1]),
				m = Integer.parseInt(first[2]);
			
			if (n == 0)
				break;

			String[] streamers = input.nextLine().split(" ");
			ArrayList[] from = new ArrayList[m];

			for (int i = 0; i < from.length; i++)
				from[i] = new ArrayList<Integer>();

			int sLength = streamers[0].length();
			
			// the DUMBEST BUG EVER
			if (sLength > l) {
				System.out.println(0);
				continue;
			}

			for (int i = 0; i < streamers.length; i++) {
				for (int j = 0; j < streamers.length; j++) {
					if ((streamers[i].substring(1, sLength)).equals(streamers[j].substring(0, sLength-1))) {
						from[j].add(i);
					}
				}
			}
			
			int[][] ways = new int[l+1][m];

			for (int i = 0; i < m; i++) 
				ways[sLength][i] = 1;
			
			int numWays = 0;

lengths:	for (int length = sLength+1; length <= l; length++) {
				numWays = 0;
streamers:		for (int i = 0; i < m; i++) {
prepended:			for (int j = 0; j < from[i].size(); j++) 
						ways[length][i] += ways[length-1][(int)from[i].get(j)];
					numWays += ways[length][i];
				}
			}

			System.out.println(numWays);

			
		}
	}
}
