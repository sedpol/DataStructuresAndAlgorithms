package tr.com.sedatpolat.datastructures.test.graphandtree;

import org.junit.Test;

import tr.com.sedatpolat.datastructures.graphandtree.GraphWithArray;

import static org.junit.Assert.*;

import org.junit.Before;

/**
 * 
 * @author sedpol
 *
 */
public class GraphWithArrayWeightOrderedTest {
	
	public GraphWithArray<Movie> graph = null;
	
	@Before
	public void initGraph() {
		
		graph = new GraphWithArray<Movie>(10, GraphWithArray.TYPE.WEIGHT_ORDERED);
		//MOVIE A->B->D
		graph.add(1000, 2000, 7000, new Movie(2000, "B", 7.6));
		graph.add(1000, 2500, 7500, new Movie(2500, "D", 8.9));
		
		//MOVIE B->C
		graph.add(2000, 5000, 5500, new Movie(5000, "C", 7.7));
		
		//MOVIE C->A->E
		graph.add(5000, 7000, 1300, new Movie(7000, "E", 7.8));
		graph.add(5000, 1000, 1500, new Movie(1000, "A", 8.1));

		//MOVIE D->A->E->F
		graph.add(2500, 1000, 4100, new Movie(1000, "A", 8.1));
		graph.add(2500, 7000, 3700, new Movie(7000, "E", 7.8));
		graph.add(2500, 8000, 3700, new Movie(8000, "F", 8.0));

		//MOVIE E->D
		graph.add(7000, 2500, 2500, new Movie(2500, "D", 8.9));

		//MOVIE F->D
		graph.add(8000, 2500, 3000, new Movie(2500, "D", 8.9));
	}
	
	@Test
	public void testAdjecency() {
		
		//A: 1000 neighbor is 2500 D;
		assertEquals(2500, graph.getAdjacencyList(1000).get(0).getVertext().getId());
		//A: 1000 neighbor is 2000 B;
		assertEquals(2000, graph.getAdjacencyList(1000).get(1).getVertext().getId());
		
		//F: 8000 neighbor is 2500 D;
		assertEquals(2500, graph.getAdjacencyList(8000).get(0).getVertext().getId());
	}
	
	@Test
	public void testSuggestion() {
		//D->4100->A  should suggest firstly A for movie D
		assertEquals(1000, graph.suggestion(2500).get(0).getVertext().getId());
		
		//MOVIE B->5500->C; should suggest firstly C for movie B
		assertEquals(5000, graph.suggestion(2000).get(0).getVertext().getId());
		
		//MOVIE F->3000->D; should suggest firstly D for movie F
		assertEquals(2500, graph.suggestion(8000).get(0).getVertext().getId());
	}
	
	@Test(expected=RuntimeException.class)
	public void testSuggestionExceptionalCase() {
		graph.suggestion(1);
	}
	
//	@Test(expected=RuntimeException.class)
//	public void testAdjacencyExceptionalCase() {
//		graph.getAdjacencyList(10);
//	}
}
