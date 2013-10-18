import java.util.*;

public class NSA {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int x = 0; x < T; x++) {
			int N = input.nextInt();
			// exchanges array in which person i exchanges with person exchanges[i]
			int[] exchanges = new int[N + 1];
			boolean[] visited = new boolean[N + 1];
			ArrayList<Integer> cycleSizes = new ArrayList<Integer>();
			for (int y = 1; y <= N; y++) {
				exchanges[y] = input.nextInt();
			}
			
			int numVisited = 0;
			
			// while a cycle and its size has yet to be examined
			while (numVisited < N) {
				int begin = -1;
				int sizeCycle = 0;
				for (int i = 1; i <= N; i++) {
					if (!visited[i])
						begin = i;
				}

				// exchange the position of the beginning person
				int current = exchanges[begin];
				numVisited++;
				sizeCycle++;
				visited[begin] = true;

				// trace to the next exchange point
				// visit the current point
				// increase the cycle size and number of people visited
				while (current != begin) {
					visited[current] = true;
					current = exchanges[current];
					sizeCycle++;
					numVisited++;
				}
				cycleSizes.add(sizeCycle);
			}
			
			int LCM = cycleSizes.get(0); 
			for (int i = 1; i < cycleSizes.size(); i++) {
				LCM = lcm(cycleSizes.get(i), LCM);
			}
			System.out.println(LCM);
		}
	}
	
	public static int gcd (int a, int b) {
		int t = 0;
		while (b != 0) {
			t = b;
			b = a % t;
			a = t;
		}
		return a;
	}

	public static int lcm (int a, int b) {
		return (a*b)/gcd(a,b);
	}
}
