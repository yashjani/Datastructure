package Arrays;

//Java program to rotate an array by 
//d elements 
class ArrayRotation {
	/* Function to left rotate arr[] of siz n by d */
	void leftRotate(int arr[], int d, int n) {
		int i, j, k, temp;
		int g_c_d = gcd(d, n);
		for (i = 0; i < g_c_d; i++) {
			/* move i-th values of blocks */
			temp = arr[i];
			j = i;
			while (true) {
				k = j + d;
				if (k >= n)
					k = k - n;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}

	/* UTILITY FUNCTIONS */

	/* function to print an array */
	void printArray(int arr[], int size) {
		int i;
		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}

	/* Fuction to get gcd of a and b */
	int gcd(int num1, int num2) {
		if (num2 == 0)
			return num1;
		else
			return gcd(num2, num1 % num2);
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		ArrayRotation rotate = new ArrayRotation();
		int arr[] = { 1, 2, 3, 4, 5};
		rotate.leftRotate(arr, 2, 5);
		rotate.printArray(arr, 8);
	}
}

//This code has been contributed by Mayank Jaiswal 
