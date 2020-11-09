package lista_doble;

import java.util.Iterator;

public interface ListDInterface {

	/*
	 * essential operations
	 */
	public boolean isEmpty(); // listo

	public int getSize(); // listo

	public void clear(); // listo

	public Object getHead();// listo

	public Object getTail();// listo

	public Object get(ListDNode node); // listo

	public Object search(Object object); // listo

	public boolean add(Object object); // listo

	public boolean insert(ListDNode node, Object object);// listo

	public boolean insert(Object ob, Object object);// listo

	public boolean insertHead(Object object);// listo

	public boolean insertTail(Object object);// listo

	public boolean set(ListDNode node, Object object);// listo

	public boolean remove(ListDNode node);// listo

	/*
	 * expansion operations
	 */
	public boolean contains(Object object); // listo

	public Iterator<ListDNode> iterator(); // listo

	public Object[] toArray();// listo

	public Object[] toArray(Object[] object);// listo

	public Object getBeforeTo(ListDNode node);// listo

	public Object getNextTo(ListDNode node);// listo

	public ListDoble subList(ListDNode from, ListDNode to);// listo

	public ListDoble sortList(); // listo

}
