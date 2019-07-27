package project.common;

public interface DoubleList<E> extends Iterable<E> {
    boolean add(E element);
    boolean addFirst(E element);
    boolean addLast(E element);
    E get(int index);
    E getFirst();
    E getLast();
    int getSize();
    boolean isEmpty();
    boolean delete(E element);
}
