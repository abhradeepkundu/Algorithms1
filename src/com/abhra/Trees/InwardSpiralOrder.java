package com.abhra.Trees;

import com.abhra.Trees.VerticalSumOfBinaryTree.Node;


public class InwardSpiralOrder {

	InwardSpiralOrder() {
		run();
	}
	
	private void run() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left= new Node(8);
		root.left.left.right= new Node(9);
		root.left.right.left= new Node(10);
		root.left.right.right= new Node(11);
		
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);
		root.right.right.left = new Node(14);
		root.right.right.right = new Node(15);
		
		printInwardSpiral(root);
	}

	/*			1
	        /  	   \	
		  /     	\
		 2        	  3
		/  \     	 /   \
	   4    5 		 6     7 
	 / \   / \	 	/ \	   / \ 	
	8	 9 10 11   12  13  14 15
* */
	public void printInwardSpiral(Node node) {
		if(node == null)
			return;
		int height = height(node);
		boolean flip = true;
		int level = height-1;
		int top = 0;
		for(int i=0;i<height;i++) {
			if(top > level)
				break;
			if(flip) {
				printLevelOrder(node,top,0,flip);
				top++;
			}else {
				printLevelOrder(node,level,0,flip);
				level--;
			}
			flip = !flip;
		}
	}
	private void printLevelOrder(Node node, int level,int curlevel,boolean flip) {
		if(node == null)
			return;
		if(curlevel == level) {
			System.out.print(node.data + " ");
			return;
		}
		if(flip) {
			printLevelOrder(node.left, level, curlevel+1,flip);
			printLevelOrder(node.right, level, curlevel+1,flip);
		}else {
			printLevelOrder(node.right, level, curlevel+1,flip);
			printLevelOrder(node.left, level, curlevel+1,flip);
		}
	}

	private int height(Node node) {
		if(node == null)
			return 0;
		int lheight = height(node.left);
		int rheight = height(node.right);
		return 1+max(lheight,rheight);
	}

	private int max(int lheight, int rheight) {
		return lheight > rheight ? lheight : rheight;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new InwardSpiralOrder();
	}

}
