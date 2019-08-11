package project.common.node;

public interface INode<E> {
    E getElement();
    INode<E> getNext();
    INode<E> getPrevious();
    void setNext(INode<E> node);
    void setPrevious(INode<E> node);

    default INode<E> getNode(E element) {
        INode<E> node = this;
        while (node != null) {
            if (element.equals(node.getElement())){
                return node;
            }
            node = node.getNext();
        }
        // Exception is thrown if element is not contained by any node.
        throw new NullPointerException("There is not node containing the element '" + element.toString() +"'");
    }
}
