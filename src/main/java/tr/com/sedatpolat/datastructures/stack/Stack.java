package tr.com.sedatpolat.datastructures.stack;

import java.util.EmptyStackException;

import tr.com.sedatpolat.datastructures.Node;

/**
 * a last-in-first-out
 * (LIFO)
 * @author sedpol
 *
 */
public class Stack<E extends Comparable<E>> {

	private Node<E> top;
	
	public E pop() {

		if (top == null)
			throw new EmptyStackException();
		
		Node<E> temp = top;
		
		top = top.next;
		
		return temp.value;
	}
	
	public void push (E data) {
		
		if (top == null) {
			top = new Node<E>(data);
			return;
		}
			
		Node<E> temp = top;
		top = new Node<E>(data);
		top.next = temp;
	}
	
	public E peek() {
		if (top == null)
			throw new EmptyStackException();
		
		return top.value;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}
