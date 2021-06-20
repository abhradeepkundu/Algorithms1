package com.abhra.Trees;

public class InorderTraversals {

	public static class Node {
		int val;
		Node left;
		Node right;
		String color;
		Node(int val) {
			this.val = val;
			this.color = "white";
		}
	}
	private static final int MAX_STACK_SIZE = 20;
	
	InorderTraversals() {
		run();
	}
	private void run() {
		Node root = new Node(25);
		insertNode(root,20);
		insertNode(root,23);
		insertNode(root,28);
		insertNode(root,29);
		insertNode(root,26);
		insertNode(root,15);
		
		inorder(root);
		
		System.out.println();
		
		inorderNonRecursive(root);
	}
	
	Node[] stack = new Node[MAX_STACK_SIZE];
	private int top = -1;
	
	private void insertNode(Node root, int val) {
		if(root == null)
			return;
		if(val <= root.val) {
			if(root.left == null)
				root.left = new Node(val);
			else 
				insertNode(root.left,val);
		}else {
			if(root.right == null) 
				root.right = new Node(val);
			else 
				insertNode(root.right,val);
		}
	}
	
	public void inorderNonRecursive(Node root) {
		if(root == null) 
			return;
		push(stack,root);
		while(!isStackEmpty()) {
			Node node = pop(stack);
			if(node.color.equalsIgnoreCase("white")) {
				if(node.right != null) 
					push(stack,node.right);
				node.color = "blue";
				push(stack,node);
				if(node.left != null)
					push(stack,node.left);
			}else {
				System.out.print( node.val +" ");
				node.color = "black";
			}
		}
	}
	private void push(Node[] stack, Node node) {
		if(node==null)
			return;
		if(isStackFull(stack)) {
			System.out.println("Stack is full");
			return;
		}
		stack[++top] = node;
	}
	private Node pop(Node[] stack) {
		if(isStackEmpty()) {
			System.out.println("Stack empty");
			return null;
		}
		Node node = stack[top--];
		//System.out.println("Poped node is : " + node.val +"  ");
		return node;
	}
	private boolean isStackEmpty() {
		if(top == -1)
			return true;
		return false;
	}
	private boolean isStackFull(Node[] stack) {
		if(top == MAX_STACK_SIZE)
			return true;
		return false;
	}
	public void inorder(Node node) {
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.val + " ");
		inorder(node.right);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new InorderTraversals();
	}

}
