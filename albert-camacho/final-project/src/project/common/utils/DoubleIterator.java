package project.common.utils;

public interface DoubleIterator<E> {
    boolean hasNext();
    E next();
    boolean hasPrevious();
    E previous();
    void set(E element);
}
