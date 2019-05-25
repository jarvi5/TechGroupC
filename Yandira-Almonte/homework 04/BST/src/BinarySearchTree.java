
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
			return other.value.compareTo(value) == 0 && other.leftChild == leftChild && other.rightChild == rightChild;
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
		if (n == null)
			return false;

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
			return false; // this ensures that the same value does not appear
							// more than once
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
		if (n == null)
			return false;

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
		if (val != null && contains(val))
			return search(root, val);
		return null;

	}

	protected Node search(Node node, E val) {
		if (node == null)
			return null;

		if (node.value.equals(val))
			return node;

		else if (val.compareTo(node.value) < 0)
			return search(node.leftChild, val);
		else
			return search(node.rightChild, val);

	}

	// Method #2.
	protected int depth(E val) {

		if (root == null || val == null || !contains(val))
			return -1;

		return depth(root,val,0); 

	}

	
	private int depth(Node node,E key,int level)
	{
		if(node==null)
			return 0;
		if(node.value.equals(key))
			return level;
 
		int result=depth(node.leftChild,key,level+1) ;
		if(result!=0)
			return result;
		
		result= depth(node.rightChild,key,level+1);
 
		return result;
	}
	
	
	// Method #3.
	protected int height(E val) {

		if (root == null || val == null) {
			return -1;
		}

		Node temp = findNode(val);
		if (temp == null)
			return -1;

		return height(temp); 

	}

	protected int height(Node node) {
        Node left = node.leftChild;
        Node right = node.rightChild;

        if (left == null && right == null)
            return 0;
        else if (left == null)
            return 1 + height(right);
        else if (right == null)
            return 1 + height(left);
        else
            return 1 + Math.max(height(left), height(right));
    }
	
	// Method #4.
	protected boolean isBalanced(Node n) {
		if (n == null)
			return false;
		int heightLeft = height(n.leftChild);
		int heightRight = height(n.rightChild);
		if (Math.abs(heightLeft - heightRight) <= 1) {
			return true;
		}
		return false;

	}

	// Method #5. .
	public boolean isBalanced() {
		if (root != null) {
			int heightLeft = height(root.leftChild);
			int heightRight = height(root.rightChild);
			if (heightLeft != -1 || heightRight != -1) {
				if (Math.abs(heightLeft - heightRight) <= 1) {
					return true;
				}
			}
		}

		return false; 

	}

}
