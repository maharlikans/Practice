import java.util.*;
import java.io.*;
//you need to import java.io and throw exceptions in the methods that call nextInt()

class CHICAGO {
	public static void main(String[] args) throws Exception{
		Parser input = new Parser(System.in);
		int n, m;
		n = input.nextInt();
		while(n != 0) {
			m = input.nextInt();
			// System.err.println("n is " + n + " and m is " + m);
			Vertex[] graph = new Vertex[n + 1];
			boolean[] visited = new boolean[n + 1];
			double[][] cost = new double[n + 1][n + 1];
			double[] dist = new double[n + 1];
			Arrays.fill(dist, 0);
			for(int i = 1; i <= n; i++) {
				graph[i] = new Vertex(i, n);
			}
			for(int i = 0; i < m; i++) {
				int a = input.nextInt();
				int b = input.nextInt();
				int p = input.nextInt();
				cost[a][b] = p*(.01);
				cost[b][a] = p*(.01);
				graph[a].conn.add(b);
				graph[b].conn.add(a);
				/*
				System.out.println("cost from " + a + " to " + b + " is " + cost[a][b]);
				System.out.println("cost from " + b + " to " + a + " is " + cost[b][a]);
				System.out.println("vertex " + a + " has connection to " + b + ": " + graph[a].conn.contains(b));
				System.out.println("vertex " + b + " has connection to " + a + ": " + graph[b].conn.contains(a));
				*/
			}
			
			int current = 1;
			dist[current] = 1;
			while(!visited[n]) {
				visited[current] = true;
				for(int i = 0; i < graph[current].conn.size(); i++) {
					int neighbor = graph[current].conn.get(i);
					if(!visited[neighbor]) {
						// System.out.println(" ------------------------ ");
						// System.out.println("Visiting neighbor " + neighbor + " from " + current);
						double tempDist = dist[current]*cost[current][neighbor];
						// System.out.println("dist[current]*cost[current][neighbor] = " + dist[current] + "*" + cost[current][neighbor] + " = " + tempDist);
						if(tempDist > dist[neighbor])
							// System.out.println("Temp dist " + tempDist + " less than " + dist[neighbor]);
							dist[neighbor] = tempDist;
					}
				}
				current = max(dist, visited);
				if(current == n)
					break;
			}
			//System.out.println(Arrays.toString(dist));
			System.out.printf("%.6f percent", dist[n]*100);
			System.out.println();
			n = input.nextInt();
		}
	}
	
	public static int max(double[] dist, boolean[] visited) {
        int maxdex = -1;
        for(int i = 1; i < dist.length; i++) {
            if(!visited[i]) {
                maxdex = i;
                break;
            }
        }
        for(int i = 1; i < dist.length; i++) { 
            if(!visited[i] && dist[i] > dist[maxdex])
                maxdex = i;
        }
        return maxdex;
    }
	
	/*public static double round(double num) {
		double blah = Math.rint(num*100000);
		return blah/100000;
	}*/
}

class Vertex {
	public int index;
	public ArrayList<Integer> conn;
	
	public Vertex(int index, int size) {
		this.index = index;
		conn = new ArrayList<Integer>(size);
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
