import java.util.*;

/* 	idea for squadtree:
 *		the nodes hashmap will store how many children a node has
 *  	HashMap<String, Integer> nodes = new HashMap<String, Integer>();
 *		first step:
 *			determine length of longest side
 *				have array of square values from 2 to 128
 *				check values to see if length is less than any of them
 *				if so, copy array and pad 0s to the ends of the integer
 *				array
 *			increment count to 0 and pass in array
 *		recursive function returns int, pass in 2d array, keep global squadsum static var:
 *			int quadsum = 0;
 *			subdivide the 2d array into length/2 x length/2 squares
 *				build a string for each of the arrays containing their elements
 *			append all the strings together at the end and check if all values are the same
 *			if all bits same in overall array
 *				quadsum++;
 *				squadsum++;
 *				return quadsum;
 *			else if it's found that all 2d subarrays are length 1
 *				quadsum += 4;
 *				squadsum += 4;
 *				return quadsum;
 *			else 
 *				for each 2d subarray check if the key (indicated as string) is already in hashmap
 *					if so
 *						quadsum += nodes.get(2dstring[i]);
 *					if not {
 *						subtreeNodes = buildSquadTree(2darr, nodes);
 *						quadsum += subtreeNodes;
 *						nodes.put(2dstring[i], subtreeNodes);
 *					}
 *				return quadsum;
 *
 */

public class Squadtrees {

	static int squadsum = 0;

	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		int[] squares = {1, 2, 4, 8, 16, 32, 64, 128};
		int n,
			m;
		HashMap<String, Integer> nodes;

		while(true) {
			n = input.nextInt();
			m = input.nextInt();
			if (n == 0 && m == 0)
				break;
		
			nodes = new HashMap<String, Integer>();
			squadsum = 0;
			int maxLength = n > m ? n : m;
			int ind;
			for (ind = 0; maxLength > squares[ind]; ind++);
			int size = squares[ind];
			int[][] image = new int[size][size];

			String line;
			for (int i = 0; i < n; i++) {
				line = input.next();
				for (int j = 0; j < m; j++) {
					image[i][j] = Integer.parseInt("" + line.charAt(j));
				}
			}

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++)
					System.out.print(image[i][j] + " ");
				System.out.println();
			}
			
			int quadsum = subdivide(image, nodes); 
			System.out.println(quadsum + " " + squadsum);
			
		}
	}
	
	// TODO change return type to int
	public static int subdivide(int[][] image, HashMap<String, Integer> nodes) {
		int quadsum = 0;
		int[][][] subimages = new int[4][][];
		int half = image.length/2;
		String whole = "";
		String[] strings = new String[4];
		Arrays.fill(strings, "");

		String ones = "", 
			   zeros = ""; 
		for (int i = 0; i < 4*half*half; i++) {
			ones += 1;
			zeros += 0;
		}

		for (int i = 0; i < subimages.length; i++)
			subimages[i] = new int[half][half];

		// whole block 
		for (int i = 0; i < image.length; i++)
			for(int j = 0; j < image.length; j++)
				whole += image[i][j];

		// top left loop
		for (int i = 0; i < half; i++) {
			for (int j = 0; j < half; j++) {
				subimages[0][i][j] = image[i][j];
				strings[0] += image[i][j];
			}
		}

		System.out.println(strings[0]);

		// top right loop
		for (int i = 0; i < half; i++) {
			for (int j = half; j < image.length; j++) {
				subimages[1][i][j-half] = image[i][j];
				strings[1] += image[i][j];
			}
		}

		System.out.println(strings[1]);

		// bottom left loop
		for (int i = half; i < image.length; i++) {
			for (int j = 0; j < half; j++) {
				subimages[2][i-half][j] = image[i][j];
				strings[2] += image[i][j];
			}
		}

		System.out.println(strings[2]);

		// bottom right loop
		for (int i = half; i < image.length; i++) {
			for (int j = half; j < image.length; j++) {
				subimages[3][i-half][j-half] = image[i][j];
				strings[3] += image[i][j];
			}
		}

		System.out.println(strings[3]);

		String map = strings[0] + strings[1] + strings[2] + strings[3];
		if (map.equals(ones) || map.equals(zeros)) {
			if (!nodes.containsKey(map))
				squadsum++;
			else
				nodes.put(map, 1);
			quadsum++;
			System.out.println("Whole map " + map + " is 1s or 0s");
			System.out.println("quad has nodes " + quadsum);
			System.out.println("squad has nodes " + squadsum);
			return quadsum;
		} else if (half == 1) {
			quadsum += 1 + 4; //i.e. itself plus 4 children
			squadsum += 1 + 4;
			System.out.println("All subarrays are size 1");
			System.out.println("quad has nodes " + quadsum);
			System.out.println("squad has nodes " + squadsum);
			return quadsum;
		} else {
			quadsum++;
			squadsum++;
			for (int i = 0; i < strings.length; i++) {
				System.out.println("Looking at " + strings[i]);
				if (nodes.containsKey(strings[i])) {
					// notice I don't add to the squadsum amount
					quadsum += nodes.get(strings[i]);
					System.out.println(strings[i] + " already in map");
					System.out.println("quad has nodes " + quadsum);
					System.out.println("squad has nodes " + squadsum);
				} else {
					System.out.println(strings[i] + " not in map");
					int subtreeNodes = subdivide(subimages[i], nodes);
					quadsum += subtreeNodes;
					System.out.println("quad has nodes " + quadsum);
					System.out.println("squad has nodes " + squadsum);
					nodes.put(strings[i], subtreeNodes);
				}
			}
			return quadsum;
		}
	}
}
