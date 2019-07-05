package project;

public class Node<T> {
    private T data;
    private Node<T> nextElement;
    private Node<T> previousElement;
    private NodeChild<T> childElement;

    public Node(T data){
        this.setData(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextElement() {
        return nextElement;
    }

    public void setNextElement(Node<T> nextElement) {
        this.nextElement = nextElement;
    }

    public Node<T> getPreviousElement() {
        return previousElement;
    }

    public void setPreviousElement(Node<T> previousElement) {
        this.previousElement = previousElement;
    }

    public NodeChild<T> getChildElement() {
        return childElement;
    }

    public void setChildElement(NodeChild<T> childElement) {
        this.childElement = childElement;
    }
}
