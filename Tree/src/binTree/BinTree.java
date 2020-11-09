package binTree;

public class BinTree {

	public Node root;

	public BinTree() {
		this.root = null;
	}

	public BinTree(Object object) {
		this.root = subBinTree(null, object, null);
	}

	public Node subBinTree(Node left, Object object, Node right) {
		return new Node(left, object, right);
	}

	public boolean isEmpty() {
		return root == null;
	}

	public boolean root(Object object) {
		try {
			root = subBinTree(null, object, null);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean insertleft(Object object) {
		try {
			if (!isEmpty()) {
				root.left = subBinTree(null, object, null);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean insertRight(Object object) {
		try {
			if (!isEmpty()) {
				root.right = subBinTree(null, object, null);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String preOrder(Node node) {

		String salida = "";
		if (node != null) {
			salida = node.toString() + preOrder(node.left) + preOrder(node.right);
		}
		return salida;

	}

	public String inOrder(Node node) {

		String salida = "";
		if (node != null) {
			salida = inOrder(node.left) + node.toString() + inOrder(node.right);
		}
		return salida;

	}

	public String posOrder(Node node) {

		String salida = "";
		if (node != null) {
			salida = posOrder(node.left) + posOrder(node.right) + node.toString();
		}
		return salida;
	}

	public void insert(Object object, Node node) {

		if (Integer.valueOf(String.valueOf(node.object)) <= (Integer) object) {
			if (node.right == null) {
				node.right = new Node(object);

			} else {
				insert(object, node.right);
			}

		} else {
			if (node.left == null) {
				node.left = new Node(object);

			} else {
				insert(object, node.left);
			}
		}
	}

	public boolean search(Object object, Node node) {

		if (node == null) {
			return false;

		} else if (String.valueOf(object).equals(String.valueOf(node))) {
			return true;

		} else if (Integer.valueOf(String.valueOf(node.object)) <= (Integer) object) {
			return search(object, node.right);

		} else {
			return search(object, node.left);
		}

	}

	public int totalNodos(Node node) {
		String contar = inOrder(node);
		return contar.length();
	}

	public void menorId(Node node) {
		try {
			String respuesta = "";
			if (node.left != null) {
				menorId(node.left);
			} else {

				respuesta = node.toString();
				System.out.println(respuesta);
			}

		} catch (Exception e) {
			System.out.println(String.valueOf(null));
		}

	}

	public void mayorId(Node node) {
		try {
			String salida = "";
			if (node.right != null) {
				mayorId(node.right);
			} else {

				salida = node.toString();
				System.out.println(salida);
			}

		} catch (Exception e) {
			System.out.println(String.valueOf(null));
		}

	}

	public void printHojas(Node node) {

		if (node.left != null) {
			printHojas(node.left);
		}
		if (node.right != null) {
			printHojas(node.right);
		}
		if (node.left == null && node.right == null) {
			System.out.print(node.object + " ");
		}

	}

	public int getLevel(Node node) {
		if (node == null) {
			return 0;
		} else {
			return node.level;
		}
	}

	public Node rotateRight(Node node) {
		Node temp1 = node.left;
		Node temp2 = temp1.right;
		temp1.right = node;
		node.left = temp2;
		node.level = Math.max(getLevel(node.left), getLevel(node.right)) + 1;
		temp1.level = Math.max(getLevel(temp1.left), getLevel(temp1.right)) + 1;
		return temp1;
	}

	public Node rotateLeft(Node node) {
		Node temp1 = node.right;
		Node temp2 = temp1.left;
		temp1.left = node;
		node.right = temp2;
		node.level = Math.max(getLevel(node.left), getLevel(node.right)) + 1;
		temp1.level = Math.max(getLevel(temp1.left), getLevel(temp1.right)) + 1;
		return temp1;
	}

	public int rocking(Node node) {
		if (node == null) {
			return 0;
		} else {
			return getLevel(node.left) - getLevel(node.right);
		}
	}

	public Node insertAVL(Node node, Object object) {
		if (node == null) {
			Node temp = new Node(object);
			return temp;
		}

		if ((Integer) object < (Integer) node.object) {
			node.left = insertAVL(node.left, object);
		} else if ((Integer) object > (Integer) node.object) {
			node.right = insertAVL(node.right, object);
		} else {
			return node;
		}

		node.level = 1 + Math.max(getLevel(node.left), getLevel(node.right));
		int balance = rocking(node);

		if (balance > 1 && (Integer) object < (Integer) node.left.object) {
			return rotateRight(node);
		}
		if (balance < -1 && (Integer) object > (Integer) node.right.object) {
			return rotateLeft(node);
		}
		if (balance > 1 && (Integer) object > (Integer) node.left.object) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}
		if (balance < -1 && (Integer) object < (Integer) node.right.object) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		return node;
	}

	@Override
	public String toString() {
		return "BinTree{" + "root=" + root + '}';
	}

}