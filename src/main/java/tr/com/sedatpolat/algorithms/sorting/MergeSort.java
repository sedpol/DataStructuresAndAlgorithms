package tr.com.sedatpolat.algorithms.sorting;

import java.lang.reflect.Array;

/**
 * 
 * @author sedpol
 *
 * @param <E>
 */
public class MergeSort <E extends Comparable<E>> {

	public MergeSort() {
	}
	
	@SuppressWarnings("unchecked")
	public void sort(E[] array) {
		partition(array, (Class<E>)array.getClass().getComponentType());
	}
	
	@SuppressWarnings("unchecked")
	private void partition(E[] arr, Class<E> clazz) {

		int length = arr.length;
		if (length < 2)
			return;
		int rightSize = length/2;
		int leftSize = length - rightSize;
		E[] left = (E[]) Array.newInstance(clazz, leftSize);
		E[] right = (E[]) Array.newInstance(clazz, rightSize);;

		System.arraycopy(arr, 0, left , 0, leftSize);
		System.arraycopy(arr, leftSize, right , 0, rightSize);
		partition(left, clazz);
		partition(right, clazz);
		merge(arr, left, right);
	}

	private void merge(E [] array, E [] left, E [] right) {

		int l, r;
		l = r = 0;
		for (int i = 0; i < array.length; i++) {
			
			if (l == left.length)
				array [i] = right[r++];
			else if (r == right.length)
				array [i] = left[l++]; 
			else
				array[i] = (left [l].compareTo(right [r]) < 1) 	? left [l++] 
																: right [r++];
		}
	}
}
