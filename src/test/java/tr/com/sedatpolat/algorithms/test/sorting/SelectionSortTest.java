package tr.com.sedatpolat.algorithms.test.sorting;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import tr.com.sedatpolat.algorithms.sorting.SelectionSort;

import static org.junit.Assert.*;

/**
 * 
 * @author sedpol
 *
 * @param <E>
 */
public class SelectionSortTest {
	SelectionSort<Integer> selectionSort = null;
	Integer [] array = null;
	
	
	@Before
	public void init () {
		
		final int size = 50000;
		array = new Integer [size];
		
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(5000);
		}
		selectionSort = new SelectionSort<Integer>();
	}

	@Test
	public void testSorting() {
		Integer[] result = Arrays.copyOf(array, array.length);
		
		System.out.println("Item size: " + array.length);

		long time = System.currentTimeMillis();
		
		selectionSort.sort(result);
		
		System.out.println("selectionSort in ms: " + (System.currentTimeMillis() - time));

		time = System.currentTimeMillis();
		
		Arrays.sort(array);
		
		System.out.println("Arrays.sort in ms " + (System.currentTimeMillis() - time));
		
		assertArrayEquals(array, result);
	}
}
