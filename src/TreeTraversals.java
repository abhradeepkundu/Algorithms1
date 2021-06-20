
public class TreeTraversals {

	public TreeTraversals() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	public final static int stackSize = 10;
	public Node[] s = new Node[stackSize];
	public int top = -1;
	/**
	 * Structure of the tree
	 * */
	public static class Node {
		Node left;
		Node right;
		Node next;
		int value;
		Node gp;

		public Node(int val) {
			this.value = val;
		}
	}
	
	
	/**
	 * Method called in constructor to invoke different tree functions
	 * 
	 * */
	public void run() {
		/*
		   50
         /     \
        30      70
       /  \    /  \
     20   40  60   80
     */
		Node root = new Node(50);
		insertNode(root, 30);
		insertNode(root, 70);
		insertNode(root, 20);
		insertNode(root, 40);
		insertNode(root, 60);
		insertNode(root, 80);
		inorder(root);
		System.out.println();
		System.out.println("Bottom up");
		for(int i =height(root); i > 0 ; i--)
			deapthFirst(root, i);
		System.out.println();
		
		/*System.out.println("Right to left ");
		for(int i = 1; i <= height(rootNode) ; i++)
			rightToLeft(rootNode,i);
		
		System.out.println();
		System.out.println("spiral order Right to left ");
		int flip = 0;
		for(int i = 1; i <= height(rootNode) ; i++) {			
			spiralRightToLeft(rootNode,i,flip);		
			flip = (~flip);
		}*/
		//preTraversal(rootNode);
//		inorder(rootNode);
//		System.out.println();
//		populateInorderSuccessor(rootNode);
//		System.out.println();
//		inorderSucc(rootNode);
		//postorderTraversal(rootNode);
	}
	/***
	 * function to populate in-order traversal
	 * */
	
	public void populateInorderSuccessor(Node node) {
		if(node == null)
			return;
		 Node next = null;
		if(node != null) {
			populateInorderSuccessor(node.right);
				
			node.next = next;
			if(node.next != null)
				System.out.println("inorder successor of " + node.value + " is "  + node.next.value);
		
			populateInorderSuccessor(node.left);
		}
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
	 * function to calculate the height of the tree
	 * */
	public int height(Node node) {
		if(node == null)
			return 0;
		else
		   {
		     /* compute the height of each subtree */
		     int lheight = height(node.left);
		     int rheight = height(node.right);
		 
		     /* use the larger one */
		     if (lheight > rheight)
		         return(lheight+1);
		     else return(rheight+1);
		   }
	}
	/**
	 * function to check weather stack is full
	 * */
	public boolean isStackFull(Node[] s) {
		if(top > s.length) {			
			return true;
		}
		return false;
	}
	
	/**
	 * function to check weather stack is Empty
	 * */
	public boolean isStackEmpty(Node[] s) {
		if(top < 0 ) {
			//System.out.println("Stack is Empty!!" +" top : " + top);
			return true;
		}
		return false;
	}
	
	
	/**
	 * function to push the Node in the stack
	 * */
	public void push(Node node) {
		//System.out.println("Pushing " + node.value);
		if(isStackFull(s)) {
			//System.out.println("Stack is full!!");
			return;
		}
		//System.out.println("top's value in push " + top);
		s[++top] = node;
	}
	
	/**
	 * function to pop the element from stack
	 * */
	public Node pop() {
		if(isStackEmpty(s)) {
			
		}
		Node temp = s[top--];
		return temp;
	}
	/***
	 * iterative pre traversal
	 * */
	
	public void preTraversal(Node node) {
		if (node == null)
			return;
		Node cur = node;
		boolean done = false;
		while (!done) {
			if (cur != null) {
				System.out.print(cur.value + " ");
				push(cur);
				cur = cur.left;
			} else {
				if (!isStackEmpty(s)) {
					cur = pop();
					cur = cur.right;
				} else {
					done = true;
				}
			}
		}
	}
	
	/**
	 * iterative post order traversal of BST
	 * */
	public void postorderTraversal(Node node) {
		if (node == null)
			return;
		Node cur = node;
		boolean done = false;
		while (!done) {
			if (cur != null) {
				//System.out.print(cur.value + " ");
				push(cur);
				cur = cur.left;
			} else {
				if (!isStackEmpty(s)) {
					cur = pop();
					if(cur.right != null)
						push(cur);
					else
						System.out.println( " cur "+ cur.value + " ");
					cur = cur.right;
				} else {
					done = true;
				}
			}
		}
	}
	/**
	 * print the depth-first form in bottom-to-top 
	 * */
	public void deapthFirst(Node node,int k) {
		if(node == null)
			return;
		if(k == 1)
			System.out.print(node.value + " ");
		else {
			deapthFirst(node.left, k - 1 );
			deapthFirst(node.right, k - 1);
		}
	}
	/**
	 * print tree in right-left style
	 * */
	
	public void rightToLeft(Node node,int k) {
		if(node == null)
			return;
		
		if(k == 1)
			System.out.print(node.value + " ");
		else {
			rightToLeft(node.right, k - 1);
			rightToLeft(node.left, k - 1);
		}
	}
	
	/**
	 * print tree in right-left style in spiral order
	 * */
	
	public void spiralRightToLeft(Node node, int k, int flip) {
		if (node == null)
			return;

		if (k == 1)
			System.out.print(node.value + " ");
		else if (k > 1) {
			if (flip == 1) {
				spiralRightToLeft(node.right, k - 1,flip);
				spiralRightToLeft(node.left, k - 1,flip);
			} else {
				spiralRightToLeft(node.left, k - 1,flip);
				spiralRightToLeft(node.right, k - 1,flip);
			}
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
	 * inorder successor traversal
	 * 
	 * */
	public void inorderSucc(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		if(node.next!=null)
			System.out.print(node.next.value + " ");
		inorder(node.right);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TreeTraversals();
	}

}
