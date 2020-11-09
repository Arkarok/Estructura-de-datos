package lista_doble;

public class ListDNode {

	private Object object;
	public ListDNode next;
	public ListDNode prev;

	public ListDNode() {
		this.object = null;
		this.next = null;
		this.prev = null;
	}

	public ListDNode(Object object) {
		this.object = object;
		this.next = null;
		this.prev = null;
	}

	public ListDNode(Object object, ListDNode next, ListDNode prev) {
		this.object = object;
		this.next = next;
		this.prev = prev;
	}

	public boolean isEquals(Object compare) {
		Object com = this.object;
		Object composition = compare;
		if (String.valueOf(com).equals(String.valueOf(composition))) {
			return true;
		} else {

			return false;
		}

	}

	public Object getNextTo() {

		return next;

	}

	public Object getBeforeTo() {

		return prev;

	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return String.valueOf(object);

	}
}
