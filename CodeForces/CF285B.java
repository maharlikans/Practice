import java.util.*;
public class CF285B {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(); 
		int s = input.nextInt(); 
		int t = input.nextInt(); 
		int counter = 0;
		boolean[] visited = new boolean[n+1];
		int[] shuffle = new int[n+1];
		
		if(s == t) {
			System.out.println(0);
			return;
		}

		// while reading, check if shuffles map to same pos
		boolean selfmap = true;

		int read;
		for (int i = 1; i <= n; i++) {
			read = input.nextInt();
			if(read != i) 
				selfmap = false;
			shuffle[i] = read;
		}

		if(selfmap) {
			System.out.println(-1);
			return;
		}

		int current = s;
		visited[current] = true;
		for (int i = 1; i <=n; i++) {
			if(!visited[shuffle[current]]) {
				counter++;
				current = shuffle[current];
				if(current == t)
					break;
			} else 
				break;
		}
		if(visited[t])
			System.out.println(counter);
		else
			System.out.println(-1);
	}
}