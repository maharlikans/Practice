import java.util.*;	

class JAVAC {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String convert;
		while(input.hasNext()){
		    convert = input.next();
			if(convert.matches("[a-z]+(_[a-z]+)*")) {
				System.out.println(cConvert(convert));
			} else if(convert.matches("[a-z]+[[A-Z]+[a-z]*]*")) {
				System.out.println(javaConvert(convert));
			} else {
				System.out.println("Error!");
			}
		}
	}

    static String cConvert(String convert) {
        String[] splitted = convert.split("_");
		String conv = splitted[0];
		for(int i = 1; i < splitted.length; i++) {
		    if(splitted[i].length() != 1) 
			    conv += Character.toUpperCase(splitted[i].charAt(0)) + splitted[i].substring(1);
		    else
		        conv += Character.toUpperCase(splitted[i].charAt(0));
		}
		return conv;
    }
	
	static String javaConvert(String toconv) {
		ArrayList loc = new ArrayList();
		
		// check where the capital letters are
		for(int i = 0; i < toconv.length(); i++) {
			if(Character.isUpperCase(toconv.charAt(i)))
				loc.add(i);
		}
		
		String[] splitted = new String[loc.size() + 1];	
		
		if(loc.size() >= 1) {
		    // create substrings using the locations
		    for(int i = 0; i < splitted.length; i++) {
			    if(i == 0) {
				    splitted[i] = toconv.substring(0, (Integer)(loc.get(i)));
			    } else if(i == splitted.length - 1) {
				    splitted[i] = toconv.substring((Integer)(loc.get(i - 1)));
			    } else {
				    splitted[i] = toconv.substring((Integer)(loc.get(i - 1)), (Integer)(loc.get(i)));
			    }
		    }
	    } else {
            splitted[0] = toconv;
	    }
		
		String conv = "";
		
		// create the converted identifier
		for(int i = 0; i < splitted.length; i++) {
			if(i != splitted.length - 1) 
				conv += splitted[i].toLowerCase() + "_";
			else
				conv += splitted[i].toLowerCase();
		}
		return conv;
	}
} 

