package dataStructure;

public class MultiList<E, V> extends DoubleLinkedList<E> {

    public void addChild(MultiNode<E, V> parentNode, Node<V> child) {
        parentNode.getChild().addToBack(child.getValue());
    }
}
