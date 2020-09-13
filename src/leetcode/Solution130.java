package leetcode;

public class Solution130 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { { '0', '0', '0'}, { '0', 'O', 'O' }, { '0', '0', 'O' },
				  };
		solve(board);

	}

	public static void solve(char[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				dfs(board, i, j);
			}
		}
		System.out.println();
	}

	public static void dfs(char[][] board, int i, int v) {
		if (i < 0 || i >= board.length || v < 0 || v >= board[i].length || board[i][v] == 'X') {
			return;
		}

		if ((i * v == 0 || i == board.length - 1 || v == board[i].length - 1)) {
			return;
		}

		board[i][v] = 'X';
		dfs(board, i, v + 1);
		dfs(board, i + 1, v);
		dfs(board, i, v - 1);
		dfs(board, i - 1, v);

	}

}
