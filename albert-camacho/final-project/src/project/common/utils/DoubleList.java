package project.common.utils;

public interface DoubleList<E> extends Iterable<E> {
    boolean add(E element);

    boolean addFirst(E element);

    boolean addLast(E element);

    E get();

    E get(int index);

    E getFirst();

    E getLast();

    E getNext();

    E getPrevious();

    E getNext(E element);

    E getPrevious(E element);

    int getSize();

    boolean isEmpty();

    boolean remove(E element);
}
