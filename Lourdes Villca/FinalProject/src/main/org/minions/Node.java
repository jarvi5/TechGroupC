package org.minions;

public class Node<T1> {
    private Node<T1> previous;
    private Node<T1> next;
    private SubNode child;
    private T1 value;

    Node(T1 value) {
        this.value = value;
        previous = null;
        child = null;
        next = null;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T1> previousElement) {
        previous = previousElement;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node<T1> nextElement) {
        this.next = nextElement;
    }

    public T1 getValue() {
        return value;
    }

    public void setValue(T1 value) {
        this.value = value;
    }

    public SubNode getChild() {
        return child;
    }
    public void setChild(SubNode child){
        this.child = child;
    }
}


