package coleccion_lista;

public class ListNode {

	private Object object;
	public ListNode next;

	public ListNode() {
		this.object = null;
		this.next = null;
	}

	public ListNode(Object object) {
		this.object = object;
		this.next = null;
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