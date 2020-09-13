package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode399 {
	
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        
        int n = queries.size();
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            res[i] = dfs(graph, new HashSet<>(), queries.get(i).get(0), queries.get(i).get(1));
        }
        return res;
    }
    
	
	  private double dfs(Map<String, Map<String, Double>> graph, Set<String> visited, String start, String end) {
	        if (!graph.containsKey(start)) return -1;
	        if (graph.get(start).containsKey(end)) return graph.get(start).get(end);
	        
	        visited.add(start);
	        for (String next : graph.get(start).keySet()) {
	            if (visited.contains(next)) continue;
	            double val = graph.get(start).get(next);
	            if (val == -1) continue;
	            double weight = dfs(graph, visited, next, end);
	            if (weight != -1) {
	                graph.get(start).put(end, weight * val);
	                return weight * val;
	            }
	        }
	        graph.get(start).put(end, (double)-1);
	        return -1;
	    }
	    
	    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
	        Map<String, Map<String, Double>> graph = new HashMap<>();
	        for (int i = 0; i < equations.size(); i++) {
	            String a = equations.get(i).get(0), b = equations.get(i).get(1);
	            double val = values[i];
	            if (!graph.containsKey(a)) graph.put(a, new HashMap<>());
	            if (!graph.containsKey(b)) graph.put(b, new HashMap<>());
	            graph.get(a).put(b, val);
	            graph.get(b).put(a, 1/val);
	        }
	        return graph;
	    }

	public static void main(String[] args) {
		
		List<List<String>> list = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		temp.add("a");
		temp.add("b");
		list.add(temp);
		temp = new ArrayList<>();
		temp.add("b");
		temp.add("c");
		list.add(temp);
		temp = new ArrayList<>();
		temp.add("c");
		temp.add("d");
		list.add(temp);
		
		double[] values = {2.0,3.0,4.0};
		
		List<List<String>> eq = new ArrayList<>();
		temp = new ArrayList<>();
		temp.add("a");
		temp.add("d");
		eq.add(temp);
		temp = new ArrayList<>();
		temp.add("b");
		temp.add("d");
		eq.add(temp);
		temp = new ArrayList<>();
		temp.add("x");
		temp.add("x");
		eq.add(temp);

		LeetCode399 ll = new LeetCode399();
		ll.calcEquation(list,values, eq);
		// TODO Auto-generated method stub

	}

}
