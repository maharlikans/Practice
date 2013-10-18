import java.util.*;
public class EasyHomework {
	
	public String determineSign(int[] A) {
		// test for 0, increment counter for negative numbers,
		int negCounter = 0; 
		for(int i = 0; i < A.length; i++) {
		    if(A[i] == 0)
		        return "ZERO";
	        else if(A[i] < 0) {
	            negCounter++;
	        }
		}
		if(negCounter % 2 == 0) {
		    return "POSITIVE";
		} else {
		    return "NEGATIVE";
		}
	}
	
	public static void main(String[] args) {
		EasyHomework temp = new EasyHomework();
		int[] A = new int[50];
		System.out.println(temp.determineSign(A));
	}
}


// Powered by FileEdit
// Powered by TZTester 1.01 [25-Feb-2003]
// Powered by CodeProcessor


// Powered by FileEdit
// Powered by TZTester 1.01 [25-Feb-2003]
// Powered by CodeProcessor
