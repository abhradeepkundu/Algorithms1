package com.abhra.Trees;

import java.util.HashMap;
import java.util.Map;

public class VerticalSumOfBinaryTree {

	public static class Node{
		Node left;
		Node right;
		int data;
		Node(int val) {
			this.data = val;
		}
	}
	VerticalSumOfBinaryTree() {
		run();
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
	
	public void run() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		/*
			  1
		    /   \
		  2      3
		 / \    / \
		4   5  6   7
		 * 
		 * 
		 * 
		 * The tree has 5 vertical lines

			Vertical-Line-1 has only one node 4 => vertical sum is 4
			Vertical-Line-2: has only one node 2=> vertical sum is 2
			Vertical-Line-3: has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12
			Vertical-Line-4: has only one node 3 => vertical sum is 3
			Vertical-Line-5: has only one node 7 => vertical sum is 7
		 * 
		 * */
		System.out.println("inorder : ");
		inorder(root);
		System.out.println();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>(); 
		map = verticalSum(root,0,map);
		System.out.println(map);
	}
	
	
	//http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
	private Map<Integer,Integer> verticalSum(Node node,int hd, Map<Integer, Integer> map) {
		if(node == null)
			return null;
		
		if(map.get(hd) != null) {
			Integer val = map.get(hd);
			map.put(hd, val + node.data);
		}else {
			map.put(hd, node.data);
		}
		verticalSum(node.left, hd-1, map);
		verticalSum(node.right, hd+1,map);
		return map;
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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new VerticalSumOfBinaryTree();
	}

}
