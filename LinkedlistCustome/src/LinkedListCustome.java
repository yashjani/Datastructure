
public class LinkedListCustome<V> {

	public static int size = 0;
	public Node<V> head;

	public static class Node<V> {

		V value;
		Node<V> next;

		public Node(V value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	public void add(V value) {

		if (value == null) {
			return;
		} else {

			Node<V> entry = new Node(value, null);
			if (head == null) {
				head = entry;
			} else {
				Node<V> current = head;
				while (current.next != null) {
					current = current.next;
				}

				current.next = entry;
				size++;
			}

		}

	}
	
	public void delete(int index){
		
		if(head == null) return;
		
		if(index == 0 ){
			head = head.next;
		}
		
		Node<V> temp = head;
		for(int i = 0 ; i < index-1 || temp.next == null ; i++){
			temp = temp.next;
		}
		
		temp.next = temp.next.next;	
	}
	
	public void addAtIndex(V value,int index){
		
		Node<V> entry = new Node<V>(value, null);
		
		Node<V> current = head;
		
		for(int i = 0 ; i < index && current.next == null ; i ++){
			
			current = current.next;		
		}
		
		
		
		
	}
	
public void printList(){
	
	    Node<V> current = head;
		
		while(current != null){
			System.out.println(current.value);
			current = current.next;
		}
		
	}

}
