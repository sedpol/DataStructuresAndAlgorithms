package tr.com.sedatpolat.datastructures.test.graphandtree;

import org.junit.Test;

import tr.com.sedatpolat.datastructures.graphandtree.Graph;

/**
 * 
 * @author sedpol
 *
 */
public class GraphTest {

	@Test
	public void testGraph() {
		
		Graph<Movie> graph = new Graph<Movie>(Graph.TYPE.WEIGHT_ORDERED);
		
		//MOVIE A->B->D
		graph.add(1000, 7000, new Movie(2000, "B", 7.6));
		graph.add(1000, 7500, new Movie(2500, "D", 8.9));
		
		//MOVIE B->C
		graph.add(2000, 5500, new Movie(5000, "C", 7.7));
		
		//MOVIE C->A->E
		graph.add(5000, 1300, new Movie(7000, "E", 7.8));
		graph.add(5000, 1500, new Movie(1000, "A", 8.1));

		//MOVIE D->A->E->F
		graph.add(2500, 4100, new Movie(1000, "A", 8.1));
		graph.add(2500, 3700, new Movie(7000, "E", 7.8));
		graph.add(2500, 3700, new Movie(8000, "F", 8.0));

		//MOVIE E->D
		graph.add(7000, 2500, new Movie(2500, "D", 8.9));

		//MOVIE F->D
		graph.add(8000, 3000, new Movie(2500, "D", 8.9));
		
		System.out.println(graph.toString());
		
		System.out.println("Suggestion for 1000: " + graph.suggestion(1000));
		System.out.println("Suggestion for 2500: " + graph.suggestion(2500));
		
	}
	
}
