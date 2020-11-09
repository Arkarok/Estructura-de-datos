package queue;

import queue.QueueInterface;

import java.util.Arrays;

public class ArrayQueue implements QueueInterface {

	private int size;
	private Object[] array;
	private int head, tail;

	public ArrayQueue(int size) {
		this.size = size;
		this.array = new Object[(size > 0) ? size : 2];
		clear();
	}

	private int next(int index) {
		return (++index < size) ? index : 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
		head = 0;
		tail = size - 1;
	}

	@Override
	public boolean isEmpty() {
		return head == next(tail) && array[head] == null;
	}

	private boolean isFull() {
		return head == next(tail) && array[head] != null;
	}

	@Override
	public Object extract() {
		if (!isEmpty()) {
			Object object = array[head];
			array[head] = null;
			head = next(head);
			return object;
		} else {
			return null;
		}
	}

	@Override
	public boolean insert(Object object) {
		if (!isFull()) {
			array[(tail = next(tail))] = object;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean search(Object object) {
		return false;
	}

	@Override
	public void sort() {
		Arrays.sort(array);
	}

	@Override
	public void reverse() {
		Object[] array2 = new Object[array.length];
		int cont = 0;
		for (int i = array2.length - 1; i >= 0; i--) {
			array2[cont] = array[i];
			cont++;
		}
		array = array2;
	}

	@Override
	public String toString() {
		return "queue.ArrayQueue{" + "size=" + size + ", array=" + Arrays.toString(array) + ", head=" + head + ", tail="
				+ tail + '}';
	}
}