


public class BinarySearchTree<E extends Comparable<E>> {
    class Node {
        E value;
        Node leftChild = null;
        Node rightChild = null;

        Node(E value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if ((obj instanceof BinarySearchTree.Node) == false)
                return false;
            @SuppressWarnings("unchecked")
            Node other = (BinarySearchTree<E>.Node) obj;
            return other.value.compareTo(value) == 0 &&
                    other.leftChild == leftChild && other.rightChild == rightChild;
        }
    }

    protected Node root = null;

    protected void visit(Node n) {
        System.out.println(n.value);
    }

    public boolean contains(E val) {
        return contains(root, val);
    }

    protected boolean contains(Node n, E val) {
        if (n == null) return false;

        if (n.value.equals(val)) {
            return true;
        } else if (n.value.compareTo(val) > 0) {
            return contains(n.leftChild, val);
        } else {
            return contains(n.rightChild, val);
        }
    }

    public boolean add(E val) {
        if (root == null) {
            root = new Node(val);
            return true;
        }
        return add(root, val);
    }

    protected boolean add(Node n, E val) {
        if (n == null) {
            return false;
        }
        int cmp = val.compareTo(n.value);
        if (cmp == 0) {
            return false; // this ensures that the same value does not appear more than once
        } else if (cmp < 0) {
            if (n.leftChild == null) {
                n.leftChild = new Node(val);
                return true;
            } else {
                return add(n.leftChild, val);
            }
        } else {
            if (n.rightChild == null) {
                n.rightChild = new Node(val);
                return true;
            } else {
                return add(n.rightChild, val);
            }
        }
    }

    public boolean remove(E val) {
        return remove(root, null, val);
    }

    protected boolean remove(Node n, Node parent, E val) {
        if (n == null) return false;

        if (val.compareTo(n.value) == -1) {
            return remove(n.leftChild, n, val);
        } else if (val.compareTo(n.value) == 1) {
            return remove(n.rightChild, n, val);
        } else {
            if (n.leftChild != null && n.rightChild != null) {
                n.value = maxValue(n.leftChild);
                remove(n.leftChild, n, n.value);
            } else if (parent == null) {
                root = n.leftChild != null ? n.leftChild : n.rightChild;
            } else if (parent.leftChild == n) {
                parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
            } else {
                parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
            }
            return true;
        }
    }

    protected E maxValue(Node n) {
        if (n.rightChild == null) {
            return n.value;
        } else {
            return maxValue(n.rightChild);
        }
    }


    /*********************************************
     *
     * IMPLEMENT THE METHODS BELOW!
     *
     *********************************************/


    // Method #1.
    public Node findNode(E val) {
        if (val == null) return null;
        return findNode(root, val);
    }

    private Node findNode(Node node, E val) {

        if (node != null && val != null) {
            if (val.equals(node.value)) {
                return node;
            } else if (val.compareTo(node.value) > 0) {
                return findNode(node.rightChild, val);
            } else if (val.compareTo(node.value) < 0) {
                return findNode(node.leftChild, val);
            }
        }
        return null;
    }

    // Method #2.
    protected int depth(E val) {

        if (val == null) return -1;
        if (val.compareTo(root.value) == 0) {
            return 0;
        }
        return depth(root, val);
    }

    private int depth(Node n, E val) {
        int cmp = val.compareTo(n.value);
        if (cmp == 0) {
            return 0;
        } else if (cmp < 0) {
            if (n.leftChild == null) {
                return -1;
            } else {
                int depth = depth(n.leftChild, val);
                return depth < 0 ? -1 : depth + 1;
            }
        } else {
            if (n.rightChild == null) {
                return -1;
            } else {
                int depth = depth(n.rightChild, val);
                return depth < 0 ? -1 : depth + 1;
            }
        }
    }

    // Method #3.
    protected int height(E val) {

        Node valNode = findNode(val);
        if (valNode != null) {
            return height(valNode);
        }
        return -1;

    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = 0;
        int rightHeight = 0;

        if (node.leftChild != null) {
            leftHeight = 1 + height(node.leftChild);
        }
        if (node.rightChild != null) {
            rightHeight = 1 + height(node.rightChild);
        }
        return Math.max(leftHeight, rightHeight);
    }


    // Method #4.
    protected boolean isBalanced(Node n) {

        if (n == null) {
            return false;
        }
        if (!contains(n.value)) {
            return false;
        }

        int leftHeight = height(n.leftChild);
        int rightHeight = height(n.rightChild);
        return Math.abs(leftHeight - rightHeight) <= 1;
    }

    // Method #5. .
    public boolean isBalanced() {

        return allBalanced(root);

    }

    private boolean allBalanced(Node n) {
        if (n == null || n.leftChild == null && n.rightChild == null) return true;
        boolean left = n.leftChild == null || isBalanced(n.leftChild);
        boolean right = n.rightChild == null || isBalanced(n.rightChild);
        boolean balanced = left && right;
        return balanced && allBalanced(n.leftChild) && allBalanced(n.rightChild);
    }

}
