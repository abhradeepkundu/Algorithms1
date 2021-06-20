public class LCA {

	public LCA() {
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
		public Node(int val) {
			this.value = val;
		}
	}
	
	/**
	 * Method called in constructor to invoke different tree functions
	 * */
	public void run() {
		Node rootNode = new Node(4);
		insertNode(rootNode, 5);
		insertNode(rootNode, 2);
		insertNode(rootNode, 3);
		insertNode(rootNode, 1);
		
		inorder(rootNode);
		Node result = LeastCommonAncestor(rootNode.left,rootNode.left.left,rootNode.left.right);
		if(result != null)
			System.out.println("Resultant node is " + result.value);
		else 
			System.out.println("Couldnt find LCA");
		System.out.println();
	}
	
	

	
	/**
	 * function to print the least common ancestor of a given node
	 * 
	 * */
	public Node LeastCommonAncestor(Node node,Node node1,Node node2) {
		
		if(node == null || node1 == null || node2 == null) {
			System.out.println("Invalid input");
			return null;
		}
		
		if(node.left != null && (node.left == node1 || node.right == node1)) {
			System.out.println("The LCA  of the given 2 nodes -> " + node1.value + " and " + node2.value + " is " + node.value);
			return node;
		}

		if(node.right != null && (node.right == node2 || node.left == node2)) {
			System.out.println("The LCA  of the given 2 nodes -> " + node.value + " and " + node2.value + " is " + node.value);
			return node;
		}
		
		if( (node1.value <= node.value)&& (node.value <= node2.value) ) {
			System.out.println("The LCA  of the given 2 nodes -> " + node.value + " and " + node2.value + " is " + node.value);
			return node;
		}
		if( (node1.value < node.value) && ( node2.value < node.value ) )
			return LeastCommonAncestor(node.left, node1, node2);
		
		if( (node1.value > node.value) && ( node2.value > node.value ) )
			return LeastCommonAncestor(node.right, node1, node2);
		
			
			return null;
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
		new LCA();
	}

}
