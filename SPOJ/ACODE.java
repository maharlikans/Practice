import java.util.*;
import java.io.*;

class ACODE {
	public static void main(String[] args) throws Exception{
		Parser input = new Parser(System.in);
		String code = input.next();
		while(!code.equals("0")) {
			System.out.println(decode(code));
			code = input.next();
		}
	}
	
	public static long decode(String code) {
		long[] length = new long[code.length() + 1];
		length[0] = 1;
		length[1] = 1; // should work
		for(int i = 2; i <= code.length(); i++) {
			// check if can add the very next number
			String next = code.substring(i-1, i);
			if(!("0".equals(next))) {
				length[i] += length[i-1];
			}
			
			// check if can add last # plus very next number
			next = code.substring(i-2, i);
			if(next.charAt(0) != '0' && Integer.parseInt(next) <= 26) {
				length[i] += length[i-2];
			}
		}
		
		return length[code.length()];
	}
}



class Parser {
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

   public double nextDouble() throws Exception {
       double toRet = 0.0;
       int ret = 0;
       byte c = read();
       while (c <= ' ') c = read();
       do
       {
           ret = ret * 10 + c - '0';
           c = read();
       } while (c > ' ' && c != '.');
       int ret2 = 0;
       double mult = 1.0;
       if (c == '.') {
           c = read();
           do {
               ret2 = ret2 * 10 + c - '0';
               mult *= .1;
               c = read();
           } while ( c > ' ');
           toRet += ret2*mult;
       }
       return toRet + ret;
   }

   public String nextString(int length) throws Exception {
       StringBuilder br = new StringBuilder();
       byte c = read();
       while(c <= ' ') c = read();
       for(int i = 0; i < length; ++i) {
           br.append((char)c);
           c = read();
       }
       return br.toString();
   }

   public String next() throws Exception{
       StringBuilder br = new StringBuilder();
       byte c = read();
       while(c <= ' ') c = read();
       while(c > ' ') {
           br.append((char)c);
           c = read();
       }
       return br.toString();
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

