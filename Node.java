
public class Node {
	int data;
	int maxDepth;
	Node[] parents, children;
	
	
	Node( int value)
	{
		data = value;
		maxDepth = 0;
		parents = new Node[1];
		children = new Node[1];
		parents[0]=null;
		children[0]=null;
	}
}
