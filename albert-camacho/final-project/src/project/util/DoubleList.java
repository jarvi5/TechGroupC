package project.util;

public class DoubleList<E> implements IDoubleList<E> {
    private class RootNode<E> {
        E element;
        RootNode<E> previous;
        RootNode<E> next;
        Node<E> child;

        RootNode(E element) {
            this(element, null, null);
        }

        RootNode(E element, RootNode<E> previous, RootNode<E> next){
            this.element = element;
            this.previous = previous;
            this.next = next;
            this.child = null;
        }
    }

    private int size;
    private RootNode<E> firstNode;
    private RootNode<E> lastNode;

    @Override
    public boolean add(E element) {
        return addLast(element);
    }

    @Override
    public boolean add(int index, E element) {
        rangeCheckForAdd(index);

        if (index == 0)
            return addFirst(element);

        if (index >= size)
            return addLast(element);

        RootNode<E> node = getRootNode(index);
        node.previous = new RootNode<>(element, node.previous, node);
        size++;
        return true;
    }

    @Override
    public boolean addFirst(E element) {
        if (isEmpty()) {
            firstNode = lastNode = new RootNode<>(element);
        } else {
            firstNode = new RootNode<>(element, null, firstNode);
            firstNode.next.previous = firstNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if (isEmpty()) {
            firstNode = lastNode = new RootNode<>(element);
        } else {
            lastNode = new RootNode<>(element,  lastNode, null);
            lastNode.previous.next = lastNode;
        }
        size++;
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(E element) {
        return false;
    }

    @Override
    public boolean remove(int index) {
        rangeCheck(index);
        return false;
    }

    @Override
    public boolean removeFirst() {
        return false;
    }

    @Override
    public boolean removeLast() {
        return false;
    }

    @Override
    public void clear() {

    }

    public E get(int index) {
        return getRootNode(index).element;
    }

    private RootNode<E> getRootNode(int index) {
        // Check if index is in range
        rangeCheck(index);

        RootNode<E> node;
        int idx = index;
        // Start from first node if True
        if ((size - idx) > size/2){
            node = firstNode;
            while (idx > 0) {
                node = node.next;
                idx--;
            }
        } else {
            node = lastNode;
            while (idx < (size -1)) {
                node = node.previous;
                idx++;
            }
        }

        return node;
    }

    private RootNode<E> getRootNode(E element){
        RootNode<E> node = firstNode;
        while (node.next != null) {
            if (element.equals(node.element)){
                return node;
            }
            node = node.next;
        }
        // new node is created at end if element doesn't exist
        addLast(element);
        return lastNode;
    }

    public boolean addChild(E element, E child){
        return addChild(getRootNode(element), child);
    }

    private boolean addChild(RootNode<E> node, E childElement) {
        if (hasChild(node)){
            Node<E> lastChild = node.child;

            while (lastChild.next != null) {
                lastChild = lastChild.next;
            }

            lastChild.next = new Node<>(childElement, lastChild, null);
        } else {
            node.child = new Node<>(childElement);
        }
        return true;
    }

    private boolean hasChild(RootNode<E> node) {
        return node.child == null;
    }

    /**
     * Checks if the given index is in range.  If not, throws an appropriate
     * runtime exception.
     */
    private void rangeCheck(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * A version of rangeCheck used by add.
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
}
