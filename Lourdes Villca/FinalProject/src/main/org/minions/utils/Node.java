package org.minions.utils;

import javax.swing.*;
import javax.swing.event.ListDataListener;

public class Node<T1> implements ListModel {
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

    public Node() {
        super();
    }

    public Node<T1> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T1> previousElement) {
        previous = previousElement;
    }

    public Node<T1> getNext() {
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

    public void setChild(SubNode child) {
        this.child = child;
    }

    @Override
    public int getSize() {
        int size = 0;
        SubNode currentNode = child;
        while (currentNode != null) {
            currentNode = currentNode.getNext();
            size++;
        }
        return size;
    }

    @Override
    public Object getElementAt(int index) {
        SubNode currentNode = child;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}


