package project.common.node;

import project.common.DoubleList;

public class MultiNode<E, V> implements INode<E>{
    private INode<E> next;
    private INode<E> previous;
    private DoubleList<V> child;
    private E element;

    public MultiNode(E element) {
        this(element, null, null);
    }

    public MultiNode(E element, INode<E> previous, INode<E> next) {
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

    public DoubleList<V> getChild(){
        return child;
    }

    public void setChild(DoubleList<V> list){
        child = list;
    }
}
