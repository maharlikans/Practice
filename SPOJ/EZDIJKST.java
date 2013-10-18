import java.util.*;
import java.io.*;

class EZDIJKST {
    public static void main(String[] args) throws Exception{
        Parser input = new Parser(System.in);
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int V = input.nextInt(), K = input.nextInt();
            int[] dist    = new int[V+1];
            boolean[] visited = new boolean[V+1];
            int[][] cost  = new int[V+1][V+1];
            ArrayList[] vertices = new ArrayList[V+1];
            //ArrayList<ArrayList<Integer>> vertices;
            for(int j = 0; j < vertices.length; j++) {
            	vertices[j] = new ArrayList();
            }
            Arrays.fill(dist, Integer.MAX_VALUE);
            for(int j = 0; j < K; j++) {
                int a = input.nextInt();
                int b = input.nextInt();
                cost[a][b] = input.nextInt();
                vertices[a].add(b);
            }
            int root = input.nextInt(), dest = input.nextInt();
            dist[root] = 0;
            
            int result = dijkstra(dist, visited, cost, vertices, root, dest);
            if(result == -1)
                System.out.println("NO");
            else 
                System.out.println(result);
        }
    }
    
    public static int dijkstra(int[] dist, boolean[] visited, int[][] cost, ArrayList<Integer>[] vertices, int root, int dest) {
        int currentNode = root;
        while(!visited[dest]) {
        	visited[currentNode] = true;
        	//System.out.println("Current is: " + currentNode);
            for(int i = 0; i < vertices[currentNode].size(); i++) {
                int tentDist = dist[currentNode] + cost[currentNode][vertices[currentNode].get(i)];
                //System.out.println("Adj. node is: " + vertices[currentNode].get(i));
                if(tentDist < dist[vertices[currentNode].get(i)] && !visited[vertices[currentNode].get(i)])
                    dist[vertices[currentNode].get(i)] = tentDist;
            }
            currentNode = min(dist, visited);
            if(currentNode == -1)
                break;
        }
        if(!visited[dest])
            return -1;
        return dist[dest];
    }
    
    public static int min(int[] dist, boolean[] visited) {
        int mindex = -1;
        for(int i = 1; i < dist.length; i++) {
            if(!visited[i]) {
                mindex = i; 
                break;
            }
        }
        if(mindex == -1) return -1;
        for(int i = 1; i < dist.length; i++) { 
            if(!visited[i] && dist[i] < dist[mindex])
                mindex = i;
        }
        if(dist[mindex] == Integer.MAX_VALUE)
            return -1;
        return mindex;
    }
}

//you need to import java.io and throw exceptions in the methods that call nextInt()

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
