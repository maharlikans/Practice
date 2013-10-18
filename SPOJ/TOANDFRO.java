import java.util.*;

class TOANDFRO {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	
		while(true) {
			int columns = input.nextInt();		
			if (columns == 0) {
				break;
			}
			String message = input.next();
			int rows = (message.length())/columns;
			char[][] messageMatrix = new char[rows][columns];
			int index = 0;
			
			// decode the string into matrix
			for(int i = 0; i < rows; i++) {
				if((i % 2) == 0) {
					for(int j = 0; j < columns; j++) {
						char c = message.charAt(index);
						messageMatrix[i][j] = c;
						index++;
					}
				} else {
					for(int j = columns - 1; j >= 0; j--) {
						char c = message.charAt(index);
						messageMatrix[i][j] = c;
						index++;
					}
				}
			}
		
			// matrix built, decode the message
			String decodedMessage = "";
			for(int j = 0; j < columns; j++) {
				for(int i = 0; i < rows; i++) {
					decodedMessage += messageMatrix[i][j];
				}
			}
		
			System.out.println(decodedMessage);
		}
	}
}
