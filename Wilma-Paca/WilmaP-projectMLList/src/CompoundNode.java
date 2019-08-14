package projectList;

public class CompoundNode<K,T> {
    private K key;
    private T data;
    private CompoundNode<K,T> next;
    private CompoundNode<K,T> before;
    
    public CompoundNode(){
        key = null;
        data = null;
        next = null;
        before = null;
    }
    
    public int size(){
        int res = 0;
        
        if(key != null){
            if(next != null){
                res = 1 + next.size();
            }else{
                res = 1;
            }
        }
        return  res;
    }
    
    public CompoundNode(K key, T data){
        this.key = key;
        this.data = data;
        next = null;
        before = null;
    }    

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CompoundNode<K,T> getNext() {
        return next;
    }

    public void setNext(CompoundNode<K,T> next) {
        this.next = next;
    }

    public CompoundNode<K,T> getBefore() {
        return before;
    }

    public void setBefore(CompoundNode<K,T> before) {
        this.before = before;
    }
}
