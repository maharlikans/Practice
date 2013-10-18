import java.util.*;

class AE00 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int count = 0; // begins at one to count the first square
        for(int i = 1; i <= n; i++) {
            for(int j = i; j*i <= n; j++) {
                count++;
            }
        }
        System.out.println(count);
    }
}
