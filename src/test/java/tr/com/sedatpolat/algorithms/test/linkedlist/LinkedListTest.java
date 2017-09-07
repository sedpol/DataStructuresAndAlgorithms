package tr.com.sedatpolat.algorithms.test.linkedlist;

import org.junit.Test;

import tr.com.sedatpolat.algorithms.linkedlist.LinkedList;

import static org.junit.Assert.*;

/**
 * 
 * @author sedpol
 *
 */
public class LinkedListTest {

	
	@Test
	public void removeDublicateWithMapTest () {
		assertEquals("sedat", 	LinkedList.removeDublicateWithMap("sseeddaatttt"));
		assertEquals("", 		LinkedList.removeDublicateWithMap(""));
		assertEquals(null, 		LinkedList.removeDublicateWithMap(null));
		assertEquals("s", 		LinkedList.removeDublicateWithMap("sssssssssssss"));
		assertEquals("sSAa", 	LinkedList.removeDublicateWithMap("ssssssSSAAAssaassaasss"));
	}
	
	@Test
	public void removeDublicateTest() {
		assertEquals("sedat", 	LinkedList.removeDublicate("sseeddaatttt"));
		assertEquals("", 		LinkedList.removeDublicate(""));
		assertEquals(null, 		LinkedList.removeDublicate(null));
		assertEquals("s", 		LinkedList.removeDublicate("sssssssssssss"));
		assertEquals("sSAa", 	LinkedList.removeDublicate("ssssssSSAAAssaassaasss"));
	}
	
	@Test
	public void findTheNthValueToEndTest() {
		assertEquals("d", 	LinkedList.findTheNthValueToEnd("sedat", 3));
		assertEquals("i", 	LinkedList.findTheNthValueToEnd("tubik", 2));
		assertEquals("e", 	LinkedList.findTheNthValueToEnd("Sedat Polat", 10));
	}
}
