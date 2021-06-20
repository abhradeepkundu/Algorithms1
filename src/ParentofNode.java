public class ParentofNode {

	public ParentofNode() {
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
		GetParent(rootNode,rootNode.right);
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
	public void GetParent(Node root,Node node) {
		if(root == null || node ==null) {
			System.out.println("Either root or the given node is null");
			return;
		}
		if(node.value == root.value) {
			System.out.println("The parent of Node " + node.value + " is " + root.parent.value);
			return;
		}
			
		else if(node.value > root.value)
			GetParent(root.right,node);
		else
			GetParent(root.left,node);
	}
	/**
	 * inorder traversal
	 * 
	 * */
	public void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		if(node.parent != null )
			System.out.print(node.parent.value + " ");
		inorder(node.right);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new ParentofNode();
	}

}
