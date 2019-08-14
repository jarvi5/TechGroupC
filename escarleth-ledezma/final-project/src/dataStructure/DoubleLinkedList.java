package dataStructure;

public class DoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public void addToFront(T value) {
        Node<T> newNode = new Node<T>(value);
        newNode.setNext(head);
        newNode.setPrevious(null);
        head = newNode;
        if (newNode.getNext() == null) {
            tail = newNode;
        }
    }

    public void addToBack(T value) {
        Node<T> newNode = new Node<T>(value);
        if (tail == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
        }
        tail = newNode;
    }

    public boolean contains(T value) {
        Node current = head;
        while (current != null) {
            if (current.getValue() == value) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public Object getByIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                if (current == null || current.getNext() == null) {
                    throw new IndexOutOfBoundsException();
                }
                current = current.getNext();
            }
            return current;
        }
    }
}

