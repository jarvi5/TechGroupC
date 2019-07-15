package main;

import java.util.LinkedList;

/**
 * Created by Yury Ortuno on 7/15/2019.
 */
public class MultiList {
    private Node head = null;
    private int size = 0;

    private LinkedList linkedList= new LinkedList();
    private class Node {
        public Object object;
        public Node next;
        public Node previous;

        public Node(Object object) {
            this.object = object;
        }
    }


    public void addFirst(Object object) {
        Node node = new Node(object);
        node.next = head;
        head = node;
        size++;
    }

    public void addLast(Object object) {
        Node node = new Node(object);
        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = node;
        size++;
    }

    public void addAfterOfPosition(int position, Object object) {
        Node node = new Node(object);
        if (head == null) {
            head = node;
        } else {
            Node pointer = head;
            int cont = 0;
            while (cont < position && pointer.next != null) {
                pointer = pointer.next;
                cont++;
            }
            node.next = pointer.next;
            pointer.next = node;
        }
        size++;
    }

    public Object getItem(int position) {
        if (head == null) {
            return null;
        } else {
            Node pointer = head;
            int cont = 0;
            while (cont < position && pointer.next != null) {
                pointer = pointer.next;
                cont++;
            }
            return (cont == position) ? pointer.object : null;
        }
    }

    public int sizeList() {
        return size;
    }

    public void removeFirst() {
        if (head != null) {
            Node first = head;
            head = first.next;
            first.next = null;
            size--;
        }
    }
}


