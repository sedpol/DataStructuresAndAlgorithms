package tr.com.sedatpolat.datastructures.test.graphandtree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tr.com.sedatpolat.datastructures.graphandtree.BinarySearchTree;

/**
 * 
 * @author sedpol
 *
 */
public class BinarySearchTreeTest {
	
	@Test
	public void testCreationOfBinarySearchTree() {

		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>(10);
		
		binarySearchTree.root.addAsOrdered(10);
		binarySearchTree.root.addAsOrdered(5);
		binarySearchTree.root.addAsOrdered(15);
		binarySearchTree.root.addAsOrdered(12);
		binarySearchTree.root.addAsOrdered(20);
		binarySearchTree.root.addAsOrdered(10);

		assertEquals(5, binarySearchTree.getHeight(binarySearchTree.root));
		
	}
}
