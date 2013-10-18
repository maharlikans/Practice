import java.util.*;
import java.io.*;

// lots of small changes made to code to make it run under the time necessary to pass spoj test

class TDBFS {
    public static void main(String[] args) throws Exception{
        Parser input = new Parser(System.in);
        StringBuilder output = new StringBuilder();
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int n = input.nextInt();
            Vertex[] vertices = new Vertex[n+1];
            
            // read in the vertices
            for(int j = 1; j < vertices.length; j++) {
                int v = input.nextInt();
                int m = input.nextInt();
                vertices[j] = new Vertex(v, m);
                for(int k = 0; k < m; k++) {
                    vertices[j].connected[k] = input.nextInt();
                }
            }
            output.append("graph " + (i + 1) + "\n");
            // begin queries
            while(true) {
                int v = input.nextInt();
                int bOrD = input.nextInt();
                if(v == 0 && bOrD == 0)
                    break;
                    
                // do BFS
                if(bOrD == 1) {
                    Queue<Integer> toVisit = new LinkedList<Integer>();
                    ArrayList<Integer> result = new ArrayList<Integer>(vertices.length);
                    boolean[] vis = new boolean[vertices.length];
                    toVisit.offer(v);
                    vis[v] = true;
                    
                    while(!toVisit.isEmpty()) {
                        int examine = toVisit.remove();
                        
                        // search the vertex's neighbors
                        for(int z = 0; z < vertices[examine].connected.length; z++) {
                            int add = vertices[examine].connected[z];
                            if(!vis[add]) {
                                toVisit.offer(add);
                                vis[add] = true;
                            }
                        }
                        result.add(examine);
                    }
                    
                    for(int b = 0; b < result.size(); b++)
                        output.append(result.get(b) + " ");
                    output.append("\n");
                } 
                // do DFS
                else {
                    Stack<Integer> toVisit = new Stack<Integer>();
                    ArrayList<Integer> result = new ArrayList<Integer>(vertices.length);
                    boolean[] vis = new boolean[vertices.length];
                    toVisit.push(v);
                    result.add(v);
                    vis[v] = true;
                    
                    while(!toVisit.empty()) {
                        int examine = toVisit.peek();
                        boolean unvisited = false;
                        
                        // search vertex to see if there are any unvisited neighbors
                        for(int z = 0; z < vertices[examine].connected.length; z++) {
                            int add = vertices[examine].connected[z];
                            if(!vis[add]) {
                                toVisit.push(add);
                                result.add(add);
                                vis[add] = true;
                                unvisited = true;
                                break;
                            }
                        }
                        
                        // if the vertex has no unvisited neighbors
                        if(!unvisited) {
                            toVisit.pop();
                        }
                    }
                    
                    for(int b = 0; b < result.size(); b++) {
                        output.append(result.get(b) + " ");
                    }
                    output.append("\n");
                }
            }
        }
        System.out.print(output + "");
    }
}

class Vertex {
    public int vertex;
    public int[] connected;

    public Vertex(int vertex, int neighbors) {
        this.vertex = vertex;
        connected = new int[neighbors];
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
