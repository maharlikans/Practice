// KYLE MAHARLIKA
// SPOJ "ROCK" SOLUTION
// 9/13/2013

// way the recursive calls work:
// we pass the actual string, plus its beginning index in the original rock,
// the ending index in the original rock, and the lengths array to memoize
// the values. I have to pass the beginning and ending indices of the rock
// because it functions as a unique identifier, and I need a faster way than 
// a hashmap to memoize the max length I can sell for each length of rock I'm 
// looking at.

import java.util.*;

class ROCK {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();

		for (int z = 0; z < t; z++) {
			input.next();
			String rock = input.next();
			// row num represents the beginning of the rock segment
			// col num represents the end (is inclusive)
			int[][] lengths = new int[200][200];

			for (int i = 0; i < lengths.length; i++)
				for (int j = 0; j < lengths.length; j++)
					lengths[i][j] = -1;

			HashMap<String, Integer> map = new HashMap<String, Integer>();

			System.out.println(longestRock(rock, 0, rock.length()-1, lengths));
		}
	}

	public static int longestRock(String rock/*, HashMap<String, Integer> map*/, int begin, int end, int[][] lengths) {
		// very complicated annoying way of passing the beginning and end of rocks
		// the begin value is the beginning index of the rock we're looking at in the original rock
		// the end value is the ending index of the rock we're looking at in the original rock

		/*
		if (map.containsKey(rock)) {
			return map.get(rock);
		}
		*/

		if (lengths[begin][end] != -1) {
			return lengths[begin][end];
		}

		int countSweet = 0;
		for (int i = 0; i < rock.length(); i++) {
			if (rock.charAt(i) == '1')
				countSweet++;
		}

		if (countSweet > rock.length()/2) {
			//map.put(rock, rock.length());
			lengths[begin][end] = rock.length();
			return rock.length();
		}

		int maxSum = 0;
		for (int i = 1; i < rock.length(); i++) {
			// this is super annoying 
			// but, anyway, the left rock will have its beginning index at the same point
			// as the beginning index of the current rock we're looking at, and its ending 
			// index will be at "begin + i-1", i being the index of the split we're making 
			// "begin + i" represents the beginning of the right rock in the split, so we
			// can also think of "begin + i-1" as the piece of rock right before the split
			//
			// the beginning index of right is "begin + i", i.e. the beginning index of the
			// current rock (with respect to the original rock) + i. The end index, is, of
			// course, the same as the ending index of the current rock (again, with respect)
			// to the original rock
			int left = longestRock(rock.substring(0, i), begin, begin + i-1, lengths);
			int right = longestRock(rock.substring(i, rock.length()), begin + i, end, lengths);

			if (maxSum < left + right) 
				maxSum = left + right;
		}
		
		// map.put(rock, maxSum);
		lengths[begin][end] = maxSum;
		return maxSum;
	}
}
