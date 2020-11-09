package lista_main;

import java.util.Date;
import java.util.Scanner;

import coleccion_lista.List;
import coleccion_lista.ListNode;

public class Parcial {

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

		int id1 = 100;
		int id2 = 100;
		List vueloBuBo = new List();// la id avion es:10014
		List vueloBuCu = new List();// la id avion es:10017
		List puestos1 = new List();
		List puestos2 = new List();

		Date limite1 = new Date(); // No olvidar cambiar fecha a 16:30
		limite1.setHours(16);
		limite1.setMinutes(30);

		Date limite2 = new Date(); // No olvidar cambiar fecha a 13:30
		limite2.setHours(13);
		limite2.setMinutes(30);

		for (int i = 1; i <= 136; i++) {
			puestos1.add(i);

		}
		ListNode nodePuesto = puestos1.head;

		for (int i = 1; i <= 136; i++) {
			puestos2.add(i);

		}
		ListNode nodePuesto2 = puestos2.head;

		while (true) {

			System.out.println("Bienvenido a la aerolinea AV-UPB");
			System.out.println("¿Que accion deseas realizar?");
			System.out.println("Digita ADMIN para usuario administrador");
			System.out.println("Digita CLIENTE para usuario cliente");
			System.out.println("Digita CANCEL para salir del menu");
			Scanner en = new Scanner(System.in);
			String entrada = en.next();

			if (entrada.toUpperCase().equals("CANCEL")) {
				break;
			}

			if (entrada.toUpperCase().equals("ADMIN")) {
				System.out.println("1 para generar reporte de pasajero en especifico");
				System.out.println("2 para generar reporte de cada vuelo ordenada por id de pasajero");
				System.out.println("0 para salir del menu");
				int op = en.nextInt();

				if (op == 0) {
					break;
				}

				if (op == 1) {
					System.out.println("Digita el vuelo que deseas consultar");
					System.out.println("1 para vuelo Bucaramanga-Bogota");
					System.out.println("2 para vuelo Bucaramanga-Cucuta");
					int conV = en.nextInt();

					if (conV == 1) {
						System.out.println("Digita la ID de registro del pasajero que deceas consultar");
						String conId = en.next();
						ListNode x = vueloBuBo.head;
						boolean s = true;
						for (int i = 0; i < vueloBuBo.getSize(); i++) {
							List xn = (List) x.getObject();
							ListNode y = xn.head;
							for (int j = 0; j < xn.getSize(); j++) {
								String parc = String.valueOf(y.getObject());
								if (conId.equals(parc)) {
									s = false;
									break;
								}
								y = y.next;
							}

							if (s == false) {
								xn.print();
								break;
							}
							x = x.next;
						}
					} else if (conV == 2) {
						System.out.println("Digita la ID de registro del pasajero que deceas consultar");
						String conId = en.next();
						ListNode x = vueloBuCu.head;
						boolean s = true;
						for (int i = 0; i < vueloBuCu.getSize(); i++) {
							List xn = (List) x.getObject();
							ListNode y = xn.head;
							for (int j = 0; j < xn.getSize(); j++) {
								String parc = String.valueOf(y.getObject());
								if (conId.equals(parc)) {
									s = false;
									break;
								}
								y = y.next;
							}

							if (s == false) {
								xn.print();
								break;
							}
							x = x.next;
						}

					}

				} else if (op == 2) {
					System.out.println("Digita el vuelo que deceas consultar");
					System.out.println("1 para vuelo Bucaramanga-Bogota");
					System.out.println("2 para vuelo Bucaramanga-Cucuta");
					int conV = en.nextInt();

					if (conV == 1) {
						ListNode vueloN = vueloBuBo.head;
						for (int i = 0; i < vueloBuBo.getSize(); i++) {
							List valorP = (List) vueloN.getObject();
							valorP.print();
							vueloN = vueloN.next;
						}
					} else if (conV == 2) {
						ListNode vueloN = vueloBuCu.head;
						for (int i = 0; i < vueloBuCu.getSize(); i++) {
							List valorP = (List) vueloN.getObject();
							valorP.print();
							vueloN = vueloN.next;
						}
					}
				}

			} else if (entrada.toUpperCase().equals("CLIENTE")) {
				System.out.println("Los vuelos disponibles son:");
				System.out.println("Bucaramanga-Bogota 17:00 pm a 19:00 pm");
				System.out.println("Bucaramanga-Cucuta 14:00 pm a 14:50 pm");
				System.out.println("Digita el vuelo que deceas tomar");
				System.out.println("1 para tomar el vuelo Bucaramanga-Bogota");
				System.out.println("2 para tomar el vuelo Bucaramanga-Cucuta");
				System.out.println("0 para salir del menu");
				int vuelo = en.nextInt();

				if (vuelo == 0) {
					break;
				}

				if (vuelo == 1) {

					System.out.println("Digita el peso de tu maleta:");
					int maleta = en.nextInt();
					if (maleta > 52) {
						System.out.println("Lo sentimos el peso no es adecuado para abordar");
						break;
					}

					System.out.println("Que tipo de vuelo deceas:");
					System.out.println("1 para Premium");
					System.out.println("2 para Ejecutivo");
					System.out.println("3 para Economico");
					int tipoVuelo = en.nextInt();
					if (tipoVuelo == 1) {
						System.out.println("Cuantos pasajeros decea registrar");
						int cantidadP = en.nextInt();
						System.out.println("Digita informacion del pasajero");

						for (int i = 0; i < cantidadP; i++) {
							List pasajero = new List();
							pasajero.add(id1);
							Date fecha = new Date();
							pasajero.add(fecha);
							if (!fecha.before(limite1)) {
								System.out.println("Lo sentimos ya no puedes generar un registro para abordaje");
								break;
							}
							pasajero.add("17:00 pm a 19:00 pm");
							System.out.println("Digita nombre del pasajero");
							String nombre = en.next();
							pasajero.add(nombre);
							System.out.println("Digita apellido del pasajero");
							String apellido = en.next();
							pasajero.add(apellido);
							System.out.println("Digita tipo de documento del pasajero");
							String tipoDocumento = en.next();
							pasajero.add(tipoDocumento);
							System.out.println("Digita numero de documento");
							int numDoc = en.nextInt();
							pasajero.add(numDoc);
							System.out.println("Digita direccion del pasajero");
							String direccion = en.next();
							pasajero.add(direccion);
							System.out.println("Digita telefono del pasajero");
							int telefono = en.nextInt();
							pasajero.add(telefono);
							pasajero.add("10014");
							listRecursiva(nodePuesto);
							System.out.println("Digita puesto del pasajero");
							int puesto = en.nextInt();
							pasajero.add(puesto);
							pasajero.add("Premium");
							pasajero.add("7.000.000");
							pasajero.add(maleta);
							System.out.println("Digita nombre de contacto del pasajero");
							String nombreC = en.next();
							pasajero.add(nombreC);
							System.out.println("Digita apellido de contacto del pasajero");
							String apellidoC = en.next();
							pasajero.add(apellidoC);
							System.out.println("Digita direccion de contacto del pasajero");
							String direccionC = en.next();
							pasajero.add(direccionC);
							System.out.println("Digita telefono de contacto del pasajero");
							int telefonoC = en.nextInt();
							pasajero.add(telefonoC);
							vueloBuBo.add(pasajero);
							id1++;
							ListNode nodePuesto1 = puestos1.head;
							while (nodePuesto1 != null) {
								int x = (int) nodePuesto1.getObject();
								if (puesto == x) {
									puestos1.remove(nodePuesto1);
									break;
								}
								nodePuesto1 = nodePuesto1.next;
							}
						}

					} else if (tipoVuelo == 2) {

						System.out.println("Cuantos pasajeros decea registrar");
						int cantidadP = en.nextInt();
						System.out.println("Digita informacion del pasajero");

						for (int i = 0; i < cantidadP; i++) {
							List pasajero = new List();
							pasajero.add(id1);
							Date fecha = new Date();
							pasajero.add(fecha);
							if (!fecha.before(limite1)) {
								System.out.println("Lo sentimos ya no puedes generar un registro para abordaje");
								break;
							}
							pasajero.add("17:00 pm a 19:00 pm");
							System.out.println("Digita nombre del pasajero");
							String nombre = en.next();
							pasajero.add(nombre);
							System.out.println("Digita apellido del pasajero");
							String apellido = en.next();
							pasajero.add(apellido);
							System.out.println("Digita tipo de documento del pasajero");
							String tipoDocumento = en.next();
							pasajero.add(tipoDocumento);
							System.out.println("Digita numero de documento");
							int numDoc = en.nextInt();
							pasajero.add(numDoc);
							System.out.println("Digita direccion del pasajero");
							String direccion = en.next();
							pasajero.add(direccion);
							System.out.println("Digita telefono del pasajero");
							int telefono = en.nextInt();
							pasajero.add(telefono);
							pasajero.add("10014");
							listRecursiva(nodePuesto);
							System.out.println("Digita puesto del pasajero");
							int puesto = en.nextInt();
							pasajero.add(puesto);
							pasajero.add("Ejecutivo");
							pasajero.add("300.000");
							pasajero.add(maleta);
							System.out.println("Digita nombre de contacto del pasajero");
							String nombreC = en.next();
							pasajero.add(nombreC);
							System.out.println("Digita apellido de contacto del pasajero");
							String apellidoC = en.next();
							pasajero.add(apellidoC);
							System.out.println("Digita direccion de contacto del pasajero");
							String direccionC = en.next();
							pasajero.add(direccionC);
							System.out.println("Digita telefono de contacto del pasajero");
							int telefonoC = en.nextInt();
							pasajero.add(telefonoC);
							vueloBuBo.add(pasajero);
							id1++;
							ListNode nodePuesto1 = puestos1.head;
							while (nodePuesto1 != null) {
								int x = (int) nodePuesto1.getObject();
								if (puesto == x) {
									puestos1.remove(nodePuesto1);
									break;
								}
								nodePuesto1 = nodePuesto1.next;
							}

						}

					} else if (tipoVuelo == 3) {
						System.out.println("Cuantos pasajeros decea registrar");
						int cantidadP = en.nextInt();
						System.out.println("Digita informacion del pasajero");

						for (int i = 0; i < cantidadP; i++) {
							List pasajero = new List();
							pasajero.add(id1);
							Date fecha = new Date();
							pasajero.add(fecha);
							if (!fecha.before(limite1)) {
								System.out.println("Lo sentimos ya no puedes generar un registro para abordaje");
								break;
							}
							pasajero.add("17:00 pm a 19:00 pm");
							System.out.println("Digita nombre del pasajero");
							String nombre = en.next();
							pasajero.add(nombre);
							System.out.println("Digita apellido del pasajero");
							String apellido = en.next();
							pasajero.add(apellido);
							System.out.println("Digita tipo de documento del pasajero");
							String tipoDocumento = en.next();
							pasajero.add(tipoDocumento);
							System.out.println("Digita numero de documento");
							int numDoc = en.nextInt();
							pasajero.add(numDoc);
							System.out.println("Digita direccion del pasajero");
							String direccion = en.next();
							pasajero.add(direccion);
							System.out.println("Digita telefono del pasajero");
							int telefono = en.nextInt();
							pasajero.add(telefono);
							pasajero.add("10014");
							listRecursiva(nodePuesto);
							System.out.println("Digita puesto del pasajero");
							int puesto = en.nextInt();
							pasajero.add(puesto);
							pasajero.add("Economico");
							pasajero.add("120.000");
							pasajero.add(maleta);
							System.out.println("Digita nombre de contacto del pasajero");
							String nombreC = en.next();
							pasajero.add(nombreC);
							System.out.println("Digita apellido de contacto del pasajero");
							String apellidoC = en.next();
							pasajero.add(apellidoC);
							System.out.println("Digita direccion de contacto del pasajero");
							String direccionC = en.next();
							pasajero.add(direccionC);
							System.out.println("Digita telefono de contacto del pasajero");
							int telefonoC = en.nextInt();
							pasajero.add(telefonoC);
							vueloBuBo.add(pasajero);
							id1++;
							ListNode nodePuesto1 = puestos1.head;
							while (nodePuesto1 != null) {
								int x = (int) nodePuesto1.getObject();
								if (puesto == x) {
									puestos1.remove(nodePuesto1);
									break;
								}
								nodePuesto1 = nodePuesto1.next;
							}
						}

					}

					System.out.println("BGA/CU: " + vueloBuCu.getSize());
					System.out.println("BGA/BO: " + vueloBuBo.getSize());
				} else if (vuelo == 2) {

					System.out.println("Digita el peso de tu maleta:");
					int maleta = en.nextInt();
					if (maleta > 52) {
						System.out.println("Lo sentimos el peso no es adecuado para abordar");
						break;
					}

					System.out.println("Que tipo de vuelo deceas:");
					System.out.println("1 para Premium");
					System.out.println("2 para Ejecutivo");
					System.out.println("3 para Economico");
					int tipoVuelo = en.nextInt();
					if (tipoVuelo == 1) {
						System.out.println("Cuantos pasajeros decea registrar");
						int cantidadP = en.nextInt();
						System.out.println("Digita informacion del pasajero");

						for (int i = 0; i < cantidadP; i++) {
							List pasajero = new List();
							pasajero.add(id2);
							Date fecha = new Date();
							pasajero.add(fecha);
							if (!fecha.before(limite2)) {
								System.out.println("Lo sentimos ya no puedes generar un registro para abordaje");
								break;
							}
							pasajero.add("14:00 pm a 14:50 pm");
							System.out.println("Digita nombre del pasajero");
							String nombre = en.next();
							pasajero.add(nombre);
							System.out.println("Digita apellido del pasajero");
							String apellido = en.next();
							pasajero.add(apellido);
							System.out.println("Digita tipo de documento del pasajero");
							String tipoDocumento = en.next();
							pasajero.add(tipoDocumento);
							System.out.println("Digita numero de documento");
							int numDoc = en.nextInt();
							pasajero.add(numDoc);
							System.out.println("Digita direccion del pasajero");
							String direccion = en.next();
							pasajero.add(direccion);
							System.out.println("Digita telefono del pasajero");
							int telefono = en.nextInt();
							pasajero.add(telefono);
							pasajero.add("10017");
							listRecursiva(nodePuesto2);
							System.out.println("Digita puesto del pasajero");
							int puesto = en.nextInt();
							pasajero.add(puesto);
							pasajero.add("Premiun");
							pasajero.add("7.000.000");
							pasajero.add(maleta);
							System.out.println("Digita nombre de contacto del pasajero");
							String nombreC = en.next();
							pasajero.add(nombreC);
							System.out.println("Digita apellido de contacto del pasajero");
							String apellidoC = en.next();
							pasajero.add(apellidoC);
							System.out.println("Digita direccion de contacto del pasajero");
							String direccionC = en.next();
							pasajero.add(direccionC);
							System.out.println("Digita telefono de contacto del pasajero");
							int telefonoC = en.nextInt();
							pasajero.add(telefonoC);
							vueloBuCu.add(pasajero);
							id2++;
							ListNode nodePuesto1 = puestos2.head;
							while (nodePuesto1 != null) {
								int x = (int) nodePuesto1.getObject();
								if (puesto == x) {
									puestos2.remove(nodePuesto1);
									break;
								}
								nodePuesto1 = nodePuesto1.next;
							}
						}

					} else if (tipoVuelo == 2) {
						System.out.println("Cuantos pasajeros decea registrar");
						int cantidadP = en.nextInt();
						System.out.println("Digita informacion del pasajero");

						for (int i = 0; i < cantidadP; i++) {
							List pasajero = new List();
							pasajero.add(id2);
							Date fecha = new Date();
							pasajero.add(fecha);
							if (!fecha.before(limite2)) {
								System.out.println("Lo sentimos ya no puedes generar un registro para abordaje");
								break;
							}
							pasajero.add("14:00 pm a 14:50 pm");
							System.out.println("Digita nombre del pasajero");
							String nombre = en.next();
							pasajero.add(nombre);
							System.out.println("Digita apellido del pasajero");
							String apellido = en.next();
							pasajero.add(apellido);
							System.out.println("Digita tipo de documento del pasajero");
							String tipoDocumento = en.next();
							pasajero.add(tipoDocumento);
							System.out.println("Digita numero de documento");
							int numDoc = en.nextInt();
							pasajero.add(numDoc);
							System.out.println("Digita direccion del pasajero");
							String direccion = en.next();
							pasajero.add(direccion);
							System.out.println("Digita telefono del pasajero");
							int telefono = en.nextInt();
							pasajero.add(telefono);
							pasajero.add("10017");
							listRecursiva(nodePuesto2);
							System.out.println("Digita puesto del pasajero");
							int puesto = en.nextInt();
							pasajero.add(puesto);
							pasajero.add("Ejecutivo");
							pasajero.add("300.000");
							pasajero.add(maleta);
							System.out.println("Digita nombre de contacto del pasajero");
							String nombreC = en.next();
							pasajero.add(nombreC);
							System.out.println("Digita apellido de contacto del pasajero");
							String apellidoC = en.next();
							pasajero.add(apellidoC);
							System.out.println("Digita direccion de contacto del pasajero");
							String direccionC = en.next();
							pasajero.add(direccionC);
							System.out.println("Digita telefono de contacto del pasajero");
							int telefonoC = en.nextInt();
							pasajero.add(telefonoC);
							vueloBuCu.add(pasajero);
							id2++;
							ListNode nodePuesto1 = puestos2.head;
							while (nodePuesto1 != null) {
								int x = (int) nodePuesto1.getObject();
								if (puesto == x) {
									puestos2.remove(nodePuesto1);
									break;
								}
								nodePuesto1 = nodePuesto1.next;
							}
						}

					} else if (tipoVuelo == 3) {
						System.out.println("Cuantos pasajeros decea registrar");
						int cantidadP = en.nextInt();
						System.out.println("Digita informacion del pasajero");

						for (int i = 0; i < cantidadP; i++) {
							List pasajero = new List();
							pasajero.add(id2);
							Date fecha = new Date();
							pasajero.add(fecha);
							if (!fecha.before(limite2)) {
								System.out.println("Lo sentimos ya no puedes generar un registro para abordaje");
								break;
							}
							pasajero.add("14:00 pm a 14:50 pm");
							System.out.println("Digita nombre del pasajero");
							String nombre = en.next();
							pasajero.add(nombre);
							System.out.println("Digita apellido del pasajero");
							String apellido = en.next();
							pasajero.add(apellido);
							System.out.println("Digita tipo de documento del pasajero");
							String tipoDocumento = en.next();
							pasajero.add(tipoDocumento);
							System.out.println("Digita numero de documento");
							int numDoc = en.nextInt();
							pasajero.add(numDoc);
							System.out.println("Digita direccion del pasajero");
							String direccion = en.next();
							pasajero.add(direccion);
							System.out.println("Digita telefono del pasajero");
							int telefono = en.nextInt();
							pasajero.add(telefono);
							pasajero.add("10017");
							listRecursiva(nodePuesto2);
							System.out.println("Digita puesto del pasajero");
							int puesto = en.nextInt();
							pasajero.add(puesto);
							pasajero.add("Economico");
							pasajero.add("120.000");
							pasajero.add(maleta);
							System.out.println("Digita nombre de contacto del pasajero");
							String nombreC = en.next();
							pasajero.add(nombreC);
							System.out.println("Digita apellido de contacto del pasajero");
							String apellidoC = en.next();
							pasajero.add(apellidoC);
							System.out.println("Digita direccion de contacto del pasajero");
							String direccionC = en.next();
							pasajero.add(direccionC);
							System.out.println("Digita telefono de contacto del pasajero");
							int telefonoC = en.nextInt();
							pasajero.add(telefonoC);
							vueloBuCu.add(pasajero);
							id2++;
							ListNode nodePuesto1 = puestos2.head;
							while (nodePuesto1 != null) {
								int x = (int) nodePuesto1.getObject();
								if (puesto == x) {
									puestos2.remove(nodePuesto1);
									break;
								}
								nodePuesto1 = nodePuesto1.next;
							}

						}

					}

					System.out.println("BGA/CU: " + vueloBuCu.getSize());
					System.out.println("BGA/BO: " + vueloBuBo.getSize());
				}

			}

		}

	}

}
