package lista_circular;

import java.util.Iterator;

public interface ListInterfaceCircular {

	/*
	 * essential operations
	 */
	public boolean isEmpty();// listo

	public int getSize();// listo

	public void clear();// listo

	public Object getHead();// listo

	public Object getTail();// listo

	public Object get(ListNodeCircular node);// listo

	public Object search(Object object);// listo

	public boolean add(Object object);// listo

	public boolean insert(ListNodeCircular node, Object object);// listo

	public boolean insert(Object ob, Object object);// listo

	public boolean insertHead(Object object);// listo

	public boolean insertTail(Object object);// listo

	public boolean set(ListNodeCircular node, Object object);// listo

	public boolean remove(ListNodeCircular node);// listo

	/*
	 * expansion operations
	 */
	public boolean contains(Object object);// listo

	public boolean isEquals(Object object);// listo

	public Iterator<ListNodeCircular> iterator();// listo

	public Object[] toArray();// listo

	public Object[] toArray(Object[] object);// listo

	public Object getBeforeTo();// listo

	public Object getBeforeTo(ListNodeCircular node);// listo

	public Object getNextTo();// listo

	public Object getNextTo(ListNodeCircular node);// listo

	public ListCircular subList(ListNodeCircular from, ListNodeCircular to);// listo

	public ListCircular sortList();
}
