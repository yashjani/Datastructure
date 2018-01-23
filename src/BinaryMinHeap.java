
public class BinaryMinHeap {

	private int[] data;
	private int heapSize;

	public BinaryMinHeap(int size) {
		this.data = new int[size];
	}

	public int getMinimum() {

		if (isEmpty())

			throw new HeapException("Heap is empty");

		else

			return data[0];

	}

	public boolean isEmpty() {

		return (heapSize == 0);

	}

	private int getLeftChildIndex(int nodeIndex) {

		return 2 * nodeIndex + 1;

	}

	private int getRightChildIndex(int nodeIndex) {

		return 2 * nodeIndex + 2;

	}

	private int getParentIndex(int nodeIndex) {

		return (nodeIndex - 1) / 2;

	}

	public void insert(int value) {

		if (heapSize == data.length)

			throw new HeapException("Heap's underlying storage is overflow");

		else {

			heapSize++;

			data[heapSize - 1] = value;

			siftUp(heapSize - 1);

		}

	}

	private void siftUp(int nodeIndex) {

		int parentIndex, tmp;

		if (nodeIndex != 0) {

			parentIndex = getParentIndex(nodeIndex);

			if (data[parentIndex] > data[nodeIndex]) {

				tmp = data[parentIndex];

				data[parentIndex] = data[nodeIndex];

				data[nodeIndex] = tmp;

				siftUp(parentIndex);

			}

		}

	}

	public void removeMin() {

		if (isEmpty())

			throw new HeapException("Heap is empty");
		else {

			data[0] = data[heapSize - 1];

			heapSize--;

			if (heapSize > 0)

				siftDown(0);

		}

	}

	private void siftDown(int nodeIndex) {

		int leftChildIndex, rightChildIndex, minIndex, tmp;

		leftChildIndex = getLeftChildIndex(nodeIndex);

		rightChildIndex = getRightChildIndex(nodeIndex);

		if (rightChildIndex >= heapSize) {

			if (leftChildIndex >= heapSize)

				return;

			else

				minIndex = leftChildIndex;

		} else {

			if (data[leftChildIndex] <= data[rightChildIndex])

				minIndex = leftChildIndex;

			else

				minIndex = rightChildIndex;

		}

		if (data[nodeIndex] > data[minIndex]) {

			tmp = data[minIndex];

			data[minIndex] = data[nodeIndex];

			data[nodeIndex] = tmp;

			siftDown(minIndex);

		}

	}

	public class HeapException extends RuntimeException {

		public HeapException(String message) {

			super(message);

		}

	}
	
	public static void main(String[] args){
		BinaryMinHeap binaryMinHeap = new BinaryMinHeap(5);
		
		binaryMinHeap.insert(3);
		binaryMinHeap.insert(2);
		binaryMinHeap.insert(4);
		binaryMinHeap.insert(1);
		binaryMinHeap.insert(0);
		
		binaryMinHeap.removeMin();
		
	}

}
