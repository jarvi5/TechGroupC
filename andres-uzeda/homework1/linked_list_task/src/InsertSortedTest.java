import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InsertSortedTest
{
    public InsertSortedTest() {}

    @Before
    public void setUp()
            throws Exception
    {}

    @Test
    public void testInsertMiddle()
    {
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(3));
        localLinkedList.addLast(Integer.valueOf(8));
        localLinkedList.addLast(Integer.valueOf(11));
        try
        {
            LinkedListUtils.insertSorted(localLinkedList, 10);
        }
        catch (Exception localException) {
            Assert.fail("insertSorted throws " + localException + " when placing value in middle of list");
        }

        Assert.assertTrue("insertSorted creates LinkedList of incorrect size when placing value in middle of list", localLinkedList.size() == 4);

        Assert.assertTrue("insertSorted does not correctly insert element when placing value in middle of list", ((Integer)localLinkedList.get(0)).intValue() == 3);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value in middle of list", ((Integer)localLinkedList.get(1)).intValue() == 8);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value in middle of list", ((Integer)localLinkedList.get(2)).intValue() == 10);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value in middle of list", ((Integer)localLinkedList.get(3)).intValue() == 11);
    }

    @Test
    public void testInsertEnd() {
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(3));
        localLinkedList.addLast(Integer.valueOf(8));
        localLinkedList.addLast(Integer.valueOf(11));
        try
        {
            LinkedListUtils.insertSorted(localLinkedList, 14);
        }
        catch (Exception localException) {
            Assert.fail("insertSorted throws " + localException + " when placing value at end of list");
        }

        Assert.assertTrue("insertSorted creates LinkedList of incorrect size when placing value at end of list", localLinkedList.size() == 4);

        Assert.assertTrue("insertSorted does not correctly insert element when placing value at end of list", ((Integer)localLinkedList.get(0)).intValue() == 3);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at end of list", ((Integer)localLinkedList.get(1)).intValue() == 8);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at end of list", ((Integer)localLinkedList.get(2)).intValue() == 11);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at end of list", ((Integer)localLinkedList.get(3)).intValue() == 14);
    }

    @Test
    public void testInsertFront() {
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(3));
        localLinkedList.addLast(Integer.valueOf(8));
        localLinkedList.addLast(Integer.valueOf(11));
        try
        {
            LinkedListUtils.insertSorted(localLinkedList, 1);
        }
        catch (Exception localException) {
            Assert.fail("insertSorted throws " + localException + " when placing value at front of list");
        }

        Assert.assertTrue("insertSorted creates LinkedList of incorrect size when placing value at front of list", localLinkedList.size() == 4);

        Assert.assertTrue("insertSorted does not correctly insert element when placing value at front of list", ((Integer)localLinkedList.get(0)).intValue() == 1);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at front of list", ((Integer)localLinkedList.get(1)).intValue() == 3);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at front of list", ((Integer)localLinkedList.get(2)).intValue() == 8);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at front of list", ((Integer)localLinkedList.get(3)).intValue() == 11);
    }

    @Test
    public void testInsertMiddleEqualToExistingElement() {
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(3));
        localLinkedList.addLast(Integer.valueOf(8));
        localLinkedList.addLast(Integer.valueOf(11));
        try
        {
            LinkedListUtils.insertSorted(localLinkedList, 8);
        }
        catch (Exception localException) {
            Assert.fail("insertSorted throws " + localException + " when placing value that is equal to value already in list");
        }

        Assert.assertTrue("insertSorted creates LinkedList of incorrect size when placing value that is equal to value already in list", localLinkedList.size() == 4);

        Assert.assertTrue("insertSorted does not correctly insert element when placing value that is equal to value already in list", ((Integer)localLinkedList.get(0)).intValue() == 3);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value that is equal to value already in list", ((Integer)localLinkedList.get(1)).intValue() == 8);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value that is equal to value already in list", ((Integer)localLinkedList.get(2)).intValue() == 8);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value that is equal to value already in list", ((Integer)localLinkedList.get(3)).intValue() == 11);
    }

    @Test
    public void testNull() {
        try {
            LinkedListUtils.insertSorted(null, 0);
        }
        catch (Exception localException) {
            Assert.fail("insertSorted throws " + localException + " when input LinkedList is null");
        }
    }

    @Test
    public void testInsertEmpty() {
        LinkedList localLinkedList = new LinkedList();
        try
        {
            LinkedListUtils.insertSorted(localLinkedList, 10);
        }
        catch (Exception localException) {
            Assert.fail("insertSorted throws " + localException + " when inserting into empty list");
        }

        Assert.assertTrue("insertSorted creates LinkedList of incorrect size when inserting into empty list", localLinkedList.size() == 1);

        Assert.assertTrue("insertSorted does not correctly insert element into empty list", ((Integer)localLinkedList.get(0)).intValue() == 10);
    }
}