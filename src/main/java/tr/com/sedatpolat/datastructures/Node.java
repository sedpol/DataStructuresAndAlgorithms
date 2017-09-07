package tr.com.sedatpolat.datastructures;

/**
 * 
 * @author sedpol
 *
 * @param <E>
 */
public class Node <E extends Comparable<E>> {
	public E value;
	public Node<E> next;

	public Node(E data) {
		this.value = data;
	}

	public void addIntoTail(E data) {
		Node<E>  end = new Node<E> (data); 
		Node<E>  current = this;
		while (current.next != null)
			current = current.next;
		
		current.next = end;
	}
	
	public Node<E> delete(Node<E>  head, int data) {
		Node<E> current = head;
		
		if (current.value.equals(data))
			return current.next;
		
		while (current.next != null) {
			if (current.next.value.equals(data)) {
				current.next = current.next.next;
				return head;
			}
			current = current.next;
		}
		return head;
	}
}
