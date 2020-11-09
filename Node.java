
public class Node {
	char key;
	int data;
	Node left, right, ancestors[], children[];
	
	Node(char key, int value)
	{
		this.key = key;
		data = value;
		left=null;
		right=null;
		ancestors=null;
		children = null;
	}
}
