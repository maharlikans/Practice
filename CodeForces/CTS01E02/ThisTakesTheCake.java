import java.util.*;

// TODO: Debuggin' more

public class ThisTakesTheCake {
	public static void main (String[] args) {
		Scanner input = new Scanner (System.in);
		int cake = 0;
		while (true) {
			cake++;
			Point[] points = new Point[8];
			boolean end = true;
			double x,
				   y;

			// indexes the vertices and leaves space for the midpoints
			for (int i = 0; i < 4; i++) {
				x = input.nextDouble();
				y = input.nextDouble();
				if (x != 0.0 || y != 0.0)
					end = false;
				points[i*2] = new Point(x, y);
			}

			if (end)
				break;

			// adds midpoints between the vertices to the array of points
			for (int i = 1; i < points.length; i += 2)  {
				points[i] = new Point((points[i-1].x + points[(i+1) % points.length].x)/2.0, (points[i-1].y + points[(i+1) % points.length].y)/2.0);
			}
			/*
			for (int i = 0; i < points.length; i++)
				System.err.printf("Point %d: (%.3f, %.3f)\n", i, points[i].x, points[i].y);
			*/

			double area1,
				   area2,
				   smallestDiff = Double.MAX_VALUE,
				   smallestArea1 = -1,
				   smallestArea2 = -1;

			// calculate separate areas from this point to all other points
			// I realize I could have just calculated the entire area once and reused it
			// but this way should work and the testing has showed that it kind of does
			// obviously there's a case which breaks it since I'm getting wrong
			// answer
			for (int i = 0; i < points.length; i++) {
				for (int j = 0; j < points.length; j++) {
					if (i == j) 
						continue;
					// System.err.printf("Looking at points (%.3f, %.3f) and (%.3f, %.3f)\n", points[i].x, points[i].y, points[j].x, points[j].y);
					area1 = calcArea(points, i, j);
					area2 = calcArea(points, j, i);
					// System.err.printf("Area 1: %f\n", area1);
					// System.err.printf("Area 2: %f\n", area2);
					if (Math.abs(area1 - area2) < smallestDiff) {
						// System.err.printf("Smallest diff currently: %f\n", smallestDiff);
						smallestDiff = Math.abs(area1 - area2);
						smallestArea1 = area1;
						smallestArea2 = area2;
					}
				}
			}

			if (smallestArea1 < smallestArea2) 
				System.out.printf("Cake %d: %.3f %.3f\n", cake, smallestArea1, smallestArea2);
			else 
				System.out.printf("Cake %d: %.3f %.3f\n", cake, smallestArea2, smallestArea1);

		}
	}

	public static double calcArea(Point[] points, int i, int j) {
		double result = 0;
		int bMod,
			bPlusMod;

		for (int begin = i; (begin % points.length) != j; begin++) {
			bMod = begin % points.length;
			bPlusMod = (begin + 1) % points.length;
			result += points[bMod].x*points[bPlusMod].y - points[bMod].y*points[bPlusMod].x;
		}
		result += points[j].x*points[i].y - points[j].y*points[i].x;

		return Math.abs(result)/2;
	}
}

class Point {
	public double x;
	public double y;

	public Point (double x, double y) {
		this.x = x;
		this.y = y;
	}
}
