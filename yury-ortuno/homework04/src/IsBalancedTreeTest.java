import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IsBalancedTreeTest
{
    protected BinarySearchTree<String> tree;

    public IsBalancedTreeTest() {}

    @Before
    public void setUp() throws Exception
    {
        tree = new BinarySearchTree();
        tree.add("dog");
        tree.add("cat");
        tree.add("pig");
    }

    @Test
    public void testRootAndTwoChildren()
    {
        try {
            boolean bool = tree.isBalanced();
            Assert.assertTrue("isBalanced should be true when only nodes are root of tree and its two children", bool);
        }
        catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when only nodes are root of tree and its two children");
        }
    }

    @Test
    public void testRootAndTwoChildrenAndOneLeftGrandchild() {
        tree.add("ant");
        try {
            boolean bool = tree.isBalanced();
            Assert.assertTrue("isBalanced should be true when difference in heights of root's left and right subtrees is 1", bool);
        }
        catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when difference in heights of root's left and right subtrees is 1");
        }
    }

    @Test
    public void testRootAndTwoChildrenAndOneRightGrandchild() {
        tree.add("skunk");
        try {
            boolean bool = tree.isBalanced();
            Assert.assertTrue("isBalanced should be true when difference in heights of root's left and right subtrees is 1", bool);
        }
        catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when difference in heights of root's left and right subtrees is 1");
        }
    }

    @Test
    public void testRightHeightIsMoreThanOneGreaterThanLeft() {
        tree.add("skunk");
        tree.add("zebra");
        try {
            boolean bool = tree.isBalanced();
            Assert.assertFalse("isBalanced should be false when difference in heights of root's left and right subtrees is greater than 1", bool);
        }
        catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when difference in heights of root's left and right subtrees is greater than 1");
        }
    }

    @Test
    public void testLeftHeightIsMoreThanOneGreaterThanRight() {
        tree.add("ant");
        tree.add("aah!");
        try {
            boolean bool = tree.isBalanced();
            Assert.assertFalse("isBalanced should be false when difference in heights of root's left and right subtrees is greater than 1", bool);
        }
        catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when difference in heights of root's left and right subtrees is greater than 1");
        }
    }

    @Test
    public void testRootIsBalancedButChildrenAreNot() {
        tree.add("ant");
        tree.add("aah!");
        tree.add("skunk");
        tree.add("zebra");
        try {
            boolean bool = tree.isBalanced();
            Assert.assertFalse("isBalanced should be false when root Node is balanced but its children are not", bool);
        }
        catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when root Node is balanced but its children are not");
        }
    }
}
