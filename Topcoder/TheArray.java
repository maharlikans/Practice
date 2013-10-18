import java.util.*;
public class TheArray {
	public static void main(String[] args) {
		TheArray temp = new TheArray();
		int n = 0, d = 0, first = 0, last = 0;
		System.out.println(temp.find(n, d, first, last));
	}
	public int find(int n, int d, int first, int last) {
		int reqSpace = (int)Math.ceil((first - last)/(double)d);
		int max = max(first, last);
		int fromFirst, fromLast;
		if(reqSpace == n-1) {
		    return max;
	    } else if(d == 0) {
	    	return first;
	    } else {
	    	int beginMax, endMax;
			fromFirst = 0;
			fromLast = n-1;
			
			while(first + fromFirst*d <= last + fromLast*d) {
				fromFirst++;
				fromLast--;
			}
			
			beginMax = (first + (--fromFirst)*d);
			
	    	fromFirst = n-1;
	    	fromLast = 0;
	    	
	    	while(first + fromFirst*d >= last + fromLast*d) {
				fromFirst--;
				fromLast++;
			}
			
			endMax = (last + (--fromLast)*d);
			
			return max(beginMax, endMax);
	    }
	}
	
	public int max(int a, int b) {
	    if(a < b) 
	        return b;
        else
            return a;
	}
}


// Powered by FileEdit
// Powered by TZTester 1.01 [25-Feb-2003]
// Powered by CodeProcessor


// Powered by FileEdit
// Powered by TZTester 1.01 [25-Feb-2003]
// Powered by CodeProcessor


// Powered by FileEdit
// Powered by TZTester 1.01 [25-Feb-2003]
// Powered by CodeProcessor
