package pila_main;

import java.util.*;

import stack.ListStack;
import list.List;

public class infijaAPostfija {

	public static int valorOperador(String value) {

		if (value.equals("^")) {
			return 3;
		} else if (value.equals("*") || value.equals("/")) {
			return 2;
		} else if (value.equals("+") || value.equals("-")) {
			return 1;
		} else {
			return 0;
		}

	}

	public static void main(String[] args) {

		ListStack pila = new ListStack();

		Scanner en = new Scanner(System.in);

		String entrada = en.next();

		String salida = "";

		List operadores = new List();
		operadores.add("^");
		operadores.add("*");
		operadores.add("/");
		operadores.add("+");
		operadores.add("-");

		for (int i = 0; i < entrada.length(); i++) {

			if (entrada.charAt(i) == '(') {
				pila.push(entrada.charAt(i));
			} else if (entrada.charAt(i) == ')') {
				while (valorOperador(String.valueOf(pila.peek())) >= valorOperador(String.valueOf(entrada.charAt(i)))) {
					String compare = String.valueOf(pila.peek());

					if (compare.equals("(")) {
						pila.pop();
						break;
					}

					compare = String.valueOf(pila.pop());
					salida += compare;
				}
			} else if (operadores.contains(entrada.charAt(i))) {
				if (pila.isEmpty() == true) {
					pila.push(entrada.charAt(i));
				} else if (pila.isEmpty() == false) {
					if (valorOperador(String.valueOf(pila.peek())) >= valorOperador(
							String.valueOf(entrada.charAt(i)))) {
						while (valorOperador(String.valueOf(pila.peek())) >= valorOperador(
								String.valueOf(entrada.charAt(i)))) {
							String compare = String.valueOf(pila.peek());

							if (compare.equals("(")) {
								break;
							}

							compare = String.valueOf(pila.pop());
							salida += compare;
						}
						pila.push(entrada.charAt(i));
					} else {
						pila.push(entrada.charAt(i));
					}
				}
			} else {
				salida += entrada.charAt(i);
			}

		}
		if (pila.isEmpty() == false) {
			while (pila.isEmpty() == false) {
				salida += pila.pop();
			}
		}
		System.out.println(salida);
	}

}
