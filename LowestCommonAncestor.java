import java.util.*;
public class LowestCommonAncestor{
	
	 public Node root;
	
	public void createRoot(char rootKey, int rootValue)
	{
		this.root = new Node(rootKey, rootValue);
		this.root.left = null;
		this.root.right = null;
	}
	
	public void addNode(char nodeKey, int nodeValue)
	{
		Node newNode =  new Node(nodeKey ,nodeValue);
		newNode.left = null;
		newNode.right = null;
		addNode(newNode, root);
	}
	
	public void addNode(Node newNode, Node root)
	{
		if(newNode.data < root.data)
		{
			if(root.left == null)
			{
				root.left = newNode;
			}
			else
			{
				addNode(newNode, root.left);
			}
		}
		else
		{
			if(root.right == null)
			{
				root.right = newNode;
			}
			else
			{
				addNode(newNode, root.right);
			}
		}
	}
	
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
		
		if(child.ancestors[0]==null) 
		{
			child.ancestors[0]=parent;
		}
		else
		{
			child.ancestors = Arrays.copyOf(child.ancestors, child.ancestors.length+1);
			child.ancestors[child.ancestors.length-1] = parent;
		}
	}
	
	public Node lca(Node root, int desc1, int desc2)
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
	}
	
	public Node lcaDAG(Node root, int desc1, int desc2)
	{
	    return root;
	}
	
	public int getNodeValue(char nodeKey)
	{
		if(nodeKey == root.key)
		{
			return root.data;
		}
		else
		{
			Node valu = getNodeValue(nodeKey, root);
			if(valu!=null)
			{
				return valu.data;
			}
		}
		return 00;
	}
	private Node getNodeValue(char nodeKey, Node root){
		Node valu = null;
		if(root.left != null){
			if (root.left.key == nodeKey){
				return root.left;
			}
			else{
				valu = getNodeValue(nodeKey, root.left);
				if(valu != null){
					return valu;
				}
			}
		}
		if(root.right != null){
			if(root.right.key == nodeKey){
				return root.right;
			}
			else{
				valu = getNodeValue(nodeKey, root.right);
				if(valu != null){
					return valu;
				}
			}
		}
		return null;
	}
	
}