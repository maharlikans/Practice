import java.util.Scanner;

class NUMGUESS {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int low = input.nextInt();
		int high = input.nextInt();
		int mid = (low + high)/2;
		while(low <= high) {
			mid = (low + high)/2;
			System.out.println(mid);
			String response = input.next();
			if(response.equals("LOW"))  {
				low = mid + 1; // mid + 1 because if it's mid and low and mid are the same number then nothing will change
			} else if (response.equals("HIGH")) {
				high = mid - 1; // mid - 1 for the same reason above.
			} else {
				break;
			}
		}
	}
}
