package tr.com.sedatpolat.datastructures.graphandtree;

import tr.com.sedatpolat.datastructures.TreeNode;

/**
 * 
 * @author sedpol
 *
 * @param <E>
 */
public class Tree<E extends Comparable<E>> {

	public TreeNode<E> root;
	
	protected void addLeft(TreeNode<E> treeNode) {
		if (root.left == null)
			root.left = treeNode;
	}
	
	protected void addRight(TreeNode<E> treeNode) {
		if (root.right == null)
			root.right = treeNode;
	}
	
	public int getHeight(TreeNode<E> root) {
		if (root == null)
			return 0;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
}
