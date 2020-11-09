package lista_doble;

import java.awt.List;
import java.util.Arrays;
import java.util.Iterator;



public class ListDoble implements ListDInterface, Iterable<ListDNode> {

	private ListDNode inode;
	private int size;

	public ListDNode head;
	public ListDNode tail;

	public ListDoble() {
		head = null;
		tail = null;
		size = 0;
	}

	public ListDoble(Object object) {
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
			Object headTem = head.getObject();
			return headTem;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Object getTail() {
		try {
			Object tailTem = tail.getObject();
			return tailTem;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Object get(ListDNode node) {
		try {
			ListDNode trail = head;

			while (trail.next != null && trail != node) {
				trail = trail.next;

			}

			return trail.getObject();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Object search(Object object) {
		Iterator<ListDNode> trail = this.iterator();
		ListDNode trailNode;
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
		insertTail(object);
		return true;
	}

	@Override
	public boolean insert(ListDNode node, Object object) {
		try {
			if (node.next == null) {
				add(object);
			} else {
				ListDNode nodoinsert = new ListDNode(object);
				nodoinsert.next = node.next;
				nodoinsert.prev = node;
				node.next = nodoinsert;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean insert(Object ob, Object object) {
		try {
			if (ob != null) {
				ListDNode trail = (ListDNode) this.search(ob);
				if (trail.next == null) {
					add(object);

				} else {
					ListDNode newnode = new ListDNode(object);
					newnode.next = newnode.next;
					trail.next = newnode;
					size++;
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
				head = new ListDNode(object);
				tail = head;
				size++;
			} else {
				ListDNode node = new ListDNode(object);
				node.next = head;
				head.prev = node;
				head = node;
				size++;
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
				head = new ListDNode(object);
				tail = head;
				size++;
			} else {
				tail.next = new ListDNode(object);
				tail.next.prev = tail;
				tail = tail.next;
			}
			size++;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean set(ListDNode node, Object object) {
		try {

			boolean retorno = false;

			ListDNode nodo = head;
			ListDNode nodu = head.prev;

			while (nodo != null) {
				if (nodo.isEquals(node.getObject())) {

					ListDNode nuevo = new ListDNode(object);
					nuevo.prev = nodu;
					nuevo.next = nodo.next;

					if (nodu == null) {
						head = nuevo;

					} else {
						nodu.next = nuevo;

					}

					retorno = true;
					break;
				}
				nodo = nodo.next;
				nodu = nodo.prev;

			}

			return retorno;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean remove(ListDNode node) {
		try {
			ListDNode Temporal = head;
			ListDNode Actual = head;
			if (Actual == node) {
				head = Actual.next;
				head.prev = null;

			} else {
				while (Actual.next != null) {

					if (Actual == node) {
						break;
					}
					Temporal = Actual;
					Actual = Actual.next;
				}

				tail = Temporal;
				Actual.next.prev = tail;
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
			ListDNode trail = head;
			boolean ret = false;
			while (trail.next != null) {
				trail = trail.next;

				if (trail == object) {
					ret = true;
					break;
				}

			}
			return ret;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Iterator<ListDNode> iterator() {
		inode = head;
		Iterator<ListDNode> i = new Iterator<ListDNode>() {
			@Override
			public boolean hasNext() {
				return inode.next != null ? true : false;
			}

			@Override
			public ListDNode next() {
				if (hasNext()) {
					ListDNode tmp = inode;
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
		try {
			Object[] array = new Object[size];
			ListDNode node = head;
			for (int i = 0; i < size; i++) {
				array[i] = node;
				node = node.next;

			}
			return array;
		} catch (Exception e) {
			Object[] objet = new Object[size];
			return objet;
		}

	}

	@Override
	public Object[] toArray(Object[] object) {
		try {

			int size1 = object.length;
			int size2 = size;
			int suma = size1 + size2;
			Object[] array = new Object[suma];

			for (int i = 0; i < size1; i++) {
				array[i] = object[i];
			}

			Object[] list = toArray();

			int cont = 0;

			while (size1 < suma) {
				array[size1] = list[cont];
				cont++;
				size1++;
			}

			return array;

		} catch (Exception e) {
			return object;
		}

	}

	@Override
	public Object getBeforeTo(ListDNode node) {
		try {
			ListDNode trail = head;
			ListDNode stop = node;

			while (trail != stop) {
				trail = trail.next;
			}
			return trail.prev;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Object getNextTo(ListDNode node) {
		try {
			ListDNode trail = head;
			ListDNode stop = node;

			while (trail != stop) {
				trail = trail.next;
			}

			return trail.next;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ListDoble subList(ListDNode from, ListDNode to) {
		try {

			ListDoble retn = new ListDoble();
			ListDNode node = head;

			while (node.next != null) {
				node = node.next;
				if (node == from) {
					retn.add(node);
					while (node != to) {
						node = node.next;
						retn.add(node);

					}
					break;
				}
			}

			retn.head.prev = null;
			retn.tail.next = null;

			return retn;
		} catch (Exception e) {
			ListDoble vac = new ListDoble();
			return vac;
		}
	}

	@Override
	public ListDoble sortList() {

		try {
			ListDoble sort = new ListDoble();

			Object[] arary = toArray();
			Arrays.sort(arary);
			clear();

			for (int i = 0; i < size; i++) {
				sort.add(arary[i]);

			}

			return sort;
		} catch (Exception e) {
			return null;
		}

	}
	
	public void print() {
		String x = "";
		ListDNode node = head;
		while (node != null) {
			x += node.toString() + " " + "\n";
			node = node.next;
		}
		System.out.println(x);
	}

}
