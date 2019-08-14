package model.dataStructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleLinkedListTest {

    @Test
    public void addFirst() {
        DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst("v1");
        doubleLinkedList.addFirst("v2");
        assertEquals("v2", doubleLinkedList.getFirstNode().data);
    }

    @org.junit.Test
    public void addLast() {
        DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addLast("v1");
        doubleLinkedList.addLast("v2");
        assertEquals("v2", doubleLinkedList.getLastNode().data);
    }

    @org.junit.Test
    public void previous() {
        DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addLast("v1");
        doubleLinkedList.addLast("v2");
        assertEquals("v1", doubleLinkedList.previous());
    }

    @org.junit.Test
    public void next() {
        DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addLast("v1");
        doubleLinkedList.addLast("v2");
        doubleLinkedList.previous();
        assertEquals("v2", doubleLinkedList.next());

    }

    @org.junit.Test
    public void search() {
        DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addLast("v1");
        doubleLinkedList.addLast("v2");
        assertEquals("v1", doubleLinkedList.search("v1"));

    }

    @org.junit.Test
    public void removeCurrent() {
        DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addLast("v1");
        doubleLinkedList.addLast("v2");
        doubleLinkedList.addLast("v3");
        doubleLinkedList.previous();
        assertEquals("v2", doubleLinkedList.removeCurrent());
        assertEquals("v3", doubleLinkedList.getCurrentData());

    }





}