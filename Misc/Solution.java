import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int p = 0; p < t; p++) {
        	int w = input.nextInt();
        	int h = input.nextInt();
        	int n = input.nextInt();

    		int[][] grid = new int[w + 1][h + 1];
    		boolean[][] visited = new boolean[w + 1][h + 1];
    		boolean[] removed = new boolean[n+1];	// represents the circles that have been removed already
        	int[] dx = {-1, -1, -1, 0, 1, 1,  1,  0};
   			int[] dy = {-1,  0,  1, 1, 1, 0, -1, -1};

   			// reading in the circles
        	for (int z = 1; z <= n; z++) {
        		int x = input.nextInt();
        		int y = input.nextInt();
        		int r = input.nextInt();

        		// iterate a square around the given point
        		// from x - r to x + r inclusive
        		for (int i = x - r; i <= x + r; i++) {
        			for (int j = y - r; j <= y + r; j++) {
        				// if we're still within bounds
        				if ((i >= 0 && i <= w)) && (j >= 0 && j <= h)) {
        					// and if the point we're looking at is in or on the circle
        					if (Math.pow(i - x, 2) + Math.pow(j - y, 2) <= r) {
        						grid[i][j] = z;
        					}
        				}
        			}
        		}

        		// need to think of a simple way to mark the grid for two things that have already been visited
        	}


    		System.out.println(0 + (int)(n*Math.random()));
        }
    }
}