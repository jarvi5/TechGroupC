public class Node<T> {
    T value;
    Node<T> next;
    Node<T> previous;
    NodeChild<T> childElement;

    public Node(T value) {
        this.value = value;
        childElement = null;
    }
}