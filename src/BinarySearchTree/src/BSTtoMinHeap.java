package BinarySearchTree.src;

//Java Program to convert a BST into a Min-Heap 
//in O(n) time and in-place 
import java.util.*;

class BSTtoMinHeap {

//Node for BST/Min-Heap 
	static class Node {
		int data;
		Node left, right;
	};

//Utility function for allocating node for BST 
	static Node newNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = node.right = null;
		return node;
	}

//Utility function to print Min-heap level by level 
	static void printLevelOrder(Node root) {
		// Base Case
		if (root == null)
			return;

		// Create an empty queue for level order traversal
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (q.size() > 0) {
			int nodeCount = q.size();
			while (nodeCount > 0) {
				Node node = q.peek();
				System.out.print(node.data + " ");
				q.remove();
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
				nodeCount--;
			}
			System.out.println();
		}
	}

//A simple recursive function to convert a given 
//Binary Search tree to Sorted Linked List 
//root	 -. Root of Binary Search Tree 
//head_ref -. Pointer to head node of created 
//			 linked list 
	static Node BSTToSortedLL(Node root, Node head_ref) {
		// Base cases
		if (root == null)
			return head_ref;

		// Recursively convert right subtree
		head_ref = BSTToSortedLL(root.right, head_ref);

		// insert root into linked list
		root.right = head_ref;

		// Change left pointer of previous head
		// to point to null
		if (head_ref != null)
			(head_ref).left = null;

		// Change head of linked list
		head_ref = root;

		// Recursively convert left subtree
		head_ref = BSTToSortedLL(root.left, head_ref);
		return head_ref;
	}

//Function to convert a sorted Linked 
//List to Min-Heap. 
//root -. Root of Min-Heap 
//head -. Pointer to head node of sorted 
//			 linked list 
	static Node SortedLLToMinHeap(Node root, Node head) {
		// Base Case
		if (head == null)
			return null;

		// queue to store the parent nodes
		Queue<Node> q = new LinkedList<>();

		// The first node is always the root node
		root = head;

		// advance the pointer to the next node
		head = head.right;

		// set right child to null
		root.right = null;

		// add first node to the queue
		q.add(root);

		// run until the end of linked list is reached
		while (head != null) {
			// Take the parent node from the q and remove it from q
			Node parent = q.peek();
			q.remove();

			// Take next two nodes from the linked list and
			// Add them as children of the current parent node
			// Also in add them into the queue so that
			// they will be parents to the future nodes
			Node leftChild = head;
			head = head.right; // advance linked list to next node
			leftChild.right = null; // set its right child to null
			q.add(leftChild);

			// Assign the left child of parent
			parent.left = leftChild;

			if (head != null) {
				Node rightChild = head;
				head = head.right; // advance linked list to next node
				rightChild.right = null; // set its right child to null
				q.add(rightChild);

				// Assign the right child of parent
				parent.right = rightChild;
			}
		}
		return root;
	}

//Function to convert BST into a Min-Heap 
//without using any extra space 
	static Node BSTToMinHeap(Node root) {
		// head of Linked List
		Node head = null;

		// Convert a given BST to Sorted Linked List
		head = BSTToSortedLL(root, head);

		// set root as null
		root = null;

		// Convert Sorted Linked List to Min-Heap
		root = SortedLLToMinHeap(root, head);
		return root;
	}

//Driver code 
	public static void main(String args[]) {
		/*
		 * Constructing below tree 8 / \ 4 12 / \ / \ 2 6 10 14
		 */

		Node root = newNode(8);
		root.left = newNode(4);
		root.right = newNode(12);
		root.right.left = newNode(10);
		root.right.right = newNode(14);
		root.left.left = newNode(2);
		root.left.right = newNode(6);

		root = BSTToMinHeap(root);

		/*
		 * Output - Min Heap 2 / \ 4 6 / \ / \ 8 10 12 14
		 */

		printLevelOrder(root);
	}
}

//This code is contributed by andrew1234 
