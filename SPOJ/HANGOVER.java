import java.util.*;

class HANGOVER {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float c = input.nextFloat(); // how do i limit a float to just 3 digits?
        while(c != 0.00) {
            int i;
            if(1.0/2 > c) {
                System.out.println("1 card(s)");
            } else {
                double sum = 1.0/2;
                for(i = 2; sum < c; i++) {
                    sum += 1.0/(i + 1);
                }
                System.out.println((i - 1) + " card(s)");
            }

            c = input.nextFloat();
        }
    }
}
