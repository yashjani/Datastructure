package trie;

public class MaxDistance {
	int maxdistance;

	public int solve(String s[]) {
		this.maxdistance = 0;
		Trie root = new Trie();
		for (String word : s)
			insert(root, word);
		query(root);
		return this.maxdistance;
	}

	public void insert(Trie root, String s) {
		Trie cur = root;
		for (char c : s.toCharArray()) {
			int i = c - '0';
			if (cur.child[i] == null)
				cur.child[i] = new Trie();
			cur = cur.child[i];
		}
		cur.isEnd = true;
	}

	public int query(Trie root) {
		if (root == null)
			return 0;
		int left = query(root.child[0]);
		int right = query(root.child[1]);
		if (left > 0 && right > 0) {
			this.maxdistance = Math.max(this.maxdistance, left + right);
		}
		return 1 + Math.max(left, right);
	}

	class Trie {
		boolean isEnd;
		Trie child[] = new Trie[2];
	}
	
	public static void main(String[] args) {
		MaxDistance m = new MaxDistance();
		String[] s = {"101010111","101010000"};
		m.solve(s);
	}
}