package model.dataStructure;

public class MultiNode<E extends Comparable,T extends Comparable> implements Comparable<MultiNode<E,T>>  {
    protected E value;
    protected DoubleLinkedList<T> children;

    public MultiNode(E value) {
        children = new DoubleLinkedList<>();
        this.value = value;
    }

    public DoubleLinkedList<T> getChildren() {
        return children;
    }

    public void setChildren(DoubleLinkedList<T> children) {
        this.children = children;
    }

    public boolean equals(MultiNode<E,T> multiNode){
        //return value.equals(multiNode.value);
        return true;
    }

    @Override
    public int compareTo(MultiNode<E, T> multiNode) {
        return value.compareTo(multiNode.value);
    }

}
