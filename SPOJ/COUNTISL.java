import java.util.*;

class COUNTISL {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		int rows = 0;
		int columns = 0;
		// read in the map
		for(int n = 0; n < cases; n++) {
			rows = input.nextInt();
			columns = input.nextInt();
			char[][] map = new char[rows][columns];
			for(int i = 0; i < rows; i++) {
				map[i] = (input.next()).toCharArray();
			}
			
			LinkedList toCheck = new LinkedList();
			LinkedList checked = new LinkedList();
			
			int islands = 0;
			for(int i = 1; i < (rows - 1); i++) {
				for(int j = 1; j < (columns - 1); j++) {
					if(map[i][j] == '#') {
						// search the indices around the #
						// this seems like a really bad idea...
						Pair pair = new Pair(i, j);
						toCheck.add(pair);
						while(true) {
							if(map[iFound-1][jFound-1] == ('#')) {
								iFound = iFound-1;
								jFound = jFound-1;
							} else if(map[iFound+1][jFound+1]== '#') {
								iFound = iFound+1;
								jFound = jFound+1;
							} else if(map[iFound-1][jFound] == '#') {
								iFound = iFound-1;
								jFound = jFound;
							} else if(map[iFound+1][jFound] == '#') {
								iFound = iFound+1;
								jFound = jFound;
							} else if(map[iFound][jFound + 1] == '#') {
								iFound = iFound;
								jFound = jFound + 1;
							} else if(map[iFound][jFound-1] == '#') {
								iFound = iFound;
								jFound = jFound-1;
							} else {
								islands++;
								break;
							}
						
						}
					}
				}
			}
			System.out.println(islands);
		}
	}
}

class Pair {
	int a = 0;
	int b = 0;
	
	Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	int getA() {
		return a;
	}
	
	int getB() {
		return b;
	}
}
