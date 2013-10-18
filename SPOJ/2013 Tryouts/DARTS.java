import java.util.*;

class DARTS {
	public static void main (String[] args) {
		Scanner input = new Scanner (System.in);
		int t = input.nextInt();
		int[] radii = {0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200};
		int[] score = {0, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

		for (int z = 0; z < t; z++) {
			int n = input.nextInt();
			int totalScore = 0;
			for (int w = 0; w < n; w++) {
				int x = input.nextInt();
				int y = input.nextInt();
				double dist = Math.sqrt(Math.pow((double)x, 2) + Math.pow((double)y, 2));
				// check the distance calculated and assign a score
				if (dist > 200.0) {
					continue;
				} else {
					for (int i = 1; i <= 10; i++) {
						if (dist <= radii[i]) {
							totalScore += score[i];
							break;
						}
					}
				}
			}
			System.out.println(totalScore);
		}
	}
}
