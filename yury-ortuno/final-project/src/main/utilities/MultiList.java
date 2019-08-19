package main.utilities;

public class MultiList<T1, T2> {
    private MultiNode head;
    private MultiNode tail;
    private MultiNode tmp;
    private int size = 0;

    public MultiNode getActualNode() {
        return tmp;
    }

    public MultiNode getHeadNode() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addParent(T1 node) {
        MultiNode<T1, T2> newMultiNode = new MultiNode<>(node);
        if (tail == null) {
            head = newMultiNode;
        } else {
            tail.setNext(newMultiNode);
            newMultiNode.setPrevious(tail);
            newMultiNode.setNext(null);
        }
        tail = newMultiNode;
        size++;
    }

    public boolean addChild(T1 node, T2 childNode) {
        MultiNode current = head;
        while (current != null) {
            if (node == current.getNode()) {
                if (current.getChild() == null) {
                    DoubleLinkedList<T2> doubleLinkedList = new DoubleLinkedList<>();
                    doubleLinkedList.addToBack(childNode);
                    current.setChild(doubleLinkedList);
                } else {
                    current.getChild().addToBack(childNode);
                }
                return true;
            }
        }
        return false;

    }

    public void returnAllNodes() {
        MultiNode current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    public MultiNode next() {
        if (tmp == null) {
            tmp = head;
            return tmp;
        } else if (tmp.getNext() != null) {
            tmp = tmp.getNext();
            return tmp;
        } else {
            return tmp;
        }
    }

    public MultiNode previous() {
        if (tmp == null) {
            tmp = head;
            return tmp;
        } else if (tmp.getPrevious() != null) {
            tmp = tmp.getPrevious();
            return tmp;
        } else {
            return tmp;
        }
    }

    public DoubleLinkedList<T2> getChildFromParent(T1 node) {
        MultiNode current = head;
        while (current != null) {
            if (node == current.getNode()) {
                return current.getChild();
            }
            current = current.getNext();
        }
        return null;
    }

}
