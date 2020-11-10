import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorTests{

	@Test
	public void lca()
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
		assertEquals(lca.lcaDAG(root, 4,5).data, 2);
		assertEquals(lca.lcaDAG(root, 7,8).data, 7);
		assertEquals(lca.lcaDAG(root, 5,6).data, 1);
	}
	
	@Test
	public void testAddChild()
	{
		LowestCommonAncestor lca = new LowestCommonAncestor();
		Node n1 = new Node(10);	
		Node n2 = new Node(4);
		lca.addChild(n1, n2);
		assertEquals("n1 has child ", n2, n1.children[0]);
		assertEquals("n2 has ancestor", n1, n2.parents[0]);
	}
	
	
	@Test
	public void testLCAdag() {
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
		assertEquals(lca.lcaDAG(root, 7,8).data, 4);
		assertEquals(lca.lcaDAG(root, 2,8).data, 1);
	}
}