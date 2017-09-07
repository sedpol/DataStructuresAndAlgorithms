package tr.com.sedatpolat.datastructures;

/**
 * 
 * @author sedpol
 *
 * @param <E>
 */
public class TreeNode<E extends Comparable<E>> {
	public E data;
	public TreeNode<E> parent;
	public TreeNode<E> left;
	public TreeNode<E> right;

	public TreeNode(E data) {
		this.data = data;
	}

	protected void addLeft(E data) {
		this.left = new TreeNode<E>(data);
		this.left.parent = this;
	}
	
	protected void addRight(E data) {
		this.right = new TreeNode<E>(data);
		this.right.parent = this;
	}
	
	public void addAsOrdered(E data) {
		if (this.data.compareTo(data) == 1) {
			if (this.left != null)
				this.left.addAsOrdered(data);
			else {
				addLeft(data);
			}
		} else {
			if (this.right != null)
				this.right.addAsOrdered(data);
			else {
				addRight(data);
			}
		}
	}
}
