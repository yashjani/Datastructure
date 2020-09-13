package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ArrangeLogs937 {
	 public static String[] reorderLogFiles(String[] logs) {
//			PriorityQueue<String> string = new PriorityQueue<>(10, new Comparator<String>() {
//				@Override
//				public int compare(String a, String b) {
//	                int firstSpaceA = a.indexOf(" ");
//	                int firstSpaceB = b.indexOf(" ");
//					return a.substring(firstSpaceA+1, a.length()).compareTo(b.substring(firstSpaceB + 1, b.length()));
//				}
//
//			});

		 	List<String> stringLogs = new ArrayList<>();
			List<String> digitLogs = new ArrayList<>();
			Arrays.stream(logs).forEach(item -> {
				String[] itemArray = null;
				itemArray = item.split(" ");
				Character c = null;
				for(int i = 0 ; i < item.length(); i++) {
					c = item.charAt(i);
					if(c.isDigit(c)) {
						digitLogs.add(item);
						break;
					}else {
						stringLogs.add(item);

					}
				}
			});

			Collections.sort(stringLogs, new Comparator<String>() {

				@Override
				public int compare(String a, String b) {
	                int firstSpaceA = a.indexOf(" ");
	                int firstSpaceB = b.indexOf(" ");
					int temp = a.substring(firstSpaceA+1, a.length()).compareTo(b.substring(firstSpaceB + 1, b.length()));
					if(temp == 0) {
						return a.substring(0, firstSpaceA).compareTo(b.substring(0, firstSpaceB));
					}
					
					return temp;
				}
			});
			List<String> result = new ArrayList<>(stringLogs);
	        result.addAll(digitLogs);

			String[] itemsArray = new String[result.size()];
			itemsArray = result.toArray(itemsArray);
			return itemsArray;

		}
	public static void main(String[] args) {
		String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		reorderLogFiles(logs);
	}
}