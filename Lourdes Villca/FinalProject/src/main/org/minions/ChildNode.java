package org.minions;

public class ChildNode<T2> extends Node<T2>{
    private ChildNode<T2> childNode;

    ChildNode(T2 value){
        super(value);
        childNode = null;
    }

    public ChildNode<T2> getChild() {
        return childNode;
    }

    public void setChild(ChildNode<T2> child) {
        this.childNode = child;
    }
    public void getParent(){

    }
}
