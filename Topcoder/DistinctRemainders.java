// BEGIN CUT HERE
// PROBLEM STATEMENT
// You are interested in a sequence of integers S = (S[1], S[2], ..., S[K]) with the following properties:


K >= 1.
For all i, S[i] is a non-negative integer.
S[1] + S[2] + ... + S[K] = N.
S[1] mod M, S[2] mod M, ..., S[K] mod M are all different.


You are given a long N and an int M. Return the number of different valid sequences S, modulo 1,000,000,007. Two sequences S1 and S2 are considered different if they either have different number of elements, or if there is an index i such that S1[i] is different from S2[i].

DEFINITION
Class:DistinctRemainders
Method:howMany
Parameters:long, int
Returns:int
Method signature:int howMany(long N, int M)


CONSTRAINTS
-N will be between 1 and 10^18, inclusive.
-M will be between 1 and 50, inclusive.


EXAMPLES

0)
3
2

Returns: 5

The 5 sequences are:

(3)
(0, 3)
(1, 2)
(2, 1)
(3, 0)


1)
3
3

Returns: 9

The 9 sequences are:

(3)
(1, 2)
(2, 1)
(0, 1, 2)
(0, 2, 1)
(1, 0, 2)
(1, 2, 0)
(2, 0, 1)
(2, 1, 0)


2)
58
1

Returns: 1

The only sequence is (58).

3)
572
7

Returns: 922572833



4)
1000000000000000000
20

Returns: 240297629

Watch out for overflows.

// END CUT HERE
import java.util.*;
public class DistinctRemainders {
	public static void main(String[] args) {
		DistinctRemainders temp = new DistinctRemainders();
		System.out.println(temp.howMany(long N, int M));
	}
	public int howMany(long N, int M) {
		
	}
}
