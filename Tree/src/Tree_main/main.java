package Tree_main;

import binTree.BinTree;
import binTree.Node;

public class main {

	public static void main(String[] args) {

		BinTree arbol = new BinTree();

		arbol.root = new Node(new Node(new Node("a"), "*", new Node("b")), "+",
				new Node(new Node("c"), "/", new Node("d")));

		System.out.println(arbol.preOrder(arbol.root));
		System.out.println(arbol.inOrder(arbol.root));
		System.out.println(arbol.posOrder(arbol.root));

		BinTree tree = new BinTree();

		tree.root = new Node(
				new Node(new Node(null, "-", new Node("a")), "+", new Node(new Node("x"), "+", new Node("y"))), "/",
				new Node(new Node(null, "+", new Node("b")), "*", new Node(new Node("c"), "*", new Node("a"))));

		System.out.println(tree.preOrder(tree.root));
		System.out.println(tree.inOrder(tree.root));
		System.out.println(tree.posOrder(tree.root));

		BinTree bt = new BinTree();

		bt.root = new Node(
				new Node(new Node(new Node("22"), "43", new Node(new Node("56"), "65", null)), "87",
						new Node(new Node("87"), "99", null)),
				"120", new Node(new Node(null, "130", new Node("135")), "140", null));

		System.out.println(bt.preOrder(bt.root));
		System.out.println(bt.inOrder(bt.root));
		System.out.println(bt.posOrder(bt.root));

		bt.insert(44, bt.root);
		bt.insert(121, bt.root);
		System.out.println(bt.inOrder(bt.root));

		System.out.println(bt.search(150, bt.root));
		System.out.println(bt.search(22, bt.root));
		System.out.println(bt.search(135, bt.root));

		// imprimir cantidad de nodos
		System.out.println(bt.totalNodos(bt.root));

		// imprimir hojas
		BinTree bt2 = new BinTree();
		bt2.root = new Node(new Node(new Node(null, 32, new Node(39)), 41, new Node(48)), 50,
				new Node(null, 60, new Node(67)));
		bt2.printHojas(bt2.root);
		System.out.println();

		// imprimir menor id y mayor id
		bt.menorId(bt.root);
		bt.mayorId(bt.root);

		// Balanceo de arboles binarios por insercion AVL
		BinTree arbolAVL = new BinTree();

		arbolAVL.root = null;

		arbolAVL.root = arbolAVL.insertAVL(arbolAVL.root, 40);
		arbolAVL.root = arbolAVL.insertAVL(arbolAVL.root, 20);
		arbolAVL.root = arbolAVL.insertAVL(arbolAVL.root, 10);
		arbolAVL.root = arbolAVL.insertAVL(arbolAVL.root, 25);
		arbolAVL.root = arbolAVL.insertAVL(arbolAVL.root, 30);
		arbolAVL.root = arbolAVL.insertAVL(arbolAVL.root, 22);
		arbolAVL.root = arbolAVL.insertAVL(arbolAVL.root, 50);

		System.out.println(arbolAVL.preOrder(arbolAVL.root));
		System.out.println(arbolAVL.inOrder(arbolAVL.root));
		System.out.println(arbolAVL.posOrder(arbolAVL.root));
		
		//Insercion y Busqueda en arbol binario de busqueda 
		
		BinTree ejemploBin= new BinTree();
		
		ejemploBin.root= new Node("200");
		
		ejemploBin.insert(58, ejemploBin.root);
		ejemploBin.insert(142, ejemploBin.root);
		ejemploBin.insert(96, ejemploBin.root);
		ejemploBin.insert(88, ejemploBin.root);
		ejemploBin.insert(202, ejemploBin.root);
		ejemploBin.insert(44, ejemploBin.root);
		ejemploBin.insert(92, ejemploBin.root);
		ejemploBin.insert(74, ejemploBin.root);
		ejemploBin.insert(40, ejemploBin.root);
		ejemploBin.insert(50, ejemploBin.root);
		ejemploBin.insert(20, ejemploBin.root);
		
		System.out.println("Binario de busqueda");
		
		System.out.println(ejemploBin.search(142, ejemploBin.root));
		System.out.println(ejemploBin.search(500, ejemploBin.root));
		System.out.println(ejemploBin.inOrder(ejemploBin.root));
		System.out.println();
		
		//Insercion y Busqueda en arbol binario de busqueda AVL
		
		BinTree ejemploBinAVL= new BinTree();
		
		ejemploBinAVL.root=null;
		
		ejemploBinAVL.root= ejemploBinAVL.insertAVL(ejemploBinAVL.root, 200);
		ejemploBinAVL.root= ejemploBinAVL.insertAVL(ejemploBinAVL.root, 58);
		ejemploBinAVL.root= ejemploBinAVL.insertAVL(ejemploBinAVL.root, 142);
		ejemploBinAVL.root= ejemploBinAVL.insertAVL(ejemploBinAVL.root, 96);
		ejemploBinAVL.root= ejemploBinAVL.insertAVL(ejemploBinAVL.root, 88);
		ejemploBinAVL.root= ejemploBinAVL.insertAVL(ejemploBinAVL.root, 202);
		ejemploBinAVL.root= ejemploBinAVL.insertAVL(ejemploBinAVL.root, 44);
		ejemploBinAVL.root= ejemploBinAVL.insertAVL(ejemploBinAVL.root, 92);
		ejemploBinAVL.root= ejemploBinAVL.insertAVL(ejemploBinAVL.root, 74);
		ejemploBinAVL.root= ejemploBinAVL.insertAVL(ejemploBinAVL.root, 40);
		ejemploBinAVL.root= ejemploBinAVL.insertAVL(ejemploBinAVL.root, 50);
		ejemploBinAVL.root= ejemploBinAVL.insertAVL(ejemploBinAVL.root, 20);
		
		System.out.println("Binario de busqueda AVL");
		
		System.out.println(ejemploBinAVL.search(44, ejemploBinAVL.root));
		System.out.println(ejemploBinAVL.search(12, ejemploBinAVL.root));
		System.out.println(ejemploBinAVL.inOrder(ejemploBinAVL.root));
		
		
		
		

	}

}
