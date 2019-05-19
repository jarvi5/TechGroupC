import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeightTest {
    protected BinarySearchTree<String> tree;

    public HeightTest() {
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
            int i = tree.height(null);
            Assert.assertEquals("height should be -1 when input value is null", -1L, i);
        } catch (Exception localException) {
            Assert.fail("height throws " + localException + " when input value is null");
        }
    }

    @Test
    public void testNotInTree() {
        try {
            int i = tree.height("banana");
            Assert.assertEquals("height should be -1 when input value is not in tree", -1L, i);
        } catch (Exception localException) {
            Assert.fail("height throws " + localException + " when input value is not in tree");
        }
    }

    @Test
    public void testLeaf() {
        try {
            int i = tree.height("cat");
            Assert.assertEquals("height should be 0 when input value is leaf", 0L, i);
        } catch (Exception localException) {
            Assert.fail("height throws " + localException + " when input value is leaf");
        }
    }

    @Test
    public void testParentOfLeaves() {
        try {
            int i = tree.height("dog");
            Assert.assertEquals("height should be 1 when input value is parent of two leaves", 1L, i);
        } catch (Exception localException) {
            Assert.fail("height throws " + localException + " when input value is parent of two leaves");
        }
    }

    @Test
    public void testNumerousDescendants() {
        tree.add("ant");
        tree.add("cow");
        tree.add("aah!");
        try {
            int i = tree.height("dog");
            Assert.assertTrue("height incorrect when input value has numerous descendants", 3 == i);
        } catch (Exception localException) {
            Assert.fail("height throws " + localException + " when input value has numerous descendants");
        }
    }
}
