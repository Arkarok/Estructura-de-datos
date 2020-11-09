package queue_main;

import java.util.Scanner;
import queue.ListQueue;

public class prioridad {

	public static void main(String[] args) {

		Scanner en = new Scanner(System.in);
		System.out.println("Cola de prioridad");
		System.out.println("Digita la cantidad de prioridades que habrá");
		int entradap = en.nextInt();

		ListQueue array[] = new ListQueue[entradap];

		for (int i = 0; i < array.length; i++) {
			array[i] = new ListQueue();
		}

		while (true) {

			System.out.println("Digita 1 para ingresar elementos por prioridad");
			System.out.println("Digita 2 para mostrar elementos por prioridad");
			System.out.println("Digita 3 para extraer elementos por prioridad");
			System.out.println("Digita 0 para finalizar");
			int entrada = en.nextInt();

			if (entrada == 0) {
				System.out.println("Salida con exito");
				break;
			} else if (entrada == 1) {

				System.out.println("Digita prioridad del elemento");
				int prioridad = en.nextInt();

				System.out.println("Digita el elemento");
				String elemento = en.next();
				array[prioridad - 1].insert(elemento);

			} else if (entrada == 2) {

				for (int i = 0; i < array.length; i++) {

					if (!array[i].isEmpty()) {
						System.out.println(array[i].print());
					}
				}

			} else if (entrada == 3) {

				for (int i = 0; i < array.length; i++) {

					if (!array[i].isEmpty()) {
						System.out.println(array[i].extract());
					}
				}

			}
		}
	}

}
