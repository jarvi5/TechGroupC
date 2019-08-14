package projectList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MultipleLinkedList<K,T> implements Iterable<CompoundNode<K,T>>{
    CompoundNode<K, T> head;
    CompoundNode<K, T> tail;
    public MultipleLinkedList(){
        head = null;
        tail = null;
    }
    
    public boolean isEmpty(){
        boolean res = true;
        if(head != null){
            res = false;
        }
        return res;
    }
    
    public int size(){
        int res = 0;
        if(head != null){
            if(head.getData().equals(tail.getData()) && head.getKey().equals(tail.getKey())){
                res = 1;
            } else{
                res = head.size();
            }
        }
        
        return res;
    }
    
    public void addEnding(K key, T data){
    
       if(isEmpty()){
           head = new CompoundNode<K, T>(key, data);
           tail = head;
           head.setNext(tail);
           tail.setBefore(head);
       } else{
           CompoundNode<K,T> aux = new CompoundNode<>(key, data);
           if(size() == 1){
               
               head.setNext(aux);
               tail = aux;
           } else{
               aux.setBefore(tail);
               tail.setNext(aux);
               tail = aux;
           }
       }
    }
    
    public void addBegining(K key, T data){
        if(isEmpty()){
           head = new CompoundNode<K, T>(key, data);
           tail = head;
           head.setNext(tail);
           tail.setBefore(head);
       } else{
            CompoundNode<K,T> aux = new CompoundNode<>(key, data);
           if(size() == 1){
               aux.setNext(head);
               head.setBefore(aux);
               head = aux;
               tail = head.getNext();
               tail.setNext(null);
           } else{
               
               head.setBefore(aux);
               aux.setNext(head);
               head = aux;
           }
       }
    }
    
    public T findDataByKey(Comparable key){
        T res = null;
        if(!isEmpty()){
            Iterator it = iterator();

            while(res == null && it.hasNext()){
                CompoundNode<K,T> aux = (CompoundNode<K,T>) it.next();
                if(key.compareTo(aux.getKey()) == 0){
                    res = aux.getData();
                }
            }
        }
        return res;
    }
    
    public K findBeforeKey(Comparable key) {
    	K res = null;
        if(!isEmpty()){
            Iterator it = iterator();

            while(res == null && it.hasNext()){
                CompoundNode<K,T> aux = (CompoundNode<K,T>) it.next();
                if(key.compareTo(aux.getKey()) == 0){
                    if(aux.getBefore() != null) {
                    	res = aux.getBefore().getKey();
                    }
                }
            }
        }
        return res;
    }

    public K findAfterKey(Comparable key) {
    	K res = null;
        if(!isEmpty()){
            Iterator it = iterator();

            while(res == null && it.hasNext()){
                CompoundNode<K,T> aux = (CompoundNode<K,T>) it.next();
                if(key.compareTo(aux.getKey()) == 0){
                    if(aux.getBefore() != null) {
                    	res = aux.getBefore().getKey();
                    }
                }
            }
        }
        return res;
    }    
    
    
    public CompoundNode<K, T> getLast() {
    	return tail;
    }
    
    public CompoundNode<K, T> getFirst() {
    	return head;
    }

    @Override
    public Iterator<CompoundNode<K,T>> iterator() {
        Iterator it = new MultipleLinkedListIterator();
        return it;  
    }

    protected class MultipleLinkedListIterator implements Iterator<CompoundNode<K,T>> {
        private CompoundNode<K,T> aux;
        
        public MultipleLinkedListIterator() {
            aux = head;
        }

        @Override
        public boolean hasNext() {
            boolean res = false;
            if(aux != null){
                res = true;
            }
                return res;
        }

        @Override
        public CompoundNode<K,T> next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            CompoundNode<K,T> tmp = aux;
            aux = aux.getNext();
            return tmp;
        }
    }

}
