import java.io.*;
import java.util.*;

public class RMQ {
	public static void main(String[] args) throws Exception {
		Parser input = new Parser(System.in);
		int[] tree = new int[treeSize()];
		fill(tree, 1, tree.length/2, tree.length/2 + );
	}

	public static int treeSize(int n) {
		int leaf = 1;
		while(true) {
			if(n > leaf)
				leaf = leaf << 1;
			else 
				break;
		}
		return 2*leaf;
	}
			
	public static void fill(int[] tree, int root, int left, int right) {
		// continue here
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
