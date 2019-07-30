package org.minions;

public class MultiList<T1, T2> extends DoubleLinkedList<T1>{
    /*public void insertDataAtFirst(T1 data) {
        Node<T1> node = new Node<>(data);
        if (head == null && tail == null) {
            head = node;
        } else {
            node.setNext(head);
            head.setPrevious(node);
            head = node;
        }
    }

    public void insertDataAtEnd(T1 data) {
        Node<T1> node = new Node<T1>(data);
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            node.setPrevious(tail);
            tail.setNext(node);
            tail = node;
        }
    }

    public T1 getData(T1 data) {
        Node<T1> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getValue().equals(data)) {
                return currentNode.getValue();
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public T1 getElementAt(int index) {
        Node<T1> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }*/

    public Node<T1> getParentNode(T1 data) {
        Node<T1> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getValue().equals(data)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public void addChild(T1 parentData, T2 childData) {
        Node<T1> parentNode = this.getParentNode(parentData);
        SubNode<T2> newChildNode = new SubNode<>(childData);
        if (parentNode.getChild() == null) {
            parentNode.setChild(newChildNode);
        } else {
            parentNode.getChild().setNext(newChildNode);
        }
    }


}
