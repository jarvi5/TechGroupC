package model.dataStructure;

public class Node<T extends Comparable> implements Comparable<Node<T>> {
    protected T data;
    protected Node<T> previousNode;
    protected Node<T> nextNode;

    public Node(Node<T> previousNode, T data, Node<T> nextNode) {
        this.data = data;
        this.previousNode = previousNode;
        this.nextNode = nextNode;
    }

    @Override
    public int compareTo(Node<T> node) {
        return data.compareTo(node.data);
    }
}
