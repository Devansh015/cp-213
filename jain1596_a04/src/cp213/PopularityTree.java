package cp213;

/**
 * Implements a Popularity Tree. Extends BST.
 *
 * @author Devansh Jain
 * @author David Brown
 * @version 2024-10-15
 */
public class PopularityTree<T extends Comparable<T>> extends BST<T> {

    /**
     * Auxiliary method for valid. May force node rotation if the retrieval count of
     * the located node data is incremented.
     *
     * @param node The node to examine for key.
     * @param key  The data to search for. Count is updated to count in matching
     *             node data if key is found.
     * @return The updated node.
     */
    private TreeNode<T> retrieveAux(TreeNode<T> node, final CountedData<T> key)
    {
	//your code here
	if (node != null)
	{
	    int compared = key.compareTo(node.getData());
	    this.comparisons++;

	    if (compared < 0)
	    {
		node.setLeft(retrieveAux(node.getLeft(), key));
		if (node.getLeft() != null)
		{
		    this.comparisons++;
		    if(node.getData().getCount() < node.getLeft().getData().getCount())
		    {
			node = rotateRight(node);
		    }
		}
	    }
	    else if(compared > 0)
	    {
		node.setRight(retrieveAux(node.getRight(), key));
		if(node.getRight() != null)
		{
		    this.comparisons++;
		    if(node.getData().getCount() < node.getRight().getData().getCount())
		    {
			node = rotateLeft(node);
		    }
		}
	    }
	    else
	    {
		node.getData().incrementCount();

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
	TreeNode<T> mid = top.getLeft();
	node.setRight(mid);
	top.setLeft(node);
	node.updateHeight();
	top.updateHeight();
	return top;

    }

    /**
     * Performs a right rotation around {@code node}.
     *
     * @param parent The subtree to rotate.
     * @return The new root of the subtree.
     */
    private TreeNode<T> rotateRight(final TreeNode<T> parent) {

	// your code here

	TreeNode<T> top = parent.getLeft();
	TreeNode<T> mid = top.getRight();
	parent.setLeft(mid);
	top.setRight(parent);
	top.updateHeight();
	parent.updateHeight();
	return top;
    }

    /**
     * Replaces BST insertAux - does not increment count on repeated insertion.
     * Counts are incremented only on retrieve.
     */
    @Override
    protected TreeNode<T> insertAux(TreeNode<T> node, final CountedData<T> data) {

	// your code here
	if (node == null)
	{
	    TreeNode<T> new_node = new TreeNode<T>(data);
	    this.size++;
	    return new_node;
	}
	else if(data.compareTo(node.getData()) < 0)
	{
	    node.setLeft(insertAux(node.getLeft(), data));
	}
	else if(data.compareTo(node.getData()) > 0)
	{
	    node.setRight(insertAux(node.getRight(), data));
	}
	node.updateHeight();

	return node;
    }

    /**
     * Auxiliary method for valid. Determines if a subtree based on node is a valid
     * subtree. An Popularity Tree must meet the BST validation conditions, and
     * additionally the counts of any node data must be greater than or equal to the
     * counts of its children.
     *
     * @param node The root of the subtree to test for validity.
     * @return true if the subtree base on node is valid, false otherwise.
     */
    @Override
    protected boolean isValidAux(final TreeNode<T> node, TreeNode<T> minNode, TreeNode<T> maxNode) {

	// your code here
	boolean valid = true;

	//Node Exists
	if (node != null)
	{
	    if(minNode != null) {
		if (node.getData().compareTo(minNode.getData()) <= 0)
		{
		    valid = false;
		}
		else if (minNode.getData().getCount() < node.getData().getCount())
		{
		    valid = false;
		}
	    }
	    if(maxNode != null) {
		if(node.getData().compareTo(maxNode.getData()) >= 0)
		{
		    valid = false;
		}
		else if (maxNode.getData().getCount() < node.getData().getCount())
		{
		    valid = false;
		}
	    }
	    if(valid == true)
	    {
		if(this.isValidAux(node.getLeft(), minNode, node) == false || this.isValidAux(node.getRight(), node, maxNode) == false)
		{
		    valid = false;
		}
	    }

	}

	return valid;
    }

    /**
     * Determines whether two PopularityTrees are identical.
     *
     * @param target The PopularityTree to compare this PopularityTree against.
     * @return true if this PopularityTree and target contain nodes that match in
     *         position, data, count, and height, false otherwise.
     */
    public boolean equals(final PopularityTree<T> target) {
	return super.equals(target);
    }

    /**
     * Very similar to the BST retrieve, but increments the data count here instead
     * of in the insertion.
     *
     * @param key The key to search for.
     */
    @Override
    public CountedData<T> retrieve(CountedData<T> key) {

	// your code here
	//CountedData<T> data = null;
	//this.root = retrieveAux(this.root, key);
	//if (this.root != null)
	//{
	//   data = this.root.getData();
	//}
	//return data;
	TreeNode<T> resultNode = retrieveAux(this.root, key);
	this.root = resultNode; // Update root in case of any rotations affecting the root
	return resultNode != null ? resultNode.getData() : null;

    }

}
