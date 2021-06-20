package com.abhra.Trees;

public class InorderSuccAndPred {

	public InorderSuccAndPred() {
		this.run();
	}
	private void run() {
		Node root = new Node(50);
		insertNode(root, 30);
		insertNode(root, 70);
		insertNode(root, 20);
		insertNode(root, 40);
		insertNode(root, 60);
		insertNode(root, 80);
		inorder(root);
		System.out.println();
		//inorderPredAndSuccOfKey(root,65);
		inorderSucc(root,55);
		System.out.println("Inorder successor of 65 : " + succ.value);
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
	 * function to create a BST
	 * 
	 * */
	public void insertNode(Node node, int val) {
		if (node == null)
			return;
		if (val <= node.value) {
			if (node.left == null) {
				node.left = new Node(val);
			}
			else
				insertNode(node.left, val);
		} else {
			if (node.right == null)
				node.right = new Node(val);
			else
				insertNode(node.right, val);
		}
	}
	/**Function to print inorder successor of a given key*/
	
	public void inorderSucc(Node node,int key) {
		if(node == null)
			return;
		if(node.value == key) {
			if(node.right!= null) {
				Node temp = node.right;
				while(temp.left != null)
					temp = temp.left;
				succ = temp;
			}
		}
		if(node.value > key) {
			succ = node;
			inorderPredSucc(node.left, key);
		}else {
			succ = node.right;
			inorderPredSucc(node.right, key);
		}
		
	}
	Node pred = null;
	Node succ = null;
	public void inorderPredAndSuccOfKey(Node node,int key) {
		inorderPredSucc(node,key);
		System.out.println("inorder predecessor of " + key + " is " + pred.value);
		System.out.println("inorder successor of " + key + " is " + succ.value);
	}
	private void inorderPredSucc(Node node,int key) {
		if(node == null)
			return;
		if(key == node.value) {
			if(node.left != null) {
				Node temp = node.left;
				while(temp.right != null)
					temp = temp.right;
				pred = temp;
			}
			if(node.right != null) {
				Node temp = node.right;
				while(temp.left != null)
					temp = temp.left;
				succ = temp;
			}
			return;
		}
		if(node.value < key) {
			pred = node;
			inorderPredSucc(node.right, key);
		}else {
			succ = node;
			inorderPredSucc(node.left, key);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new InorderSuccAndPred();
	}

}
