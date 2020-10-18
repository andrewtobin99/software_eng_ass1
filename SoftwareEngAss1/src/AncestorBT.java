
public class AncestorBT {
	Node root;
	
	Node lca(Node node, int desc1, int desc2)
	{
		if(node==null)
		{
			return null;
		}
		else if(node.data>desc1 && node.data>desc2)
		{
			return lca(node.left, desc1, desc2);
		}
		else if(node.data<desc1 && node.data<desc2)
		{
			return lca(node.right, desc1, desc2);
		}
		else
			return node;
	}
}
