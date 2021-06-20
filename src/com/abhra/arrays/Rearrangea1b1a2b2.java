package com.abhra.arrays;


public class Rearrangea1b1a2b2 {

	public static final int STACKSIZE = 20;


	/**
	 * Created by Shams on 10th Sep 2015
	 * @param args 
	 */
	public static void main(String[] args) {
		/**Method 1*/
		int[] a = {1,3,5,4,7,8,2,6 };
		//int[] a = {1,2,3,4,5,6,7,8};
		shuffle(a);
		
		printArray(a);
		
		/**Method 2*/
		
//		System.out.println();
//		stack s = new stack();
//		reArrange(a,s);
//		printArray(a);
	}

	public static class stack {
		int top=-1;
		int[] stack = new int[STACKSIZE];
	}
	private static void push(stack s,int val) {
		if(isStackFull(s)) {
			System.out.println("stack is full");
			return;
		}
		s.stack[++(s.top)] = val;
	}
	
	private static int pop(stack s) {
		if(s.top < 0) {
			System.out.println("stack underflow");
			return -1;
		}
		return s.stack[s.top--];
	}

	private static boolean isStackFull(stack s) {
		if(s.top >= s.stack.length)
			return true;
		return false;
	}
	
	/**
	 * Push elements in stacks in the order a1,b1,a2,b2..............anbn
	 * and restore back in array
	 * */
	// Input - A - 1,3,5,4,7,8,2,6  ->  1,7,3,8,5,2,4,6
	private static int[] reArrange(int[] a,stack s) {
		int n = a.length;
		int i=0; int mid=(n)/2;
		int j = mid;
		while(i < mid && j < n) {
			push(s,a[i++]);
			push(s,a[j++]);
		}
		j--;
		while(j>=0) {
			a[j--] = pop(s);
		}
		return a;
	}
	
	/***
	 * Insertion technique is used
	 * 
	 * */
	public static int[] shuffle(int[] a) {
		if(a == null)
			return null;
	    if(a.length<=2)
	    return a;
	    int j;
	    int n = a.length;
	    int temp;
	    int k = (n)/2;
	    for(int i=1; i<n-1;i= i+2) {
	        
	    	j = k;
	        temp = a[j];
	        while(j>=i &&  j < n) {
	        	a[j] = a[j-1];
	        	j--;
	        }
	        a[i] = temp;
	        k++;
	    }
	    return a;
	   
	}
	
	
	private static void printArray(int[] a) {
		for(int i = 0 ; i< a.length; ++i)
			System.out.print(a[i] + " ");
	}
}
