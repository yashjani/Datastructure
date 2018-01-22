package LinkedlistCustome.src;



public class UseList {

	public static void main(String... args) {
		LinkedListCustome<Integer> l = new LinkedListCustome<>();

		l.add(10);
		l.add(11);
		l.add(13);
		l.printList();
		l.addAtIndex(20, 2);
		l.delete(2);
		l.printList();
	}

}
