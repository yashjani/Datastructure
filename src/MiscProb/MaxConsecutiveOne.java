package MiscProb;

public class MaxConsecutiveOne {

	public static void main(String[] args) {
		int [] A = {1,1,1,0,0,0,1,1,1,1,0};
		int K = 2;
		longestOnes(A, K);

	}

	public static int longestOnes(int[] A, int K) {
		int max = 0;
		int zeroCount = 0; // zero count in current window
		int i = 0; // slow pointer
		for (int j = 0; j < A.length; ++j) {
			if (A[j] == 0) { // move forward j, if current is 0, increase the zeroCount
				zeroCount++;
			}
			// when current window has more than K, the window is not valid any more
			// we need to loop the slow pointer until the current window is valid
			while (zeroCount > K) {
				if (A[i] == 0) {
					zeroCount--;
				}
				i++;
			}
			max = Math.max(max, j - i + 1); // everytime we get here, 
			//the current window is valid
		}
		return max;
	}
}
