public class TestTree {
    public static void main(String[] paramArrayOfString) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(12);
        tree.add(13);
        tree.add(10);
        tree.add(9);
        tree.add(8);
        tree.add(7);
        tree.add(1);
        System.out.println(tree.root.value);
        System.out.println(tree.findNode(9).value);
        System.out.println(tree.findNode(10).value);
        System.out.println(tree.findNode(13).value);
        System.out.println(tree.findNode(12).value);
        System.out.println("******depth******");
        System.out.println(tree.depth(1));
        System.out.println("******heigth******");
        System.out.println(tree.height(13));
        System.out.println(tree.height(7));
        System.out.println(tree.isBalanced());
    }
}
