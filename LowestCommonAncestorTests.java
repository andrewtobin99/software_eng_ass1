import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorTests{

	@Test
	public void lcaSimpleBinaryTree()
	{
		LowestCommonAncestor lca = new LowestCommonAncestor();
		Node root = new Node(1);
		Node n2 = new Node(2);						
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		lca.addChild(root, n2);
		lca.addChild(root, n3);
		lca.addChild(n2, n4);
		lca.addChild(n2, n5);
		lca.addChild(n3, n6);
		lca.addChild(n3, n7);
		lca.addChild(n7, n8);
		//tests two children of same parent
		assertEquals(lca.lca(root, 4,5).data, 2);
		//tests parent/child lca
		assertEquals(lca.lca(root, 7,8).data, 7);
		//other tests
		assertEquals(lca.lca(root, 5,6).data, 1);
		assertEquals(lca.lca(root, 8,6).data, 3);
		//tests when root is one of nodes
		assertEquals(lca.lca(root, 1,5).data, 1);
	}
	
	@Test
	public void testAddChild()
	{
		LowestCommonAncestor lca = new LowestCommonAncestor();
		Node n1 = new Node(10);	
		Node n2 = new Node(4);
		lca.addChild(n1, n2);
		//tests to see if child was added successfully
		assertEquals("n1 has child ", n2, n1.children[0]);
		//checks if new child has old node as parent
		assertEquals("n2 has ancestor", n1, n2.parents[0]);
	}
	
	/* @Test
	public void testOneDownlineTree()
	{
		LowestCommonAncestor lca = new LowestCommonAncestor();
		Node root = new Node(1);
		Node n2 = new Node(2);						
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		lca.addChild(root, n2);
		lca.addChild(n2, n3);
		lca.addChild(n3, n4);
		lca.addChild(n4, n5);
		lca.addChild(n5, n6);
		lca.addChild(n6, n7);
		lca.addChild(n7, n8);
		assertEquals(lca.lca(root, 1,3).data, 1);
		assertEquals(lca.lca(root, 3,4).data, 3);
		assertEquals(lca.lca(root, 2,8).data, 2);
	}
	*/
	
	@Test
	public void testDAG() {
		LowestCommonAncestor lca = new LowestCommonAncestor();
		// creating a DAG
		Node root = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		lca.addChild(root, n2);
		lca.addChild(root, n3);
		lca.addChild(n2, n4);
		lca.addChild(n2, n5);
		lca.addChild(n3, n5);
		lca.addChild(n3, n6);
		lca.addChild(n4, n7);
		lca.addChild(n4, n8);
		lca.addChild(n5, n7);
		lca.addChild(n5, n8);
		lca.addChild(n6, n8);
		//tests bottom most nodes
		assertEquals(lca.lca(root, 7,8).data, 4);
		//other tests
		assertEquals(lca.lca(root, 2,8).data, 1);
		assertEquals(lca.lca(root, 6,7).data, 1);
		//tests child and parent LCA
		assertEquals(lca.lca(root, 5,8).data, 5);
		//tests when one of the nodes is root
		assertEquals(lca.lca(root, 1,3).data, 1);
		
	}
	
	@Test 
	public void diffDag()
	{
		LowestCommonAncestor lca = new LowestCommonAncestor();
		Node root = new Node(1);
		Node n2 = new Node(2);						
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		lca.addChild(root, n2);
		lca.addChild(n2, n3);
		lca.addChild(n2, n4);
		lca.addChild(n2, n5);
		lca.addChild(n3, n6);
		lca.addChild(n4, n6);
		lca.addChild(n4, n7);
		lca.addChild(n5, n6);
		lca.addChild(n5, n7);
		assertEquals(lca.lca(root, 3, 7).data, 2);
	}
}