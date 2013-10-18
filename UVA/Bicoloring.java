import java.util.*;

//    10004 Bicoloring problem on UVA - problem 945, 
//    no node will have an edge to itself.
//    the graph is nondirected. That is, if a node a is said to be connected to a node b, then you must assume that b is connected to a.
//    the graph will be strongly connected. That is, there will be at least one path from any node to any other node.  

public class Main {
	public static void main (String[] args) {
		Scanner input = new Scanner (System.in);

		while (true) {
			int n = input.nextInt();
			if (n == 0)
				break;
			
			int l = input.nextInt();
			
			ArrayList[] graph = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				graph[i] = new ArrayList<Integer>();
			}

			boolean[] visited = new boolean[n];
			int[] colored = new int[n];

			for (int i = 0; i < l; i++) {
				int a = input.nextInt(),
					b = input.nextInt();

				graph[a].add(b);
				graph[b].add(a);
			}

			Queue<Integer> q = new LinkedList<Integer>();

			// the "root node" is 0 in this case, 
			// or at least that's what I'm considering it to be

			q.offer(0);
			visited[0] = true;
			colored[0] = 1; // first kind of thing

			int currentNode;
			boolean bipartite = true;

			while (!q.isEmpty()) {
				currentNode = q.poll();
				ArrayList<Integer> neighbors = graph[currentNode];
				for (int i = 0; i < neighbors.size(); i++) {
					int neighbor = neighbors.get(i);
					if (!visited[neighbor]) {
						q.offer(neighbor);
						visited[neighbor] = true;
						if (colored[currentNode] == 1) 
							colored[neighbor] = 2;
						else
							colored[neighbor] = 1;
					} else if (colored[neighbor] == colored[currentNode]) {
						bipartite = false;	
					}
				}
			}

			if (bipartite)
				System.out.println("BICOLORABLE.");
			else 
				System.out.println("NOT BICOLORABLE.");
		
		}
			
	}
}
