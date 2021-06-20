public class LevelOrderTraversal {

	private static final int MAXSTACKSIZE = 50;

	public LevelOrderTraversal() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	private void run() {
		// TODO Auto-generated method stub
		Node root = new Node(25);
		insertNode(root, 15);
		insertNode(root, 35);
		insertNode(root, 17);
		insertNode(root, 13);

		inorder(root);
		System.out.println();
		//levelorder(root);
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
	
	public static class Stack {
		public  int top1 = -1;
		public  int top2 = -1;		
		public  Node[] current_level = new Node[MAXSTACKSIZE];
		public  Node[] next_level = new Node[MAXSTACKSIZE];
	}

	

	private void insertNode(Node root, int val) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		if (val < root.value) {
			if (root.left == null)
				root.left = new Node(val);
			else
				insertNode(root.left, val);
		} else {
			if (root.right == null)
				root.right = new Node(val);
			else
				insertNode(root.right, val);
		}
	}

	public void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.value + " ");
		inorder(node.right);
	}

	// level order

	/*public void levelorder(Node node) {
		if (node == null)
			return;
		boolean left2right = true;
		Node[] temp;
		Stack s1 = new Stack();
		Stack s2 = new Stack();
		push(current_level, s1, node);
		System.out.println("curr len => " + s1.top1); 
		while (!isStackEmpty(s1)) {
			System.out.println("coming here");
			node = pop(current_level, s1);
			System.out.println(node.value + " ");

			if (node != null) {
				if (left2right) {
					// next_level
					if (node.left != null)
						push(next_level, s2, node.left);

					if (node.right != null)
						push(next_level, s2, node.right);
				} else {
					if (node.right != null)
						push(next_level, s2, node.right);

					if (node.left != null)
						push(next_level, s2, node.left);
				}
			}
			if (isStackEmpty(s1.top1)) {
				left2right = !left2right;

				// swap stacks
				temp = current_level;
				current_level = next_level;
				next_level = temp;
			}
		}
	}
*/
	/*private Node pop(Node[] s, Stack t) {
		// TODO Auto-generated method stub
		if (isStackEmpty(t.top)) {
			System.out.println("stack is empty");
			return null;
		}
		Node temp = s[top--];
		return temp;
	}

	private boolean isStackEmpty(Stack t) {
		// TODO Auto-generated method stub
		if (t.top < 0) {
			return true;
		}
		return false;
	}*/

	private boolean isStackFull(Node[] s, int top) {
		// TODO Auto-generated method stub
		if (top >= MAXSTACKSIZE) {
			return true;
		}
		return false;
	}

	private void push(Node[] s, int top, Node node) {
		// TODO Auto-generated method stub
		if (isStackFull(s, top)) {
			System.out.println("stck is FULL, cannot insert more items");
			return;
		}
		s[++top] = node;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LevelOrderTraversal();
	}

}
