public class TeamContestEasy {
	public static int worstRank(int[] strength) {
		int ourRank = calcStr(strength[0], strength[1], strength[2]);
		if(strength.length > 3) {
			int[] restStrengths = new int[strength.length - 3];
			int[] teamStrengths = new int[restStrengths.length/3];
			
			for(int i = 3, j=0; i < strength.length; i++, j++) {
				restStrengths[j] = strength[i];
			}
			
			Arrays.sort(restStrengths);
			// then reverse
			int left = 0;
			int right = restStrengths.length - 1;
			while(left < right) {
				int temp = restStrengths[left];
				restStrengths[left] = restStrengths[right];
				restStrengths[right] = temp;
			}
			
			int better = 0;
			
			for(int i = 0, j = 0; i < restStrengths.length; i+=3, j++) {
				teamStrengths[j] = calcStr(restStrengths[i], restStrengths[i + 1], restStrengths[i + 2]);
			}
			
			for(int i )
		} else {
			return 1;
		}
	}
	
	public static int min(int s1, int s2) {
		if (s1 < s2)
			return s1;
		else
			return s2;
	}
	
	public static int minAll(int s1, int s2, int s3) {
		return min(min(s1, s2), s3);
	}
	
	public static int calcStr(int s1, int s2, int s3) {
		return s1 + s2 + s3 - minAll(s1, s2, s3);
	}
}
