package HashMapCustomeImple.src;


public class HashMapCustome<K, V> {

	public Entry<K, V>[] table;
	public static int size = 4;

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next) {

			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	@SuppressWarnings("unchecked")
	public HashMapCustome() {
		table = new Entry[4];
	}

	/* p = hashvlaue ; cu = hashvalue ;cu next */
	public int hash(K key) {

		return Math.abs(key.hashCode()) % size;
	}

	public void put(K key, V value) {
		if (key == null) {
			return;
		}
		Entry<K, V> newEntry = new Entry<K, V>(key, value, null);

		int position = hash(key);
		if (table[position] == null) {
			table[position] = newEntry;
		} else {

			Entry<K, V> current = table[position];
			Entry<K, V> previous = null;

			while (current != null) {
				if (current.key.equals(newEntry.key)) {
					if (previous == null) {

						newEntry.next = current.next;
						table[position] = newEntry;
						return;

					} else {

						newEntry.next = current.next;
						previous.next = newEntry;
						return;
					}
				}
				previous = current;
				current = current.next;
			}

			previous.next = newEntry;

		}

	}

	public void remove(K key) {
		if (key == null) {
			return;
		}
		int hash = hash(key);
		if (table[hash] == null) {
			return;
		} else {
			Entry<K, V> current = table[hash];
			Entry<K, V> previous = null;

			while (current != null) {
				if (current.key.equals(key)) {
					if (previous == null) {
						table[hash] = table[hash].next;
						return;
					}
					previous.next = current.next;
					current = null;
					return;
				}

				previous = current;
				current = current.next;
			}
		}
	}
	
	  public V get(K key){
	        int hash = hash(key);
	        if(table[hash] == null){
	         return null;
	        }else{
	         Entry<K,V> temp = table[hash];
	         while(temp!= null){
	             if(temp.key.equals(key))
	                 return temp.value;
	             temp = temp.next; //return value corresponding to key.
	         }         
	         return null;   //returns null if key is not found.
	        }
	    }
	  public void display(){
	       
	       for(int i=0;i<size;i++){
	           if(table[i]!=null){
	                  Entry<K, V> entry=table[i];
	                  while(entry!=null){
	                        System.out.print("{"+entry.key+"="+entry.value+"}" +" ");
	                        entry=entry.next;
	                  }
	           }
	       }             
	    
	    }

}
