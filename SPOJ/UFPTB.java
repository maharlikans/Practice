import java.util.*;

class UFPTB {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = 1;
		while(true) {
			int n = input.nextInt();
			if(n == 0)
				break;
			int best = 0;
			int[] diameter = new int[n];
			int[] price    = new int[n];
			double[] ppi      = new double[n];
			for(int i = 0; i < n; i++) {
				diameter[i] = input.nextInt();
				price[i]    = input.nextInt();
				double temp = (double)price[i];
				ppi[i]      = (Math.pow((double)(diameter[i])/((double)2), 2))/temp;
				if(ppi[i] > ppi[best])
					best = i;
			}
			System.out.println("Menu " + count + ": " + diameter[best]);
			count++;
		}
	}
}
