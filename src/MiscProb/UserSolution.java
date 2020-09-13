package MiscProb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class UserSolution {
	public static int networkDelayTime(int[][] times, int N, int K) {
		
//		if(times.length == 0){
//            return -1;
//        }
//        
//        if(times.length == 1){
//            return times[0][3];
//        }

		boolean[] visited = new boolean[N+1];
		int result = 0;

		List<Node1>[] list = new List[N+1];

		for (int i = 0; i < times.length; i++) {
			if(list[times[i][0]] == null) {
				list[times[i][0]] = new ArrayList<>();	
			} 
			list[times[i][0]].add(new Node1(times[i][1], times[i][2]));
		}

		Queue<List<Node1>> queue = new LinkedList<>();
		queue.offer(list[K]);
		visited[K] = true;

		while (!queue.isEmpty()) {
			List<Node1> tempList = queue.poll();
			
			
			if(tempList == null) {
				continue;
			}
			

			for (int i = 0 ; i < tempList.size(); i++) {
				if(tempList.get(i) == null) {
					continue;
				}
				if (!visited[tempList.get(i).dest]) {
					queue.offer(list[tempList.get(i).dest]);
					result += tempList.get(i).weight;
					
				}
				
				visited[tempList.get(i).dest] = true;

			}

		}

		for (int i = 1 ; i < N + 1; i++) {
			if (!visited[i]) {
				return -1;
			}
		}

		return result;

	}

	public static void main(String[] args) {
		
		int[][] times = {{2,1,2},{2,3,2},{3,4,1}};
		//int[][] times = {{1,2,1}};
//		int[][] times = {{1,2,1},{2,1,3}};
		
		networkDelayTime(times,4,2);

	}
}
