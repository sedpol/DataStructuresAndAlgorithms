package tr.com.sedatpolat.algorithms.test.search;

import org.junit.Before;
import org.junit.Test;

import tr.com.sedatpolat.algorithms.search.BinarySearch;

import static org.junit.Assert.*;

import java.util.Random;
/**
 * 
 * @author sedpol
 *
 */
public class BinarySearchTest {

	BinarySearch<Integer> binarySearch = null;
	Integer [] array = null;
	
	final int SEARCH_ITEM = 5555;
	
	@Before
	public void init () {
		
		final int size = 1000000;
		array = new Integer [size];
		
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(2500000);
		}
		
		array [rand.nextInt(array.length)] = SEARCH_ITEM; // put it in random index
		
		binarySearch = new BinarySearch<>(array);
	}
	
	@Test
	public void speedTest() {
		long time = System.nanoTime();
		binarySearch.searchIteratively(SEARCH_ITEM);
		System.out.println(array.length + " sized array, searched as iteratively time in nanoTime: " + (System.nanoTime() - time));
		
		time = System.nanoTime();
		binarySearch.searchRecursively(SEARCH_ITEM);
		System.out.println(array.length + " sized array, searched as recursively time in nanoTime: " + (System.nanoTime() - time));
	}
	
	@Test
	public void testSearchIteratively () {
		assertEquals(true, binarySearch.searchIteratively(SEARCH_ITEM));
		assertEquals(false, binarySearch.searchIteratively(Integer.MAX_VALUE));
	}
	
	@Test
	public void testSearchRecursively () {
		assertEquals(true, binarySearch.searchRecursively(SEARCH_ITEM));
		assertEquals(false, binarySearch.searchRecursively(Integer.MAX_VALUE));		
	}

	@Test
	public void testHackingBinarySearchArray() {
		array [array.length - 1] = Integer.MAX_VALUE;
		assertEquals(false, binarySearch.searchIteratively(Integer.MAX_VALUE));
		assertEquals(false, binarySearch.searchRecursively(Integer.MAX_VALUE));
	}
}
