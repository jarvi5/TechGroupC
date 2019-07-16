package org.minions;

public class Node<T> {
    private Node<T> previous;
    private Node<T> next;
    private Node<T> child;
    private T value;

    Node(T value) {
        this.value = value;
        previous = null;
        next = null;
        child = null;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previousElement) {
        previous = previousElement;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node<T> nextElement) {
        this.next = nextElement;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getChild() {
        return child;
    }

    public void setChild(Node<T> child) {
        this.child = child;
    }


}
