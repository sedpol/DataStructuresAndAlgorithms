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
		public int weight;
		public E vertext;
		
		public Edge(int weight, E vertext) {
			this.weight = weight;
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
	
	private Map<Integer, List<Graph<E>.Edge>> adjacencyMap = new HashMap<Integer, List<Graph<E>.Edge>>(); //TODO better to be used <String, List<Graph<E>.Edge>>

	public Graph(TYPE type) {
		this.type = type;
	}
	
	public void add(int id, int weight, E vertext) {
		List<Graph<E>.Edge> edgeList = adjacencyMap.get(id);
		
		if (edgeList == null) {
			edgeList = new LinkedList<Graph<E>.Edge>();
			adjacencyMap.put(id, edgeList);
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
	
	public List<Graph<E>.Edge> getAdjacencyList(int id) {
		return adjacencyMap.get(id);
	}
	
	public List<Graph<E>.Edge> suggestion(int id) {
		List<Graph<E>.Edge>  suggestedList = getAdjacencyList(id);
		
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
		
		Set<Integer> adjacencyList = adjacencyMap.keySet();
		Iterator<Integer> iterator = adjacencyList.iterator();
		
		List<Edge> list = null;
		int id = 0;
		
		while (iterator.hasNext()) {
			id = iterator.next();
			list = adjacencyMap.get(id);
			
			if (list != null) {
				stringBuffer.append("ID: " + id + "-->");
				
				for (Edge edge : list) {
					stringBuffer.append(edge.toString());
				}
				stringBuffer.append("\n");
			}
		}
		return stringBuffer.toString();
	}
}