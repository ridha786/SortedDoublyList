import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * 
 * @author Ridha Ali
 *
 * @param <T>
 */
public class SortedDblList<T extends Comparable<T> >implements Serializable  {
	protected int size;
	protected Node<T> head = null;
	protected Node<T> tail = null;
	public int getSize() {
		return size;
	}
	/**
	 * 
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * 
	 * @return this returns the head
	 */
	public Node<T> getHead() {
		return head;
	}
	/**
	 * 
	 * @param head
	 */
	public void setHead(Node<T> head) {
		this.head = head;
	}
	/**
	 * 
	 * @return this returns the tail
	 */
	public Node<T> getTail() {
		return tail;
	}
	/**
	 * 
	 * @param tail
	 */
	public void setTail(Node<T> tail) {
		this.tail = tail;
	}
	/**
	 * 
	 */
	public SortedDblList(){

	}
	/**
	 * 
	 * @param fileName
	 */
	public void writeObject(String fileName){
		FileOutputStream output = null;
		ObjectOutputStream output2 = null;
		try{
			output = new FileOutputStream(fileName);
			output2 = new ObjectOutputStream(output);
			output2.writeObject(this.size);
			
			for(int i= 0; i<this.size; i++){
			output2.writeObject(this.get(i));
			
			}
			System.out.println("Worked");
		}
		
		catch(FileNotFoundException oops){
			oops.printStackTrace();
		}
		catch(IOException oops){
			oops.printStackTrace();
		}
		finally{
			try{
				output2.flush();
				output2.close();
			}
			catch(IOException oops){
				oops.printStackTrace();
			}
		}

	}
	/**
	 * 
	 * @param fileName
	 * @return the object that was read in
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public SortedDblList<T> readObject(String fileName) throws ClassNotFoundException{
		FileInputStream input = null;
		ObjectInputStream input2 = null;
		SortedDblList<T> newList =  new SortedDblList<T>();
		System.out.println("Workkking");
		
		try{
			input = new FileInputStream(fileName);
			input2 = new ObjectInputStream(input);
			
			int count = (int) input2.readObject();
			
			for(int i= 0; i< count; i++){
			newList.add((T)input2.readObject());
			
			}
			System.out.println("Worked");
		}
		
		catch(FileNotFoundException oops){
			oops.printStackTrace();
		}
		catch(IOException oops){
			oops.printStackTrace();
		}
		finally{
			try{
				input2.close();
			}
			catch(IOException oops){
				oops.printStackTrace();
			}
		}

			return newList;
	}
	/**
	 * 
	 * @param index
	 * @return this returns the object at the index
	 * @throws IndexOutOfBoundsException
	 */
	
	@SuppressWarnings("unchecked")
	public T get(int index) throws IndexOutOfBoundsException{
		Node spot = head;
		for(int i = 0;i <index;i++){
			spot = spot.getNext();
		}
		T answer = (T)spot.getData();
		return answer;

	}
	/**
	 * 
	 * @param element
	 * @return if the element was added
	 */
	public boolean add(T element ){

		Node<T> newOne = new Node();
		newOne.setData(element);
		Node<T> spot = head;
		boolean answer = true;

		if(element == null){
			return false;
		}

		else if(this.isEmpty()== true){
			head = newOne;
			newOne.setData(element);
			tail = newOne;
			size++;
			return true;
		}
		while(spot!=null){
			if(element.compareTo((T)spot.getData()) == 0 ){
				return false;
			}
			else if(element.compareTo(spot.getData()) == 1){

				if(spot.getNext() == null){
					spot.setNext(newOne);
					newOne.setPrev(spot);
					size++;
					tail = newOne;
					return true;
				}
				if(element.compareTo(spot.getNext().getData()) == -1){

					newOne.setPrev(spot);
					newOne.setNext(spot.getNext());
					spot.setNext(newOne);
					size++;
					return true;
				}
			}
			else if (element.compareTo((T)spot.getData()) == -1 ){
				if(element.compareTo(head.getData()) == -1){
					head.setPrev(newOne);
					newOne.setNext(head);
					head = newOne;
					size++;
					return true;
				}
				else if(element.compareTo(spot.getNext().getData()) == 1){
					newOne.setPrev(spot);
					newOne.setNext(spot.getNext());
					spot.setNext(newOne);
					size++;
					return true;
				}
			}
			spot = spot.getNext();
		}
		return false;
	}
	/**
	 * 
	 * @param o
	 * @return if the object was removed or not
	 */

	public boolean remove(Object o){
		boolean answer= false;
		Node<T> spot = head;
		Node<T> next = null;
		Node<T> prev = null;
		while(spot!=null){
			if(o.equals(spot.getData())){
				if(spot == head){
					next = spot.getNext();
					head = next;
					next.setPrev(null);
					size--;
					return true;
				}
				else if (spot == tail){
					prev = spot.getPrev();
					tail = prev;
					size--;
					return true;
				}
				else{
					next = spot.getNext();
					prev = spot.getPrev();
					prev.setNext(next);
					next.setPrev(prev);
					size --;
					return true;
				}
			}
			spot =spot.getNext();
		}
		return answer;
	}
	/**
	 * 
	 * @return if the list is empty
	 */
	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		else 
			return false;
	}
	/**
	 * 
	 * @param otherList
	 * @return a list that combines the two lists
	 */
	public SortedDblList<T> union(SortedDblList<? extends T> otherList){
		SortedDblList<T> union = new SortedDblList<T>();
		Node spot = this.head;

		while(spot!=null){
			union.add((T) spot.getData());
			spot = spot.getNext();
		}
		spot = otherList.getHead();

		while(spot!=null){
			union.add((T) spot.getData());
			spot = spot.getNext();
		}
		return union;	
	}
	/**
	 * 
	 * @param otherList
	 * @return the matched objects in the two lists
	 */
	public SortedDblList<T> intersection(SortedDblList<? extends T> otherList){
		SortedDblList<T> intersection = new SortedDblList<T>();
		Node spot = this.head;
		Node spot2 = otherList.getHead();

		while(spot!=null && spot2!=null){
			if (((Comparable<? super T>) spot.getData()).compareTo((T) spot2.getData()) == 0){
				intersection.add((T) spot.getData());
			}

			spot = spot.getNext();
			if(spot==null){
				spot = this.head;
				spot2= spot2.getNext();
			}
		}

		return intersection;
	}
	/**
	 * 
	 */
	public void printList(){
		Node spot = head;
		for(int i = 0;i <size;i++){
			System.out.println(spot.getData().toString());
			spot=spot.getNext();
		}

	}
	/**
	 * 
	 * @param o
	 * @return the index of the object 
	 */
	public int indexOf(Object o){
		int index= -1;
		int counter = 0;
		Node<T> spot = head;

		while(spot.getNext()!=null){

			if(((Comparable<T>) o).compareTo((T)spot.getData()) == 0){
				index = counter;
				break;
			}
			counter++;
			spot = spot.getNext();
		}
		if(spot.getNext()==null){
			if(((Comparable<T>) o).compareTo((T)spot.getData()) == 0){
				index = counter;
			}
		}
		return index;
	}




















}
