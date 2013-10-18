import java.util.*;
import java.io.*;

class PT07Y {
	public static void main (String[] args) throws Exception {
		Parser input = new Parser(System.in);
		
		int N = input.nextInt();
		int M = input.nextInt();
		
		if (M != N-1) {
			System.out.println("NO");
			return;
		}

		ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		ArrayList<Integer> currNode;
		int currNeighbor;
		int count = 0;
		
		for (int i = 0; i <= N; i++)
			tree.add(new ArrayList<Integer>());

		for (int i = 0; i < M; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			tree.get(a).add(b);
			tree.get(b).add(a);
		}

		q.offer(1);
		visited[1] = true;
		count++;

		while (!q.isEmpty()) {
			currNode = tree.get(q.poll());
			for (int i = 0; i < currNode.size(); i++) {
				currNeighbor = currNode.get(i);
				if (!visited[currNeighbor]) {
					q.offer(currNeighbor);
					visited[currNeighbor] = true;
					count++;
				}
			}
		}

		if (count == N) 
			System.out.println("YES");
		else
			System.out.println("NO");
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
