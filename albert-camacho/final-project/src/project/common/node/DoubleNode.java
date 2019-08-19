package project.common.node;

public class DoubleNode<E> implements INode<E> {
    private INode<E> next;
    private INode<E> previous;
    private E element;

    public DoubleNode(E element) {
        this(element, null, null);
    }

    public DoubleNode(E element, INode<E> previous, INode<E> next) {
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
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public boolean hasPrevious() {
        return previous != null;
    }

    @Override
    public void setNext(INode<E> node) {
        next = node;
    }

    @Override
    public void setPrevious(INode<E> node) {
        previous = node;
    }

}
