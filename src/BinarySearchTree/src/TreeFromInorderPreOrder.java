package BinarySearchTree.src;

import java.util.HashMap;
import java.util.Map;

class TreeFromInorderPreOrder {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	int prIndex = 0;
	int[] preorder;
	int[] inorder;
	Map<Integer, Integer> map = new HashMap<>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int id = 0;
		this.preorder = preorder;
		this.inorder = inorder;
		for (int i : inorder) {
			this.map.put(i, id++);
		}
		return healper(0, inorder.length);

	}

	public TreeNode healper(int left, int right) {

		if (left == right)
			return null;
		int value = this.preorder[prIndex];
		TreeNode root = new TreeNode(value);
		prIndex++;

		int index = map.get(value);

		root.left = healper(left, index);
		root.right = healper(index + 1, right);
		return root;

	}
	
	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		
		TreeFromInorderPreOrder obj = new TreeFromInorderPreOrder();
		TreeNode node = obj.buildTree(preorder, inorder);
		
	}
}
