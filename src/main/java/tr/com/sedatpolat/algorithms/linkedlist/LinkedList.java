package tr.com.sedatpolat.algorithms.linkedlist;

import java.security.InvalidParameterException;
import java.util.Hashtable;
import java.util.Map;

import tr.com.sedatpolat.datastructures.Node;

/**
 * 
 * @author sedpol
 *
 */
public class LinkedList {

	private LinkedList() {
	}
	
	private static Node<Character> charArrayToLinkedList (char [] chars) {
		if (chars == null || chars.length == 0)
			return null;
		Node<Character> head = new Node<Character> (chars [0]);
		for (int i = 1; i < chars.length; i++) {
			head.addIntoTail(chars[i]);
		}
		
		return head;
	}
	
	private static String linkedListToString (Node<Character> head) {
		StringBuilder stringBuilder = new StringBuilder();
		Node<Character> temp = head;
		while (temp != null) {
			stringBuilder.append(Character.toString((char)temp.value));
			temp = temp.next;
		}
		
		return stringBuilder.toString();
	}
	
	public static String findTheNthValueToEnd (String str, int n) {
		Node<Character> head = charArrayToLinkedList(str.toCharArray());

		Node<Character> nth = head;
		for (int i = 0; i < n; i++) {
			if (nth == null)
				throw new InvalidParameterException("Size is smaller than " + n);
			nth = nth.next;
		}
		
		Node<Character> result = head;
		
		while (nth != null) {
			result = result.next;
			nth = nth.next;
		}
		
		
		return Character.toString((char)result.value);
	}
	
	public static String removeDublicateWithMap (String str) {
		
		if (str == null || str.length() < 2)
			return str;
		
		Node<Character> head = charArrayToLinkedList(str.toCharArray());
		Map<Character, Boolean> hashTable = new Hashtable<Character, Boolean>();
		
		Node<Character> n = head;
		Node<Character> pre = null;
		while (n != null) {
			
			if (Boolean.TRUE == hashTable.get(n.value))
				pre.next = n.next;
			else {
				hashTable.put(n.value, true);
				pre = n;
			}
			n = n.next;
		}
		return linkedListToString(head);
	}
	
	public static String removeDublicate(String str) {
		
		if (str == null || str.length() < 2)
			return str;
		
		Node<Character> head = charArrayToLinkedList(str.toCharArray());
		Node<Character> previous = head;
		Node<Character> current = previous.next;
		
		Node<Character> runner = null;
		while (current != null) {
			runner = head;
			while (runner != current) {
				
				if (current.value == runner.value) {
					previous.next = current.next;
					current = previous.next;
					break;
				}
				
				runner = runner.next;
			}
			if (runner == current) {
				previous = current;
				current = current.next;
			}
		}
		
		return linkedListToString(head);
	}
}
