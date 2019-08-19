package project.common.utils;

public interface DoubleList<E> extends Iterable<E> {
    boolean add(E element);

    boolean addFirst(E element);

    boolean addLast(E element);

    E get(int index);

    E getFirst();

    E getLast();

    int getSize();

    boolean isEmpty();

    boolean remove(E element);

    void removeFirst();

    void removeLast();

    DoubleIterator<E> doubleIterator();
}
