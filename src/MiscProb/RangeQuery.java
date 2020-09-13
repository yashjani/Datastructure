package MiscProb;

public class RangeQuery {

	static int[] arr = { 0, 1, 1, 1, 0, 0 };
	static int[] preSum = new int[arr.length + 1];

	public static void main(String[] args) {

		for (int i = 1; i < preSum.length; i++) {
			if (arr[i - 1] == 1)
				preSum[i] = preSum[i - 1] + 1;
			else
				preSum[i] = preSum[i - 1];
		}
		System.out.println(howManyOnesInRage(0, 3));
	}

	private static int howManyOnesInRage(int i, int j) {
		return preSum[j + 1] - preSum[i];
	}
}