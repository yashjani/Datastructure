package DaynamicProgramming;

import java.util.HashMap;

public class LongestAithmeticSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// int[] arr = {
		// 24,13,1,100,0,94,3,0,3};
		int[] arr = { 83, 20, 17, 43, 52, 78, 68, 45 };
		System.out.println(longestArithSeqLength(arr));

	}

	public static int longestArithSeqLength(int[] A) {
		if (A == null || A.length <= 1)
			return 0;

		int maxCount = 0;

		// key = difference, value = count
		HashMap<Integer, Integer>[] maps = new HashMap[A.length];
		for (int i = 0; i < A.length; i++) {
			maps[i] = new HashMap<Integer, Integer>();
			// No need to iterate grater value then i becoz we will calcu
			// late it by using dp
			for (int j = i - 1; j >= 0; j--) {
				int difference = A[i] - A[j];
				// take max count of this difference
				// get previous same difference  increment it by one or use existing one
				maps[i].put(difference,
						Math.max(maps[i].getOrDefault(difference, 1), maps[j].getOrDefault(difference, 1) + 1));
				maxCount = Math.max(maxCount, maps[i].get(difference));
			}
		}
		return maxCount;

	}

}
