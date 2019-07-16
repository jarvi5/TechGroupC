package proyectolist;

import java.util.LinkedList;

public class Node<E> {

	protected E data;
	protected Node previuos;
	protected Node next;	
	protected LinkedList<Node<E>> children;
	protected boolean check;
	
	Node(E element, Node next, Node previous){
		data = element;
		this.next = next;
		this.previuos = previous;
	}    
	
	public Node() {
	    data = null;
	    previuos = null;
	    next = null;
	    check = false;
	    children = new LinkedList();
	}
	
	public Node(E value){
		
		data = value;
		previuos = null;
	    next = null;
	    check = false;
	    children = new LinkedList();
	}
	
	public void append(E value){
	    append(new Node(value));
	}
	  
	public void append(Node<E> node) {
	    children.add(node);
	}
	
	public E getValue(){
	    return data;
	}
	
	public void add(Node<E> node){
	    children.add(node);
	}
	  
	public LinkedList<Node<E>> getAll()	{
	    return children;
	}
	  
	public Node<E> get(int i){
	    return (Node)children.get(i);
	}
	  
	public boolean checked()
	{
	    return check;
	}
	  
	public void check()
	{
	    check = true;
	}
	  
	public void unCheck()
	{
	    check = false;
	}
	  
	public Node<E> remove(int i)
	{
	    return (Node)children.remove(i);
	}
	  
	public void clear()
	{
	    children.clear();
	}

}
