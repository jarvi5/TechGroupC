package org.minions.utils;

public class SubNode<T2> {
    private SubNode<T2> previous;
    private SubNode<T2> next;
    private T2 value;

    public SubNode(T2 value) {
        this.value = value;
        previous = null;
        next = null;
    }

    public SubNode<T2> getNext() {
        return next;
    }
    public void setNext(SubNode next) {
        this.next = next;
    }
    public void setPrevious(SubNode previous) {
        this.previous = previous;
    }
    public T2 getValue() {
        return value;
    }
}
