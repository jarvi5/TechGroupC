


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
        Node result = null;
        Node node = root;
        if (val != null) {
            while (node != null) {
                if (val.equals(node.value)) {
                    result = node;
                    break;
                } else {
                    node = getNode(val, node);
                }
            }
        }
        return result;
    }

    // Method #2.
    protected int depth(E val) {
        int result = -1;
        int count = 0;
        Node node = root;
        if (val != null && node != null) {
            while (node != null) {
                if (val.equals(node.value)) {
                    result = count;
                    break;
                } else {
                    node = getNode(val, node);
                }
                count++;
            }
        }
        return result;
    }

    private Node getNode(E val, Node node) {
        if (val.compareTo(node.value) < 0) {
            node = node.leftChild;
        } else {
            if (val.compareTo(node.value) > 0) {
                node = node.rightChild;
            }
        }
        return node;
    }

    // Method #3.
    protected int height(E val) {
        int result = -1;
        int countLeftChild = 0;
        int countRightChild = 0;
        Node node = root;
        if (val != null && node != null) {
            while (node != null) {
                if (val.equals(node.value)) {
                    result = getResultHeight(countLeftChild, countRightChild, node);
                    break;
                } else {
                    if (val.compareTo(node.value) < 0) {
                        node = node.leftChild;
                        countLeftChild++;
                    } else {
                        if (val.compareTo(node.value) > 0) {
                            node = node.rightChild;
                            countRightChild++;
                        }
                    }
                }
            }
        }
        return result;
    }

    private int getResultHeight(int countLeftChild, int countRightChild, Node node) {
        int result;
        if (node.leftChild == null || node.rightChild == null) {
            result = 0;
        } else {
            result = getNodoHeight(countLeftChild, countRightChild, node);
        }
        return result;
    }

    private int getNodoHeight(int countLeftChild, int countRightChild, Node node) {
        int result;
        if (node.leftChild.leftChild != null || node.rightChild.rightChild != null) {
            result = nodoSheet(node);
        } else {
            result = 1 + Math.max(countLeftChild, countRightChild);
        }
        return result;
    }

    private int nodoSheet(Node node) {
        int result = 0;
        while (node != null) {
            node = node.leftChild;
            result++;
        }
        return result - 1;
    }


    // Method #4.
    protected boolean isBalanced(Node n) {
        boolean result = false;
        if(n != null){
            int heightLeft = heightNode(n.leftChild);
            int heightRight = heightNode(n.rightChild);
            if (Math.abs(heightLeft - heightRight) <= 1) {
                result = true;
            }
        }
        return result;
    }

    // Method #5. .
    public boolean isBalanced() {
        boolean result = false;
        if(root != null){
            int heightLeft = heightNode(root.leftChild);
            int heightRight = heightNode(root.rightChild);
            if(heightLeft != -1 || heightRight != -1){
                if (Math.abs(heightLeft - heightRight) <= 1) {
                    result = true;
                }
            }
        }
        return result;
    }

    private int heightNode(Node node) {
        int result = 0;
        int left = 0;
        int right = 0;
        if (node != null) {
            left = heightNode(node.leftChild);
            right = heightNode(node.rightChild);
            if(left > right){
                result = left + 1;
            }else {
                result = right + 1;
            }
        }
        if(Math.abs(left - right) > 1){
            result = -1;
        }
        return result;
    }
}
