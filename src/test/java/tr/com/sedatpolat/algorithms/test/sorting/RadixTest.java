package tr.com.sedatpolat.algorithms.test.sorting;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import tr.com.sedatpolat.algorithms.sorting.RadixSort;

/**
 * 
 * @author sedpol
 *
 * @param <E>
 */
public class RadixTest {
	RadixSort radixSort = null;
	Integer [] array = null;
	
	
	@Before
	public void init () {
		
		final int size = 500000;
		array = new Integer [size];
		
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(500000);
		}
		radixSort = new RadixSort();
	}

	@Test
	public void testSorting() {

		Integer[] result = Arrays.copyOf(array, array.length);
		
		System.out.println("Item size: " + array.length);

		long time = System.currentTimeMillis();

		radixSort.sort(result);
		
		System.out.println("radixSort in ms " + (System.currentTimeMillis() - time));
		
		time = System.currentTimeMillis();
		
		Arrays.sort(array);
		
		System.out.println("Arrays.sort in ms " + (System.currentTimeMillis() - time));
		
		assertArrayEquals(array, result);
	}
}
