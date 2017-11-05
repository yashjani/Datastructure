package HashMapCustomeImple.src;


public class UseMAp {

	public static <K, V> void main(String[] args) {

		
		HashMapCustome<Integer, Integer> hashMapCustom = new HashMapCustome<Integer, Integer>();
		hashMapCustom.put(21, 12);
		hashMapCustom.put(25, 121);
		hashMapCustom.put(30, 151);
		hashMapCustom.put(33, 15);
		hashMapCustom.put(35, 89);

		System.out.println("value corresponding to key 21=" + hashMapCustom.get(21));
		System.out.println("value corresponding to key 51=" + hashMapCustom.get(51));

		System.out.print("Displaying : ");
		hashMapCustom.display();
		 hashMapCustom.remove(21);
		 System.out.println("Displaying : ");
		hashMapCustom.display();
	}

}
