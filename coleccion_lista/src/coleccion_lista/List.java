package coleccion_lista;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;



public class List implements ListInterface, Iterable<ListNode> {

	private ListNode inode;
	private int size;

	public ListNode head;
	public ListNode tail;

	public List() {
		head = null;
		tail = null;
		size = 0;
	}

	public List(Object object) {
		add(object);
	}

	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void clear() {

		try {
			Iterator<ListNode> trail = this.iterator();
			for (int i = 0; i < size; i++) {
				trail = null;
			}
		} catch (Exception e) {
			System.out.println("the list is empty");
		}

	}

	@Override
	public Object getHead() {
		Object headTem = head.getObject();

		return headTem;
	}

	@Override
	public Object getTail() {
		Object tailTem = tail.getObject();
		return tailTem;
	}

	@Override
	public Object get(ListNode node) {

		try {
			ListNode trail = head;

			while (trail.next != null) {
				trail = trail.next;

			}

			return trail.getObject();
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Object search(Object object) {
		Iterator<ListNode> i = this.iterator();
		ListNode inode;
		while (i.hasNext()) {

			inode = i.next();
			if (inode.getObject().toString().equals(object.toString())) {
				return inode;
			}
		}
		return null;
	}

	@Override
	public boolean add(Object object) {
		try {
			if (isEmpty()) {
				head = new ListNode(object);
				tail = head;
				size++;
			} else {
				tail.next = new ListNode(object);
				tail = tail.next;
				size++;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean insert(ListNode node, Object object) {

		return false;
	}

	@Override
	public boolean insert(Object ob, Object object) {
		try {
			if (ob != null) {
				ListNode inode = (ListNode) this.search(ob);
				if (inode.next == null) {
					add(object);
				} else {
					ListNode newNode = new ListNode(object);
					newNode.next = inode.next;
					inode.next = newNode;
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
				head = new ListNode(object);
				tail = head;
				size++;
			} else {
				ListNode node = new ListNode(object);
				node.next = head;
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
				head = new ListNode(object);
				tail = head;
				size++;
			} else {
				tail.next = new ListNode(object);
				tail = tail.next;
				size++;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean set(ListNode node, Object object) {

		try {
			if (isEmpty()) {
				return false;
			}
			ListNode trail = head;
			while (trail != null) {
				trail = trail.next;
				if (trail.equals(node)) {
					trail.setObject(object);
					return true;
				}

			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public boolean remove(ListNode node) {

		ListNode Temporal = head;
		ListNode Actual = tail;
		if (isEmpty()) {
			if (head.next == null) {
				head = null;
			}

		} else if (Temporal.equals(node)) {
			head = head.next;
			return true;
		} else {
			while (Temporal.next != null) {

				if (Temporal.toString().equals(node.toString())) {
					Actual.next = Temporal.next;
					return true;
				}
				Actual = Temporal;
				Temporal = Temporal.next;
			}

		}
		return false;

	}

	@Override
	public boolean contains(Object object) {

		try {
			ListNode trail = head;
			boolean retorno = false;
			while (trail.next != null) {
				trail = trail.next;

				if (trail == object) {
					retorno = true;
					break;
				}

			}
			return retorno;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean isEquals(Object object) {

		ListNode pointer = head;
		while (pointer.next != null) {
			if (pointer.getObject().toString().equals(object.toString())) {

			}
			pointer = pointer.next;
			return true;
		}

		return false;

	}

	@Override
	public Iterator<ListNode> iterator() {

		inode = head;
		Iterator<ListNode> i = new Iterator<ListNode>() {
			@Override
			public boolean hasNext() {
				return inode.next != null ? true : false;
			}

			@Override
			public ListNode next() {
				if (hasNext()) {
					ListNode tmp = inode;
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
		ListNode node = head;
		for (int i = 0; i < size; i++) {
			array[i] = node;
			node = node.next;
		}
		return array;
	}

	@Override
	public Object[] toArray(Object[] object) {

		try {
			ListNode trail = head;
			int sizen = object.length;
			int x = 0;

			do {
				trail = trail.next;
				x++;
				object[x] = trail.getObject();
			} while (x <= sizen);

			return object;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Object getBeforeTo() {

		try {
			ListNode trail = head;

			while (trail.next != tail) {
				trail = trail.next;
			}

			return trail;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Object getBeforeTo(ListNode node) {

		try {
			ListNode trail = head;
			ListNode stop = node;

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

		try {
			if (isEmpty()) {
				return null;

			} else {
				return head.next.getObject();
			}

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Object getNextTo(ListNode node) {

		try {
			ListNode trail = head;
			ListNode stop = node;

			while (trail != stop) {
				trail = trail.next;
			}

			return trail.next;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List subList(ListNode from, ListNode to) {

		try {

			List retorno = new List();
			ListNode node = head;

			while (node.next != null) {
				node = node.next;
				if (node == from) {
					retorno.add(node);
					while (node != to) {
						node = node.next;
						retorno.add(node);

					}
					break;
				}
			}

			return retorno;
		} catch (Exception e) {
			List vacio = new List();
			return vacio;
		}
	}

	@Override
	public List sortList() {
		try {

			List order = new List();

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

	public void llenado(int a) {
		add(0);

		if (size != a) {
			llenado(a);
		} else {
		}

	}

	public List mix() {
		List mixs = new List();
		Object[] array = toArray();
		Collections.shuffle(Arrays.asList(array));
		for (int i = 0; i < size; i++) {
			mixs.add(array[i]);
		}
		return mixs;
	}

	public void print() {
		String x = "";
		ListNode node = head;
		while (node != null) {
			x += node.toString() + " " + "\n";
			node = node.next;
		}
		System.out.println(x);
	}

	public int Index(int index) {

		int cont = 0;

		ListNode node = head;

		while (cont != index) {

			node = node.next;
			cont++;
		}
		String a = node.toString();
		int b = Integer.valueOf((String) a);

		return b;
	}

	public void listRecursiva(ListNode node) {

		if (node.next == null) {
			String x = (String) node.toString();
			System.out.println(x);
		} else {
			String y = (String) node.toString();
			System.out.println(y);
			listRecursiva(node.next);
		}

	}

}
