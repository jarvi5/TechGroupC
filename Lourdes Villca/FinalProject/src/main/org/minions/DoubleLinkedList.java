package org.minions;

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

/*    public void addChild(T parentData, T childData) {
        Node<T> parentNode = this.getNode(parentData);
        Node<T> newChildNode = new Node<>(childData);
        if (parentNode.getChild() == null) {
            parentNode.setChild(newChildNode);
        } else {
            parentNode.getChild().setNext(newChildNode);
        }
    }*/

    public T getElementAt(int index) {
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }
}
