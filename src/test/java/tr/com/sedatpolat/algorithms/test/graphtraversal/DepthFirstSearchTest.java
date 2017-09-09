package tr.com.sedatpolat.algorithms.test.graphtraversal;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import tr.com.sedatpolat.datastructures.graphandtree.GraphWithArray;

/**
 * 
 * @author sedpol
 *
 */
public class DepthFirstSearchTest {

	public GraphWithArray<String> graph = null;

	@Before
	public void initGraph() {

		graph = new GraphWithArray<String>(10, GraphWithArray.TYPE.NONE);
		graph.add("A", 0, "B");
		graph.add("A", 0, "D");

		graph.add("B", 0, "C");

		graph.add("C", 0, "E");
		graph.add("C", 0, "A");

		graph.add("D", 0, "A");
		graph.add("D", 0, "E");
		graph.add("D", 0, "F");

		graph.add("E", 0, "D");

		graph.add("F", 0, "D");
	}

	@Test
	public void testBeadthFirstSearch() {
		System.out.println(graph.beadthFirstSearch("A"));
		assertEquals("A->B->C->E->D->F", graph.beadthFirstSearch("A"));
	}
	
	/*
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

		graph.add("A", 0, "B"); 
		graph.add("A", 0, "D"); 
		graph.add("A", 0, "G"); 
		
		graph.add("B", 0, "A"); 
		graph.add("B", 0, "E"); 
		graph.add("B", 0, "F"); 

		graph.add("C", 0, "F"); 
		graph.add("C", 0, "H"); 

		graph.add("D", 0, "A"); 
		graph.add("D", 0, "F"); 

		graph.add("E", 0, "B"); 
		graph.add("E", 0, "G");
		
		graph.add("F", 0, "B"); 
		graph.add("F", 0, "C"); 
		graph.add("F", 0, "D"); 

		graph.add("G", 0, "A");
		graph.add("G", 0, "E");
		
		graph.add("H", 0, "C");
		
		System.out.println(graph.beadthFirstSearch("A"));
		assertEquals("A->B->E->G->F->C->H->D", graph.beadthFirstSearch("A"));
	}
}
