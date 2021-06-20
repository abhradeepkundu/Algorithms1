

public class Traversals {
	
	public static class Node {
		Node left;
		Node right;
		int data;
		String color;
		
		Node(int val) {
			this.data = val;
			this.color = "white";
		}
	}
	
	
	public void run() {
		Node root = new Node(25);
		insertNode(root,20);
		insertNode(root,30);
		/*insertNode(root,15);
		insertNode(root,16);*/
		//inorderRecursive(root);
		inorderIterative(root,stack);
	}

	private void insertNode(Node root, int val) {
		// TODO Auto-generated method stub
		if(root == null)
			return;
		if(val < root.data) {
			if(root.left == null) {
				Node newNode = new Node(val);
				root.left = newNode;
			}else {
				insertNode(root.left,val);
			}
		}else {
			if(root.right == null) {
				Node newNode = new Node(val);
				root.right = newNode;
			}else {
				insertNode(root.right,val);
			}
		}
	}

	Node[] stack = new Node[20];
	static int top = -1;

	private boolean isStackOverFlow(Node[] s) {
		// TODO Auto-generated method stub
		if(top >= s.length)
			return true;
		return false;
	}

	public void push(Node[] s,Node node) {
		if(node == null) {
			System.out.println(" Push : empty node");
			return;
		}
		if(isStackOverFlow(s)) {
			System.out.println("stack overflow");
			return;
		}
		s[++top] = node;
	}

	private boolean isStackEmpty(Node[] s) {
		// TODO Auto-generated method stub
		if(top < 0)
			return true;
		return false;
	}
	
	public Node pop(Node[] s) {
		if(isStackEmpty(s))
			return null;
		
		Node node = s[top--];
		return node;
	}
	

	/**
	 * inorder iterative
	 * */
	
	public void inorderIterative(Node node,Node[] s) {
		if(node == null)
			return;
		push(s,node);
		while(!isStackEmpty(s)) {
			node = pop(s);
			//System.out.println("popped : " + node.data + " node color : " + node.color);
			if(node.right != null)
				push(s,node.right);
			
			if(node.color.equalsIgnoreCase("blue"))
				System.out.print(node.data + " ");
			else  {
				node.color = "blue";
				push(s,node);
			}
			
			if(node.left != null)
				push(s,node.left);
		}
	}
	
	/***
	 * Post order iterative
	 * */
	public void postorderIterative(Node node,Node[] s) {
		if(node == null)
			return;
		push(s,node);
		while(!isStackEmpty(s)) {
			if(node.color.equalsIgnoreCase("blue"))
				System.out.print(node.data + " ");
			else {
				node.color = "blue";
				push(s,node);
			}
			
			
			if(node.right != null)
				push(s,node.right);
			
			if(node.left != null)
				push(s,node.left);
		}
	}
	public void inorderRecursive(Node node) {
		if(node == null)
			return;
		inorderRecursive(node.left);
		System.out.print( node.data + " ");
		inorderRecursive(node.right);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Traversals().run();
	}

}
