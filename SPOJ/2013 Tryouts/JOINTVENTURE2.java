import java.util.*;

class JOINTVENTURE2 {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int x = Integer.parseInt(input.next());
			int n = Integer.parseInt(input.next());
			int l1 = 0, 
				l2 = n-1;
			int[] length = new int[n];
			
			for (int i = 0; i < n; i++) {
				length[i] = Integer.parseInt(input.next());
			}

			Arrays.sort(length);

			while (l1 != l2) {
				if (length[l1] + length[l2] > x) 
					l2 = l2 - 1;
				else if (length[l1] + length[l2] < x) 
					l1 = l1 + 1;
				else
					break;
			}

			if (l1 == l2) 
				System.out.println("danger");
			else 
				System.out.println("yes" + length[l1] + " " + length[l2]);

		}
	}
}
