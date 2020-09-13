package MiscProb;

public class ProductOfArray {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] temp = { 1, 2, 3, 4 };
		productExceptSelf(temp);
	}

	public static int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		for (int i = 0, tmp = 1; i < nums.length; i++) {
			result[i] = tmp;
			tmp *= nums[i];
		}
		for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
			result[i] *= tmp;
			tmp *= nums[i];
		}
		return result;
	}

}
