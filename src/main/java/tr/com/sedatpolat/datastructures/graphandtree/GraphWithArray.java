package tr.com.sedatpolat.datastructures.graphandtree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeOperationsException;

import tr.com.sedatpolat.datastructures.queue.Queue;
import tr.com.sedatpolat.datastructures.stack.Stack;

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

		public E getVertext() {
			return vertext;
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
	private boolean visitedArr [];
	
	private TYPE type;
	
	private Map<Integer, E> idMap = new HashMap<Integer, E>(); //TODO should be used <String, Integer>

	private int index = 0;

	@SuppressWarnings("unchecked")
	public GraphWithArray(int size, TYPE type) {
		adjacencyArr = new LinkedList [size];
		visitedArr = new boolean [size];
		this.type = type;
	}
	
	public void add(E current, int weight, E vertext) {

		Integer currentIndex = getIndex(current);
		if (currentIndex == null) {
			if (adjacencyArr[index] == null) 
				adjacencyArr[index] = new LinkedList<GraphWithArray<E>.Edge>();
			
			add(index, new Edge(weight, vertext)); 
			idMap.put(index++, current);
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
	
	public List<GraphWithArray<E>.Edge> getAdjacencyList(E e) {
		Integer currentIndex = getIndex(e);
		if (currentIndex == null)	
			return  new ArrayList<GraphWithArray<E>.Edge>();
//			throw new RuntimeOperationsException(new RuntimeException(), "There is no Node reletaed with ID: " + id + "!");
		
		List<GraphWithArray<E>.Edge>  suggestedList = new ArrayList<GraphWithArray<E>.Edge>(); // protect for modification
		suggestedList.addAll(adjacencyArr[currentIndex]);
		return suggestedList;
	}
	
	public List<GraphWithArray<E>.Edge> suggestion(E e) {
		List<GraphWithArray<E>.Edge>  suggestedList = null;
		
		Integer currentIndex = getIndex(e);
		if (currentIndex == null)	
			throw new RuntimeOperationsException(new RuntimeException(), "There is no Node reletaed with ID: " + e.toString() + "!");

		suggestedList = new ArrayList<GraphWithArray<E>.Edge>();// protect for modification
		
		if (this.type == TYPE.WEIGHT_ORDERED) {
			suggestedList.addAll(adjacencyArr[currentIndex]);
		} else if (this.type == TYPE.COMPARABLE_ORDERED) {
			suggestedList.addAll(adjacencyArr[currentIndex]);
			Collections.sort(suggestedList, Collections.reverseOrder());
		}
		
		return suggestedList;
	}
	
	private Integer getIndex(E e) {
		Collection<Integer> graphIndexList = idMap.keySet();
		
		if(graphIndexList == null)
			return null;
		
		for (Integer indexTemp : graphIndexList) {
			E temp = idMap.get(indexTemp);
			if (e.equals(temp))
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

	private Queue<Integer> queue = null;
	public String depthFirstSearch(E e) {
		queue = new Queue<Integer>();

		Integer index = getIndex(e);
		
		if (index == null)
			return "";
		
		StringBuffer stringBuffer = new StringBuffer();
		
		for (int i = 0; i < visitedArr.length; i++) 
			visitedArr[i] = false;
		
		
		visitedArr [index] = true;
		
		addFirstIntoBuffer(index, stringBuffer);
		
		dfs(index, stringBuffer);
		
		return stringBuffer.toString();
	}
	
	private void dfs(Integer index, StringBuffer stringBuffer) {
		if (!isVisited(index)) {
			addBuffer(visit(index), stringBuffer);
			queue.enqueue(index);
		}
		
		List<GraphWithArray<E>.Edge> list = adjacencyArr[index];
		if (list != null) {
			for (Edge edge : list) {
				int neighbourIndex = getIndex(edge.vertext);
				if (!isVisited(neighbourIndex)) {
					addBuffer(visit(neighbourIndex), stringBuffer);
					queue.enqueue(neighbourIndex);
				}
			}
		}
		if (!queue.isEmpty()) {
			dfs(queue.dequeue().value, stringBuffer);
		}
	}

	Stack<Integer> stack = null;
	public String beadthFirstSearch(E e) {
		stack = new Stack<Integer>();
		
		Integer index = getIndex(e);
		if (index == null)
			return "";
		
		for (int i = 0; i < visitedArr.length; i++) 
			visitedArr[i] = false;

		StringBuffer stringBuffer = new StringBuffer();

		bfs(index, stringBuffer);
		
		String resultStr = stringBuffer.toString();
		
		if (resultStr.length() < 2)
			return resultStr;
		
		return resultStr.substring(2); // remove leading ("->") trick
	}
	
	private void bfs(Integer index, StringBuffer stringBuffer) {
		
		if (!isVisited(index)) {
			Integer nextIndex = visit(index);
			
			stack.push(nextIndex);
			addBuffer(nextIndex, stringBuffer);
			
			List<GraphWithArray<E>.Edge> list = adjacencyArr [nextIndex];
			if (list != null) {
				for (GraphWithArray<E>.Edge edge : list) {
					
					Integer tempIndex = getIndex(edge.vertext);
					if (!isVisited(tempIndex))
						bfs(tempIndex, stringBuffer);
				}
			}
		} else {
			if (!stack.isEmpty())
				bfs(stack.pop(), stringBuffer);
		}
	}
	
	private boolean isVisited(int index) {
		return visitedArr[index];
	}
	
	private Integer visit (int index) {
		if (isVisited(index))
			throw new RuntimeException(idMap.get(index) + " is already visited!");
		
		visitedArr[index] = true;
		return index;
	}

	private void addBuffer(int index, StringBuffer stringBuffer) {
		stringBuffer.append("->" + idMap.get(index));
	}
	
	private void addFirstIntoBuffer(int index, StringBuffer stringBuffer) {
		stringBuffer.append(idMap.get(index));
	}
}
