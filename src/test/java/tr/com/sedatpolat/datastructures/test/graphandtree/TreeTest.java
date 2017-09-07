package tr.com.sedatpolat.datastructures.test.graphandtree;

import org.junit.Test;

import tr.com.sedatpolat.datastructures.TreeNode;
import tr.com.sedatpolat.datastructures.graphandtree.Tree;

import static org.junit.Assert.*;

/**
 * 
 * @author sedpol
 *
 */
public class TreeTest {

	@Test
	public void getheightTest() {

		Tree<Integer> tree = new Tree<Integer>();
		
		assertEquals(0, tree.getHeight(tree.root));
		
		tree.root = new TreeNode<Integer>(10);
		tree.root.left = new TreeNode<Integer>(5);
		tree.root.left.left = new TreeNode<Integer>(17);
		tree.root.right = new TreeNode<Integer>(55);
		tree.root.right.right = new TreeNode<Integer>(555);
		tree.root.right.right.right = new TreeNode<Integer>(575);
		tree.root.right.right.left = new TreeNode<Integer>(755);
		tree.root.right.right.left.right = new TreeNode<Integer>(0);
		
		assertEquals(5, tree.getHeight(tree.root));
		
	}

}
