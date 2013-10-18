import java.util.*;

public class PushingBoxes {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		// solution idea
		// for pushing the top wall down, search each box in the row and if found, 
		// then push the box to a stack, then try to move the box down as much
		// as we want to push the wall down. if we can't, push the box that's blocking
		// it into the stack, or if we've reached the bottom wall, don't allow the boxes 
		// to be pushed any further. pop each element from the stack and allow them
		// to be move as far downward as they can. 
		// 
		// then do the same for the push on the wall left
	}
}
