// BEGIN CUT HERE
// PROBLEM STATEMENT
// Consider a string consisting of lowercase characters and following two operations that can change it: 

	Next: Choose a lowercase character other than 'z' and replace its every occurrence with the next character 
	('a' -> 'b', 'b' -> 'c', ..., 'x' -> 'y', 'y' -> 'z'). 
	Prev: Choose a lowercase character other than 'a' and replace its every occurrence with the previous character 
	('b' -> 'a', 'c' -> 'b', ..., 'y' -> 'x', 'z' -> 'y'). 

You can use each operation as many times as you want, and in any order you like. 
You are given ints nextCost and prevCost. 
These represent the cost of using each Next and Prev operation, respectively. 
You are also given two Strings start and goal. 
These strings are special: no two characters in start are the same, and no two characters in goal are the same. 
Return the minimum cost required in order to transform start into goal using the above operations. 
If transforming start into goal is impossible, return -1 instead. 


DEFINITION
Class:NextOrPrev
Method:getMinimum
Parameters:int, int, String, String
Returns:int
Method signature:int getMinimum(int nextCost, int prevCost, String start, String goal)


CONSTRAINTS
-nextCost and prevCost will each be between 1 and 1000, inclusive. 
-start and goal will each contain between 1 and 26 characters, inclusive. 
-start and goal will contain the same number of characters. 
-Each character in start and goal will be a lowercase character. 
-The characters in start will be distinct. 
-The characters in goal will be distinct. 


EXAMPLES

0)
5
8
"ae"
"bc"

Returns: 21

There are several optimal sequences of operations. 
Here is one of them: "ae" -(Next)-> "be" -(Prev)-> "bd" -(Prev)-> "bc". The total cost is 5 + 8 + 8 = 21. 


1)
5
8
"ae"
"cb"

Returns: -1

It is impossible to transform "ae" into "cb". 


2)
1
1
"srm"
"srm"

Returns: 0

start and goal may be the same. 
The cost of an empty sequence of operations is 0. 


3)
10
1
"acb"
"bdc"

Returns: 30



4)
10
1
"zyxw"
"vuts"

Returns: 16



5)
563
440
"ptrbgcnlaizo"
"rtscedkiahul"

Returns: 10295



6)
126
311
"yovlkwpjgsna"
"zpwnkytjisob"

Returns: -1



// END CUT HERE
import java.util.*;
public class NextOrPrev {
	public int getMinimum(int nextCost, int prevCost, String start, String goal) {
		
	}
	
	public boolean check(String start, String goal) {
		for(int i = 0; i < start.length(); i++) {
			for(int j = i; j < start.length(); j++) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		NextOrPrev temp = new NextOrPrev();
		System.out.println(temp.getMinimum(int nextCost, int prevCost, String start, String goal));
	}
}
