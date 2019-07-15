package project.common;

import project.common.node.INode;
import project.common.node.Node;

public class ParentList<E> implements DoubleList<E> {
    private int size;
    private Node<E, Object> firstNode;
    private Node<E, Object> lastNode;

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
            firstNode = lastNode = new Node<>(element);
        } else {
            firstNode = new Node<>(element, null, firstNode);
            //firstNode.next.previous = firstNode;
            firstNode.getNext().setPrevious(firstNode);
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
            firstNode = lastNode = new Node<>(element);
        } else {
            lastNode = new Node<>(element,  lastNode, null);
            //lastNode.previous.next = lastNode;
            lastNode.getPrevious().setNext(lastNode);
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
            node = firstNode;
            while (idx > 0) {
                node = node.getNext();
                idx--;
            }
        } else {
            node = lastNode;
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
        return firstNode.getElement();
    }

    /**
     * Get the last element in the list
     * @return The last element in the list
     */
    @Override
    public E getLast() {
        return lastNode.getElement();
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
    public void delete(E element) {
        Node<E, Object> node = getNode(element);
        // Remove the firstNode
        if (node.getPrevious() == null) {
            firstNode = (Node<E, Object>) node.getNext();
        } else {
            node.getPrevious().setNext(node.getNext());
        }

        // remove the last node
        if (node.getNext() == null) {
            lastNode = (Node<E, Object>) node.getPrevious();
        }else {
            node.getNext().setPrevious(node.getPrevious());
        }
        size--;
    }

    /**
     * Adds a child Object to the element, child will be added at the last position if has already
     * a child.
     * @param element Object where the child will be added
     * @param value Object that will be added.
     * @return True if child was added
     */
    public boolean addChild(E element, Object value) {
        Node<E, Object> node = getNode(element);
        return node.addChild(value);
    }

    /**
     * Returns only the first child in the element
     * @param element Object from which we will retrieve the first child
     * @return Child object element
     */
    public Object getChild(E element) {
        return getNode(element).getChild().getElement();
    }

    /**
     * Creates and return the list of child objects in the list
     * @param element object where the children are stored
     * @return DoubleList of child objects
     */
    public DoubleList<Object> getChildren(E element) {
        DoubleList<Object> children = new ParentList<>();

        if (hasChild(element)) {
            INode<Object> node = getNode(element).getChild();
            while (node != null) {
                children.add(node.getElement());
                node = node.getNext();
            }
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
     * Deletes the first child in the element, the next child will be converted to the first
     * @param element Object from which we will delete the first child
     */
    public boolean deleteChild(E element) {
        if (hasChild(element)) {
            INode<Object> node = getNode(element).getChild();
            getNode(element).setChild(node.getNext());
            return true;
        }
        return false;
    }

    /**
     * Deletes a child object from the element
     * @param element Object from which we will delete the first child
     * @param value Child object that will be deleted
     */
    public boolean deleteChild(E element, Object value) {
        return getNode(element).deleteChild(value);
    }

    // Returns the node where the element is hosted, a new node is added if the element
    // doesn't exists in the list.
    private Node<E, Object> getNode(E element){
        Node<E, Object> node = firstNode;
        while (node != null) {
            if (element.equals(node.getElement())){
                return node;
            }
            node = (Node<E, Object>) node.getNext();
        }
        // new node is created at end if element doesn't exist
        addLast(element);
        return lastNode;
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
}
