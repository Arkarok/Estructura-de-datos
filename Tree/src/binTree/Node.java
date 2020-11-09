package binTree;

public class Node {

	public Node left;
	public Node right;
	public Object object;
	public int level;

	public Node(Object object) {
		this.left = null;
		this.right = null;
		this.object = object;
		this.level=0;
	}

	public Node(Node left, Object object, Node right) {
		this.left = left;
		this.right = right;
		this.object = object;
	}

	@Override
	public String toString() {
		return String.valueOf(object);
	}
}
