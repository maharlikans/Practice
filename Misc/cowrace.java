import java.util.*;
import java.io.*;

public class cowrace {
	public static void main(String[] args) {
		Scanner input = new Scanner(new File("cowrace.in"));
		PrintWriter output = new PrintWriter(new File("cowrace.out"));
		int N = input.nextInt();
		int M = input.nextInt();
		
		int[] B = new int[N+1];
		int[] E = new int[M+1];
		
		int j = 1;
		for(int i = 0; i < N; i++) {
			int speed = input.nextInt();
			int time = input.nextInt();
			for (int z = 0; z < time; z++, j++) {
				B[j] = speed;
			}
		}

		for(int i = 0; i < M; i++) {
			int speed = input.nextInt();
			int time = input.nextInt();
		}
	}
}