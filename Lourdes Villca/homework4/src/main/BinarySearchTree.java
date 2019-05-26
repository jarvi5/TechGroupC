


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
        return getNode(root, val);

    }

    protected Node getNode(Node n, E val) {
        if (n == null || val == null) return null;
        if (n.value.equals(val)) {
            return n;
        } else if (n.value.compareTo(val) > 0) {
            return getNode(n.leftChild, val);
        } else {
            return getNode(n.rightChild, val);
        }
    }

    // Method #2.
    protected int depth(E val) {
        int count = 0;
        return calculateDepth(root, val, count);
    }

    protected int calculateDepth(Node n, E val, int count) {
        if (n == null || val == null) return -1;
        if (n.value.equals(val)) {
            return count++;
        } else if (n.value.compareTo(val) > 0) {
            count ++;
            return calculateDepth(n.leftChild, val, count);
        } else {
            count ++;
            return calculateDepth(n.rightChild, val, count);
        }
    }

    // Method #3.
    protected int height(E val) {
        Node node = findNode(val);
        return getHeightTree(node);

    }

    protected int getHeightTree(Node node) {
        if (node == null)
            return -1;
        if (node.rightChild == null && node.leftChild == null) {
            return 0;
        }
        int leftCount = getHeightTree(node.leftChild);
        int rightCount = getHeightTree(node.rightChild);
        return Math.max(leftCount, rightCount) + 1;
    }

    // Method #4.
    protected boolean isBalanced(Node n) {
        if (n == null || !contains(n.value)) {
            return false;
        }
        int heightDiff = Math.abs(getHeightTree(n.leftChild) - getHeightTree(n.rightChild));
        if (heightDiff <= 1) {
            return true;
        } else {
            return isBalanced(n.leftChild) && isBalanced(n.rightChild);
        }

    }

    // Method #5. .
    public boolean isBalanced() {
        return isBalanced(root.leftChild) && isBalanced(root.rightChild);
    }

}