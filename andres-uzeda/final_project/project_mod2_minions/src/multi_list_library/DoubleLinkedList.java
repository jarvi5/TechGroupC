package multi_list_library;

public class DoubleLinkedList<T> {
    private Node head;
    private Node tail;
    private Node actual;

    public DoubleLinkedList() {
    }

    public Node getActualNode(){
        return actual;
    }

    public Node getHeadNode(){
        return head;
    }

    public Node getTailNode(){
        return tail;
    }

    public void addToBack(T node){
        Node newNode = new Node(node);
        if(tail == null){
            head = newNode;
        }else{
            tail.next = newNode;
            newNode.previous = tail;
            newNode.next = null;
        }
        tail = newNode;
    }

    public void returnAllNodes(){
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
