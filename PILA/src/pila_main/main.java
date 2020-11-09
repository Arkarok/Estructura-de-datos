package pila_main;

import stack.ListStack;

public class main {

	public static void main(String[] args) {
		
		ListStack libreria=new ListStack();
		
		for (int i = 0; i < 6; i++) {
			
			libreria.push(i);
		}
		
		System.out.println("tamaño inicial de la pila: "+libreria.size());
		System.out.println("top inicial de la pila: "+libreria.peek());
		System.out.println("eliminar top inicial de la pila: "+libreria.pop());
		System.out.println("inspeccionar nuevo top de la pila: "+libreria.peek());
		System.out.println("inspeccionar nuevo tamaño de la pila: "+libreria.size());
		

		
		libreria.reverse();
		
		System.out.println("inspeccionar nuevo top de la pila al usar reverse: "+libreria.peek());
		
		ListStack x=new ListStack();
		
		x.push(11);
		x.push(1);
		x.push(4);
		x.push(22);
		
		System.out.println(x.peek());
		x.reverse();
		System.out.println(x.peek());
		x.pop();
		System.out.println(x.peek());
	}

}
