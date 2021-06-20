public class CheckifBST {

	public CheckifBST() {
		this.run();
	}

	public static class Node {
		int value;
		Node left;
		Node right;
		Node(int val) {
			this.value = val;
		}
	}
	

	/**
	 * Method called in constructor to invoke different tree functions
	 * */
	public void run() {
		Node root = new Node(3);
		root.right = new Node(5);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
//		insertNode(rootNode, 35);
//		insertNode(rootNode, 45);
//		insertNode(rootNode, 12);
//		insertNode(rootNode, 38);
//		insertNode(rootNode, 17);
//		insertNode(rootNode, 19);
//		insertNode(rootNode, 36);
		//int[] a = {4,3,7,9,2,6};
//		Node root= new Node(a[0]);
//		for(int i=1;i<a.length;i++)
//			insertNode(root, a[i]);
		inorder(root);
		/*
		System.out.println();
		checkBst(rootNode);
		*/
		System.out.println();
		if(isBST(root))
			System.out.println("Given Tree is BST");
		else 
			System.out.println("Tree is NOT BST");
	}
	
	/**
	 * function to create a BST
	 * 
	 * */
	
	public void insertNode(Node node,int val) {
		if(node == null) 
			return;
		if(val < node.value) {
			if(node.left == null) 
				node.left =  new Node(val);
			else
				insertNode(node.left,val);
		}else {
			if(node.right == null) 
				node.right = new Node(val);
			else 
				insertNode(node.right,val);
		}
	}

	Node prev = null;
	public boolean isBST(Node node) {
		
		if(node != null) {
			if(!isBST(node.left))
				return false;
			
			if(prev != null && prev.value >= node.value)
				return false;
			
			this.prev = node;
			
			return isBST(node.right);

		}
		return true;
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
		new CheckifBST();
	}

}
