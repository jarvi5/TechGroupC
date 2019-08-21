package main.utilities;

public class DoubleLinkedList<T> {
    private Node head;
    private Node tail;
    private Node tmp;
    private int size = 0;

    public Node getActualNode() {
        return tmp;
    }

    public Node getHeadNode() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getTailNode() {
        return tail;
    }

    public void addToBack(T node) {
        Node<T> newNode = new Node<>(node);
        if (tail == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            newNode.setNext(null);
        }
        tail = newNode;
        size++;
    }

    public void returnAllNodes() {
        Node current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    public Node next() {
        if (tmp == null) {
            tmp = head;
            return tmp;
        } else if (tmp.getNext() != null) {
            tmp = tmp.getNext();
            return tmp;
        } else {
            return tmp;
        }
    }

    public Node previous() {
        if (tmp == null) {
            tmp = head;
            return tmp;
        } else if (tmp.getPrevious() != null) {
            tmp = tmp.getPrevious();
            return tmp;
        } else {
            return tmp;
        }
    }
}
