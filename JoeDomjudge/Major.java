import java.util.*;

public class Major {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int i = 0; i < T; i++) {
			// initialize necessary variables
			int N = input.nextInt();
			boolean[] visited = new boolean[N];
			char[] major = new char[N];
			Arrays.fill(major, 'u');
			ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(N);		
			String e;

			// read in graph
			input.nextLine();
			for (int j = 0; j < N; j++) {
				graph.add(new ArrayList<Integer>());
				e = input.nextLine();
				for (int k = 0; k < N; k++) {
					if(e.charAt(k) == 'Y') {
						graph.get(j).add(k);	
					}
				}
			}
			
			// graph constructed, now bfs
			Queue<Integer> q = new LinkedList<Integer>();
			
			int current = 0;
			visited[0] = true;
			q.offer(0);
			major[current] = 'e';
			char othermajor = 's';
			boolean possible = true;

			while (!q.isEmpty()) {
				current = q.poll();
				if ((major[current]) == 'e') {
					othermajor = 's';
					for (int a = 0; a < graph.get(current).size(); a++) {
						int neighbor = graph.get(current).get(a);
						if (!visited[neighbor]) {
							major[neighbor] = othermajor;
							q.offer(neighbor);
							visited[neighbor] = true;
						} else if (major[neighbor] != othermajor) {
							possible = false;
							break;
						}
					}
				}
				else {
					othermajor = 'e';
					for (int a = 0; a < graph.get(current).size(); a++) {
						int neighbor = graph.get(current).get(a);
						if (!visited[neighbor]) {
							major[neighbor] = othermajor;
							q.offer(neighbor);
							visited[neighbor] = true;
						} else if (major[neighbor] != othermajor) {
							possible = false;
							break;
						}
					}
				}
			}

			if (possible)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}

