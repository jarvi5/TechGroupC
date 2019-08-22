package org.minions.utils;

public class Node<T> {
    private Node<T> previous;
    private Node<T> next;
    private DoubleLinkedList child;
    private T value;

    /**
     * Constructor that Initialize attributes.
     *
     * @param value object that contains the node.
     */
    Node(T value) {
        this.value = value;
    }

    /**
     * Method that get the previous Node.
     *
     * @return the previous Node.
     */
    public Node<T> getPrevious() {
        return previous;
    }

    /**
     * Method that set the previous Node.
     *
     * @param previousElement previous Node.
     */
    public void setPrevious(Node<T> previousElement) {
        previous = previousElement;
    }

    /**
     * Method that get the Next Node.
     *
     * @return the next Node.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Method that set the next Node.
     *
     * @param nextElement next node.
     */
    public void setNext(Node<T> nextElement) {
        this.next = nextElement;
    }

    /**
     * Method that get the Node's value.
     *
     * @return the Value of the Node.
     */
    public T getValue() {
        return value;
    }

    /**
     * Method that set the Value to the node.
     *
     * @param value value to be set to the node.
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Method that set the child information.
     *
     * @param child Child information to be set to the Node.
     */
    public void setChild(DoubleLinkedList child) {
        this.child = child;
    }

    /**
     * Method that get the child Information from the Node.
     *
     * @return the Child Information.
     */
    public DoubleLinkedList getChild() {
        return child;
    }
}


