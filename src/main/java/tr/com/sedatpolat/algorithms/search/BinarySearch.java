package tr.com.sedatpolat.algorithms.search;

import java.util.Arrays;

import tr.com.sedatpolat.algorithms.sorting.QuickSort;

/**
 * left + right may be greater than Integer.MAX_VALUE. This is why operation at the below must be used <br/>
 * so; left - left/2 + right/2 = (left + right)/2
 * 
 * @author sedpol
 *
 * @param <E>
 */
public class BinarySearch<E extends Comparable<E>>{

	private E [] array = null;
	
	public BinarySearch(E [] array) {
		this.array = Arrays.copyOf(array, array.length); // array must not modified after initializing.
		new QuickSort<E>().sort(this.array); // must be sorted.
	}
	
	public boolean searchIteratively(E item) {

		int left = 0, right;
		right = array.length - 1;
		
		while (left <= right) {
			
			int middle = left + ((right - left) / 2); // left - left/2 + right/2 = (left + right)/2
			
			if (array [middle].compareTo(item) == 0) // item equals
				return true;
			else if (array [middle].compareTo(item) == 1) { // item is lesser
				right = middle -1;
			} else { // item is greater
				left = middle + 1;
			}
		}
		
		return false;
	}
	
	public boolean searchRecursively(E item) {
		
		return searchRecursively(item, 0, array.length -1);
	}
	
	private boolean searchRecursively (E item, int left, int right ) {
		
		if (left > right)
			return false;
		
		int middle = left + ((right - left) / 2); // left - left/2 + right/2 = (left + right)/2
		
		if (array[middle].compareTo(item) == 0)
			return true;
		else if (array[middle].compareTo(item) == 1) //item is lesser
			return searchRecursively(item, left, middle - 1);
		else //item is greater
			return searchRecursively(item, middle + 1, right);
	}
	
}
