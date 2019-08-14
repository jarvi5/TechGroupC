package model.dataStructure;


public class MultiList<E extends Comparable,T extends Comparable> {
    protected DoubleLinkedList<MultiNode<E,T>> doubleLinkedList;
    protected MultiNode<E,T> currentMultiNode;


    public MultiList() {
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public void addBack(E value) {
        MultiNode<E,T> multiNode = new MultiNode<>(value);
        doubleLinkedList.addLast(multiNode);
        currentMultiNode = multiNode;
    }

    public  void addChildToFirst(T data){
        currentMultiNode.getChildren().addFirst(data);
    }

    public void addChildToCurrent(T data){
        currentMultiNode.getChildren().addLast(data);
    }

    public E previous(){
        currentMultiNode = doubleLinkedList.previous();
        return currentMultiNode.value;
    }

    public E next(){
        currentMultiNode = doubleLinkedList.next();
        return currentMultiNode.value;
    }

    public E search(E value){
       // MultiNode<E,T> iterator = doubleLinkedList.getFirst();
        MultiNode<E,T> comparator = new MultiNode<>(value);
        currentMultiNode = doubleLinkedList.search(comparator);

        return currentMultiNode.value;
    }

    public E updateCurrent(E data){
        currentMultiNode.value = data;
        return currentMultiNode.value;
    }

    public E removeCurrent(){
        MultiNode<E, T> multiNode = doubleLinkedList.removeCurrent();
        currentMultiNode = doubleLinkedList.getCurrentData();
        return multiNode.value;
    }

    public T updateCurrentChild(T value){
        currentMultiNode.getChildren().updateCurrent(value);
        return currentMultiNode.getChildren().getCurrentData();
    }

    public MultiNode<E, T> getCurrentMultiNode() {
        return currentMultiNode;
    }

    public void setCurrentMultiNode(MultiNode<E, T> currentMultiNode) {
        this.currentMultiNode = currentMultiNode;
    }

    public T nextCurrentChild(){
        return currentMultiNode.getChildren().next();
    }

    public T previousCurrentChild(){
        return currentMultiNode.getChildren().previous();
    }

    public E getCurrentValue(){
        return currentMultiNode.value;
    }

    public T getCurrentChild(){
        return currentMultiNode.getChildren().getCurrentData();
    }

    public DoubleLinkedList<T> getCurrentChildrenList(){
        return currentMultiNode.getChildren();
    }
 }
