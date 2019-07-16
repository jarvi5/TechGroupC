public class NodeChild<T> {
     T value;
     NodeChild<T> next;
     NodeChild<T> previous;

    public NodeChild(T value){
        this.value = value;
    }
}