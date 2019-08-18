package project.common.utils;

import project.common.node.DoubleNode;
import project.common.node.INode;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DoubleLinkedList<E> implements DoubleList<E> {
    int size;
    INode<E> firstNode;
    INode<E> lastNode;

    /**
     * Add an element to the last position of the list.
     *
     * @param element Object that will be added
     * @return True if element was added.
     */
    @Override
    public boolean add(E element) {
        return addLast(element);
    }

    /**
     * Add an element to the first position of the list.
     *
     * @param element Object that will be added
     * @return True if element was added.
     */
    @Override
    public boolean addFirst(E element) {
        if (isEmpty()) {
            firstNode = lastNode = new DoubleNode<>(element);
        } else {
            firstNode = new DoubleNode<>(element, null, firstNode);
            //firstNode.next.previous = firstNode;
            firstNode.getNext().setPrevious(firstNode);
        }
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
            firstNode = lastNode = new DoubleNode<>(element);
        } else {
            lastNode = new DoubleNode<>(element, lastNode, null);
            //lastNode.previous.next = lastNode;
            lastNode.getPrevious().setNext(lastNode);
        }
        size++;
        return true;
    }

    /**
     * Retrieve the element in an specific position.
     *
     * @param index Position where element is located.
     * @return Element found or an exception if index is out of range.
     */
    @Override
    public E get(int index) {
        // Check if index is in range
        rangeCheck(index);

        INode<E> node;
        int idx = index;
        // Start from first node if True
        if ((size - idx) > size / 2) {
            node = firstNode;
            while (idx > 0) {
                node = node.getNext();
                idx--;
            }
        } else {
            node = lastNode;
            while (idx < (size - 1)) {
                node = node.getPrevious();
                idx++;
            }
        }
        return node.getElement();
    }

    /**
     * Get the first element in the list
     *
     * @return The first element in the list.
     */
    @Override
    public E getFirst() {
        return firstNode.getElement();
    }

    /**
     * Get the last element in the list
     *
     * @return The last element in the list
     */
    @Override
    public E getLast() {
        return lastNode.getElement();
    }

    /**
     * Get the length of the list.
     *
     * @return An integer value that indicates the size
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Allows to know if the list is empty
     *
     * @return True if the list is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Deletes an element in the list
     *
     * @param element Object that will be deleted
     */
    @Override
    public boolean remove(E element) {
        INode<E> node = firstNode.getNode(element);
        // Remove the firstNode
        if (node.getPrevious() == null) {
            firstNode = node.getNext();
        } else {
            node.getPrevious().setNext(node.getNext());
        }

        // remove the last node
        if (node.getNext() == null) {
            lastNode = node.getPrevious();
        } else {
            node.getNext().setPrevious(node.getPrevious());
        }
        size--;
        return true;
    }

    @Override
    public DoubleIterator<E> doubleIterator() {
        return new DoubleListIterator();
    }

    // Checks if the given index is in range.  If not, throws an appropriate
    // runtime exception.
    private void rangeCheck(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    // A version of rangeCheck used by add.
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    // Constructs an IndexOutOfBoundsException detail message.
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        // Add code if this method is needed
    }

    @Override
    public Spliterator<E> spliterator() {
        // Add code if this method is needed
        return null;
    }

    private class ListIterator implements Iterator<E> {

        private INode<E> node = firstNode;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Iterator exceeded.");
            }

            E element = node.getElement();
            node = node.getNext();
            return element;
        }
    }

    private class DoubleListIterator implements DoubleIterator<E> {

        private INode<E> node = firstNode;

        @Override
        public boolean hasNext() {
            return node.getNext() != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Iterator exceeded.");
            }

            node = node.getNext();
            return node.getElement();
        }

        @Override
        public boolean hasPrevious() {
            return node.getPrevious() != null;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException("Iterator exceeded.");
            }

            node = node.getPrevious();
            return node.getElement();
        }

        @Override
        public void set(E element) {
            node = firstNode.getNode(element);
        }
    }
}
