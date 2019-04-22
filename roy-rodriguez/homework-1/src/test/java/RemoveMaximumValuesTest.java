import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;


public class RemoveMaximumValuesTest {

    @Test
    public void testNull() {
        try {
            LinkedListUtils.removeMaximumValues(null, 2);
        } catch (Exception localException) {
            Assert.fail("removeMaximumValues throws " + localException + " when input LinkedList is null");
        }
    }

    @Test
    public void testNegativeSize() {
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add("doge");
        localLinkedList.add("cat");
        try {
            LinkedListUtils.removeMaximumValues(localLinkedList, -1);
        } catch (Exception localException) {
            Assert.fail("removeMaximumValues throws " + localException + " when number of elements to remove is negative");
        }

        if (localLinkedList.size() < 2) {
            Assert.fail("removeMaximumValues removes elements from LinkedList when number of elenents to remove is negative");
        }

        if (localLinkedList.size() > 2) {
            Assert.fail("removeMaximumValues adds elements to LinkedList when number of elenents to remove is negative");
        }
    }

    @Test
    public void testInsertEmpty() {
        LinkedList localLinkedList = new LinkedList();
        try {
            LinkedListUtils.removeMaximumValues(localLinkedList, 1);
        } catch (Exception localException) {
            Assert.fail("removeMaximumValues throws " + localException + " when input LinkedList is empty");
        }

        Assert.assertTrue("removeMaximumValues adds elements to list when input LinkedList is empty", localLinkedList.isEmpty());
    }

    @Test
    public void testRemoveGreaterThanSize() {
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add("doge");
        try {
            LinkedListUtils.removeMaximumValues(localLinkedList, 2);
        } catch (Exception localException) {
            Assert.fail("removeMaximumValues throws " + localException + " when number of elements to remove is greater than size of input LinkedList");
        }

        Assert.assertTrue("removeMaximumValues does not remove all elements when number of elements to remove is greater than size of input LinkedList", localLinkedList.isEmpty());
    }


    @Test
    public void testRemoveEqualsSize() {
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add("doge");
        try {
            LinkedListUtils.removeMaximumValues(localLinkedList, 1);
        } catch (Exception localException) {
            Assert.fail("removeMaximumValues throws " + localException + " when number of elements to remove equals size of input LinkedList");
        }

        Assert.assertTrue("removeMaximumValues does not remove all elements when number of elements to remove equals size of input LinkedList", localLinkedList.isEmpty());
    }

    @Test
    public void testEachMaxAppearsOnce() {
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add("doge");
        localLinkedList.add("cat");
        localLinkedList.add("kangaroo");
        localLinkedList.add("koala");
        localLinkedList.add("bear");
        try {
            LinkedListUtils.removeMaximumValues(localLinkedList, 2);
        } catch (Exception localException) {
            Assert.fail("removeMaximumValues throws " + localException + " when number of elements to remove is less than size of input");
        }

        if (localLinkedList.size() < 3) {
            Assert.fail("removeMaximumValues removes too many elements from LinkedList when number of elements to remove is less than size of input");
        }
        if (localLinkedList.size() > 3) {
            Assert.fail("removeMaximumValues does not remove enough elements from LinkedList when number of elements to remove is less than size of input");
        }

        if ((localLinkedList.contains("kangaroo")) || (localLinkedList.contains("koala"))) {
            Assert.fail("removeMaximumValues does not remove correct elements from LinkedList when number of elements to remove is less than size of input");
        }

        Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input", ((String) localLinkedList.get(0)).equals("doge"));
        Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input", ((String) localLinkedList.get(1)).equals("cat"));
        Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input", ((String) localLinkedList.get(2)).equals("bear"));
    }

    @Test
    public void testMaxValuesAppearMoreThanOnce() {
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add("doge");
        localLinkedList.add("kangaroo");
        localLinkedList.add("cat");
        localLinkedList.add("kangaroo");
        localLinkedList.add("koala");
        localLinkedList.add("bear");
        localLinkedList.add("doge");
        localLinkedList.add("koala");
        localLinkedList.add("kangaroo");
        try {
            LinkedListUtils.removeMaximumValues(localLinkedList, 2);
        } catch (Exception localException) {
            Assert.fail("removeMaximumValues throws " + localException + " when number of elements to remove is less than size of input and maximum elements appear more than once");
        }

        if (localLinkedList.size() < 4) {
            Assert.fail("removeMaximumValues removes too many elements from LinkedList when number of elements to remove is less than size of input and maximum elements appear more than once");
        }

        if ((localLinkedList.contains("kangaroo")) || (localLinkedList.contains("koala"))) {
            Assert.fail("removeMaximumValues does not remove all instances of max elements from LinkedList when number of elements to remove is less than size of input and maximum elements appear more than once");
        }

        if (localLinkedList.size() > 4) {
            Assert.fail("removeMaximumValues does not remove enough elements from LinkedList when number of elements to remove is less than size of input and maximum elements appear more than once");
        }

        Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input and maximum elements appear more than once", ((String) localLinkedList.get(0)).equals("doge"));
        Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input and maximum elements appear more than once", ((String) localLinkedList.get(1)).equals("cat"));
        Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input and maximum elements appear more than once", ((String) localLinkedList.get(2)).equals("bear"));
        Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input and maximum elements appear more than once", ((String) localLinkedList.get(3)).equals("doge"));
    }
}
