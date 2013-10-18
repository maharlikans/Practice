import java.util.*;
import java.io.*;

class HIGHWAYS {
    public static void main(String[] args) throws Exception {
        
		Parser input = new Parser(System.in);
        int t = input.nextInt();

        for(int z = 0; z < t; z++) {
            int V = input.nextInt();
			int K = input.nextInt();
			int infinity = 200000000;
			// dist is the DIST FROM ROOT
            int[] dist = new int[V+1];
            boolean[] visited = new boolean[V+1];
			ArrayList[] neighbors = new ArrayList[V+1];

            for(int j = 1; j <= V; j++) {
				neighbors[j] = new ArrayList<Pair>();
            }

            Arrays.fill(dist, infinity);
			int root = input.nextInt();
			int dest = input.nextInt();

            for(int j = 0; j < K; j++) {
                int a = input.nextInt();
                int b = input.nextInt();
				int c = input.nextInt();
                neighbors[a].add(new Pair(b, c));
                neighbors[b].add(new Pair(a, c));
            }
			
			PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

            dist[root] = 0;
			pq.offer(new Pair(root, 0));
            
			int currentNode = root;
			Pair currPair = null;

			while(!pq.isEmpty()) {
				currPair = pq.poll();
				if (visited[currPair.city])
					continue;
				else if (currPair.dist == infinity)
					break;
				currentNode = currPair.city;
				visited[currentNode] = true;
				ArrayList<Pair> neigh = neighbors[currentNode];
				for (int i = 0; i < neigh.size(); i++) {
					Pair neighbor = neigh.get(i);
					int tentDist = dist[currentNode] + neighbor.dist;
					if(tentDist < dist[neighbor.city] && !visited[neighbor.city]) {
						dist[neighbor.city] = tentDist;
						pq.offer(new Pair(neighbor.city, tentDist));
					}
				}
			}
			
			if(!visited[dest])
                System.out.println("NONE");
			else 
				System.out.println(dist[dest]);
        }
    }
	
}

class Pair implements Comparable<Pair> {
	public int city;
	public int dist;

	public Pair(int city, int dist) {
		this.city = city;
		this.dist = dist;
	}

	public int compareTo(Pair b) {
		return dist - b.dist;
	}
}

class Parser
{
   final private int BUFFER_SIZE = 1 << 16;
 
   private DataInputStream din;
   private byte[] buffer;
   private int bufferPointer, bytesRead;
 
   public Parser(InputStream in)
   {
      din = new DataInputStream(in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
   }
 
   public int nextInt() throws Exception
   {
      int ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do
      {
         ret = ret * 10 + c - '0';
         c = read();
      } while (c > ' ');
      if (neg) return -ret;
      return ret;
   }
   
   public long nextLong() throws Exception
   {
      long ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do
      {
         ret = ret * 10 + c - '0';
         c = read();
      } while (c > ' ');
      if (neg) return -ret;
      return ret;
   }
 
   private void fillBuffer() throws Exception
   {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1) buffer[0] = -1;
   }
 
   private byte read() throws Exception
   {
      if (bufferPointer == bytesRead) fillBuffer();
      return buffer[bufferPointer++];
   }
} 

