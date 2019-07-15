package project.common.node;

public interface INode<E> {
    E getElement();
    INode<E> getNext();
    INode<E> getPrevious();
    void setNext(INode<E> node);
    void setPrevious(INode<E> node);
}
