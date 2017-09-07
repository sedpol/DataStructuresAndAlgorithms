package tr.com.sedatpolat.datastructures.queue;

import java.util.EmptyStackException;

import tr.com.sedatpolat.datastructures.Node;

/**
 * FIFO (first-in-first-out)
 * @author sedpol
 *
 */
public class Queue<E extends Comparable<E>> {
	
	private Node<E> front;
	private Node<E> rear;
	
	/**
	 * removes the first item of the queue.
	 * @return
	 */
	public Node<E> dequeue() {

		if (front == null)
			throw new EmptyStackException();
		
		Node<E> temp = front;
		front = temp.next;
		
		return temp;
	}
	
	/**
	 * adds new value to the end of queue
	 * @param value
	 */
	public void enqueue(E value) {
		
		if (front == null) {
			front = rear =  new Node<E>(value);
			return;
		}
		
		rear.next = new Node<E>(value);
		
		rear = rear.next;
	}
	
	public E front() {
		if (front == null)
			throw new EmptyStackException();
		
		return front.value;
	}
	
	public E rear() {
		if (rear == null)
			throw new EmptyStackException();
		
		return rear.value;
	}
}
