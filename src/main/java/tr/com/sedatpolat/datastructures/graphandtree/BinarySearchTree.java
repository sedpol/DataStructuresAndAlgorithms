package tr.com.sedatpolat.datastructures.graphandtree;

import tr.com.sedatpolat.datastructures.TreeNode;

/**
 * 
 * @author sedpol
 *
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>> extends Tree<E> {

	public BinarySearchTree(E rootData) {
		this.root = new TreeNode<E>(rootData);
	}

	public E findMax(TreeNode<E> node) {
		if (node.right != null);
			findMax(node.right);
			
		return node.data;
	}
	
	public E findMin(TreeNode<E> node) {
		if (node.left != null)
			findMin(node.left);
		
		return node.data;
	}
}
