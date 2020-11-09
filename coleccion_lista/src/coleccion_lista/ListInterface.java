package coleccion_lista;

import java.util.Iterator;

public interface ListInterface {

	/*
	 * essential operations
	 */
	public boolean isEmpty(); //listo

	public int getSize(); //listo

	public void clear();//listo

	public Object getHead();//listo

	public Object getTail();//listo

	public Object get(ListNode node); //listo

	public Object search(Object object); //listo

	public boolean add(Object object); //listo

	public boolean insert(ListNode node, Object object);

	public boolean insert(Object ob, Object object);//listo

	public boolean insertHead(Object object);//listo

	public boolean insertTail(Object object);//listo

	public boolean set(ListNode node, Object object);//listo

	public boolean remove(ListNode node);//listo

	/*
	 * expansion operations
	 */
	public boolean contains(Object object); //listo

	public boolean isEquals(Object object);//listo

	public Iterator<ListNode> iterator();//listo

	public Object[] toArray();//listo

	public Object[] toArray(Object[] object);//listo

	public Object getBeforeTo();//listo

	public Object getBeforeTo(ListNode node);//listo

	public Object getNextTo();//listo

	public Object getNextTo(ListNode node);//listo

	public List subList(ListNode from, ListNode to);//listo

	public List sortList();
	

}