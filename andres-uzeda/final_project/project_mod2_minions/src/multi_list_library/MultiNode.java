package multi_list_library;

public class MultiNode<T1,T2> extends Node{
    private DoubleLinkedList<T2> child;
    public MultiNode(T1 node) {
        super(node);
        child = new DoubleLinkedList<T2>();
    }

    public DoubleLinkedList<T2> getChild() {
        return child;
    }

    public void setChild(DoubleLinkedList<T2> child) {
        this.child = child;
    }
}
