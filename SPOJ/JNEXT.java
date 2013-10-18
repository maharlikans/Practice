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

class JNEXT {
    public static void main(String[] args) throws Exception{
        Parser input = new Parser(System.in);
        StringBuilder output = new StringBuilder();
        //StringBuilder.append
        int cases = input.nextInt();
        for(int i = 0; i < cases; i++) {
            int length   = input.nextInt();
            int[] digits = new int[length];
            
            for(int j = 0; j < digits.length; j++)
                digits[j] = input.nextInt();
                
            // when it returns, it'll be permuted
            boolean worked = permutation(digits);
            if(worked == false) {
                output.append(-1);
                output.append("\n");
            } else {
               // String output = "";
                for(int k = 0; k < digits.length; k++)
                    output.append(digits[k]);
                output.append("\n");
            }
        }
        System.out.print(output + "");
    }
    
    static boolean permutation (int[] digits) {
        // find largest index a st digits[a] < digits[a+1]
        int a = digits.length-2;
        for(; a >= 0; a--) {
            if(digits[a] < digits[a + 1])
                break;
        }
        if(a == -1)
            return false;

        // find largest index b st digits[a] < digits[b]
        int b = digits.length-1;
        for(; b > a; b--) {
            if(digits[b] > digits[a])
                break;
        }
        
        // swap seq[a] with seq[b]
        int temp = digits[a];
        digits[a] = digits[b];
        digits[b] = temp;
        
        // reverse seq[a + 1] to seq[n]
        reverse(digits, a + 1, digits.length - 1);
        
        return true;
    }
    
    static void reverse (int[] digits, int start, int end) {
        if(start == end)
            return;
        while(start < end) {
            int temp = digits[start];
            digits[start] = digits[end];
            digits[end] = temp;
            start++;
            end--;
        }
    }
}
