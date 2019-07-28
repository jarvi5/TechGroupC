package project.common;

import project.common.node.INode;
import project.common.node.MultiNode;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MultiList<E, V> implements DoubleList<E> {
    private int size;
    private MultiNode<E, V> firstMultiNode;
    private MultiNode<E, V> lastMultiNode;

    /**
     * Add an element to the last position of the list.
     * @param element Object that will be added
     * @return True if element was added.
     */
    @Override
    public boolean add(E element) {
        return addLast(element);
    }

    /**
     * Add an element to the first position of the list.
     * @param element Object that will be added
     * @return True if element was added.
     */
    @Override
    public boolean addFirst(E element) {
        if (isEmpty()) {
            firstMultiNode = lastMultiNode = new MultiNode<>(element);
        } else {
            firstMultiNode = new MultiNode<>(element, null, firstMultiNode);
            //firstMultiNode.next.previous = firstMultiNode;
            firstMultiNode.getNext().setPrevious(firstMultiNode);
        }
        size++;
        return true;
    }

    /**
     * Add an element to the last position of the list.
     * @param element Object that will be added
     * @return True if element was added.
     */
    @Override
    public boolean addLast(E element) {
        if (isEmpty()) {
            firstMultiNode = lastMultiNode = new MultiNode<>(element);
        } else {
            lastMultiNode = new MultiNode<>(element, lastMultiNode, null);
            //lastMultiNode.previous.next = lastMultiNode;
            lastMultiNode.getPrevious().setNext(lastMultiNode);
        }
        size++;
        return true;
    }

    /**
     * Retrieve the element in an specific position.
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
        if ((size - idx) > size/2){
            node = firstMultiNode;
            while (idx > 0) {
                node = node.getNext();
                idx--;
            }
        } else {
            node = lastMultiNode;
            while (idx < (size -1)) {
                node = node.getPrevious();
                idx++;
            }
        }
        return node.getElement();
    }

    /**
     * Get the first element in the list
     * @return The first element in the list.
     */
    @Override
    public E getFirst() {
        return firstMultiNode.getElement();
    }

    /**
     * Get the last element in the list
     * @return The last element in the list
     */
    @Override
    public E getLast() {
        return lastMultiNode.getElement();
    }

    @Override
    public E getNext(E element) {
        if (element != null){
            INode<E> node = getNode(element).getNext();
            return (node != null) ? node.getElement() : element;
        }
        return null;
    }

    @Override
    public E getPrevious(E element) {
        if (element != null){
            INode<E> node = getNode(element).getPrevious();
            return (node != null) ? node.getElement() : element;
        }
        return null;
    }

    /**
     * Get the length of the list.
     * @return An integer value that indicates the size
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Allows to know if the list is empty
     * @return True if the list is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Deletes an element in the list
     * @param element Object that will be deleted
     */
    @Override
    public boolean delete(E element) {
        MultiNode<E, V> node = getNode(element);
        // Remove the firstMultiNode
        if (node.getPrevious() == null) {
            firstMultiNode = (MultiNode<E, V>) node.getNext();
        } else {
            node.getPrevious().setNext(node.getNext());
        }

        // remove the last node
        if (node.getNext() == null) {
            lastMultiNode = (MultiNode<E, V>) node.getPrevious();
        }else {
            node.getNext().setPrevious(node.getPrevious());
        }
        size--;
        return true;
    }

    /**
     * Adds a child Object to the element, child will be added at the last position if has already
     * a child.
     * @param element Object where the child will be added
     * @param value Object that will be added.
     * @return True if child was added
     */
    public boolean addChild(E element, V value) {
        MultiNode<E, V> node = getNode(element);
        if (node.getChild() == null){
            node.setChild(new MultiList<>());
        }
        return node.getChild().add(value);
    }

    /**
     * Creates and return the list of child objects in the list
     * @param element object where the children are stored
     * @return DoubleList of child objects
     */
    public DoubleList<V> getChildList(E element) {
        DoubleList<V> children = new MultiList<>();

        if (hasChild(element)) {
            children = getNode(element).getChild();
        }
        return children;
    }

    /**
     * Allows to know if the element has a child
     * @param element Object from which we will check if has a child
     * @return True if has a child
     */
    public boolean hasChild(E element) {
        return getNode(element).getChild() != null;
    }

    /**
     * Deletes a child object from the element
     * @param element Object from which we will delete the first child
     * @param value Child object that will be deleted
     */
    public boolean deleteChild(E element, V value) {
        if (hasChild(element)){
            return getNode(element).getChild().delete(value);
        }
        return false;
    }

    // Returns the node where the element is hosted, a new node is added if the element
    // doesn't exists in the list.
    protected MultiNode<E, V> getNode(E element){
        MultiNode<E, V> node = firstMultiNode;
        while (node != null) {
            if (element.equals(node.getElement())){
                return node;
            }
            node = (MultiNode<E, V>) node.getNext();
        }
        // new node is created at end if element doesn't exist
        addLast(element);
        return lastMultiNode;
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
        return "Index: "+index+", Size: "+size;
    }

    @Override
    public Iterator<E> iterator() {
        return new DoubleListIterator();
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

    private class DoubleListIterator implements Iterator<E> {

        private INode<E> node = firstMultiNode;

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
}
