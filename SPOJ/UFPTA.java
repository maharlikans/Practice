import java.util.*;

class UFPTA {
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		String blah;
		while(true){
			blah = input.nextLine();
			if(blah.equals("END"))
				break;
			Set letters = new HashSet();
			boolean dup = false;
			for(int i = 0; i < blah.length(); i++) {
				if((blah.charAt(i) != ' ') && !letters.add(blah.charAt(i)))
					dup = true;
			}
			if(!dup) 
				System.out.println(blah);
		}
	}
}

// check for duplicates excluding spaces
