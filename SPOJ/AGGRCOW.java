import java.util.*;
import java.io.*;

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

class AGGRCOW {
    public static void main(String[] args) throws Exception{
        Parser input = new Parser(System.in);
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int N = input.nextInt();
            int C = input.nextInt();
            int[] stalls = new int[N];
            for(int k = 0; k < N; k++)
                stalls[k] = input.nextInt();
            
            // sort the stalls
            Arrays.sort(stalls);
            ArrayList differences = new ArrayList();
            
            // have the stalls, begin binary searching the differences
			// AGAIN we're binary searching differences and checking
			// if the difference we find is valid
			// if it's too high, then we search for a lower value
			// if it's valid, then we search for a higher value
			// until min <= max
            int min = 0, max = 1000000000, mid;
            int diff = 0;
            while(min <= max) {
                mid = (min + max)/2;
                if(checkDiff(stalls, mid, C)) {
					diff = mid;
                    min = mid + 1;
                } else
                    max = mid - 1;
            }
            
            System.out.println(diff);
            
        }
    }
    
	// the checkDiff function verifies that a certain distance is 
	// possible with the stall configurations we have
    static boolean checkDiff(int[] stalls, int diff, int cows) {
        int a = 0, b = 1, count = 1;
        while(b != stalls.length && (count < cows)) {
            if(stalls[b] - stalls[a] >= diff) {
                a = b;
                b = a + 1;
                count++;
            } else 
                b++;
        }
        if(count < cows)
            return false;
        else 
            return true;
    }
}
