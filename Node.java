
public class Node {
	char key;
	int data;
	Node left, right, 
	Node[] ancestors, children;
	
	Node(char key, int value)
	{
		this.key = key;
		data = value;
		left=null;
		right=null;
		ancestors = new Node[1];
		children = new Node[1];
		ancestors[0]=null;
		children[0]=null;
	}
}
