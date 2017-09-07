package tr.com.sedatpolat.algorithms.sorting;

/**
 * 
 * @author sedpol
 *
 * @param <E>
 */
public class SelectionSort<E extends Comparable<E>>{

	private E[] array;

	public SelectionSort() {
	}
 
	public void sort (E [] array) {
		this.array = array;
		sortIteratively();
	}
	
	private void sortIteratively () {
		int minItemIndex;
		E e = null;
		for (int i = 0; i < array.length; i++) {
			e = array [i];
			minItemIndex = -1;
			for (int j = i; j < array.length; j++) {
				if (e.compareTo(array [j]) == 1) {
					e = array [j];
					minItemIndex = j;
				}
			}
			if (minItemIndex != -1)
				swap(minItemIndex, e, i);
		}
	}

	private void swap(int minItemIndex, E item, int i) {
		E temp = array [i];
		array [i] = item;
		array [minItemIndex] = temp;
	}
}
