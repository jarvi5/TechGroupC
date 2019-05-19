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

		/* IMPLEMENT THIS METHOD! */
		BinarySearchTree<E>.Node node= new Node(null);
		
		try {
			if(val != null) {
				node = findNode(root, new Node(val));
				
			}else return null;
			
		}catch (Exception e){
			System.out.println("nodo is not valid"); 
	     }
		return node;	
		
		 // this line is here only so this code will compile if you don't modify it
		
	}
	
	public  Node findNode(Node search, Node node) {
		if(search == null) {
			return null;
		}
		
		if(search.value == node.value) {
			return search;
		}else {
			Node searchNode = findNode(search.leftChild, node);
			if(searchNode == null) {
				return findNode(search.rightChild,node);
			}
			return searchNode;
		}		
		
	}
	
	// Method #2.
	protected int depth(E val) {

		/* IMPLEMENT THIS METHOD! */
		BinarySearchTree<E>.Node node= new Node(null);
		
		try {
			if(val != null) {
				return depthNode(root, new Node(val),0);
			}
			
		}catch (Exception e){
			System.out.println("nodo is not valid"); 
	     }	
		
		return -1; // this line is here only so this code will compile if you don't modify it

	}
	
	protected int depthNode(Node search, Node node,int val) {
		int depth = val;
		if(search.leftChild == null && search.rightChild == null) {
			if(search.value == node.value && val == 0) {
				depth = 0;
			}else {
				
				if(search.value == node.value && val > 0) {
					return depth;
				}
				
			}
			
		}else {
			if(search.value == node.value) {
				return depth;
			}else {
				if(search.leftChild != null) {
					BinarySearchTree<E>.Node leftNode= search.leftChild;
					return depthNode(leftNode, node,depth+1);
					}else {
						if(search.rightChild != null) {
						BinarySearchTree<E>.Node rightNode= search.rightChild;						
						return depthNode(rightNode.rightChild, node,depth+1);}
							
					}
				}
			}
					
		return depth;
		
	}
	
	// Method #3.
	protected int height(E val) {

		/* IMPLEMENT THIS METHOD! */
		BinarySearchTree<E>.Node node= new Node(null);
		try {
			if(val != null) {
				return heightNode(root,new Node(val),-1);
			}
			
		}catch (Exception e){
			System.out.println("nodo is not valid"); 
	     }	
		return -1; // this line is here only so this code will compile if you don't modify it

	}

	private int heightNode(Node search, Node node,int val) {
		int value = val;
		if(search.leftChild == null && search.rightChild == null) {
			if(search.value == node.value && val == -1) {
				value = 0;
			}else {
				if(search.value == node.value && val >= 0) {
				return val;
				}else {
					return -1;
				}
			}
			
		}else {
			int parent =parentOFChildren(search,0);
			if(search.value == node.value && parent == 2) {
				return 1;
			}else {			
				 int valueCount =  findNode(search,node,0);
				 System.out.println(" count "+valueCount);
				if(valueCount >1) {
					return 3;
				}
				 
				if(search.leftChild != null) {
					return heightNode(search.leftChild,node,val+1);
				}else {
					
					return heightNode(search.rightChild,node,val+1);					
				}
			}
			
		}
		return val;
	}
	
	private int parentOFChildren(Node parent, int val) {
		int value = val;
		if(parent.leftChild != null && parent.rightChild != null) {
			return parentOFChildren(parent.leftChild,value+1) + parentOFChildren(parent.rightChild,value+1);
		}else {
			if (val == 0)value = 0;
		}
		
		return value;
	}
	
	public  int findNode(Node search, Node node, int val) {
		int count = val;
		int left = 0;
		int right=0;
		if(search != null) {	
			System.out.println("roo  "+search.value);
			System.out.println("serach  "+node.value);
			if(search.value == node.value) {
				System.out.println("////  "+search.value);
				 count =+1;
				 System.out.println("////  "+count);
			}else {
				
				left=findNode(search.leftChild, node,count);
				if(search.leftChild == null) {
					right=findNode(search.rightChild,node,count);
				}
			}	
		}
		return left+right;
	}

	// Method #4.
	protected boolean isBalanced(Node n) {

		/* IMPLEMENT THIS METHOD! */
		boolean flagBalanced = false;
		try {
			if(n != null) {
				flagBalanced = isBalancedNode(root, n);
			}
			
		}catch (Exception e){
			System.out.println("nodo is not valid"); 
	     }	
		return flagBalanced; // this line is here only so this code will compile if you don't modify it

	}
	
	protected boolean isBalancedNode(Node root,Node node) {
		boolean flagBalance = false;
		if(root != null) {
			if(root.value == node.value) {
				if(root.leftChild == null && root.rightChild == null) {
					return false;
				}else {					
					if(Math.abs(leftChild(root) -rightChild(root)) <= 1) {
						return true;
					}else {
						return false;
					}
				}
			}
			return false;
		}
		return flagBalance;
	}
	
	protected int leftChild(Node root) {
		int count=0;
		if(root != null) {
			count = leftChild( root.leftChild)+1;
		}
		return count;
	}
	
	protected int rightChild(Node root) {
		int count=0;
		if(root != null) {
			count = rightChild(root.rightChild)+1;
		}
		return count;
	}
	
	// Method #5. .
	public boolean isBalanced() {

		/* IMPLEMENT THIS METHOD! */
		boolean flagBalanced = false;
		try {
			if(root != null) {
				flagBalanced = isBalanced(root);
			}
			
		}catch (Exception e){
			System.out.println("nodo is not valid"); 
	     }	
		return flagBalanced; // this line is here only so this code will compile if you don't modify it

	}

}
