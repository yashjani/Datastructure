package DaynamicProgramming;

/* Dynamic Programming implementation of LCS problem */
import java.util.*;

class PrintAllLongestCommonSubsequence {

// Maximum String length 
	static int N = 100;

	static int[][] L = new int[N][N];

	/*
	 * Returns set containing all LCS for X[0..m-1], Y[0..n-1]
	 */
	static Set<String> findLCS(String X, String Y, int m, int n) {
		// construct a set to store possible LCS
		Set<String> s = new HashSet<>();

		// If we reaches end of either String,
		// return a empty set
		if (m == 0 || n == 0) {
			s.add("");
			return s;
		}

		// If the last characters of X and Y are same
		if (X.charAt(m - 1) == Y.charAt(n - 1)) {
			// recurse for X[0..m-2] and Y[0..n-2]
			// in the matrix
			Set<String> tmp = findLCS(X, Y, m - 1, n - 1);

			// append current character to all possible LCS
			// of subString X[0..m-2] and Y[0..n-2].
			for (String str : tmp)
				s.add(str + X.charAt(m - 1));
		}

		// If the last characters of X and Y are not same
		else {
			// If LCS can be constructed from top side of
			// the matrix, recurse for X[0..m-2] and Y[0..n-1]
			if (L[m - 1][n] >= L[m][n - 1]) {
				Set<String> tmp = findLCS(X, Y, m - 1, n);
				s.addAll(tmp);
				
			}

			// If LCS can be constructed from left side of
			// the matrix, recurse for X[0..m-1] and Y[0..n-2]
			if (L[m][n - 1] >= L[m - 1][n]) {
				Set<String> tmp = findLCS(X, Y, m, n - 1);

				// merge two sets if L[m-1][n] == L[m][n-1]
				// Note s will be empty if L[m-1][n] != L[m][n-1]
				s.addAll(tmp);
			}
		}
		return s;
	}

	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	static int LCS(String X, String Y, int m, int n) {
		// Build L[m+1][n+1] in bottom up fashion
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X.charAt(i - 1) == Y.charAt(j - 1))
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
			}
		}
		return L[m][n];
	}

// Driver Code 
	public static void main(String[] args) {
		String X = "AGTGATG";
		String Y = "GTTAG";
		int m = X.length();
		int n = Y.length();

		System.out.println("LCS length is " + LCS(X, Y, m, n));

		Set<String> s = findLCS(X, Y, m, n);

		for (String str : s)
			System.out.println(str);
	}
}

// This code is contributed by 29AjayKumar 
