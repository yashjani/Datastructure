package MiscProb;

import java.util.PriorityQueue;
import java.util.Queue;

public class PointInMaxOverlapping {

	public static void main(String[] args) {
		int m = 10, n = 4;
		int[][] intervals = {{-3, 5}, {0,2}, {8, 10}, {6, 7}};
		System.out.println(getMaxPoint(intervals, n));
	}

	private static int getMaxPoint(int[][] intervals, int n) {
		Queue<int[]> minHeap = new PriorityQueue<>((a, b)-> a[0] - b[0]);
		int res = Integer.MIN_VALUE;
		int gloMax = 0;
		int max = 0;
		for(int[] it : intervals) {
			minHeap.offer(new int[] {it[0], 1});
			minHeap.offer(new int[] {it[1], -1});
		}
		while(!minHeap.isEmpty()) {
			int[] cur = minHeap.poll();
			max += cur[1];
			if(max > gloMax) {
				gloMax = max;
				res = cur[0];
			}
		}
		return gloMax;
	}

}
