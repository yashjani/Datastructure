package MiscProb;
//Given a source of integers, design a class or set of functions that will:

import java.util.LinkedList;

//   a. accept new data via a newValue(...) function.
//   b. return the minimum value seen so far.
//   c. return the median value of the data.
//
//[ 0, 1, 2, 3, 6, 9, 20]  --> 3
//[ 0, 1, 2, 3, 4, 6, 9, 20] ---> 3.5
//
//[ 0, 1, 1, 1, 1, 1, 1, 1, 2, 3, 6, 6, 7, 9, 20]
//
//2*i
//2*i + 1
//[]

import java.util.PriorityQueue;

public class Solution1 {
	PriorityQueue<Short> queue = null;

	public Solution1() {
		queue = new PriorityQueue<>();
	}

	public void newValue(short input) {
		queue.offer(input);
	}

	public short getMinum() {
		return queue.peek();
	}

	public float getMedian() {
		if (queue.isEmpty()) {
			return -1;
		}
		float result;
		int index = queue.size() / 2;
		if (queue.size() % 2 == 0) {
			result = (queue.get(index) + queue.get(++index)) / 2.0;
		} else {
			result = queue.get(index);
		}

		return result;

	}

	public static void main(String[] args) {

		Solution1 sol = new Solution1();
		Short s = new Short((short) 0);
		sol.newValue((short)zs);
		sol.newValue(1);
		sol.newValue(2);
		sol.newValue(3);
		sol.newValue(4);
		sol.getMinum();
		sol.getMedian();

	}

}
