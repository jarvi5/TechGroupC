package org.minions.utils;

import javax.swing.*;
import javax.swing.event.ListDataListener;

public class Node<T>{
    private Node<T> previous;
    private Node<T> next;
    private DoubleLinkedList child;
    private T value;

    Node(T value) {
        this.value = value;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previousElement) {
        previous = previousElement;
    }

    public Node<T> getNext() {
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

    public void setChild(DoubleLinkedList child) {
        this.child = child;
    }

    public DoubleLinkedList getChild() {
        return child;
    }
}


