import java.util.*;

class ADDREV {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            System.out.println(z(String.valueOf(z(String.valueOf(x)) + z(String.valueOf(y)))));
        }
    }

    public static int z(String s) {
        int i; 
        for(i = s.length() - 1; i >= 0 && s.charAt(i) == '0'; i--) {
        }
        char[] torev = s.substring(0, i + 1).toCharArray();
        char[] rev   = new char[torev.length];
        for(i = 0; i < torev.length; i++) {
            rev[i] = torev[torev.length - i - 1];
        }
        return Integer.parseInt(String.valueOf(rev));
    }
}
