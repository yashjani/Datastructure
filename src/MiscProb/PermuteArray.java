package MiscProb;

public class PermuteArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 1, 2, 3 };
		permute(array);

	}

	private static void permute(int[] array) {
		permuteUtil(array, 0, array.length - 1);

	}

	private static void permuteUtil(int[] array, int left, int right) {

		if (left == right) {
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = left; i <= right; i++) {
			swap(array,left,i);
			permuteUtil(array, left + 1, right);
			swap(array,left,i);
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
