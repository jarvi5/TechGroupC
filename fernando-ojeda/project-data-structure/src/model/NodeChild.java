package project;

public class NodeChild<T> {
    private T data;
    private NodeChild<T> childNext;
    private NodeChild<T> childPreviuos;

    public NodeChild(T data){
        this.setData(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeChild<T> getChildNext() {
        return childNext;
    }

    public void setChildNext(NodeChild<T> childNext) {
        this.childNext = childNext;
    }

    public NodeChild<T> getChildPreviuos() {
        return childPreviuos;
    }

    public void setChildPreviuos(NodeChild<T> childPreviuos) {
        this.childPreviuos = childPreviuos;
    }
}
