package tr.com.sedatpolat.datastructures.test.arraysandstrings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tr.com.sedatpolat.datastructures.arraysandstrings.ArraysAndStrings;

/**
 * 
 * @author sedpol
 *
 */
public class ArraysAndStringsTest {

	@Test
	public void hasUniqueChar() {		
		assertEquals(true, ArraysAndStrings.hasUniqueChar("asdcA123"));
		assertEquals(false, ArraysAndStrings.hasUniqueChar("ASDASD"));
		assertEquals(false, ArraysAndStrings.hasUniqueChar("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
		assertEquals(false, ArraysAndStrings.hasUniqueChar("AAAABBBBSSSSDDDDFFFFGGGG"));
		assertEquals(false, ArraysAndStrings.hasUniqueChar("  "));
		assertEquals(true, ArraysAndStrings.hasUniqueChar(null));
		assertEquals(true, ArraysAndStrings.hasUniqueChar(""));
		assertEquals(true, ArraysAndStrings.hasUniqueChar("asdfghjklpouytrewq"));
	}
	
	@Test
	public void reverse() {
		assertEquals("", ArraysAndStrings.reverse(""));
		assertEquals(null, ArraysAndStrings.reverse(null));
		assertEquals("tades", ArraysAndStrings.reverse("sedat"));
		assertEquals("kibut", ArraysAndStrings.reverse("tubik"));
		assertEquals("kibuttades", ArraysAndStrings.reverse("sedattubik"));
	}
}
