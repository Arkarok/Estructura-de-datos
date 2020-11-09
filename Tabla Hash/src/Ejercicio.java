import java.util.Scanner;

public class Ejercicio {

	public static boolean EsPrimo(int n) {
		int a = 0, i;
		for (i = 1; i < (n + 1); i++)
			if (n % i == 0)
				a++;
		if (a != 2)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Ingrese el tamaño de la tabla:");
		int n = sc.nextInt();

		int[] Tablahash = new int[n];

		while (true) {

			System.out.println("Consola");
			System.out.println("Ingresa 1 para agregar valores a la tabla");
			System.out.println("Ingresa 0 para salir de la consola");
			int casos = sc.nextInt();

			if (casos == 1) {

				System.out.println("Ingrese los valores que desea ingresar en la tabla:");
				int entrada = sc.nextInt();

				int mod = entrada % n;

				if (Tablahash[mod] != 0) {
					int caso = 0;
					for (int i = n; i >= 1; i--) {
						boolean r = EsPrimo(i);
						if (r == true) {
							caso = i;
							break;

						}

					}

					mod = entrada % caso;
					if (Tablahash[mod] == 0) {
						Tablahash[mod] = entrada;
					}
				} else {

					Tablahash[mod] = entrada;
				}

			} else if (casos == 0) {
				break;
			}

		}

	}

}
