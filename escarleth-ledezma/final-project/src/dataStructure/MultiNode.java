package dataStructure;

public class MultiNode<E, V> extends Node<E> {
    private Node<E> node;
    private DoubleLinkedList<V> child;

    public MultiNode(E value) {
        super(value);
    }

    public DoubleLinkedList<V> getChild() {
        return child;
    }

    public void setChild(DoubleLinkedList<V> child) {
        this.child = child;
    }
    public Node<E> getNode() {
        return node;
    }

    public void setNode(Node<E> node) {
        this.node = node;
    }

}
