import java.util.*;

class KNAPSACK {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int s = input.nextInt();
		int n = input.nextInt();
		
		// each item i is represented in w, v as w[i]
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			w[i] = input.nextInt();
			v[i] = input.nextInt();
		}
		
		// pair (i, j)
		// i is current item, j is current capacity
		// best is initialized to have all 0 values
		int[][] best = new int[n + 1][s + 1];
		
		// for each item, for each capacity
		// check if the current item can fit in the current capacity
		// if it can, check if the value would be better if you included the item in the sack
		for(int currItem = 1; currItem <= n; currItem++) {
			for(int currCap = 1; currCap <= s; currCap++) {
				if(w[currItem] <= currCap) {
					int tentValue = best[currItem-1][currCap - w[currItem]] + v[currItem];
					if(tentValue > best[currItem-1][currCap]) {
						best[currItem][currCap] = tentValue;
					} else {
						best[currItem][currCap] = best[currItem-1][currCap];
					}
				} else {
					best[currItem][currCap] = best[currItem-1][currCap];
				}
			}
		}
		
		
		System.out.println(best[n][s]);
	}
}
