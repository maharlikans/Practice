/* Kyle Maharlika 			    *
 * Extended Euclidean Algorithm *
 * con Bezout Pairs	    	    */


import java.util.*;

class ExtendedEuclidean {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> ints = new ArrayList<Integer>();
		
		while(true) {
			String s = input.next();
			if(s.equals("~"))
				break;
			else
				ints.add(Integer.parseInt(s));
		}
		
		System.out.println("\nCool, thanks.\n");
		iterEuclid(ints);
	}
	
	/* iterEuclid() iteratively uses the euclidean algorithm to calculate *
	 * the GCD of the given integers and print the values of the bezout   *
	 * pairs for each of the given integers								  */
	public static void iterEuclid(ArrayList<Integer> ints) {
		int G, A, B; // current GCD, alpha, and beta
		int n = 2; // current iteration; I start at n=2 because I calculate the case for the first two numbers in the list outside the loop
		
		if(ints.size() < 2)
			System.out.println("There aren't enough integers in this list.");
		else {
			ArrayList<Integer> bezoutMult = new ArrayList<Integer>();
			
			// add first alpha and beta bezout multipliers and get first GCD
			EuclidTuple first = euclidean(ints.get(0), ints.get(1));
			G = first.GCD;
			bezoutMult.add(first.s);
			bezoutMult.add(first.t);
			
			// iterate through list of ints
			// calculate GCD(G, ints.get(i))
			// add to list of bezout multipliers
			for(int i = 2; i < ints.size(); i++) {
				EuclidTuple result = euclidean(G, ints.get(i));
				G = result.GCD;
				A = result.s;
				B = result.t;
				
				// multiply all the current bezout multipliers by A
				for(int j = 0; j < bezoutMult.size(); j++) {
					bezoutMult.set(j, A*bezoutMult.get(j));
				}
				
				// append B to list of bezout multipliers
				bezoutMult.add(B);
			}
			
			// print the GCD and multipliers
			System.out.println("GCD is " + G);
			System.out.print("The bezout multipliers are (");
			for(int i = 0; i < bezoutMult.size() - 1; i++) {
				System.out.print(bezoutMult.get(i) + ", ");
			}
			System.out.println(bezoutMult.get(bezoutMult.size() - 1) + ")");
		}
	}
	
	/* euclidean() calculates the GCD and bezout multipliers *
	 * returned in the form of a EuclidTuple: (GCD, s, t)    */
	public static EuclidTuple euclidean(int a, int b) {
		ArrayList<Integer> R = new ArrayList<Integer>();
		ArrayList<Integer> S = new ArrayList<Integer>();
		ArrayList<Integer> T = new ArrayList<Integer>();
		int n = 1;
		int r = -1;
		
		// initialize row n = 0 of table
		R.add(a);
		S.add(1);
		T.add(0);
		
		// initialize row n = 1 of table
		R.add(b);
		S.add(0);
		T.add(1);
		
		int q = 1; // initialize quotient variable
		while(r != 0) {
			q = R.get(n-1)/R.get(n);
			r = R.get(n-1) % R.get(n); // calc next remainder
			R.add(r); 
			S.add(S.get(n-1) - q*S.get(n)); // calc next s for bezout pair
			T.add(T.get(n-1) - q*T.get(n)); // calc next t for bezout pair
			n++;
		}
		n--; // loop will iterate one over the row needed in the table
		
		return new EuclidTuple(R.get(n), S.get(n), T.get(n));
	}
}

/* EuclidTuple serves as tuple containing the return values    *
 * of the extended Euclidean algorithm in the form (GCD, s, t) *
 * where GCD is the GCD of the two given values and s and t    *
 * are the bezout multipliers for given arguments a and b	   */
class EuclidTuple {
	public int GCD, s, t;
	public EuclidTuple(int GCD, int s, int t) {
		this.GCD = GCD;
		this.s = s;
		this.t = t;
	}
}

