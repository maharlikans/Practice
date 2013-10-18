import java.util.*;

public class PhoneHome {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		int caseNo = 0;
cases:	while (true) {
			n = input.nextInt();
			if (n == 0)
				break;
			caseNo++;

			CartCoor[] towers = new CartCoor[n];

			for (int i = 0; i < towers.length; i++) {
				towers[i] = new CartCoor(input.nextDouble(), input.nextDouble());
			}

			ArrayList[] near = new ArrayList[n];
			for (int i = 0; i < n; i++)
				near[i] = new ArrayList<Integer>();

			// building the graph, both ways
			for (int i = 0; i < towers.length; i++) {
				for (int j = 0; j < towers.length; j++) {
					if (i == j)
						continue;
					else if (towers[i].distLessTwenty(towers[j])) {
						near[i].add(j);
					}
				}
			}

			/*
			if (n == 1) {
				System.out.printf("The towers in case %d can be covered in %d frequencies.\n", caseNo, 1);
				continue cases;
			} 
			*/

			// eliminate whether or not it's a 5 coloring
			if (n >= 5) {
newcoloring:	for (int i = 0; i < pow(2, n); i++) {
					ArrayList<Integer> toSearch = new ArrayList<Integer>();
					String num = Integer.toBinaryString(i);
					int count = 0;
					while (num.length() != n)
						num = "0" + num;

					for (int letter = 0; letter < n; letter++) {
						if (num.charAt(letter) == '1') {
							count++;
							toSearch.add(letter);
						}
					}

					if (count == 5) {
						/*
						System.err.println("The included list of towers in this 5 combination is " + num);
						for (int nums = 0; nums < toSearch.size(); nums++) 
							System.err.print(toSearch.get(nums) + " ");
						System.err.println();
						*/
						for (int currNode = 0; currNode < toSearch.size(); currNode++) {
							ArrayList<Integer> neighbors = near[toSearch.get(currNode)];
							/*
							System.err.printf("Here are %d's neighbors: ", toSearch.get(node));
							for (int test = 0; test < neighbors.size(); test++)
								System.err.print(neighbors.get(test) + " ");
							System.err.println();
							*/
							for (int possibleNeighbor = 0; possibleNeighbor < toSearch.size(); possibleNeighbor++) {
								if (possibleNeighbor == currNode)
									continue;
								else if (!neighbors.contains(toSearch.get(possibleNeighbor))) {
									//System.err.println("We don't have " + toSearch.get(neighbor) + " in " + node + "'s neighbors.");
									continue newcoloring;
								}
							}
						}
						System.out.printf("The towers in case %d can be covered in %d frequencies.\n", caseNo, count);
						continue cases;
					} 
				}
			}

			if (n >= 4) {
				// check if it can be 4-colored and eliminate 4 colorings
newcoloring:	for (int i = 0; i < pow(2, n); i++) {
					ArrayList<Integer> toSearch = new ArrayList<Integer>();
					String num = Integer.toBinaryString(i);
					int count = 0;
					while (num.length() != n)
						num = "0" + num;

					// adds the combination to the ArrayList toSearch
					// to, of course, be searched
					for (int letter = 0; letter < n; letter++) {
						if (num.charAt(letter) == '1') {
							count++;
							toSearch.add(letter);
						}
					}

					// check to see if the count is 4 and check to see if the groups of 4 or 5 are all connected
					if (count == 4) {
						for (int currNode = 0; currNode < toSearch.size(); currNode++) {
							ArrayList<Integer> neighbors = near[toSearch.get(currNode)];
							for (int possibleNeighbor = 0; possibleNeighbor < toSearch.size(); possibleNeighbor++) {
								if (possibleNeighbor == currNode)
									continue;
								else if (!neighbors.contains(toSearch.get(possibleNeighbor))) {
									continue newcoloring;
								}
							}
						}
						System.out.printf("The towers in case %d can be covered in %d frequencies.\n", caseNo, count);
						continue cases;
					} 
				}
			}

			// if neither of the two above work, start checking colorings from 2 upward
colors:		for (int color = 1; color <= 3; color++) {
				int[] combination = new int[n];
combinations:	for (int k = 0; k < pow(color, n); k++) {
					boolean[] visited = new boolean[n];
					/*
					System.err.print("The current tower coloring is : ");
					for (int e : combination)
						System.err.print(e);
					System.err.println();
					*/

					int nodesVisited = 0;
bfs:				for (int tower = 0; tower < n; tower++) {
						if (visited[tower])
							continue;
						Queue<Integer> q = new LinkedList<Integer>();
						int currTower;
						q.offer(tower);

						while (!q.isEmpty()) {
							currTower = q.poll();
							visited[currTower] = true;
							nodesVisited++;
							for (int j = 0; j < near[currTower].size(); j++) {
								int neighbor = (int)(near[currTower].get(j));
								// System.err.printf("current tower is %d, ", currTower);
								// System.err.printf("current neighbor is %d\n", neighbor);
								// System.err.printf("currTower color = %d vs. neighbor is %d\n", combination[currTower], combination[neighbor]);
								if (combination[neighbor] != combination[currTower]) {
									if (!visited[neighbor]) {
										q.offer(neighbor);
										visited[neighbor] = true;
										nodesVisited++;
									}
								} else 
									break bfs;
							}
						}

						if (nodesVisited < n)
							continue;
						
						System.out.printf("The towers in case %d can be covered in %d frequencies.\n", caseNo, color);
						continue cases;
					}
					// once BFS finds out the coloring is bad, it breaks, then we go to the next combination
					int lowest = 0;
					// kind of cryptic line, basically shows how I'm simulating a base-color number
					// and iterating through all the possible values
					while (lowest < combination.length && ++combination[lowest] % color == 0) {
						combination[lowest] %= color;
						lowest++;
					}
				}
			}
		}
	}

	// java's pow sucks and takes too long and returns double so I use my own here
	public static int pow (int base, int exp) {
		if (exp == 0)
			return 1;
		int mult = base;
		for (int i = 2; i <= exp; i++)
			mult *= base;

		return mult;
	}
}

class CartCoor {
	public double x;
	public double y;

	public CartCoor(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public boolean distLessTwenty (CartCoor b) {
		return (Math.sqrt(Math.pow(this.x - b.x, 2) + Math.pow(this.y - b.y, 2)) <= 20.0);
	}
}
