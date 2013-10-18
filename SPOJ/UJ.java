import java.util.*;
import java.math.*;

class UJ {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int D = input.nextInt();
		while(!(N == 0 && D == 0)) {
			System.out.println((new BigInteger(Integer.toString(N))).pow(D));
			N = input.nextInt();
			D = input.nextInt();
		}
	}
}
