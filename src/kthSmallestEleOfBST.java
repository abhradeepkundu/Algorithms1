


public class kthSmallestEleOfBST {

	public kthSmallestEleOfBST() {
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
		int lcount;
		
		public Node(int val) {
			this.value = val;
		}
	}
	
	/**
	 * Method called in constructor to invoke different tree functions
	 * */
	public void run() {
		Node rootNode = new Node(25);
		insertNode(rootNode,35);
		insertNode(rootNode,15);
		insertNode(rootNode,12);
		insertNode(rootNode,38);
		insertNode(rootNode,17);
		insertNode(rootNode,19);
		insertNode(rootNode,36);
		inorder(rootNode);
		System.out.println();
		
	}
		
	/**
	 * function to create a BST
	 * 
	 * */
	public void insertNode(Node node,int val) {
		if(node == null)
			return;
		if(val <= node.value) { 
			node.lcount++;
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
	/*kth smallest element*/
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("shams");
		new kthSmallestEleOfBST();
	}

}
