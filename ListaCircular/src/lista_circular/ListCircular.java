package lista_circular;

import java.util.Arrays;
import java.util.Iterator;

public class ListCircular implements ListInterfaceCircular, Iterable<ListNodeCircular> {

	private ListNodeCircular inode;
	private int size;

	public ListNodeCircular head;
	public ListNodeCircular tail;

	public ListCircular() {
		head = null;
		tail = null;
		size = 0;
	}

	public ListCircular(Object object) {
		size = 0;
		add(object);
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
	}

	@Override
	public Object getHead() {
		try {
			Object headCircular = head.getObject();
			return headCircular;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Object getTail() {
		try {
			Object tailCircular = tail.getObject();
			return tailCircular;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Object get(ListNodeCircular node) {
		try {
			ListNodeCircular trail = head;
			if (contains(node)) {
				return null;
			} else {

				while (!trail.isEquals(node)) {
					trail = trail.next;

				}

				return trail;

			}

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Object search(Object object) {
		Iterator<ListNodeCircular> trail = this.iterator();
		ListNodeCircular trailNode;
		while (trail.hasNext()) {

			trailNode = trail.next();
			if (trailNode.getObject().toString().equals(object.toString())) {
				return trailNode;
			}
		}
		return null;
	}

	@Override
	public boolean add(Object object) {
		try {
			if (isEmpty()) {
				head = new ListNodeCircular(object);
				tail = head;
				size++;
			} else {
				tail.next = new ListNodeCircular(object);
				tail = tail.next;

				size++;
				tail.next = head;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean insert(ListNodeCircular node, Object object) {
		try {
			if (!contains(node)) {
				add(object);
			} else {
				ListNodeCircular nodoinsert = new ListNodeCircular(object);
				nodoinsert.next = node.next;

				node.next = nodoinsert;
				size++;
			}
			tail.next = head;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean insert(Object ob, Object object) {
		try {
			if (ob != null) {
				ListNodeCircular trail = (ListNodeCircular) this.search(ob);
				if (trail.next == null) {
					add(object);

				} else {
					ListNodeCircular newNodo = new ListNodeCircular(object);
					newNodo.next = trail.next;
					trail.next = newNodo;
					size++;

					tail.next = head;
				}
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean insertHead(Object object) {
		try {
			if (isEmpty()) {
				head = new ListNodeCircular(object);
				tail = head;
				size++;
			} else {
				ListNodeCircular node = new ListNodeCircular(object);
				node.next = head;
				head = node;
				size++;
				tail.next = head;
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean insertTail(Object object) {
		try {
			if (isEmpty()) {
				head = new ListNodeCircular(object);
				tail = head;
				size++;
			} else {
				tail.next = new ListNodeCircular(object);
				tail = tail.next;
				size++;
				tail.next = head;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean set(ListNodeCircular node, Object object) {
		try {
			if (isEmpty()) {
				return false;
			}
			ListNodeCircular trail = head;
			while (trail != null) {
				trail = trail.next;
				if (trail.equals(node)) {
					trail.setObject(object);
					return true;
				}

			}
			tail.next = head;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public boolean remove(ListNodeCircular node) {
		try {
			ListNodeCircular Temporal = head;
			ListNodeCircular Actual = head;
			if (Actual == node) {
				head = Actual.next;

			} else if (node.isEquals(tail)) {
				tail = (ListNodeCircular) getBeforeTo(tail);
				tail.next = head;

			} else {
				int cont = 0;
				while (cont < size) {

					if (Actual.isEquals(node)) {
						break;
					}
					Temporal = Actual;
					Actual = Actual.next;
					cont++;
				}

				tail = Temporal;
				tail.next = Actual.next;

			}
			size--;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean contains(Object object) {
		try {

			ListNodeCircular trail = head;
			boolean ret = false;
			int cont = 0;
			while (cont < size) {
				trail = trail.next;

				if (trail == object) {
					ret = true;
					break;
				}
				cont++;

			}
			return ret;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isEquals(Object object) {

		return false;
	}

	@Override
	public Iterator<ListNodeCircular> iterator() {
		inode = head;
		Iterator<ListNodeCircular> i = new Iterator<ListNodeCircular>() {
			@Override
			public boolean hasNext() {
				return inode.next != null ? true : false;
			}

			@Override
			public ListNodeCircular next() {
				if (hasNext()) {
					ListNodeCircular tmp = inode;
					inode = inode.next;
					return tmp;
				} else {
					return null;
				}
			}
		};
		return i;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		ListNodeCircular node = head;
		for (int i = 0; i < size; i++) {
			array[i] = node;
			node = node.next;

		}
		return array;
	}

	@Override
	public Object[] toArray(Object[] object) {
		try {
			int size1 = object.length;
			int size2 = size;
			int total = size1 + size2;
			Object[] array = new Object[total];

			for (int i = 0; i < size1; i++) {
				array[i] = object[i];
			}

			Object[] lista = toArray();

			int cont = 0;

			while (size1 < total) {
				array[size1] = lista[cont];
				cont++;
				size1++;
			}

			return array;

		} catch (Exception e) {
			return object;
		}
	}

	@Override
	public Object getBeforeTo() {

		return null;
	}

	@Override
	public Object getBeforeTo(ListNodeCircular node) {
		try {
			ListNodeCircular trail = head;
			ListNodeCircular stop = node;

			while (trail.next != stop) {
				trail = trail.next;
			}
			return trail;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Object getNextTo() {
		return null;
	}

	@Override
	public Object getNextTo(ListNodeCircular node) {
		try {
			if (contains(node)) {

				ListNodeCircular trail = head;
				ListNodeCircular stop = node;

				while (trail != stop) {
					trail = trail.next;
				}

				return trail.next;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ListCircular subList(ListNodeCircular from, ListNodeCircular to) {
		try {

			ListCircular retorno = new ListCircular();
			ListNodeCircular node = head;

			int cont = 0;
			while (cont < size) {
				node = node.next;
				if (node.isEquals(from)) {
					retorno.add(node);
					while (!node.isEquals(to)) {
						node = node.next;
						retorno.add(node);

					}
					break;
				}
				cont++;
			}
			retorno.tail.next = retorno.head;

			return retorno;
		} catch (Exception e) {
			ListCircular vacio = new ListCircular();
			return vacio;
		}
	}

	@Override
	public ListCircular sortList() {
		try {

			ListCircular order = new ListCircular();

			Object[] arary = toArray();
			Arrays.sort(arary);
			clear();

			for (int i = 0; i < size; i++) {
				order.add(arary[i]);

			}

			return order;

		} catch (Exception e) {
			return null;
		}
	}
}
