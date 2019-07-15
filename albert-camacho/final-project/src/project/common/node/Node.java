package project.common.node;

public class Node<E, V> implements INode<E>{
    private INode<E> next;
    private INode<E> previous;
    private INode<V> child;
    private E element;

    public Node(E element) {
        this(element, null, null);
    }

    public Node(E element, INode<E> previous, INode<E> next) {
        this.element = element;
        this.previous = previous;
        this.next = next;
    }

    @Override
    public E getElement() {
        return element;
    }

    @Override
    public INode<E> getNext() {
        return next;
    }

    @Override
    public INode<E> getPrevious() {
        return previous;
    }

    @Override
    public void setNext(INode<E> node) {
        next = node;
    }

    @Override
    public void setPrevious(INode<E> node) {
        previous = node;
    }

    /**
     * Add a child at the last position
     * @param value Object that will be added
     * @return True if the object was added
     */
    public boolean addChild(V value) {
        if (child != null) {
            INode<V> c = child;
            while (c.getNext() != null) {
                c = c.getNext();
            }
            c.setNext(new Node<>(value, c, null));
            return true;
        }
        child = new Node<>(value);
        return true;
    }

    public INode<V> getChild() {
        return child;
    }

    public INode<V> getChild(int index) {
        if (child != null) {
            int idx = index;
            INode<V> c = child;
            while (idx > 0){
                c = c.getNext();
                idx--;
            }
            return c;
        }
        return null;
    }

    public INode<V> getChild(V value) {
        INode<V> c = child;
        while (c != null){
            if (value.equals(c.getElement())){
                return c;
            }
            c = c.getNext();
        }
        return null;
    }

    public void setChild(INode<V> value) {
        child = value;
    }

    public boolean deleteChild() {
        if (child != null) {
            if (child.getNext() != null) {
                child.getNext().setPrevious(child.getPrevious());
            }
            child = child.getNext();
            return true;
        }
        return false;
    }

    public boolean deleteChild(V value){
        if (child != null) {
            if (child.getElement().equals(value)){
                return deleteChild();
            }
            INode<V> node = child.getNext();
            while (node != null) {
                if (node.getElement().equals(value)){
                    if (node.getNext() != null){
                        node.getNext().setPrevious(node.getPrevious());
                    }
                    node.getPrevious().setNext(node.getNext());
                    return true;
                }
                node = node.getNext();
            }
        }
        return false;
    }
}
