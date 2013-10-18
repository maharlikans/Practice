import java.util.*;

class MFLAR10 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// word has one letter
		// length <= 20
		String sentence = input.nextLine();
		while(!(sentence.equals("*"))) {
			String[] words = sentence.split(" ");
			boolean sameFirst = true;
			for(int i = 1; i < words.length; i++) {
				if(!((Character.toString(words[i].charAt(0))).equalsIgnoreCase(Character.toString(words[i - 1].charAt(0)))))
					sameFirst = false;
			}
			if(sameFirst) {
				System.out.println("Y");
			}else {
				System.out.println("N");
			}
			sentence = input.nextLine();
		}
	}
}
