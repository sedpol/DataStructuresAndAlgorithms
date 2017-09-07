package tr.com.sedatpolat.algorithms.sorting;

/**
 * 
 * @author sedpol
 *
 * @param <E>
 */
public class QuickSort<E extends Comparable<E>> {

	private E [] array = null;
	
	public QuickSort() {
	}
	
	public void sort(E [] array) {
		this.array = array;
		sortRecursively(0, array.length - 1);
	}
	
	private void sortRecursively (int low, int high) {
		if (low < high) {
		
			int partitionIndex = partition(low, high);
			
			sortRecursively(low, partitionIndex -1);
			sortRecursively(partitionIndex + 1, high);
		}
	}

	private int partition(int low, int high) {
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (array[j].compareTo(array[high]) == -1) {
				swap(++i, j);
			}
		}
		swap(high, ++i);
		return i;
	}
	
	private void swap(int i, int j) {
		E temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
