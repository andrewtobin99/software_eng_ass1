public class LowestCommonAncestor{
	public static void main(String args[])
	{
		AncestorBT tree = new AncestorBT();
		tree.root = new Node(20);
		tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
        
        int desc1 = 10, desc2 = 14; 
        Node t = tree.lca(tree.root, desc1, desc2); 
        System.out.println("Lowest Common Ancestor of " + desc1 + " and " + desc2 + " is " + t.data); 
   
        desc1 = 14; 
        desc2 = 8; 
        t = tree.lca(tree.root, desc1, desc2); 
        System.out.println("Lowest Common Ancestor of " + desc1 + " and " + desc2 + " is " + t.data); 
   
        desc1 = 10; 
        desc2 = 22; 
        t = tree.lca(tree.root, desc1, desc2); 
        System.out.println("Lowest Common Ancestor of " + desc1 + " and " + desc2 + " is " + t.data); 
   
	}
}