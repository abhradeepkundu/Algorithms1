public class FillGrandParent {

	public FillGrandParent() {
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
		Node gp;

		public Node(int val) {
			this.value = val;
		}
	}

	/**
	 * Method called in constructor to invoke different tree functions
	 * */
	public void run() {
		Node rootNode = new Node(25);
		insertNode(rootNode, 35);
		insertNode(rootNode, 15);
		insertNode(rootNode, 12);
		insertNode(rootNode, 38);
		insertNode(rootNode, 17);
		insertNode(rootNode, 19);
		insertNode(rootNode, 36);
		//inorder(rootNode);
		fillGPUtil(rootNode);
		System.out.println();
		printGP(rootNode);

	}

	public void printGP(Node node) {
		
		if(node == null)
			return;
		
		//System.out.println("Current node is " + node.value);
		//System.out.println(" The GP for the node " + node.left.right.value + " is " + node.left.right.gp.value);
		
		if (node.gp == null)
			System.out.println(" The GP for the node " + node.value + " is null");
		
		printGP(node.left);
		
		if(node.gp != null)
			System.out.println("The GP of node " + node.value + " is "
				+ node.gp.value);
		
		printGP(node.right);
	}

	/**
	 * function to fill the grand parent for the node
	 * */
	public void fillGP(Node node) {

		if (node.left != null) {
			if (node.left.left != null) {
				//System.out.print(" current node is " + node.left.left.value);
				node.left.left.gp = node;
			}
			if (node.left.right != null) {
				node.left.right.gp = node;
			}
		}

		if (node.right != null) {
			if (node.right.left != null) {
				node.right.left.gp = node;
			}
				if (node.right.right != null) {
					node.right.right.gp = node;			
			}
		}
	}

	/**
	 * function to fill the grand parent for the nodes from level 3, Nodes in
	 * level 1 and 2 will have the GP as null
	 * 
	 * */

	public void fillGPUtil(Node node) {

		if (node == null)
			return;

		fillGP(node);

		fillGPUtil(node.left);
		fillGPUtil(node.right);
	}

	/**
	 * function to create a BST
	 * 
	 * */
	public void insertNode(Node node, int val) {
		if (node == null)
			return;
		if (val <= node.value) {
			if (node.left == null)
				node.left = new Node(val);
			else
				insertNode(node.left, val);
		} else {
			if (node.right == null)
				node.right = new Node(val);
			else
				insertNode(node.right, val);
		}
	}

	/**
	 * inorder traversal
	 * 
	 * */
	public void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.value + " ");
		inorder(node.right);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FillGrandParent();
	}

}
