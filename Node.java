/**
 * 
 * @author Ridha Ali
 *
 * @param <T>
 */
public class Node<T> {
	
	private T data;
	private Node<T> prev;
	private Node<T> next;
	/**
	 * 
	 */
	public Node(){
		data= null;
		next=null;
		prev=null;
	}
	/**
	 * 
	 * @param data
	 */
	public Node(T data){
		this.data= data;
		next = null;
		prev = null;
	}
	/**
	 * 
	 * @return this returns Data
	 */
	public T getData() {
		return data;
	}
	/**
	 * 
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * 
	 * @return this returns prev
	 */
	public Node<T> getPrev() {
		return prev;
	}
	/**
	 * 
	 * @param prev
	 */
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	/**
	 * 
	 * @return this returns next
	 */
	public Node<T> getNext() {
		return next;
	}
	/**
	 * 
	 * @param next
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	

}
