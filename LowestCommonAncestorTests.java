import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorTests{

	
	@Test
	public void testCreateRoot(){
		LowestCommonAncestor lca = new LowestCommonAncestor();
		lca.createRoot('a',5);
		assertEquals("Tree root", 5, lca.root.data);
	}
	
	@Test
	public void testAddNode(){
		LowestCommonAncestor lca = new LowestCommonAncestor();
		lca.createRoot('z', 6);
		lca.addNode('a', 1);
		assertEquals("Add node 'a' with value 1", 1, lca.getNodeValue('a'));
		lca.addNode('b', 2);
		assertEquals("Add node 'b' with value 2", 2, lca.getNodeValue('b'));
		lca.addNode('c', 3);
		assertEquals("Add node 'c' with value 3", 3, lca.getNodeValue('c'));
		lca.addNode('d', 8);
		assertEquals("Add node 'd' with value 4", 8, lca.getNodeValue('d'));
		lca.addNode('e', 9);
		assertEquals("Add node 'e' with value 5", 9, lca.getNodeValue('e'));
	}
	
	@Test
	public void testLCA(){
		LowestCommonAncestor lca = new LowestCommonAncestor();
		lca.createRoot('a',10);		
		lca.addNode('b',2);
		lca.addNode('c',1);
		lca.addNode('d',4);
		lca.addNode('e',15);
		lca.addNode('f',12);
		lca.addNode('g',16);
		assertEquals("Should return tree root i.e. 10", lca.root.data, lca.lca(lca.root, lca.getNodeValue('a'), lca.getNodeValue('a')).data);
		assertEquals("Should return tree root i.e. 10", lca.root.data, lca.lca(lca.root, lca.getNodeValue('g'), lca.getNodeValue('d')).data);
		assertEquals("Should return 3", lca.getNodeValue('b'), lca.lca(lca.root, lca.getNodeValue('c'), lca.getNodeValue('d')).data);
		assertEquals("Should return 12", lca.getNodeValue('e'), lca.lca(lca.root, lca.getNodeValue('f'), lca.getNodeValue('g')).data);
	}	
}