package lista_main;

import coleccion_lista.List;

import coleccion_lista.ListNode;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void listRecursiva(ListNode node) {

		if (node.next == null) {
			String x=(String)node.toString();
			System.out.println(x);
		} else {
			String y=(String)node.toString();
			System.out.println(y);
			listRecursiva(node.next);
		}

	}

	public static void sumaList(String x, String y, List list1, List list2) {

		for (int i = x.length() - 1; i >= 0; i--) {
			list1.add(x.charAt(i));
		}

		for (int i = y.length() - 1; i >= 0; i--) {
			list2.add(y.charAt(i));
		}

		if (list1.getSize() != list2.getSize()) {
			if (list1.getSize() < list2.getSize()) {
				list1.llenado(list2.getSize());
			} else {
				list2.llenado(list1.getSize());
			}

		}

		ListNode nodnum = list1.head;
		ListNode nodnom = list2.head;
		String s = "";
		int cociente = 0;
		for (int i = 1; i <= list1.getSize(); i++) {

			int n = Integer.valueOf(String.valueOf(nodnum.getObject()));
			int m = Integer.valueOf(String.valueOf(nodnom.getObject()));
			int value = n + m + cociente;

			if (value > 9 && nodnum.next != null) {
				int residuo = value % 10;
				cociente = value / 10;
				String p = String.valueOf(residuo);
				String q = String.valueOf(cociente);
				s += residuo;
				nodnum = nodnum.next;
				nodnom = nodnom.next;
			} else if (value > 9 && nodnum.next == null) {
				s += value - 10;
				s += 1;
			} else {
				s += value;
				cociente = 0;
			}
		}
		String se = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			se = se + s.charAt(i);
		}
		System.out.println(se);
	}

	public static void productoList(String x, String y, List list1, List list2) {

		for (int i = x.length() - 1; i >= 0; i--) {
			list1.add(x.charAt(i));
		}

		for (int i = y.length() - 1; i >= 0; i--) {
			list2.add(y.charAt(i));
		}

		if (list1.getSize() != list2.getSize()) {
			if (list1.getSize() < list2.getSize()) {
				list1.llenado(list2.getSize());
			} else {
				list2.llenado(list1.getSize());
			}

		}

		ListNode nodnum = list1.head;
		ListNode nodnom = list2.head;
		String s = "";
		int cociente = 0;
		for (int i = 1; i <= list1.getSize(); i++) {

			int n = Integer.valueOf(String.valueOf(nodnum.getObject()));
			int m = Integer.valueOf(String.valueOf(nodnom.getObject()));
			int value = n * m + cociente;

			if (value > 9 && nodnum.next != null) {
				int residuo = value % 10;
				cociente = value / 10;
				String p = String.valueOf(residuo);
				String q = String.valueOf(cociente);
				s += residuo;
				nodnum = nodnum.next;
				nodnom = nodnom.next;
			} else if (value > 9 && nodnum.next == null) {
				s += value;
				s += 1;
			} else {
				s += value;
				cociente = 0;
			}
		}
		String se = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			se = se + s.charAt(i);
		}
		System.out.println(se);
	}

	public static void main(String[] args) {

		///////////////////////////////////////////////////////////////

		// Solucion primer punto

		List recursiva = new List();

		for (int i = 0; i <= 10; i++) {
			recursiva.add(i);
		}

		ListNode node = recursiva.head;

		System.out.println("Solucion primer punto");
		listRecursiva(node);
		System.out.println();

		//////////////////////////////////////////////////////////////

		// Solucion segundo punto
		System.out.println("Solucion segundo punto");
		List cartas = new List();
		cartas.add("A♠");
		cartas.add("2♠");
		cartas.add("3♠");
		cartas.add("4♠");
		cartas.add("5♠");
		cartas.add("6♠");
		cartas.add("7♠");
		cartas.add("8♠");
		cartas.add("9♠");
		cartas.add("10♠");
		cartas.add("J♠");
		cartas.add("Q♠");
		cartas.add("K♠");
		cartas.add("A♣");
		cartas.add("2♣");
		cartas.add("3♣");
		cartas.add("4♣");
		cartas.add("5♣");
		cartas.add("6♣");
		cartas.add("7♣");
		cartas.add("8♣");
		cartas.add("9♣");
		cartas.add("10♣");
		cartas.add("J♣");
		cartas.add("Q♣");
		cartas.add("K♣");
		cartas.add("A♥");
		cartas.add("2♥");
		cartas.add("3♥");
		cartas.add("4♥");
		cartas.add("5♥");
		cartas.add("6♥");
		cartas.add("7♥");
		cartas.add("8♥");
		cartas.add("9♥");
		cartas.add("10♥");
		cartas.add("J♥");
		cartas.add("Q♥");
		cartas.add("K♥");
		cartas.add("A♦");
		cartas.add("2♦");
		cartas.add("3♦");
		cartas.add("4♦");
		cartas.add("5♦");
		cartas.add("6♦");
		cartas.add("7♦");
		cartas.add("8♦");
		cartas.add("9♦");
		cartas.add("10♦");
		cartas.add("J♦");
		cartas.add("Q♦");
		cartas.add("K♦");

		List mix = new List();

		while (true) {

			System.out.println("Baraja, digita la opcion que deceas realizar");
			System.out.println("0 para salir del menu");
			System.out.println("1 para revolver");
			System.out.println("2 ordenar por palo");
			Scanner sce = new Scanner(System.in);
			int entrada = sce.nextInt();

			if (entrada == 0) {
				break;
			}

			if (entrada == 1) {
				System.out.println("Digita el numero de veces que deceas revolver la baraja");
				Scanner t = new Scanner(System.in);
				int en = sce.nextInt();

				for (int i = 0; i < en; i++) {
					cartas.mix();
					mix = cartas.mix();
				}
				mix.print();
			} else if (entrada == 2) {
				System.out.println("Por que palo deceas ordenar");
				System.out.println("1 para ♠");
				System.out.println("2 para ♣");
				System.out.println("3 para ♥");
				System.out.println("4 para ♦");
				Scanner t = new Scanner(System.in);
				int en = sce.nextInt();

				switch (en) {
				case 1:
					ListNode nodes = cartas.head;
					while (nodes != null) {

						String x = (String) nodes.getObject();

						for (int i = 0; i < x.length(); i++) {

							if (x.charAt(i) == '♠') {
								System.out.println(x);

							}
						}
						nodes = nodes.next;
					}
					break;
				case 2:
					ListNode nod = cartas.head;
					while (nod != null) {

						String x = (String) nod.getObject();

						for (int i = 0; i < x.length(); i++) {

							if (x.charAt(i) == '♣') {
								System.out.println(x);

							}

						}
						nod = nod.next;
					}
					break;
				case 3:
					ListNode noed = cartas.head;
					while (noed != null) {

						String x = (String) noed.getObject();

						for (int i = 0; i < x.length(); i++) {

							if (x.charAt(i) == '♥') {
								System.out.println(x);

							}

						}
						noed = noed.next;
					}
					break;
				case 4:
					ListNode no = cartas.head;
					while (no != null) {

						String x = (String) no.getObject();

						for (int i = 0; i < x.length(); i++) {

							if (x.charAt(i) == '♦') {
								System.out.println(x);

							}

						}
						no = no.next;
					}
					break;
				}
			}
		}

		//////////////////////////////////////////////////////////////

		// Solucion tercer punto

		System.out.println();
		System.out.println("Solucion tercer Punto");
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("Calculadora, digita la operacion que deceas realizar");
			System.out.println("+ para sumar");
			System.out.println("* para multiplicar");
			System.out.println("0 para salir del menu");
			Scanner sce = new Scanner(System.in);
			String entrada = sce.next();

			if (entrada.equals("0")) {
				break;
			}

			if (entrada.equals("+")) {
				List num1 = new List();
				List num2 = new List();
				System.out.println("Digita los valores a sumar");
				String x = sc.next();
				String y = sc.next();

				sumaList(x, y, num1, num2);

			} else if (entrada.equals("*")) {
				List num1 = new List();
				List num2 = new List();
				System.out.println("Digita los valores a multiplicar");
				String x = sc.next();
				String y = sc.next();

				productoList(x, y, num1, num2);
			}
		}
		//////////////////////////////////////////////////////////////

		// Solucion cuarto punto

		System.out.println();
		System.out.println("Solucion cuarto punto");

		while (true) {

			System.out.println("Vector disperso");
			System.out.println("1 para hallar producto escalar");
			System.out.println("2 para hallar suma de vectores");
			System.out.println("0 para salir del menu");
			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();

			if (n == 0) {
				break;
			}

			if (n == 1) {
				System.out.println("Digita la dimension de tus vectores");
				int d = scan.nextInt();
				List vectorUno = new List();
				List vectorDos = new List();
				List vectorResultante = new List();

				System.out.println("llenar primer vector");
				for (int i = 0; i < d; i++) {
					String s = scan.next();
					vectorUno.add(s);
				}
				System.out.println("llenar segundo vector");
				for (int i = 0; i < d; i++) {
					String s = scan.next();
					vectorDos.add(s);
				}

				ListNode nodov1 = vectorUno.head;
				ListNode nodov2 = vectorDos.head;

				for (int i = 0; i < d; i++) {
					int x = Integer.valueOf((String) nodov1.getObject());
					int y = Integer.valueOf((String) nodov2.getObject());

					vectorResultante.add(x * y);
					nodov1 = nodov1.next;
					nodov2 = nodov2.next;
				}

				ListNode nodovResult = vectorResultante.head;

				System.out.println("El producto escalar es:");
				int productoEscalar = 0;
				for (int i = 0; i < vectorResultante.getSize(); i++) {
					int y = (int) nodovResult.getObject();
					productoEscalar += y;
					nodovResult = nodovResult.next;
				}
				System.out.println(productoEscalar);
			} else if (n == 2) {
				System.out.println("Digita la dimension de tus vectores");
				int d = scan.nextInt();
				List vectorUno = new List();
				List vectorDos = new List();
				List vectorResultante = new List();

				System.out.println("llenar primer vector");
				for (int i = 0; i < d; i++) {
					String s = scan.next();
					vectorUno.add(s);
				}
				System.out.println("llenar segundo vector");
				for (int i = 0; i < d; i++) {
					String s = scan.next();
					vectorDos.add(s);
				}

				ListNode nodov1 = vectorUno.head;
				ListNode nodov2 = vectorDos.head;

				for (int i = 0; i < d; i++) {
					int x = Integer.valueOf((String) nodov1.getObject());
					int y = Integer.valueOf((String) nodov2.getObject());

					vectorResultante.add(x + y);
				}
				System.out.println("La suma de vectores es:");
				ListNode nodovResult = vectorResultante.head;
				listRecursiva(nodovResult);

			}
		}

	}
}
