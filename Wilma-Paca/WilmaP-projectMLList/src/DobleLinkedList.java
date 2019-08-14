package projectList;

import java.awt.List;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DobleLinkedList<T> {

	protected Node head;
	protected Node tail;
	protected int size;
     
    public DobleLinkedList() {
        size = 0;
    }
    
    public class Node<T> {

    	T data;
    	Node previuos;
    	Node next;	    	
    	
    	Node(T element, Node next, Node previous){
    		data = element;
    		this.next = next;
    		this.previuos = previous;
    	}    
    }
    
    public int getSize() {
    	return size;
    }
    
    public boolean isEmpty() { 
    	return size == 0; 
    }
        
    public void addFirst(T element) {
        Node tmp = new Node(element, head, null);
        
        if(head != null ) {
        	head.previuos = tmp;
        }
        head = tmp;
        if(tail == null) {
        	tail = tmp;
        }
        size++;
        System.out.println("adding: "+element);
    }
     

    public void addLast(T element) {
         
        Node tmp = new Node(element, null, tail);
        if(tail != null) {
        	tail.next = tmp;
        }
        tail = tmp;
        if(head == null) {
        	head = tmp;
        }
        size++;
        System.out.println("adding: "+element);
    }
    
    public void removeLast() {
        if (size != 0) {
	        Node tmp = tail;
	        tail = tail.previuos;
	        tail.next = null;
	        size--;
	        System.out.println("deleted: "+tmp.data);
	        
        }
        
    }
    
    public Node<T> getFirst()
    {
       if(head == null) throw new NoSuchElementException();

       return head;
    }
    
    public Node<T> getLast()
    {
       if(head == null) throw new NoSuchElementException();

       Node<T> tmp = head;
       while(tmp.next != null) {
    	   tmp = tmp.next;
       }
       return tmp;
    }

    public T find(Comparable data){
        T res = null;
        
        Iterator it = iterator();
        T aux;
        while(res == null && it.hasNext()){
            aux = (T)it.next();
            if(data.compareTo(aux) == 0){
                res = aux;
            }
        }
        return res;
    }
    
    public Iterator<T> iterator()
    {
       return new LinkedListIterator();
    }

    public class LinkedListIterator  implements Iterator<T>
    {
       private Node<T> nextNode;

       public LinkedListIterator()
       {
          nextNode = head;
       }

       public boolean hasNext()
       {
          return nextNode != null;
       }

       public T next()
       {
          if (!hasNext()) throw new NoSuchElementException();
          T res = nextNode.data;
          nextNode = nextNode.next;
          return res;
       }

       public void remove() { throw new UnsupportedOperationException(); }
    }
    
    
}
