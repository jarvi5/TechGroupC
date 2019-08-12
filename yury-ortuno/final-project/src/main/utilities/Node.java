package main.utilities;

public class Node<T1> {
    private T1 node;
    public Node next = null;
    public Node previous = null;

    public Node(T1 node) {
        this.node = node;
    }

    public T1 getNode() {
        return this.node;
    }

    public void setNode(T1 node) {
        this.node = node;
    }
}
