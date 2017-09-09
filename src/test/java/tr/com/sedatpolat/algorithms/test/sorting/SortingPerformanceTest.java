package tr.com.sedatpolat.algorithms.test.sorting;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import tr.com.sedatpolat.algorithms.sorting.MergeSort;
import tr.com.sedatpolat.algorithms.sorting.QuickSort;
import tr.com.sedatpolat.algorithms.sorting.RadixSort;

public class SortingPerformanceTest {
	private static Integer[] array = null;
	private static Integer[] sortedArr;
	@BeforeClass
	public static void init() {

		int SIZE = 500000;
		final int size = SIZE;
		array = new Integer[size];

		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(Integer.MAX_VALUE);
		}
		System.out.println("Array length: " + array.length);
		
		sortedArr = Arrays.copyOf(array, array.length);
		long time = System.currentTimeMillis();
		Arrays.sort(sortedArr);
		System.out.println("Arrays.sort in ms: " + (System.currentTimeMillis() - time));
	}

	@Test
	public void testQuickSort() {
		Integer[] tempArr = Arrays.copyOf(array, array.length);

		long time = System.currentTimeMillis();
		QuickSort<Integer> quickSort = new QuickSort<Integer>();
		quickSort.sort(tempArr);
		System.out.println("QuickSort in ms: " + (System.currentTimeMillis() - time));

		assertArrayEquals(sortedArr, tempArr);
	}

	@Test
	public void testMergeSort() {
		Integer[] tempArr = Arrays.copyOf(array, array.length);
		
		long time = System.currentTimeMillis();
		MergeSort<Integer> mergeSort = new MergeSort<Integer>();
		mergeSort.sort(tempArr);
		System.out.println("MergeSort in ms: " + (System.currentTimeMillis() - time));
		
		assertArrayEquals(sortedArr, tempArr);
	}
	
	@Test
	public void testRadixSort() {
		Integer[] tempArr = Arrays.copyOf(array, array.length);
		
		long time = System.currentTimeMillis();
		RadixSort radixSort = new RadixSort();
		radixSort.sort(tempArr);
		System.out.println("RadixSort in ms: " + (System.currentTimeMillis() - time));
		
		assertArrayEquals(sortedArr, tempArr);
	}

	/* can not run in over 50K array
	@Test
	public void testSelectionSort() {
		Integer[] tempArr = Arrays.copyOf(array, array.length);

		long time = System.currentTimeMillis();
		SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();
		selectionSort.sort(tempArr);
		System.out.println("SelectionSort in ms: " + (System.currentTimeMillis() - time));

		assertArrayEquals(sortedArr, tempArr);
	}
	*/
}
