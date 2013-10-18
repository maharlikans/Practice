import java.util.*;

class NGM {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int nikifor = input.nextInt();
		if (nikifor % 10 != 0) {
			System.out.println("1");
			System.out.println((nikifor % 10));
		} else
			System.out.println("2");
	}
}
