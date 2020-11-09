package queue;

import list.List;
import list.ListNode;

public class ListQueue implements QueueInterface {

	private List list = new List();
	Object object;

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public Object extract() {
		try {
			object = list.tail;
			list.remove(list.tail);
			return object;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean insert(Object object) {
		try {
			list.insertHead(object);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public int size() {
		return list.getSize();
	}

	@Override
	public boolean search(Object object) {
		return list.contains(object);
	}

	@Override
	public void sort() {
		list.sortList();
	}

	@Override
	public void reverse() {
		ListNode node = list.head;
		List list2 = new List();

		for (int i = 0; i < list.getSize(); i++) {
			Object x = node.getObject();
			list2.insertHead(x);
			node = node.next;
		}
		list = list2;
	}
	
	public Object print() {
		return list.getHead();
	} 
}
