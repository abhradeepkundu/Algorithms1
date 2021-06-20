

public class DoubleTree {

	public DoubleTree() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	/**
	 *  Structure of the tree
	 * */
	public static class Node {
		Node left;
		Node right;
		int value;
		//int lcount;
		
		public Node(int val) {
			this.value = val;
		}
	}
	
	/**
	 * Method called in constructor to invoke different tree functions
	 * */
	public void run() {
		Node rootNode = new Node(4);
		insertNode(rootNode,2);
		insertNode(rootNode,5);
		insertNode(rootNode,6);
		insertNode(rootNode,3);
		
		/*insertNode(rootNode, 38);
		insertNode(rootNode, 17);
		insertNode(rootNode, 19);
		insertNode(rootNode, 36);*/
		inorder(rootNode);
		System.out.println();
		doubleTree(rootNode);
		inorder(rootNode);
		
	}
	
	/**
	 * function to create a BST
	 * 
	 * */
	public void insertNode(Node node,int val) {
		if(node == null)
			return;
		if(val <= node.value) { 
			//node.lcount++;
			if(node.left == null)
				node.left = new Node(val);
			else insertNode(node.left,val);
		}else {
			if(node.right == null)
				node.right = new Node(val);
			else insertNode(node.right, val);
		}
	}
	
	
	/**
	 * inorder traversal
	 * 
	 * */
	public void inorder(Node node) {
		if(node == null) 
			return;
		inorder(node.left);
		System.out.print(node.value+ " ");
		inorder(node.right);
	}
	/**
	 * function to convert Double tree 
	 * */
	public void doubleTree(Node node) {
		if(node == null) 
			return;
//		if(node.left == null && node.right == null) {
//			Node newNode = new Node(node.value);
//			node.left = newNode;
//			node = newNode.left;
//		}
//		if(node.left != null) {
//			Node leftChild = node.left;
//			Node newNode = new Node(node.value);
//			node.left = newNode;
//			newNode.left = leftChild;
//			node = newNode.left;
//		}
//		if(node.right != null) {
//			Node rightChild = node.right;
//			Node newNode = new Node(node.value);
//			node.right = newNode;
//			newNode.left = rightChild;
//			node = newNode.left;
//		}
		doubleTree(node.left);
		
		Node leftChild = node.left;
		node.left = new Node(node.value);
		node.left.left = leftChild;
		
		
		doubleTree(node.right);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DoubleTree();
	}

}
