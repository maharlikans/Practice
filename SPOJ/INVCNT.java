import java.util.*;

// change using merge sort (count inversions)
// TLE'D

class INVCNT {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int aI, aJ;
		
		for(int n = 0; n < t; n++) {
			in.nextLine();
			int count = 0;
			int iLen = in.nextInt();
			ArrayList<Integer> numbers = new ArrayList();
			for(int i = 0; i < iLen; i++) {
				numbers.add(in.nextInt());
			}
			for(int i = 0; i < numbers.size(); i++) {
				for(int j = i + 1; j < numbers.size(); j++) {
					if(numbers.get(i) > numbers.get(j)) {
						count++;
					} 
				}
			}
			System.out.println(count);
		}
	}
}
