package queue_main;

import queue.ListQueue;

public class main {

	public static void main(String[] args) {

		ListQueue cola = new ListQueue();

		for (int i = 1; i < 6; i++) {

			cola.insert(i);
		}
		
		System.out.println(cola.extract());
		
		ListQueue x = new ListQueue();
		
		x.insert(14);
		x.insert(12);
		x.insert(2);
		
		System.out.println(x.extract());
		System.out.println(x.extract());
		
		
	}

}
