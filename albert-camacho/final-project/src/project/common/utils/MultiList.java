package project.common.utils;

import project.common.node.MultiNode;

public class MultiList<E, V> extends DoubleLinkedList<E> {

    /**
     * Add an element to the first position of the list.
     *
     * @param element Object that will be added
     * @return True if element was added.
     */
    @Override
    public boolean addFirst(E element) {
        if (isEmpty()) {
            firstNode = lastNode = new MultiNode<>(element, new DoubleLinkedList<>());
        } else {
            firstNode = new MultiNode<>(element, null, firstNode, new DoubleLinkedList<>());
            //firstNode.next.previous = firstNode;
            firstNode.getNext().setPrevious(firstNode);
        }
        current = firstNode;
        size++;
        return true;
    }

    /**
     * Add an element to the last position of the list.
     *
     * @param element Object that will be added
     * @return True if element was added.
     */
    @Override
    public boolean addLast(E element) {
        if (isEmpty()) {
            firstNode = lastNode = new MultiNode<>(element, new DoubleLinkedList<>());
        } else {
            lastNode = new MultiNode<>(element, lastNode, null, new DoubleLinkedList<>());
            //lastNode.previous.next = lastNode;
            lastNode.getPrevious().setNext(lastNode);
        }
        current = lastNode;
        size++;
        return true;
    }

    public boolean addChild(V value) {
        return addChild(current.getElement(), value);
    }

    /**
     * Adds a child Object to the element, child will be added at the last position if has already
     * a child.
     *
     * @param element Object where the child will be added
     * @param value   Object that will be added.
     * @return True if child was added
     */
    public boolean addChild(E element, V value) {
        return multiNodeOf(element).getChild().add(value);
    }

    public DoubleList<V> getChildList() {
        return getChildList(current.getElement());
    }

    /**
     * Creates and return the list of child objects in the list
     *
     * @param element object where the children are stored
     * @return DoubleList of child objects
     */
    public DoubleList<V> getChildList(E element) {
        return multiNodeOf(element).getChild();
    }

    /**
     * Deletes a child object from the element
     *
     * @param element Object from which we will remove the first child
     * @param value   Child object that will be deleted
     */
    public boolean deleteChild(E element, V value) {
        if (!getChildList(element).isEmpty()) {
            return multiNodeOf(element).getChild().remove(value);
        }
        return false;
    }

    private MultiNode<E, V> multiNodeOf(E element) {
        current = firstNode.getNode(element);
        return (MultiNode<E, V>) current;
    }
}
