package org.minions;

class MultiList<T1,T2> extends DoubleLinkedList<T1> {

    public void addChild(T1 parentData, T2 childData) {
        Node<T1> parentNode = this.getNode(parentData);
        ChildNode<T2> newChildNode = new ChildNode<>(childData);
        if (newChildNode.getChild() == null) {
            parentNode.setChild(newChildNode);
        } else {
            parentNode.getChild().setNext(newChildNode);
        }
    }

}
