// BEGIN CUT HERE
// PROBLEM STATEMENT
// You might remember the old computer arcade games. Here is one about Manao.

The game level is an NxM grid of equal cells. The bottom of some cells has a platform at which Manao can stand. All the cells in the bottommost row contain a platform, thus covering the whole ground of the level. The rows of the grid are numbered from 1 to N starting from the top and the columns are numbered from 1 to M starting from the left. Exactly one cell contains a coin and Manao needs to obtain it.

Initially, Manao is standing on the ground, i.e., in the bottommost row. He can move between two horizontally adjacent cells if both contain a platform. Also, Manao has a ladder which he can use to climb. He can use the ladder to climb both up and down. If the ladder is L units long, Manao can climb between two cells (i1, j) and (i2, j) if both contain a platform and |i1-i2| <= L. Note that Manao carries the ladder along, so he can use it multiple times. You need to determine the minimum ladder length L which is sufficient to acquire the coin.

Take a look at the following picture. On this level, Manao will manage to get the coin with a ladder of length 2.



You are given a int[] level containing N elements. The j-th character in the i-th row of level is 'X' if cell (i+1, j+1) contains a platform and '.' otherwise. You are also given ints coinRow and coinColumn. The coin which Manao seeks is located in cell (coinRow, coinColumn) and it is guaranteed that this cell contains a platform.

Return the minimum L such that ladder of length L is enough to get the coin. If Manao can perform the task without using the ladder, return 0.

DEFINITION
Class:ArcadeManao
Method:shortestLadder
Parameters:String[], int, int
Returns:int
Method signature:int shortestLadder(String[] level, int coinRow, int coinColumn)


NOTES
-Manao is not allowed to fall. The only way in which he may change his vertical coordinate is by using the ladder.


CONSTRAINTS
-level will contain N elements, where N is between 1 and 50, inclusive.
-Each element of level will be M characters long, where M is between 1 and 50, inclusive.
-Each element of level will consist of '.' and 'X' characters only.
-The last element of level will be entirely filled with 'X'.
-coinRow will be between 1 and N, inclusive.
-coinColumn will be between 1 and M, inclusive.
-level[coinRow - 1][coinColumn - 1] will be 'X'.


EXAMPLES

0)
{"XXXX....",
 "...X.XXX",
 "XXX..X..",
 "......X.",
 "XXXXXXXX"}
2
4

Returns: 2

The example from the problem statement.

1)
{"XXXX",
 "...X",
 "XXXX"}
1
1

Returns: 1

Manao can use the ladder to climb from the ground to cell (2, 4), then to cell (1, 4) and then he can walk right to the coin.

2)
{"..X..",
 ".X.X.",
 "X...X",
 ".X.X.",
 "..X..",
 "XXXXX"}
1
3

Returns: 4

With a ladder of length 4, Manao can first climb to cell (5, 3) and then right to (1, 3).

3)
{"X"}
1
1

Returns: 0

Manao begins in the same cell as the coin.

4)
{"XXXXXXXXXX",
 "...X......",
 "XXX.......",
 "X.....XXXX",
 "..XXXXX..X",
 ".........X",
 ".........X",
 "XXXXXXXXXX"}
1
1

Returns: 2



// END CUT HERE
import java.util.*;
public class ArcadeManao {
	public int shortestLadder(String[] level, int coinRow, int coinColumn) {
		// scan from left to right
		for (int i = level.length-1; i >= 0; --i) {
			for (int j = 0; j < level[i].length(); ++j) {
				if (level[i].charAt(j) == 'X') {
					// search up
					int up = i;
					for (int k = ; ; ) {
						
					}
					// search down
				}
			}
		}
		// for each level above and below at same index j,
		// if that platform is accessible, store in a priority queue
		// recall algorithm on the closest platform 
	}
}
