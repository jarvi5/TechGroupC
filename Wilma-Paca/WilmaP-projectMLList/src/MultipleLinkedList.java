package proyectolist;

public class MultipleLinkedList<E> {

	private Node head;
    private Node tail;
    private Node children;
    private int size;
     
    public MultipleLinkedList() {
        size = 0;
    }
    
        
    public void addFirst(E element) {
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
     

    public void addLast(E element) {
         
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
}
