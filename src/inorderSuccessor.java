public class inorderSuccessor {

	public inorderSuccessor() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	
	/**
	 * Structure of the tree
	 * */
	public static class Node {
		Node left;
		Node right;
		int value;
		Node parent;

		public Node(Node parent,int val) {
			this.value = val;
			this.parent = parent;
		}
	}
	
	/**
	 * Method called in constructor to invoke different tree functions
	 * */
	public void run() {
		Node rootNode = new Node(null,4);
		insertNode(rootNode, 5);
		insertNode(rootNode, 2);
		insertNode(rootNode, 3);
		insertNode(rootNode, 1);
		inorder(rootNode);
		System.out.println();	
		Node n = rootNode.left;
		Node insucc = inSuccessor(rootNode,n);
		if(insucc != null)
			System.out.println("The inorder successor of " + n.value + " is " + insucc.value);
		else 
			System.out.println(n.value + " is the right most node. Hence no inorder successor");
	}
	/**
	 * function to create a BST
	 * 
	 * */
	public void insertNode(Node node, int val) {
		if (node == null)
			return;
		if (val <= node.value) {
			if (node.left == null) {
				node.left = new Node(node,val);
			}
			else
				insertNode(node.left, val);
		} else {
			if (node.right == null)
				node.right = new Node(node,val);
			else
				insertNode(node.right, val);
		}
	}
	/**
	 * function to find the inorder successor of a given Node
	 * */
	public Node inSuccessor(Node root,Node node) {
		if(node == null || root == null) {
			return null;
		}
		Node p = node.parent;
		if(node.right != null) {
			node = node.right;
			while(node.left != null)
				node = node.left;
			return node;
		}else {			
			// loop until the node is the left child of the parent
			while(p != null && (node == p.right)) {
				node = p;
				p = p.parent;				
			}
		}		
		return p;
	}
	/**
	 * inorder traversal
	 * 
	 * */
	public void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		//if(node.parent != null )
			//System.out.print(node.parent.value + " ");
		System.out.print(node.value + " ");
		inorder(node.right);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new inorderSuccessor();
	}

}
