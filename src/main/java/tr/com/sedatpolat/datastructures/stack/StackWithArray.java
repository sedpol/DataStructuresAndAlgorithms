package tr.com.sedatpolat.datastructures.stack;

import java.util.Arrays;
import java.util.EmptyStackException;
/**
 * 
 * @author sedpol
 *
 * @param <E>
 */
public class StackWithArray<E extends Comparable<E>> {
	private final int SIZE;
	private int top = -1;
	private E [] arr;
	
	public StackWithArray(E [] arr) {
		this.SIZE = arr.length;
		this.arr = Arrays.copyOf(arr, this.SIZE);
	}
	
	public E pop() {
		if (top == -1)
			throw new EmptyStackException(); 
		return arr [top--];
	}
	
	public void push (E value) {
		if (top == SIZE -1)
			throw new StackOverflowError();
		arr [++top] = value;
	}
	
	public E peek () {
		if (top == -1)
			throw new EmptyStackException(); 
		return arr[top];
	}
}
