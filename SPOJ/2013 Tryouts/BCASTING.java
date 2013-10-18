import java.util.*;
import java.math.*;

// knowing the rule in which a b-base number xyz is represented as a base 10 number
// as x*b^2 + y*b^1 + z*b^0, and when taking the mod by base (b-1), the b components 
// all become 1's. So we can just add x + y + z and do sum % (b-1) to get out answer

class BCASTING {
	public static void main (String[] args) {
		Scanner input = new Scanner (System.in);
		int sets = input.nextInt();
		for (int i = 1; i <= sets; i++) {
			input.next();
			int b = input.nextInt();
			String d = input.next();
			int sum = 0;
			for (int j = 0; j < d.length(); j++) {
				sum += Integer.parseInt(d.charAt(j));
			}
			System.out.print(i + " ");
			System.out.println(sum % (b-1));
		}
	}
}
