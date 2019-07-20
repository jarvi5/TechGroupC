package multi_list_library;

public class DoubleLinkedList<T> {
    protected Node head;
    protected Node tail;
    protected Node actual;

    public void addToBack(T student){
        Node newNode = new Node(student);
        if(tail == null){
            head = newNode;
        }else{
            tail.next = newNode;
            newNode.previous = tail;
            newNode.next = null;
        }
        tail = newNode;
    }

    public void printLinkedList(){
        Node current = head;
        while (current != null){
            System.out.println(current);
            current =  current.next;
        }
    }

    public Node moveNext(){
        if(actual == null){
            actual = head;
            return actual;
        }else if(actual.next != null){
            actual = actual.next;
            return actual;
        }else{
            return actual;
        }
    }

    public Node movePrevious(){
        if(actual == null){
            actual = head;
            return actual;
        }else if(actual.previous != null){
            actual = actual.previous;
            return actual;
        }else{
            return actual;
        }
    }
}
