package main.utilities;

public class MultiNode<T1, T2> {
    private T1 node;
    private MultiNode next = null;
    private MultiNode previous = null;
    private DoubleLinkedList<T2> child = null;

    public MultiNode(T1 node) {
        this.node = node;
    }

    public DoubleLinkedList<T2> getChild() {
        return child;
    }

    public T1 getNode() {
        return node;
    }

    public void setNode(T1 node) {
        this.node = node;
    }

    public MultiNode getNext() {
        return next;
    }

    public void setNext(MultiNode next) {
        this.next = next;
    }

    public MultiNode getPrevious() {
        return previous;
    }

    public void setPrevious(MultiNode previous) {
        this.previous = previous;
    }

    public void setChild(DoubleLinkedList<T2> child) {
        this.child = child;
    }

}
