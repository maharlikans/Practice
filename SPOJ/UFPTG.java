import java.util.*;

class UFPTG {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int names, MAXLEN, caseno;
	    caseno = 1;
	    while(true) {
			names  = input.nextInt();
			MAXLEN = input.nextInt();
			if(MAXLEN == 0 && names == 0)
				break;
			HashMap<String, Integer> usernames = new HashMap<String, Integer>();
			ArrayList users   = new ArrayList(names);
			for(int i = 0; i < names; i++) {
				if(i == 0) {
					String useless = input.nextLine();
				}
				String name     = input.nextLine();
                String username = makeUsername(name, MAXLEN);
				
				// key is taken
				if(!usernames.containsKey(username)) {
				    usernames.put(username, 1);
				    users.add(username);
			    } else {
			        int currentNum = usernames.get(username);
                    users.add(appendNumber(username, currentNum, MAXLEN));
                    usernames.put(username, ++currentNum);
			    }
			}
			System.out.println("Case " + caseno++);
			for(int j = 0; j < users.size(); j++) {
				System.out.println(users.get(j));
			}
		}
	}

	static String makeUsername(String name, int MAXLEN) {
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
		return username;
	}

	static String appendNumber(String username, int number, int MAXLEN) {
		if(number < 10) {
			if(username.length() < MAXLEN)
				username += Integer.toString(number);
			else 
				username = username.substring(0, username.length() - 1) + Integer.toString(number);
			return username;
		} else {
			if(username.length() <= MAXLEN - 2)
				username += Integer.toString(number);
			else if (username.length() == MAXLEN)
				username = username.substring(0, username.length()-2) + Integer.toString(number);
			else
				username = username.substring(0, username.length()-1) + Integer.toString(number);
			return username;
		}
	}
}
