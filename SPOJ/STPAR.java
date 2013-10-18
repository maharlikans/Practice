import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class STPAR {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(true) {
			int cars = in.nextInt();
			if (cars == 0) {
				break;
			}
			Stack<Integer> stack = new Stack<Integer>();
			int[] answer = new int[cars];
			int n = 0;
			for(int i=0;i<cars;++i) {
				int currentCar = in.nextInt();
				
				while(!stack.empty() && stack.peek() == n+1) {
					answer[n] = stack.pop();
					++n;
				}
				if (currentCar == n+1) {
					answer[n] = currentCar;
					++n;
				}
				else {
					stack.push(currentCar);
				}
			}
			while(!stack.empty()) {
				answer[n] = stack.pop();
				++n;
			}
			
			boolean right = true;
			for(int i = 0; i < answer.length - 1; i++) {
				if(answer[i + 1] != (answer[i] + 1)) {
					right = false;
					break;
				}
			}
			
			if(right) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
		
	}
}

