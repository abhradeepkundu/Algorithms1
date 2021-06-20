package com.abhra.Trees;


public class PrintKdistanceNodes {
	
	
	PrintKdistanceNodes() {
		run();
	}
	
	public static class Node{
		Node left;
		Node right;
		int data;
		
		Node(int val) {
			this.data = val;
		}
	}
	
	/**
	 * function to create a BST
	 * 
	 * */
	public void insertNode(Node node,int val) {
		if(node == null)
			return;
		if(val <= node.data) { 
			if(node.left == null)
				node.left = new Node(val);
			else insertNode(node.left,val);
		}else {
			if(node.right == null)
				node.right = new Node(val);
			else insertNode(node.right, val);
		}
	}
	
	private void run() {
		Node root = new Node(20);
		insertNode(root, 8);
		insertNode(root, 4);
		insertNode(root, 22);
		insertNode(root, 12);
		insertNode(root, 10);
		insertNode(root, 14);
		insertNode(root, 9);
		inorder(root);
		System.out.println();
		int k = 2;
		Node target = new Node(8);
		System.out.println("K distance nodes are ");
		printKDistanceNodes(root,target,k);
	}
	
	/**
	 * inorder traversal
	 * 
	 * */
	public void inorder(Node node) {
		if(node == null) 
			return;
		inorder(node.left);
		System.out.print(node.data+ " ");
		inorder(node.right);
	}
	
	private int printKDistanceNodes(Node root, Node target,int k) {
		if(root == null || k < 0)
			return -1;
		// assuming the nodes are unique
		if(root.data == target.data) {
			printKDistanceNodesDown(root,k);
			return 0;
		}
		int dl =  printKDistanceNodes(root.left,target,k);
		if(dl != -1) {
			if(1 + dl == k) {
				System.out.println(root.data);
			}else 
				printKDistanceNodesDown(root.right,k-dl-2);
			return 1 + dl;
		}
		
		int dr = printKDistanceNodes(root.right,target,k);
		if(dr != -1) {
			if(1 + dr == k) {
				System.out.println(root.data);
			}else 
				printKDistanceNodesDown(root.left, k-dr-2);
			return 1 + dr;
		}
		return -1;
	}

	private void printKDistanceNodesDown(Node node,int k) {
		if(node == null || k< 0)
			return;
		if(k == 0) {
			System.out.println(node.data);
			return;
		}
		printKDistanceNodesDown(node.left,k-1);
		printKDistanceNodesDown(node.right,k-1);
	}

	/**
	 * @param args
	 * http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
	 */
	public static void main(String[] args) {
		new PrintKdistanceNodes();
	}

}
