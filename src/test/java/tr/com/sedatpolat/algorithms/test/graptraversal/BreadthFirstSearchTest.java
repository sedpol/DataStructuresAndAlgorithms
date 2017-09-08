package tr.com.sedatpolat.algorithms.test.graptraversal;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import tr.com.sedatpolat.datastructures.graphandtree.GraphWithArray;

/**
 * 
 * @author sedpol
 *
 */
public class BreadthFirstSearchTest {

	public GraphWithArray<String> graph = null;

	int A = 1000;
	int B = 2000;
	int C = 3000;
	int D = 4000;
	int E = 5000;
	int F = 6000;
	int G = 7000;
	int H = 8000;
	
	/*
	  ----------------
	  |				  |
	  |				  |
	  A - B - C - E - D - F
	  |		  |
	  ---------
	  
	 */
	
	@Before
	public void initGraph() {

		graph = new GraphWithArray<String>(10, GraphWithArray.TYPE.NONE);
		graph.add(A, B, 0, "B");
		graph.add(A, D, 0, "D");

		graph.add(B, C, 0, "C");

		graph.add(C, E, 0, "E");
		graph.add(C, A, 0, "A");

		graph.add(D, A, 0, "A");
		graph.add(D, E, 0, "E");
		graph.add(D, F, 0, "F");

		graph.add(E, D, 0, "D");

		graph.add(F, D, 0, "D");
	}

	@Test
	public void testBeadthFirstSearch() {
		System.out.println(graph.beadthFirstSearch(1000));
		assertEquals("1000->2000->3000->5000->4000->6000", graph.beadthFirstSearch(1000));
	}
	
	/*
	 * A: 1000, B: 2000, C: 3000, D: 4000, E:5000, F:6000, G:7000, H:8000
	  ----------------
	  |	   	  	  H	  |
	  |	  		  |	  |
	  A - B - F - C	  D 
	  |	  |   |  	  |	 
	  G - E   ---------
	  
	 */
	
	@Test
	public void testBeadthFirstSearch2() {
		GraphWithArray<String> graph = new GraphWithArray<String>(10, GraphWithArray.TYPE.NONE);

		graph.add(A, B, 0, "B"); 
		graph.add(A, D, 0, "D"); 
		graph.add(A, G, 0, "G"); 
		
		graph.add(B, A, 0, "A"); 
		graph.add(B, E, 0, "E"); 
		graph.add(B, F, 0, "F"); 

		graph.add(C, F, 0, "F"); 
		graph.add(C, H, 0, "H"); 

		graph.add(D, A, 0, "A"); 
		graph.add(D, F, 0, "F"); 

		graph.add(E, B, 0, "B"); 
		graph.add(E, G, 0, "G");
		
		graph.add(F, B, 0, "B"); 
		graph.add(F, C, 0, "C"); 
		graph.add(F, D, 0, "D"); 

		graph.add(G, A, 0, "A");
		graph.add(G, E, 0, "E");
		
		graph.add(H, C, 0, "C");
		
		System.out.println(graph.beadthFirstSearch(A));
		assertEquals("1000->2000->5000->7000->6000->3000->8000->4000", graph.beadthFirstSearch(A));
	}
}
