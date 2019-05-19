import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IsBalancedNodeTest {
    protected BinarySearchTree<String> tree;

    public IsBalancedNodeTest() {
    }

    @Before
    public void setUp() throws Exception {
        tree = new BinarySearchTree();
        tree.add("dog");
        tree.add("cat");
        tree.add("pig");
    }

    @Test
    public void testNull() {
        try {
            boolean bool = tree.isBalanced(null);
            Assert.assertFalse("isBalanced should be false when input value is null", bool);
        } catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when input value is null");
        }
    }

    @Test
    public void testNotInTreeDifferentValue() {
        BinarySearchTree.Node localNode = tree.findNode("banana");
        try {
            boolean bool = tree.isBalanced(localNode);
            Assert.assertFalse("isBalanced should be false when input Node is not in tree", bool);
        } catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when input Node is not in tree");
        }
    }

    @Test
    public void testRootBalanced() {
        BinarySearchTree.Node localNode = tree.findNode("dog");
        try {
            boolean bool = tree.isBalanced(localNode);
            Assert.assertTrue("isBalanced should be true when input Node is root of tree with two children", bool);
        } catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when input Node is root of tree with two children");
        }
    }

    @Test
    public void testLeaf() {
        BinarySearchTree.Node localNode = tree.findNode("cat");
        try {
            boolean bool = tree.isBalanced(localNode);
            Assert.assertTrue("isBalanced should be true when input Node is leaf", bool);
        } catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when input Node is leaf");
        }
    }

    @Test
    public void testLeftHeightIsOneGreaterThanRight() {
        tree.add("ant");
        BinarySearchTree.Node localNode = tree.findNode("dog");
        try {
            boolean bool = tree.isBalanced(localNode);
            Assert.assertTrue("isBalanced should be true when difference in heights of child nodes is 1", bool);
        } catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when difference in heights of child nodes is 1");
        }
    }

    @Test
    public void testRightHeightIsOneGreaterThanLeft() {
        tree.add("zebra");
        BinarySearchTree.Node localNode = tree.findNode("dog");
        try {
            boolean bool = tree.isBalanced(localNode);
            Assert.assertTrue("isBalanced should be true when difference in heights of child nodes is 1", bool);
        } catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when difference in heights of child nodes is 1");
        }
    }

    @Test
    public void testLeftHeightIsTwoGreaterThanRight() {
        tree.add("ant");
        tree.add("aah!");
        BinarySearchTree.Node localNode = tree.findNode("dog");
        try {
            boolean bool = tree.isBalanced(localNode);
            Assert.assertFalse("isBalanced should be false when difference in heights of child nodes is more than 1", bool);
        } catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when difference in heights of child nodes is more than 1");
        }
    }

    @Test
    public void testRightHeightIsTwoGreaterThanLeft() {
        tree.add("rat");
        tree.add("skunk");
        BinarySearchTree.Node localNode = tree.findNode("dog");
        try {
            boolean bool = tree.isBalanced(localNode);
            Assert.assertFalse("isBalanced should be false when difference in heights of child nodes is more than 1", bool);
        } catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when difference in heights of child nodes is more than 1");
        }
    }
}
