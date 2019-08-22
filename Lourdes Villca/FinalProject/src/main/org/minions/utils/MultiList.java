package org.minions.utils;

public class MultiList<T1, T2> extends DoubleLinkedList<T1> {
    /**
     * Method that add child Linked List to a given parentNode.
     *
     * @param parentData Parent Object Information to get the parent node.
     * @param childData  Child data information to add to the parent node.
     */
    public void addChild(T1 parentData, T2 childData) {
        Node<T1> parentNode = getNode(parentData);
        if (parentNode.getChild() == null) {
            DoubleLinkedList<T2> childList = new DoubleLinkedList<>();
            childList.insertElementAtEnd(childData);
            parentNode.setChild(childList);
        } else {
            parentNode.getChild().insertElementAtEnd(childData);
        }
    }

}
