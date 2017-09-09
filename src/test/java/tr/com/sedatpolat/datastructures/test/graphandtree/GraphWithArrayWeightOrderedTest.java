package tr.com.sedatpolat.datastructures.test.graphandtree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import tr.com.sedatpolat.datastructures.graphandtree.GraphWithArray;

/**
 * 
 * @author sedpol
 *
 */
public class GraphWithArrayWeightOrderedTest {
	
	public GraphWithArray<Movie> graph = null;

	private Movie A = new Movie(1000, "A", 8.1);
	private Movie B = new Movie(2000, "B", 7.6);
	private Movie C = new Movie(5000, "C", 7.7);
	private Movie D = new Movie(2500, "D", 8.9);
	private Movie E = new Movie(7000, "E", 7.8);
	private Movie F = new Movie(8000, "F", 8.0);
	
	@Before
	public void initGraph() {
		
		graph = new GraphWithArray<Movie>(10, GraphWithArray.TYPE.WEIGHT_ORDERED);
		//MOVIE A->B->D
		graph.add(A, 7000, B);
		graph.add(A, 7500, D);
		
		//MOVIE B->C
		graph.add(B, 5500, C);
		
		//MOVIE C->A->E
		graph.add(C, 1300, E);
		graph.add(C, 1500, A);

		//MOVIE D->A->E->F
		graph.add(D, 4100, A);
		graph.add(D, 3700, E);
		graph.add(D, 3700, F);

		//MOVIE E->D
		graph.add(E, 2500, D);

		//MOVIE F->D
		graph.add(F, 3000, D);
	}
	
	@Test
	public void testAdjecency() {
		
		//A: 1000 neighbor is 2500 D;
		assertEquals(D, graph.getAdjacencyList(A).get(0).getVertext());
		//A: 1000 neighbor is 2000 B;
		assertEquals(B, graph.getAdjacencyList(A).get(1).getVertext());
		
		//F: 8000 neighbor is 2500 D;
		assertEquals(D, graph.getAdjacencyList(F).get(0).getVertext());
	}
	
	@Test
	public void testSuggestion() {
		//D->4100->A  should suggest firstly A for movie D
		assertEquals(A, graph.suggestion(D).get(0).getVertext());
		
		//MOVIE B->5500->C; should suggest firstly C for movie B
		assertEquals(C, graph.suggestion(B).get(0).getVertext());
		
		//MOVIE F->3000->D; should suggest firstly D for movie F
		assertEquals(D, graph.suggestion(F).get(0).getVertext());
	}
	
	@Test(expected=RuntimeException.class)
	public void testSuggestionExceptionalCase() {
		graph.suggestion(new Movie(50, "X", 0.0));
	}
	
//	@Test(expected=RuntimeException.class)
//	public void testAdjacencyExceptionalCase() {
//		graph.getAdjacencyList(10);
//	}
}
