package multi_list_library;

public class Node<T> {
    private T node;
    public Node next = null;
    public Node previous = null;

    public Node(T node) {
        this.node = node;
    }

    public T getNode() {
        return node;
    }

    public void setNode(T node) {
        this.node = node;
    }
}
