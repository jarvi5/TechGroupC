package org.minions.utils;

public class MultiList<T1, T2> extends DoubleLinkedList<T1>{
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
            SubNode<T2> currentNode = parentNode.getChild();
            while (currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newChildNode);
            newChildNode.setPrevious(currentNode);

        }
    }



}
