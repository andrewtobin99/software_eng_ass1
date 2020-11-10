import java.util.Arrays;
public class LowestCommonAncestor{
	
	 public Node root;
	
	 public void addChild(Node parent, Node child)
		{
			if(parent.children[0]==null)
			{
				parent.children[0]=child;	
			}
			else
			{
				parent.children = Arrays.copyOf(parent.children, parent.children.length+1);
				parent.children[parent.children.length-1] = child;
			}
			
			if(child.parents[0]==null) 
			{
				child.parents[0]=parent;
			}
			else
			{
				child.parents = Arrays.copyOf(child.parents, child.parents.length+1);
				child.parents[child.parents.length-1] = parent;
			}
			if(child.maxDepth < parent.maxDepth +1)
				child.maxDepth = parent.maxDepth + 1;
		}
	
	public Node lca(Node root, int desc1, int desc2)
	{
		int deepestAncestorDepth = -1;
		Node deepestAncestor = null;
		if (root == null)
		{
			return null;
		}
		else if(root.children==null) 
		{
			return null;
		}
		
		Node desc1N = findNode(root, desc1);
		Node desc2N = findNode(root, desc2);
		
		if(desc1N == null || desc2N == null)
		{
			return null;
		}
		if(desc1N==desc2N)
		{
			return desc1N;
		}
		if(desc1N==root || desc2N==root)
		{
			return root;
		}
		else{
				for(int i=0; i<desc1N.parents.length; i++)
				{
					for(int j=0; j<desc2N.parents.length; j++)
					{
						if(desc1N.parents[i]==desc2N.parents[j])
						{
							if(desc1N.parents[i].maxDepth > deepestAncestorDepth)
								deepestAncestor = desc1N.parents[i];
								deepestAncestorDepth = deepestAncestor.maxDepth;
						}
					}
				}
				for(int i=0; i<desc2N.parents.length; i++)
				{
					if(desc2N.parents[i] == desc1N)
					{
						if(desc1N.maxDepth>deepestAncestorDepth)
							deepestAncestor = desc1N;
							deepestAncestorDepth = deepestAncestor.maxDepth;
					}
				}
				for(int i=0; i<desc2N.parents.length; i++)
				{
					if(desc1N==desc2N.parents[i])
					{
						if(desc1N.maxDepth>deepestAncestorDepth)
							deepestAncestor = desc1N;
							deepestAncestorDepth = deepestAncestor.maxDepth;
					}
				}
				
				for(int i=0; i<desc1N.parents.length; i++)
				{
					if(desc2N==desc1N.parents[i])
					{
						if(desc2N.maxDepth>deepestAncestorDepth)
							deepestAncestor = desc2N;
							deepestAncestorDepth = deepestAncestor.maxDepth;
					}
				}
				if(deepestAncestor!=null)
					return deepestAncestor;
		}
		deepestAncestor = lca(root, desc1N.parents[0].data, desc2N.parents[0].data);
		if(deepestAncestor!=null)
			return deepestAncestor;
		else
			return null;
	}
	
	//currently can't return correct LCA if node X is an ancestor of node Y
	//but is not a parent of node Y, returns root value instead.
	
	public Node findNode(Node root, int value)
	{
		if(root.data == value)
			{
			return root;
			}
		else {
			Node node = root;
			for(int i = 0; i<root.children.length; i++)
			{
				node = root.children[i];
				if(node.data == value)
				{
					return node;
				}
				else 
				{
					for(int j = 0; j<node.children.length; j++) 
					{
						if(node.children[j]!=null)
							if(node.children[j].data==value)
							{
								return node.children[j];
							}
						
					}
				}
			}
			node = findNode(node, value);
			if(node!=null)
				return node;
		}
		return null;
	}
	
	// nodes from original LCA that are obsolete now but could be used again 
	
	/* public Node lca(Node root, int desc1, int desc2)
	{
		if(root==null)
			return null;
	 
	    if(root.data==desc1 || root.data==desc2)
	        return root;
	 
	    Node l = lca(root.left, desc1, desc2);
	    Node r = lca(root.right, desc1, desc2);
	 
	    if(l!=null&&r!=null){
	        return root;
	    }else if(l==null&&r==null){
	        return null;
	    }else{
	        return l==null?r:l;
	    }
	} */
	
	/*public Node getNodeValue(int value)
	{
		if(value == root.data)
		{
			return root;
		}
		else
		{
			Node valu = getNodeValue(root, value);
			if(valu!=null)
			{
				return valu;
			}
		}
		return null;
	}
	private Node getNodeValue(Node root, int value){
		Node valu = null;
		if(root.left != null){
			if (root.left.data == value){
				return root.left;
			}
			else{
				valu = getNodeValue(root.left, value);
				if(valu != null){
					return valu;
				}
			}
		}
		if(root.right != null){
			if(root.right.data == value){
				return root.right;
			}
			else{
				valu = getNodeValue(root.right, value);
				if(valu != null){
					return valu;
				}
			}
		}
		return null;
	}*/
	
}