import java.util.*;

// pretty weird problem and a pretty weird solution
// you should probably just do it a different way
// but anyway, I just set up a 20x20 max array
// then stored the corresponding stacking pattern
// given to me in an array. 
// then I noticed a particular pattern with left rotations
// in which the 1st row corresponds to the first column in
// the left rotation.
// I take each element in the first row of the sp, I'll call the
// element the kth element. Then I iterate over sp[i][k] elements
// in the ith column and iterate each by 1.

public class StackingCubes {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			int[][] sp = new int[20][20];
			int n = input.nextInt();
			if (n == 0)
				break;
			for (int i = 0; i < n; i++) {
				int cubes = -1;
				for (int j = 0; j < 20; j++) {
					cubes = input.nextInt();
					if (cubes == 0)
						break;
					sp[i][j] = cubes;
				}
			}

			int[][] leftRot = leftRotation(sp);
			int[][] rightRot = rightRotation(sp);

			for (int i = 0; i < leftRot.length; i++) {
				int j;
				for (j = 0; j < leftRot[i].length; j++) {
					if (leftRot[i][j] == 0)
						break;
					System.out.print(leftRot[i][j] + " ");
				}
				if (j == 0)
					break;
				System.out.println();
			}

			System.out.println();

			for (int i = 0; i < rightRot.length; i++) {
				int j;
				for (j = 0; j < rightRot[i].length; j++) {
					if (rightRot[i][j] == 0)
						break;
					System.out.print(rightRot[i][j] + " ");
				}
				if (j == 0)
					break;
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}
	}

	public static int[][] leftRotation (int[][] sp) {
		int[][] leftRot = new int[20][20];
rows:	for (int i = 0; i < sp.length; i++) {
columns:	for (int j = 0; j < sp[i].length; j++) {
				if (sp[i][j] == 0)
					break columns;
				else {
					for (int k = 0; k < sp[i][j]; k++) 
						leftRot[k][i]++;
				}
			}
		}

		return leftRot;
	}

	public static int[][] rightRotation (int[][] sp) {
		return leftRotation(leftRotation(sp));
	}
}
