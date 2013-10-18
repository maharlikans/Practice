import java.util.*;

public class CF285A {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		int prev = k + 1;
		int kplus = k + 2;
		System.out.print(prev);

		for (int i = 1; i < n; i++) {
			if(prev != 1) {
				--prev;
				System.out.print(" " + prev);
			} else {
				System.out.print(" " + (kplus++));
			}
		}
	}
}