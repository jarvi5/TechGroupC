package org.minions.utils;

class DoubleLinkedList<T> {
    protected Node<T> head;
    protected Node<T> tail;

    public void insertDataAtFirst(T data) {
        Node<T> node = new Node<>(data);
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head.setPrevious(node);
            head = node;
        }
    }

    public void insertDataAtEnd(T data) {
        Node<T> node = new Node<T>(data);
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            node.setPrevious(tail);
            tail.setNext(node);
            tail = node;
        }
    }

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

    public T getElementAt(int index) {
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    public T getNextElement(T data){
        Node<T> node = getNode(data);
        if(node.getNext() != null){
            return node.getNext().getValue();
        }
        return null;
    }

    public T getPreviousElement(T data){
        Node<T> node = getNode(data);
        if(node.getPrevious() != null)
            return node.getPrevious().getValue();
        return null;
    }
}
