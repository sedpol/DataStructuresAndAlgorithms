package tr.com.sedatpolat.datastructures.graphandtree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeOperationsException;

/**
 * 
 * @author sedpol
 * @param <E>
 *
 * @param <T>
 */
public class GraphWithArray<E extends Comparable<E>> {

	public enum TYPE {
		WEIGHT_ORDERED,
		COMPARABLE_ORDERED,
		NONE
	}
	
	public class Edge implements Comparable<Edge> {
		private int weight;
		private E vertext;
		public Edge(int weight, E vertext) {
			this.weight = weight;
			this.vertext = vertext;
		}
		
		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public E getVertext() {
			return vertext;
		}

		public void setVertext(E vertext) {
			this.vertext = vertext;
		}

		@Override
		public String toString() {
			return "(" + "Weight: " + weight + ", " + vertext.toString() + ")";
		}

		public int compareTo(Edge e) {
			return this.vertext.compareTo(e.vertext);
		}
	}
	
	private List<GraphWithArray<E>.Edge> adjacencyArr[];
	private TYPE type;
	
	private Map<Integer, Integer> idMap = new HashMap<Integer, Integer>(); //TODO should be used <String, Integer>

	private int index = 0;

	@SuppressWarnings("unchecked")
	public GraphWithArray(int size, TYPE type) {
		adjacencyArr = new LinkedList [size];
		this.type = type;
	}
	
	public void add(int id, int weight, E vertext) {

		Integer currentIndex = getIndexById(id);
		if (currentIndex == null) {
			if (adjacencyArr[index] == null) 
				adjacencyArr[index] = new LinkedList<GraphWithArray<E>.Edge>();
			
			add(index, new Edge(weight, vertext)); 
			idMap.put(index++, id);
		} else {
			add(currentIndex, new Edge(weight, vertext));
		}
	}
	
	private void add(int graphIndex, Edge edge) {
		if (this.type == TYPE.WEIGHT_ORDERED) {
			int edgeIndex = 0;
			for (GraphWithArray<E>.Edge tempEdge : adjacencyArr[graphIndex]) {
				if (edge.weight > tempEdge.weight) 
					break;
				edgeIndex++;
			}
			adjacencyArr[graphIndex].add(edgeIndex, edge);
		} else if ((this.type == TYPE.COMPARABLE_ORDERED)){
			adjacencyArr[graphIndex].add(0, edge);// adding as first object is O(1) in LinkedList (for UNORDERED)
		} else {
			adjacencyArr[graphIndex].add(edge);
		}
	}
	
	public List<GraphWithArray<E>.Edge> getAdjacencyList(int id) {
		Integer currentIndex = getIndexById(id);
		if (currentIndex == null)	
			return  new ArrayList<GraphWithArray<E>.Edge>();
//			throw new RuntimeOperationsException(new RuntimeException(), "There is no Node reletaed with ID: " + id + "!");
		
		List<GraphWithArray<E>.Edge>  suggestedList = new ArrayList<GraphWithArray<E>.Edge>(); // protect for modification
		suggestedList.addAll(adjacencyArr[currentIndex]);
		return suggestedList;
	}
	
	public List<GraphWithArray<E>.Edge> suggestion(int id) {
		List<GraphWithArray<E>.Edge>  suggestedList = null;
		
		Integer currentIndex = getIndexById(id);
		if (currentIndex == null)	
			throw new RuntimeOperationsException(new RuntimeException(), "There is no Node reletaed with ID: " + id + "!");

		suggestedList = new ArrayList<GraphWithArray<E>.Edge>();// protect for modification
		
		if (this.type == TYPE.WEIGHT_ORDERED) {
			suggestedList.addAll(adjacencyArr[currentIndex]);
		} else if (this.type == TYPE.COMPARABLE_ORDERED) {
			suggestedList.addAll(adjacencyArr[currentIndex]);
			Collections.sort(suggestedList, Collections.reverseOrder());
		}
		
		return suggestedList;
	}
	
	private Integer getIndexById(Integer id) {
		Collection<Integer> graphIndexList = idMap.keySet();
		for (Integer indexTemp : graphIndexList) {
			Integer idTemp = idMap.get(indexTemp);
			if (id.equals(idTemp))
				return indexTemp;
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		
		List<Edge> list = null;
		for (int i = 0; i < adjacencyArr.length; i++) {
			
			list = adjacencyArr[i];
			
			if (list != null) {
				stringBuffer.append("ID: " + idMap.get(i) + "-->");
				
				for (Edge edge : list) {
					stringBuffer.append(edge.toString());
				}
				stringBuffer.append("\n");
			}
		}
		return stringBuffer.toString();
	}
}
