package tr.com.sedatpolat.datastructures.graphandtree;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.management.RuntimeOperationsException;

/**
 * 
 * @author sedpol
 * @param <E>
 *
 */
public class Graph<E extends Comparable<E>> {

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
	
	private TYPE type;
	
	private Map<E, List<Graph<E>.Edge>> adjacencyMap = new HashMap<E, List<Graph<E>.Edge>>(); //TODO better to be used <String, List<Graph<E>.Edge>>

	public Graph(TYPE type) {
		this.type = type;
	}
	
	public void add(E e, int weight, E vertext) {
		List<Graph<E>.Edge> edgeList = adjacencyMap.get(e);
		
		if (edgeList == null) {
			edgeList = new LinkedList<Graph<E>.Edge>();
			adjacencyMap.put(e, edgeList);
			add(edgeList, new Edge(weight, vertext)); 
		} else {
			add(edgeList, new Edge(weight, vertext));
		}
	}

	private void add(List<Graph<E>.Edge> edgeList, Edge edge) {
		if (this.type == TYPE.WEIGHT_ORDERED) {
			int edgeIndex = 0;
			for (Graph<E>.Edge tempEdge : edgeList) {
				if (edge.weight > tempEdge.weight) 
					break;
				edgeIndex++;
			}
			edgeList.add(edgeIndex, edge);
		} else if (type == TYPE.COMPARABLE_ORDERED) {
			edgeList.add(0, edge);// adding as first object is O(1) in LinkedList (for UNORDERED)
		} else {
			edgeList.add(edge);
		}
	}
	
	public List<Graph<E>.Edge> getAdjacencyList(E e) {
		return adjacencyMap.get(e);
	}
	
	public List<Graph<E>.Edge> suggestion(E e) {
		List<Graph<E>.Edge>  suggestedList = getAdjacencyList(e);
		
		if (suggestedList == null)	
			throw new RuntimeOperationsException(new RuntimeException(), "ID could not found!");
		
		if (this.type == TYPE.WEIGHT_ORDERED) {
			suggestedList.addAll(suggestedList);
		} else if (this.type == TYPE.COMPARABLE_ORDERED) {
			suggestedList.addAll(suggestedList);
			Collections.sort(suggestedList, Collections.reverseOrder());
		} else {
			suggestedList.addAll(suggestedList);
		}
		
		return suggestedList;
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		
		Set<E> adjacencyList = adjacencyMap.keySet();
		Iterator<E> iterator = adjacencyList.iterator();
		
		List<Edge> list = null;
		E e = null;
		
		while (iterator.hasNext()) {
			e = iterator.next();
			list = adjacencyMap.get(e);
			
			if (list != null) {
				stringBuffer.append("E: " + e + "-->");
				
				for (Edge edge : list) {
					stringBuffer.append(edge.toString());
				}
				stringBuffer.append("\n");
			}
		}
		return stringBuffer.toString();
	}
}