import java.util.*;

class UFPTE {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int names, MAXLEN, caseno;
		caseno = 1;
		while(true) {
			names  = input.nextInt();
			MAXLEN = input.nextInt();
			if(MAXLEN == 0 && names == 0)
				break;
			Set userdb        = new HashSet();
			ArrayList users   = new ArrayList(names);
			int serial        = 1;
			int dserial       = 10;
			for(int i = 0; i < names; i++) {
				if(i == 0) {
					String useless = input.nextLine();
				}
				String name   = input.nextLine();
				String[] splitted = name.split(" ");
				String fname, lname, username;
				fname = splitted[0];
				lname = (splitted[splitted.length - 1]).toLowerCase();
				username = Character.toString(Character.toLowerCase(fname.charAt(0)));

				for(int b = 0; b < fname.length(); b++) {
					if(!Character.toString(fname.charAt(b)).equals("-") && !Character.toString(fname.charAt(b)).equals("'")) {
						username = Character.toString(Character.toLowerCase(fname.charAt(b)));
						break;
					}
				}
				
				int k = 0;
				// iter if the char isn't "-" or "'"
				while(username.length() < MAXLEN && k < lname.length()) {
					if(!Character.toString(lname.charAt(k)).equals("-") && !Character.toString(lname.charAt(k)).equals("'"))
						username += lname.charAt(k);
					k++;
				}
				
				// tiebreaker 1
				if(!userdb.add(username)) {
					if(serial != 10) {
						if(username.length() < MAXLEN)
							username += Integer.toString(serial++);
						else 
							username = username.substring(0, username.length() - 1) + Integer.toString(serial++);
					}
					
					// tiebreaker 2
					if(!userdb.add(username)) {
						if(username.length() <= MAXLEN - 2)
							username += Integer.toString(dserial++);
						else if (username.length() == MAXLEN)
							username = username.substring(0, username.length()-2) + Integer.toString(dserial++);
						else
							username = username.substring(0, username.length()-1) + Integer.toString(dserial++);

						userdb.add(username);
						users.add(username);
					} else {
						users.add(username);
					}
				} else {
					users.add(username);
				}
				
				
			}
			System.out.println("Case " + caseno++);
			for(int j = 0; j < users.size(); j++) {
				System.out.println(users.get(j));
			}
		}
	}
}
