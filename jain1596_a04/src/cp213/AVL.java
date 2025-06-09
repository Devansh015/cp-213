package cp213;

/**
 * Implements an AVL (Adelson-Velsky Landis) tree. Extends BST.
 *
 * @author your name here
 * @author David Brown
 * @version 2024-10-15
 */
public class AVL<T extends Comparable<T>> extends BST<T> {

    /**
     * Returns the balance data of node. If greater than 1, then left heavy, if less
     * than -1, then right heavy. If in the range -1 to 1 inclusive, the node is
     * balanced. Used to determine whether to rotate a node upon insertion.
     *
     * @param node The TreeNode to analyze for balance.
     * @return A balance number.
     */
    private int balance(final TreeNode<T> node) {

	// your code here
	int num = 0;
	if (node != null)
	{
	    if (node.getLeft() == null && node.getRight() == null)
	    {
		num = 0;
	    }
	    else if(node.getLeft() == null)
	    {
		num = 0 - node.getRight().getHeight();
	    }
	    else if (node.getRight() == null)
	    {
		num = node.getLeft().getHeight();
	    }
	    else
	    {
		num = node.getLeft().getHeight() - node.getRight().getHeight();
	    }
	}
	return num ;
    }

    /**
     * Rebalances the current node if its children are not balanced.
     *
     * @param node the node to rebalance
     * @return replacement for the rebalanced node
     */
    private TreeNode<T> rebalance(TreeNode<T> node) {

	// your code here
	if (node != null)
	{
	    if (balance(node) > 1)
	    {
		if (balance(node.getLeft()) < 0)
		{
		    node.setLeft(rotateLeft(node.getLeft()));
		}
		return rotateRight(node);
	    }
	    else if (balance(node) < -1)
	    {
		if(balance(node.getRight()) > 0)
		{
		    node.setRight(rotateRight(node.getRight()));
		}
		return rotateLeft(node);
	    }
	}

	return node;

    }
    /**
     * Performs a left rotation around node.
     *
     * @param node The subtree to rotate.
     * @return The new root of the subtree.
     */
    private TreeNode<T> rotateLeft(final TreeNode<T> node) {

	// your code here

	TreeNode<T> top = node.getRight();
	TreeNode<T> mid = node.getRight().getLeft();
	top.setLeft(node);
	node.setRight(mid);
	node.updateHeight();
	top.updateHeight();
	return top;
    }

    /**
     * Performs a right rotation around node.
     *
     * @param node The subtree to rotate.
     * @return The new root of the subtree.
     */
    private TreeNode<T> rotateRight(final TreeNode<T> node) {

	// your code here
	TreeNode<T> top = node.getLeft();
	TreeNode<T> mid = node.getLeft().getRight();
	top.setRight(node);
	node.setLeft(mid);
	node.updateHeight();
	top.updateHeight();
	return top;

    }

    /**
     * Auxiliary method for insert. Inserts data into this AVL. Same as BST
     * insertion with addition of rebalance of nodes.
     *
     * @param node The current node (TreeNode).
     * @param data Data to be inserted into the node.
     * @return The inserted node.
     */
    @Override
    protected TreeNode<T> insertAux(TreeNode<T> node, final CountedData<T> data) {

	// your code here

	if (node == null)
	{
	    TreeNode<T> new_node = new TreeNode<T>(data);
	    this.size++;
	    new_node.getData().incrementCount();
	    return new_node;
	}
	else if (data.compareTo(node.getData()) > 0)
	{
	    node.setRight(insertAux(node.getRight(), data));
	}
	else if(data.compareTo(node.getData()) < 0)
	{
	    node.setLeft(insertAux(node.getLeft(), data));
	}
	node.updateHeight();

	return rebalance(node);
    }

    /**
     * Auxiliary method for valid. Determines if a subtree based on node is a valid
     * subtree. An AVL must meet the BST validation conditions, and additionally be
     * balanced in all its subtrees - i.e. the difference in height between any two
     * children must be no greater than 1.
     *
     * @param node The root of the subtree to test for validity.
     * @return true if the subtree base on node is valid, false otherwise.
     */
    @Override
    protected boolean isValidAux(final TreeNode<T> node, TreeNode<T> minNode, TreeNode<T> maxNode) {

	// your code here
	boolean valid = true;
	if (node != null)
	{
	    if(minNode != null && node.getData().compareTo(minNode.getData()) <= 0)
	    {
		valid = false;
	    }
	    else if(maxNode != null && node.getData().compareTo(maxNode.getData()) >= 0)
	    {
		valid = false;
	    }
	    else
	    {
		int lheight = 0;
		int rheight = 0;
		if(node.getLeft() != null)
		{
		    lheight = node.getLeft().getHeight();
		}
		if(node.getRight() != null)
		{
		    rheight = node.getRight().getHeight();
		}
		int hDiff = Math.abs(lheight - rheight);
		if(this.isValidAux(node.getLeft(), minNode, node) == false || this.isValidAux(node.getRight(), node, maxNode) == false)
		{
		    valid = false;
		}
		if(hDiff > 1)
		{
		    valid = false;
		}
	    }

	}
	return valid;
    }

    /**
     * Determines whether two AVLs are identical.
     *
     * @param target The AVL to compare this AVL against.
     * @return true if this AVL and target contain nodes that match in position,
     *         data, count, and height, false otherwise.
     */
    public boolean equals(final AVL<T> target) {
	return super.equals(target);
    }

    /**
     * Auxiliary method for remove. Removes data from this BST. Same as BST removal
     * with addition of rebalance of nodes.
     *
     * @param node The current node (TreeNode).
     * @param data Data to be removed from the tree.
     * @return The replacement node.
     */
    @Override
    protected TreeNode<T> removeAux(TreeNode<T> node, final CountedData<T> data) {

	// your code here
	if (node != null)
	{
	    if(data.compareTo(node.getData()) < 0)  {node.setLeft(removeAux(node.getLeft(), data));}
	    else if(data.compareTo(node.getData()) > 0) {node.setRight(removeAux(node.getRight(), data));}
	    //Assume they are equal, if not, there are bigger issues...
	    else
	    {
		this.size--;
		if(node.getLeft() == null && node.getRight() == null)
		{
		    //Nothing
		    node = null;
		}
		else if(node.getLeft()== null)
		{
		    node = node.getRight();
		}
		else if(node.getRight() == null)
		{
		    node = node.getLeft();
		}
		else
		{
		    TreeNode<T> old_l = node.getLeft();
		    TreeNode<T> old_r = node.getRight();
		    TreeNode<T> prev = old_r;
		    TreeNode<T> curr = old_r;
		    while (curr.getLeft() != null)
		    {
			prev = curr;
			curr = curr.getLeft();
		    }
		    if (prev != old_r)
		    {
			prev.setLeft(curr.getRight());
			curr.setRight(old_r);
		    }
		    curr.setLeft(old_l);
		    node = curr;
		}

	    }
	    if (node!= null)
	    {
		node.updateHeight();
	    }
	}
	return rebalance(node);
    }

}
