package org.minions.utils;

import javax.swing.*;
import javax.swing.event.ListDataListener;

public class DoubleLinkedList<T> implements ListModel {
    protected Node<T> head;
    protected Node<T> tail;
    protected int size;

    /**
     * Constructor that initialize the attributes.
     */
    DoubleLinkedList() {
        this.size = 0;
    }

    /**
     * Method that inserta an element to the first position of the double linked list.
     *
     * @param data the object data that will be created and added to the list.
     */
    public void insertElementAtFirst(T data) {
        Node<T> node = new Node<>(data);
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head.setPrevious(node);
            head = node;
        }
        size++;
    }

    /**
     * Method that insert and element to the last position of the double linked list.
     *
     * @param data object that is created added to the double linked list
     */
    public void insertElementAtEnd(T data) {
        Node<T> node = new Node<T>(data);
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            node.setPrevious(tail);
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    /**
     * Methos that get the data from the double linked list.
     *
     * @param data object data that is searched in the list.
     * @return the data found in the list;
     */
    public T getData(T data) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getValue().equals(data)) {
                return currentNode.getValue();
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    /**
     *
     * @param data
     * @return
     */
    public Node<T> getNode(T data) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getValue().equals(data)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public T getElementAtIndex(int index) {
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    public void deleteFirstElement() {
        if (head == null) {
            return;
        } else if (head.equals(tail)) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrevious(null);
        }
        size--;
    }

    public void deleteLastElement() {
        if (head == null) {
            return;
        } else if (head.equals(tail)) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrevious();
            head.setNext(null);
        }
        size--;
    }

    public void deleteElementAtIndex(int index) {
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        Node<T> nodeTemp = currentNode.getPrevious();
        nodeTemp.setPrevious(currentNode.getPrevious());
        nodeTemp.setNext(currentNode.getNext());
        size--;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Object getElementAt(int index) {
        Node currentNode = head;
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
