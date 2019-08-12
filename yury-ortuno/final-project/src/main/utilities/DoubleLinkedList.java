package main.utilities;

public class DoubleLinkedList<T> {
    private Node head;
    private Node tail;
    private Node tmp;

    public Node getActualNode() {
        return tmp;
    }

    public Node getHeadNode() {
        return head;
    }

    public Node getTailNode() {
        return tail;
    }

    public void addToBack(T node) {
        Node newNode = new Node(node);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            newNode.next = null;
        }
        tail = newNode;
    }

    public void returnAllNodes() {
        Node current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public Node moveNext() {
        if (tmp == null) {
            tmp = head;
            return tmp;
        } else if (tmp.next != null) {
            tmp = tmp.next;
            return tmp;
        } else {
            return tmp;
        }
    }

    public Node movePrevious() {
        if (tmp == null) {
            tmp = head;
            return tmp;
        } else if (tmp.previous != null) {
            tmp = tmp.previous;
            return tmp;
        } else {
            return tmp;
        }
    }
}
