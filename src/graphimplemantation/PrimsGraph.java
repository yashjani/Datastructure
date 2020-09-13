package graphimplemantation;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;


public class PrimsGraph {
	
	List<Entry<Integer,Integer>> [] adjList;
	int v;
	@SuppressWarnings("unchecked")
	public PrimsGraph(int v) {
		
		this.adjList = new LinkedList[v];
		this.v = v;
		for(int i = 0 ; i < v ; i ++) {
			this.adjList[i] = new LinkedList<>();
		}
		
	}
	
	public void addEdge(int i, int v, int w) {
		this.adjList[i].add(new AbstractMap.SimpleEntry<Integer, Integer>(v, w));
		this.adjList[v].add(new AbstractMap.SimpleEntry<Integer, Integer>(i, w));

	}
	
	

	public static void main(String[] args) {

		int V = 9; 
		PrimsGraph g = new PrimsGraph(V); 
	  
	    //  making above shown graph 
	    g.addEdge(0, 1, 4); 
	    g.addEdge(0, 7, 8); 
	    g.addEdge(1, 2, 8); 
	    g.addEdge(1, 7, 11); 
	    g.addEdge(2, 3, 7); 
	    g.addEdge(2, 8, 2); 
	    g.addEdge(2, 5, 4); 
	    g.addEdge(3, 4, 9); 
	    g.addEdge(3, 5, 14); 
	    g.addEdge(4, 5, 10); 
	    g.addEdge(5, 6, 2); 
	    g.addEdge(6, 7, 1); 
	    g.addEdge(6, 8, 6); 
	    g.addEdge(7, 8, 7); 
	  
	    g.primMST(); 
		
	}

	private void primMST() {
		
		int[] key = new int[this.v];
		boolean[] visited = new boolean[this.v];
		Entry<Integer,Integer>[] result = new AbstractMap.SimpleEntry[this.v];
		
		for(int i = 0 ; i < this.v; i++) {
			visited[i] = false;
			key[i] = Integer.MAX_VALUE;
		}
	
		//Initialize priority queue
        //override the comparator to do the sorting based keys
		PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
		
        //create the pair for for the first index, 0 key 0 index
        key[0] = 0;
        Entry<Integer, Integer> p0 = new AbstractMap.SimpleEntry<>(key[0],0);
        //add it to pq
        pq.offer(p0);
        
        //add it to pq

        result[0] = new AbstractMap.SimpleEntry<>(-1,null);

        //while priority queue is not empty
        while(!pq.isEmpty()){
            //extract the min
            Entry<Integer, Integer> extractedPair = pq.poll();

            //extracted vertex
            int extractedVertex = extractedPair.getValue();
            visited[extractedVertex] = true;

            //iterate through all the adjacent vertices and update the keys
            List<Entry<Integer, Integer>> list = adjList[extractedVertex];
            for (int i = 0; i <list.size() ; i++) {
                Entry<Integer, Integer> edge = list.get(i);
                //only if edge destination is not present in mst
                if(visited[edge.getKey()]==false) {
                    int destination = edge.getKey();
                    int weight = edge.getValue();
                    //check if updated key < existing key, if yes, update if
                    if(key[destination]>weight) {
                        //add it to the priority queue
                        Entry<Integer, Integer> p = new AbstractMap.SimpleEntry<>(weight, destination);
                        pq.offer(p);
                        //update the resultSet for destination vertex
                        result[destination] =  new AbstractMap.SimpleEntry<Integer, Integer>(extractedVertex,weight);
                        //update the key[]
                        key[destination] = weight;
                    }
                }
            }
        }
        //print mst
        printMST(result);
		
	}

	private void printMST(Entry<Integer, Integer>[] result) {
		 int total_min_weight = 0;
         System.out.println("Minimum Spanning Tree: ");
         for (int i = 1; i <v ; i++) {
             System.out.println("Edge: " + result[i].getKey() + " - " + i +
                     " key: " + result[i].getValue());
             total_min_weight += result[i].getValue();
         }
         System.out.println("Total minimum key: " + total_min_weight);
		
	}

}
