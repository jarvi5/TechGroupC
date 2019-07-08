package project.util;

public class Node<E> {
    E data;
    Node<E> previous;
    Node<E> next;

    Node(E data) {
        this(data, null, null);
    }

    Node(E data, Node<E> previous, Node<E> next){
        this.data = data;
        this.previous = previous;
        this.next = next;
    }
}
