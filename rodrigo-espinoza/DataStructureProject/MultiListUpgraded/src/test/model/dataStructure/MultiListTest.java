package model.dataStructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiListTest {

    @Test
    public void addBack() {
        MultiList<String, Integer> multiList = new MultiList<>();
        multiList.addBack("v1");
        multiList.addBack("v2");
        assertEquals("v2", multiList.getCurrentMultiNode().value);
    }

    @Test
    public void addChildToFirst() {
    }

    @Test
    public void addChildToCurrent() {
    }

    @Test
    public void previous() {
    }

    @Test
    public void next() {
    }

    @Test
    public void search() {
        MultiList<String, Integer> multiList = new MultiList<>();
        multiList.addBack("v1");
        multiList.addBack("v2");
        assertEquals("v1", multiList.search("v1"));
    }

    @Test
    public void removeCurrent() {
    }
}