package tr.com.sedatpolat.algorithms.sorting;

import java.util.List;

import tr.com.sedatpolat.datastructures.graphandtree.Graph;

/**
 * 
 * @author sedpol
 *
 */
public class RadixSort {

	private static final int SIZE = 10;
	private int max = Integer.MIN_VALUE;
	private Integer [] arr;
	
	private Graph<Integer> graph = null;
	
	public RadixSort() {
		initGraph();
	}
	
	public void sort(Integer[] arr) {
		if (arr == null || arr.length < 2)
			return;

		this.arr = arr;
		
		calculateMax();
		
		sortWithDigit(1);
	}
	
	private void sortWithDigit(long digit) { // digit have to be long to be able to sort Integer.MAX_VALUE.
		for (int i = 0; i < arr.length; i++) {
			int value = (int) ((arr[i] % (digit*10)) / digit);
			graph.add(value, 0, arr[i]);
		}
		mapToArr();

		if (digit < max) {
			digit *= 10;
			sortWithDigit(digit);
		}
	}
	
	private void mapToArr() {
		List<Graph<Integer>.Edge> list;
		int index = 0;
		for (int i = 0; i < SIZE; i++) {
			list = graph.getAdjacencyList(i);
			if (list != null)
				for (Graph<Integer>.Edge edge : list)
					arr [index++] = edge.vertext;
		}
		initGraph();
	}
	
	private void calculateMax() {
		for (Integer integer : arr) {
			if (max < integer.intValue())
				max = integer;
		}
	}
	
	private void initGraph() {
		graph = new Graph<Integer>(Graph.TYPE.NONE); 
	}
}
