package MiscProb;

public class FindNoOfOccurenceInSortedElement {
//Input: arr = [4, 4, 8, 8, 8, 15, 16, 23, 23, 42], target = 8
//	Output: 3
	public static void main(String[] args) {

		int[] arr = {2,2};
		int target = 2;
		System.out.println(searchRange(arr, target));

	}

	public static int[] searchRange(int[] arr, int target) {

		if (arr == null || arr.length == 0) {
			int [] result = {-1,-1};
		    return result;
		}

		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (end + start) / 2;

			if (arr[mid] < target) {
				start = mid + 1;
			} else if (arr[mid] > target) {
				end = mid - 1;
			} else {
				int temp = mid;
				start = mid;
				while (temp > 0 && arr[temp - 1] == target) {
					--temp;
					start = temp;
				}
				temp = mid;
				end = mid;
				while (temp < arr.length - 1 && arr[temp + 1] == target) {
					++temp;
					end = temp;
				}
				int[] result = { start, end };
				return result;
			}

		}

		int [] result = {-1,-1};
		return result;

	}
}
