package project.common.node;

import project.common.utils.DoubleList;

public class MultiNode<E, V> extends DoubleNode<E> {
    private DoubleList<V> child;

    public MultiNode(E element, DoubleList<V> child) {
        this(element, null, null, child);
    }

    public MultiNode(E element, INode<E> previous, INode<E> next, DoubleList<V> child) {
        super(element, previous, next);
        this.child = child;
    }

    public DoubleList<V> getChild() {
        return child;
    }
}
