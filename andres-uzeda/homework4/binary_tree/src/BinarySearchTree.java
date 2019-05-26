


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
			Node other = (BinarySearchTree<E>.Node)obj;
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
			if (n.leftChild != null && n.rightChild != null){
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			} else if (parent == null) {
				root = n.leftChild != null ? n.leftChild : n.rightChild;
			} else if (parent.leftChild == n){
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
		if (val == null){
		    return null;
		}
		return findNodeInATree(root, val);
	}

	private Node findNodeInATree(Node node, E val){
        if (val.compareTo(node.value) == 0) {
            return node;
        } else if (val.compareTo(node.value) < 0) {
            if(node.leftChild == null){
                return null;
            }else{
                return  findNodeInATree(node.leftChild, val);
            }
        } else {
            if(node.rightChild == null){
                return null;
            }else{
                return findNodeInATree(node.rightChild, val);
            }
        }
    }
	
	// Method #2.
	protected int depth(E val) {
        if (val == null){
            return -1;
        }
		return depthOfANode(root, val);
	}

    private int depthOfANode(Node node, E val) {
        int compareResult = val.compareTo(node.value);
        if (compareResult == 0) {
            return 0;
        } else if (compareResult < 0) {
            if (node.leftChild == null) {
                return -1;
            } else {
                int depth = depthOfANode(node.leftChild, val);
                if(depth < 0){
                    return -1;
                }else{
                    return depth + 1;
                }
            }
        } else {
            if (node.rightChild == null) {
                return -1;
            } else {
                int depth = depthOfANode(node.rightChild, val);
                if(depth < 0){
                    return -1;
                }else{
                    return depth + 1;
                }
            }
        }
    }
	
	// Method #3.
	protected int height(E val) {
        if (val == null) return -1;
        Node node = findNode(val);
        return heightOfANode(node);
	}

    private int heightOfANode(Node node) {
        int left = 0;
        int right = 0;
	    if (node == null){
            return -1;
        }
        if(node.leftChild != null){
            left = 1 + heightOfANode(node.leftChild);
        }
        if(node.rightChild != null){
            right = 1 + heightOfANode(node.rightChild);
        }
        if(left >= right){
            return left;
        }else{
            return right;
        }
    }


	// Method #4.
	protected boolean isBalanced(Node n) {
        int left = -1;
        int right = -1;
	    if (n == null){
            return false;
        }
        if (!contains(n.value)){
            return false;
        }
        if(n.leftChild != null){
            left = heightOfANode(n.leftChild);
        }
        if(n.rightChild != null){
            right = heightOfANode(n.rightChild);
        }
        //absolute value
        if(Math.abs(left - right) <= 1){
            return true;
        }else{
            return false;
        }
	}
	
	// Method #5. .
	public boolean isBalanced() {
		return isABalancedTree(root);
	}

    private boolean isABalancedTree(Node node) {
        if (node == null || node.leftChild == null && node.rightChild == null){
            return true;
        }
        boolean leftBranch = node.leftChild == null || isBalanced(node.leftChild);
        boolean rightBranch = node.rightChild == null || isBalanced(node.rightChild);
        boolean isItBalanced = leftBranch && rightBranch;
        return isItBalanced && isABalancedTree(node.leftChild) && isABalancedTree(node.rightChild);
    }
}
