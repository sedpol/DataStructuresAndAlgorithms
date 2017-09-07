package tr.com.sedatpolat.datastructures.queue;

public class QueueWithArray {
	private final int CAPACITY;
	private int size = 0;
	private int front = 0;
	private int rear = -1;
	private int[] arr;
	
	public QueueWithArray(int capacity) {
		this.CAPACITY = capacity;
		arr = new int [CAPACITY];
	}
	
	public int dequeue () {
		if (isEmpty())
			throw new RuntimeException("Queue is empty!");
		
		int temp = arr [front];
		front++;
		size--;
		return temp;
	}
	
	public void enqueue(int value) {
		if (isFull())
			throw new RuntimeException("Queue is full!");
		
		this.rear = (rear + 1) % CAPACITY;
		size++;
		arr [rear] = value;
	}
	
	public int rear () {
		return arr [rear];
	}
	
	public int front () {
		return arr [front];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == CAPACITY;
	}
}
