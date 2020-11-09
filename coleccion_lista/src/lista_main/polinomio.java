package lista_main;

import coleccion_lista.List;
import coleccion_lista.ListNode;
import java.util.Scanner;

public class polinomio {

	public static void listRecursiva(ListNode node) {

		if (node.next == null) {
			String x = (String) node.toString();
			System.out.println(x);
		} else {
			String y = (String) node.toString();
			System.out.println(y);
			listRecursiva(node.next);
		}

	}

	public static void main(String[] args) {

		List coeficiente = new List();
		List exponente = new List();
		List polinomio = new List();

		Scanner en = new Scanner(System.in);
		int entrada = en.nextInt();

		while (true) {
			System.out.println("Polinomio");
			System.out.println("LLenar polinomio");

			System.out.println("Digita cuantos coeficientes decea");
			int grado = en.nextInt();

			for (int i = 0; i < grado; i++) {
				System.out.println("Digita coeficiente");
				int coe = en.nextInt();
				System.out.println("Digita exponente");
				int exp = en.nextInt();
				coeficiente.add(coe);
				exponente.add(exp);
			}

			System.out.println("1 Derivar polinomio");
			System.out.println("2 Eliminar coeficiente");
			System.out.println("3 Insertar coeficiente");

			int opcion = en.nextInt();

			ListNode node1 = coeficiente.head;
			ListNode node2 = exponente.head;

			if (opcion == 1) {
				for (int i = 0; i < coeficiente.getSize(); i++) {
					int x = (int) node1.getObject();
					int y = (int) node2.getObject();

					polinomio.add(x * y);
					polinomio.add(y - 1);
					
					node1=node1.next;
					node2=node2.next;

				}
				
				String resultante="";

				for (int i = 0; i < polinomio.getSize(); i = i + 2) {
					
					String x=String.valueOf(polinomio.Index(i));
					String y=String.valueOf(polinomio.Index(i+1));
					String result=x+"X^"+y;
					resultante=resultante+result;
				}
				System.out.println(resultante);
				
			}else if(opcion==2) {
				
			}

		}
	}

}
