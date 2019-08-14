package org.minions.utils;

public class MultiList<T1, T2> extends DoubleLinkedList<T1> {
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
        if (parentNode.getChild() == null) {
            DoubleLinkedList<T2> childList = new DoubleLinkedList<>();
            childList.insertDataAtEnd(childData);
            parentNode.setChild(childList);
        } else {
            parentNode.getChild().insertDataAtEnd(childData);
        }
    }

    }
