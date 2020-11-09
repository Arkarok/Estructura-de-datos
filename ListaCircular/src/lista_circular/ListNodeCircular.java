package lista_circular;

public class ListNodeCircular {

	private Object object;
	public ListNodeCircular next;

	public ListNodeCircular() {
		this.object = null;
		this.next = null;
	}

	public ListNodeCircular(Object object) {
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

	public Object getNextTo() {

		return next;

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
