import java.util.*;

class GUESSTHE {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nums = "";
        while(true) {
            nums = "0" + input.next();
            if(nums.equals("0*"))
                break;
            ArrayList<Long> yes = new ArrayList<Long>();
            ArrayList<Long> no  = new ArrayList<Long>();
            
            // add numbers to both lists
            for(int i = 1; i < nums.length(); i++) {
                if(nums.charAt(i) == 'Y')
                    yes.add((long)i);
                else
                    no.add((long)i);
            }
            
            // find the LCM with yes's
            long lcm = -1;
            if(yes.size() > 0) {
                if(yes.size() > 1)
                    lcm = lcm(yes.get(0), yes.get(1));
                else 
                    lcm = yes.get(0);
            }
            for(int i = 2; i < yes.size(); i++) {
                lcm = lcm(lcm, yes.get(i));
            }
            
            // check nos to be sure the lcm isn't divisible by any of those numbers
            boolean divisible = false;
            for(int i = 0; i < no.size() && divisible == false; i++) {
                if(lcm % no.get(i) == 0)
                    divisible = true;
            }
            
            // print the results
            if (divisible)
                System.out.println(-1);
            else 
                System.out.println(lcm);
        }
    }
    
    static long gcd(long b, long a) {
        long t;
        while(b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    
    static long lcm(long b, long a) {
        return (a*b)/(gcd(a, b));
    }
}

