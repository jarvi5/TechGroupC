package project.common.utils;

@FunctionalInterface
public interface IString<E> {
    String ofElement(E element);
}
