package project.util;

public interface IDoubleList<E> {
    boolean add(E element);
    boolean add(int index, E element);
    boolean addFirst(E element);
    boolean addLast(E element);
    int getSize();
    int indexOf(E element);
    boolean isEmpty();
    boolean remove(E element);
    boolean remove(int index);
    boolean removeFirst();
    boolean removeLast();
    void clear();
}
