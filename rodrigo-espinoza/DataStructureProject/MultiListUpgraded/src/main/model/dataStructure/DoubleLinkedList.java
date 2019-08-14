package model.dataStructure;

public class DoubleLinkedList<T extends Comparable> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private Node<T> currentNode;

    public void addFirst(T value) {
        final Node<T> firstNode = this.firstNode;
        final Node<T> newNode = new Node<>(null, value, firstNode);
        this.firstNode = newNode;
        if (firstNode == null)
            lastNode = newNode;
        else
            firstNode.previousNode = newNode;
    }

    /**
     * Appends the specified element to the end of this list.
     */
    public void addLast(T value) {
        final Node<T> lastNode = this.lastNode;
        final Node<T> newNode = new Node<>(lastNode, value, null);
        this.lastNode = newNode;
        currentNode = this.lastNode;
        if (lastNode == null)
            firstNode = newNode;
        else
            lastNode.nextNode = newNode;
    }

    public T previous() {
        if (currentNode != null && currentNode.previousNode != null) {
            currentNode = currentNode.previousNode;
        }
        return currentNode.data;
    }

    public T next() {
        if (currentNode != null && currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        return currentNode.data;
    }

   public T search(T value) {
       Node<T> current = firstNode;
       while (current != null) {
           if (current.data.compareTo(value) == 0) {
               currentNode = current;
               return currentNode.data;
           } else {
               if (current.nextNode != null) {
                   current = current.nextNode;
               } else {
                   break;
               }
           }
       }
       return null;
   }

    public  T getFirst(){
        return firstNode.data;
    }

    public T getLast(){
        return lastNode.data;
    }

    public T removeCurrent() {
        // assert x != null;
        Node<T> x = currentNode;
        final T element = x.data;
        final Node<T> next = x.nextNode;
        final Node<T> prev = x.previousNode;


        if (prev == null) {
            firstNode = next;
            currentNode = firstNode;
        } else {
            prev.nextNode = next;
            x.previousNode = null;
        }

        if (next == null) {
            lastNode = prev;
            currentNode = lastNode;
        } else {
            next.previousNode = prev;
            currentNode = next;
            x.nextNode = null;
        }

        x.data = null;
        return element;
    }

    public T updateCurrent(T data){
        currentNode.data = data;
        return currentNode.data;
    }

    public Node<T> getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Node<T> firstNode) {
        this.firstNode = firstNode;
    }

    public Node<T> getLastNode() {
        return lastNode;
    }

    public void setLastNode(Node<T> lastNode) {
        this.lastNode = lastNode;
    }

    private Node<T> getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node<T> currentNode) {
        this.currentNode = currentNode;
    }

    public  T getCurrentData(){
        return currentNode.data;
    }
}
