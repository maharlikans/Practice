import java.util.*;

class UFPTH {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int counter = 1;
        while(true) {
            long first       = input.nextLong();
            String second    = input.next();
            String fresult   = String.valueOf(Long.parseLong(second)*first);
            String[] results = new String[second.length()];

            if(first == 0 && second.equals("0"))
                break;
                
            // multiply the numbers and store the results in an array
            for(int i = 0; i < results.length; i++)
                results[i] = String.valueOf(Long.parseLong(String.valueOf(second.charAt(results.length - 1 - i)))*first);

            System.out.println("Problem " + counter);
            
            // print the two numbers and the line separating
            System.out.println(spaces(String.valueOf(first), fresult) + first);
            System.out.println(spaces(second, fresult) + second);
            for(int i = 0; i < fresult.length(); i++) {
                if(fresult.length() - i == 1)
                    System.out.println("-");
                else
                    System.out.print("-");
            }

            int zeroes = 0;
            int lines = 0;
            // iterate through results and start printing them
            for(int i = 0; i < results.length; i++) {
                if(results[i].equals("0"))
                    zeroes++;
                else {
                    String line = "";
                    for(int j = 0; j < zeroes; j++)
                        results[i] += 0;
                    for(int j = 0; j < fresult.length() - results[i].length() - i; j++)
                        line += " ";
                    line += results[i];
                    zeroes = 0;
                    lines++;
                    System.out.println(line);
                }
            }

            // print the line again
            if(lines != 1) {
                for(int i = 0; i < fresult.length(); i++) {
                    if(fresult.length() - i == 1)
                        System.out.println("-");
                    else
                        System.out.print("-");
                }
                // print the fresult
                System.out.println(fresult);
            }
            counter++;
        }
    }

    public static String spaces(String shorter, String longer) {
        String spaces = "";
        int diff = longer.length() - shorter.length();
        for(int i = 0; i < diff; i++) {
            spaces += " ";
        }
        return spaces;
    }


}
