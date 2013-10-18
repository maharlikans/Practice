//SOLVED

import java.util.*;
import java.math.BigInteger;

class JULKA{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < 10; i++) {
			BigInteger total = input.nextBigInteger();
			BigInteger diff  = input.nextBigInteger();
			BigInteger two = new BigInteger("2");
			BigInteger N = (total.subtract(diff)).divide(two);
			BigInteger K = total.subtract(N);
			System.out.println(K);
			System.out.println(N);
		}
	}
}
